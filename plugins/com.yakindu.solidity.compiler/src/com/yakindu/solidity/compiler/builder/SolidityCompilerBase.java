package com.yakindu.solidity.compiler.builder;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.preference.IPreferenceStore;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.yakindu.solidity.compiler.builder.processor.OutputHandler;
import com.yakindu.solidity.ui.preferences.SolidityPreferences;

public abstract class SolidityCompilerBase implements ISolidityCompiler {
	@Inject
	private IPreferenceStore preferences;

	@Inject
	private OutputHandler handler;

	public void compile(IFile file, IProgressMonitor progress) {

		if (file == null) {
			return;
		}
		progress.beginTask("compiling ..." + file.getName(), 10);
		try {
			Process process = new ProcessBuilder(createParameter(file)).start();
			handler.handleOutput(process.getInputStream(), file);
			handler.handleError(process.getErrorStream(), file);
			int exitCode = process.waitFor();
			if (exitCode != 0) {
				throw new Exception("Solidity compiler invocation failed with exit code " + exitCode + ".");
			}
			progress.done();

		} catch (Exception e) {
			e.printStackTrace();
			progress.done();
		}
	}

	private List<String> createParameter(IResource file) {
		boolean bin = preferences.getBoolean(SolidityPreferences.COMPILER_OUTPUT_BIN);
		boolean ast = preferences.getBoolean(SolidityPreferences.COMPILER_OUTPUT_AST);
		boolean abi = preferences.getBoolean(SolidityPreferences.COMPILER_OUTPUT_ABI);
		boolean asm = preferences.getBoolean(SolidityPreferences.COMPILER_OUTPUT_ASM);
		List<String> parameters = Lists.newArrayList();
		parameters.add(getCompilerPath());
		if (bin) {
			parameters.add("--bin");
		}
		if (abi) {
			parameters.add("--abi");
		}
		if (ast) {
			parameters.add("--ast");
		}
		if (asm) {
			parameters.add("--asm");

		}
		parameters.add(file.getLocation().toOSString());
		return parameters;
	}

	private String getCompilerPath() {
		String pathToCompiler = preferences.getString(SolidityPreferences.COMPILER_PATH);
		if (pathToCompiler == null || pathToCompiler.isEmpty()) {
			return getFallbackCompilerPath();
		}
		return pathToCompiler;
	}

	protected abstract String getFallbackCompilerPath();

}
