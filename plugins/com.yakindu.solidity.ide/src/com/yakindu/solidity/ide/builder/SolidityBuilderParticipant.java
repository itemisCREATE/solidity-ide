package com.yakindu.solidity.ide.builder;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;

import com.google.common.collect.Lists;

public class SolidityBuilderParticipant implements IXtextBuilderParticipant {

	public static final String ID = "com.yakindu.solidity.ide.builder.solidityBuilder";

	private final String solc = getClass().getProtectionDomain().getCodeSource().getLocation().getFile()
			+ "/compiler/solc.exe";

	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		IProject project = context.getBuiltProject();
		List<IFile> filesToCompile = Lists.newArrayList();
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
		SubMonitor progress = SubMonitor.convert(monitor);
		progress.beginTask("Compiling solidity...", filesToCompile.size());
		for (IFile file : filesToCompile) {
			if (progress.isCanceled()) {
				throw new RuntimeException();
			}
			compile(file, progress.newChild(1));
		}
		project.refreshLocal(IProject.DEPTH_INFINITE, progress);
		progress.done();

	}

	private void compile(IFile file, SubMonitor progress) {
		progress.beginTask("compiling " + file.getName(), 10);
		Process process;
		try {
			process = new ProcessBuilder(solc, "--bin", "--abi", "--ast-compact-json", "--asm-json",
					file.getLocation().toOSString()).start();
			OutputHandler handler = new OutputHandler(file);
			handler.handleError(process.getErrorStream());
			handler.handleOutput(process.getInputStream());
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
