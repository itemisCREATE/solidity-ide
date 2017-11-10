package com.yakindu.solidity.ide.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.SubMonitor;

public abstract class SolidityCompilerBase implements ISolidityCompiler {

	public void compile(IFile file, SubMonitor progress) {
		if (file == null) {
			return;
		}
		progress.beginTask("compiling " + file.getName(), 10);
		Process process;
		try {
//			file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_ONE);
			process = new ProcessBuilder(getCompiler(), "--bin", "--abi", "--ast-compact-json", "--asm-json",
					file.getLocation().toOSString()).start();
			OutputHandler handler = new OutputHandler(file);
			handler.handleOutput(process.getInputStream());
			handler.handleError(process.getErrorStream());
			process.waitFor();
			handler.shutdown();
			progress.done();
		} catch (Exception e) {
			progress.done();
		}
	}

	protected abstract String getCompiler();

}
