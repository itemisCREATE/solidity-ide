package com.yakindu.solidity.ide.builder;

import java.io.IOException;
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
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class SolidityBuilderParticipant implements IXtextBuilderParticipant {

	public static final String ID = "com.yakindu.solidity.ide.builder.solidityBuilder";

	private final String solc = getClass().getProtectionDomain().getCodeSource().getLocation().getFile()
			+ "/compiler/solc.exe";

	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		if (!isEnabled(context)) {
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
			compile(findFile(uri, files), progress);
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
					if (file.getFileExtension().equals("sol")) {
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
		return true;
	}

	// TODO configure by preference
	protected Map<String, OutputConfiguration> getOutputConfigurations(IBuildContext context) {
		return Maps.newHashMap();
	}

	private void compile(IFile file, SubMonitor progress) {
		if (file == null) {
			return;
		}
		progress.beginTask("compiling " + file.getName(), 10);
		Process process;
		try {
			process = new ProcessBuilder(solc, "--bin", "--abi", "--ast-compact-json", "--asm-json",
					file.getLocation().toOSString()).start();
			OutputHandler handler = new OutputHandler(file);
			handler.handleOutput(process.getInputStream());
			handler.handleError(process.getErrorStream());
			process.waitFor();
			handler.shutdown();
			progress.done();
		} catch (IOException e) {
			progress.done();
		} catch (InterruptedException e) {
			progress.done();
		}
	}

}
