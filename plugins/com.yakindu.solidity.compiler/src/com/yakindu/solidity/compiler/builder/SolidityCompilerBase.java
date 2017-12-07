/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - Itemis AG - initial API and implementation
 * 	Karsten Thoms   - Itemis AG - initial API and implementation
 * 	Florian Antony  - Itemis AG - initial API and implementation
 * 	committers of YAKINDU 
 * 
 */
package com.yakindu.solidity.compiler.builder;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.yakindu.solidity.compiler.SolidityCompilerActivator;
import com.yakindu.solidity.compiler.builder.processor.OutputHandler;
import com.yakindu.solidity.compilerparameter.ParameterBuilder;
import com.yakindu.solidity.compilerparameter.Source;
import com.yakindu.solidity.ui.preferences.SolidityPreferences;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public abstract class SolidityCompilerBase implements ISolidityCompiler {

	@Inject
	private IPreferenceStore preferences;
	@Inject
	private OutputHandler handler;

	protected abstract Path getPath();

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
		ParameterBuilder builder = new ParameterBuilder().addSource(file.getName(), new Source((IFile) file));
			
		List<String> parameters = Lists.newArrayList();

		parameters.add(getCompilerPath());
		parameters.add("--standard-json");
		parameters.add(builder.buildJson());
		return parameters;

		// boolean bin =
		// preferences.getBoolean(SolidityPreferences.COMPILER_OUTPUT_BIN);
		// boolean ast =
		// preferences.getBoolean(SolidityPreferences.COMPILER_OUTPUT_AST);
		// boolean abi =
		// preferences.getBoolean(SolidityPreferences.COMPILER_OUTPUT_ABI);
		// boolean asm =
		// preferences.getBoolean(SolidityPreferences.COMPILER_OUTPUT_ASM);
		// List<String> parameters = Lists.newArrayList();
		// parameters.add(getCompilerPath());
		// if (bin) {
		// parameters.add("--bin");
		// }
		// if (abi) {
		// parameters.add("--abi");
		// }
		// if (ast) {
		// parameters.add("--ast");
		// }
		// if (asm) {
		// parameters.add("--asm");
		//
		// }
		// parameters.add(file.getLocation().toOSString());
		// return parameters;
	}

	private String getCompilerPath() {
		String pathToCompiler = preferences.getString(SolidityPreferences.COMPILER_PATH);
		if (pathToCompiler == null || pathToCompiler.isEmpty()) {
			return getFallbackCompilerPath();
		}
		return pathToCompiler;
	}

	protected String getFallbackCompilerPath() {
		Bundle bundle = Platform.getBundle(SolidityCompilerActivator.PLUGIN_ID);
		URL url = FileLocator.find(bundle, getPath(), null);
		try {
			URL fileURL = FileLocator.toFileURL(url);
			return fileURL.getFile();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
}
