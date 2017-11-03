package com.yakindu.solidity.ide.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import com.google.common.collect.Lists;

/**
 * @author Florian Antony - Initial contribution and API
 */
public class SolidityBuilder extends IncrementalProjectBuilder {

	public static final String ID = "com.yakindu.solidity.ide.builder.solidityBuilder";

	private MarkerBuilder markerBuilder = new MarkerBuilder();

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		IProject project = getProject();
		project.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		final ArrayList<IFile> filesToCompile = Lists.newArrayList();
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
		progress.done();
		return null;
	}

	private void compile(IFile file, SubMonitor progress) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		progress.beginTask("compiling " + file.getName(), 10);
		Process process;
		String projectPath = file.getProject().getLocation().toOSString();
//		String output = projectPath + "\\solidity-output";
		try {
			ProcessBuilder builder = new ProcessBuilder(
					"C:\\Users\\Flow\\git\\sct4solidity\\plugins\\com.yakindu.solidity.ide\\compiler\\solc.exe",
					"--bin", file.getLocation().toOSString());
			// "-o " + output,
			// , "--ast", "--asm",
			builder.directory(new File(projectPath));
			process = builder.start();
			service.submit(handleCompilerErrorOutput(file,
					new BufferedReader(new InputStreamReader(process.getErrorStream()))));
			service.submit(handleCompilerInfoOutput(file,
					new BufferedReader(new InputStreamReader(process.getInputStream()))));
			process.waitFor();
			service.shutdown();
			progress.done();
		} catch (IOException e) {
			progress.done();
		} catch (InterruptedException e) {
			progress.done();
		}
	}

	private Runnable handleCompilerErrorOutput(final IFile file, final BufferedReader output) {
		return new Runnable() {
			@Override
			public void run() {
				String line;
				try {
					line = output.readLine();
					while (line != null && !isInterrupted()) {
						System.err.println(line);
						markerBuilder.getMarker(file, line);
						line = output.readLine();
					}
				} catch (IOException e) {
					// TODO
				}
			}
		};
	}

	private Runnable handleCompilerInfoOutput(final IFile file, final BufferedReader output) {
		return new Runnable() {
			@Override
			public void run() {
				String line;
				try {
					line = output.readLine();
					while (line != null && !isInterrupted()) {
						System.out.println(line);
						line = output.readLine();
					}
				} catch (IOException e) {
					// TODO
				}
			}
		};
	}

}
