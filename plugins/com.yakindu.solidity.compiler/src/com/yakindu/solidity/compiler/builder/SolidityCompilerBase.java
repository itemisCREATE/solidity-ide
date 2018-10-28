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

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import com.google.inject.Inject;
import com.yakindu.solidity.compiler.SolidityCompilerActivator;
import com.yakindu.solidity.compiler.builder.processor.CompileOutputType;
import com.yakindu.solidity.compiler.builder.processor.OutputParser;
import com.yakindu.solidity.compiler.parameter.ParameterBuilder;
import com.yakindu.solidity.compiler.parameter.Source;
import com.yakindu.solidity.compiler.result.CompilerOutput;
import com.yakindu.solidity.ui.preferences.SolidityPreferencesFacade;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public class SolidityCompilerBase implements ISolidityCompiler {

	@Inject
	private SolidityPreferencesFacade prefs;

	@Inject
	private OutputParser outputParser;

	protected Path getPath() {
		throw new IllegalStateException("No path to solc defined. Please specify it in preferences.");
	}

	@Override
	public Optional<CompilerOutput> compile(Set<IResource> filesToCompile, IProgressMonitor progress) {
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

	private void sendInput(OutputStream stream, Set<IResource> filesToCompile) {
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
			for (IResource resource : filesToCompile) {
				if (resource instanceof IFile) {
					IFile file = (IFile) resource;
					builder.addSource(file.getLocation().lastSegment(), new Source(file));
				}
			}
			builder.addOutput(CompileOutputType.GAS.COMPILER_KEY);
			writer.write(builder.buildJson());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String getCompilerPath() {
		String pathToCompiler = prefs.getCompilerPath();
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
			File file = new File(fileURL.toURI());
			if (!file.canExecute())
				file.setExecutable(true);
			return fileURL.getFile();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
