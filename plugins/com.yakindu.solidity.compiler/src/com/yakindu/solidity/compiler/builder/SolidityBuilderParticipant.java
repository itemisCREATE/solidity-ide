package com.yakindu.solidity.compiler.builder;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.yakindu.solidity.ui.preferences.SolidityPreferences;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * 
 */
public class SolidityBuilderParticipant implements IXtextBuilderParticipant {

	public static final String ID = "com.yakindu.solidity.ide.builder.solidityBuilder";

	@Inject
	private IPreferenceStore preferences;
	@Inject(optional=true)
	private ISolidityCompiler compiler;

	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		if (!isEnabled(context) || compiler == null) {
			return;
		}
		final List<IResourceDescription.Delta> deltas = getRelevantDeltas(context);
		if (deltas.isEmpty()) {
			return;
		}
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		SubMonitor progress = SubMonitor.convert(monitor);
		List<IFile> files = getFiles(context);
		progress.beginTask("Compiling solidity...", deltas.size());

		for (Delta delta : deltas) {
			if (progress.isCanceled()) {
				throw new OperationCanceledException();
			}
			String uri = delta.getUri().toString();
			compiler.compile(findFile(uri, files), progress);
		}
		context.getBuiltProject().refreshLocal(IProject.DEPTH_INFINITE, monitor);
		progress.done();

	}

	private IFile findFile(String uri, List<IFile> files) {
		for (IFile iFile : files) {
			if (uri.endsWith(iFile.getFullPath().toString())) {
				return iFile;
			}
		}
		return null;
	}

	private List<IFile> getFiles(IBuildContext context) throws CoreException {
		List<IFile> filesToCompile = Lists.newArrayList();
		IProject project = context.getBuiltProject();
		project.accept(new IResourceVisitor() {
			@Override
			public boolean visit(IResource resource) throws CoreException {
				if (resource instanceof IContainer) {
					return true;
				}
				if (resource instanceof IFile) {
					IFile file = (IFile) resource;
					String fileExtension = file.getFileExtension();
					if (fileExtension != null && fileExtension.equals("sol")) {
						filesToCompile.add(file);
					}
				}
				return false;
			}
		});
		return filesToCompile;
	}

	private List<Delta> getRelevantDeltas(IBuildContext context) {
		List<Delta> filtered = Lists.newArrayList();
		for (Delta delta : context.getDeltas()) {
			if (delta.getUri().fileExtension().equals("sol")) {
				filtered.add(delta);
			}
		}
		return filtered;
	}

	// TODO turn it on and off by preference
	private boolean isEnabled(IBuildContext context) {
		return preferences.getBoolean(SolidityPreferences.COMPILER_ENABLED);
	}

	// TODO configure by preference
	protected Map<String, OutputConfiguration> getOutputConfigurations(IBuildContext context) {
		return Maps.newHashMap();
	}

}
