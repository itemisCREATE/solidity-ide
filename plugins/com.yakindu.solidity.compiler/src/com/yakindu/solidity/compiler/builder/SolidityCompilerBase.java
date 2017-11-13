package com.yakindu.solidity.compiler.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;

import com.google.inject.Inject;
import com.yakindu.solidity.compiler.builder.processor.OutputHandler;

public abstract class SolidityCompilerBase implements ISolidityCompiler {

	@Inject
	private OutputHandler handler;
	
	public void compile(IFile file, IProgressMonitor progress) {
		if (file == null) {
			return;
		}
		progress.beginTask("compiling ..." + file.getName(), 10);
		try {
			Process process = new ProcessBuilder(getCompiler(), "--bin", "--abi", "--ast-compact-json", "--asm-json",
					file.getLocation().toOSString()).start();
			handler.handleOutput(process.getInputStream(), file);
			handler.handleError(process.getErrorStream(), file);
			process.waitFor();
			progress.done();
		} catch (Exception e) {
			e.printStackTrace();
			progress.done();
		}
	}

	protected abstract String getCompiler();

}
