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
package com.yakindu.solidity.solc;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.yakindu.solidity.solc.output.CompileOutputType;
import com.yakindu.solidity.solc.output.OutputParser;
import com.yakindu.solidity.solc.parameter.ParameterBuilder;
import com.yakindu.solidity.solc.parameter.Source;
import com.yakindu.solidity.solc.preferences.ICompilerPreferences;
import com.yakindu.solidity.solc.result.CompilerOutput;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public abstract class SolidityCompilerBase implements ISolidityCompiler {

	@Inject
	private ICompilerPreferences prefs;

	@Inject
	private OutputParser outputParser;

	protected Path getPath() {
		throw new IllegalStateException("No path to solc defined. Please specify it in preferences.");
	}

	@Override
	public Optional<CompilerOutput> compile(Set<File> filesToCompile, IProgressMonitor progress) {
		if (filesToCompile.isEmpty() || progress.isCanceled()) {
			return Optional.empty();
		}
		progress.beginTask("compiling ...", filesToCompile.size());
		try {

			Process process = new ProcessBuilder(getCompilerPath(), "--standard-json").start();
			sendInput(process.getOutputStream(), filesToCompile);
			Optional<CompilerOutput> result = outputParser.parse(process.getInputStream(), filesToCompile);

			if (process.waitFor(30, TimeUnit.SECONDS) && process.exitValue() != 0) {
				throw new Exception("Solidity compiler invocation failed with exit code " + process.exitValue() + ".");
			}
			progress.done();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			progress.done();
			return Optional.empty();
		}
	}

	protected Set<File> addImports(URI uri) {
		// TODO resolve uris to imported contracts
		return Sets.newHashSet();
	}

	protected void sendInput(OutputStream stream, Set<File> filesToCompile) {
		try (OutputStreamWriter writer = new OutputStreamWriter(stream, Charset.forName("UTF-8"));) {
			ParameterBuilder builder = new ParameterBuilder();
			if (prefs.isWriteBINFile()) {
				builder.addOutput(CompileOutputType.BIN.COMPILER_KEY);
			}
			if (prefs.isWriteABIFile()) {
				builder.addOutput(CompileOutputType.ABI.COMPILER_KEY);
			}
			if (prefs.isWriteASMFile()) {
				builder.addOutput(CompileOutputType.ASM.COMPILER_KEY);
			}
			for (File resource : filesToCompile) {
				if (resource.isFile()) {
					builder.addSource(resource.getName(), new Source(resource));
				}
			}
			builder.addOutput(CompileOutputType.GAS.COMPILER_KEY);
			writer.write(builder.buildJson());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected String getCompilerPath() {
		Optional<String> pathToCompiler = prefs.getCompilerPath();
		String compilerPath;
		if (pathToCompiler.isPresent()) {
			compilerPath = pathToCompiler.get();
		} else {
			compilerPath = getBuiltInCompilerPath();
		}
		File file = new File(compilerPath);
		if (!file.canExecute()) {
			if(!file.setExecutable(true)) {
				throw new IllegalStateException("Compiler is not executabel and cannot be set to be.");
			};			
		}
		return compilerPath;
	}

	protected String getBuiltInCompilerPath() {
		Bundle bundle = Platform.getBundle(SolidityCompilerActivator.PLUGIN_ID);
		URL url = FileLocator.find(bundle, getPath(), null);
		try {
			URL fileURL = FileLocator.toFileURL(url);
			return fileURL.getFile();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
