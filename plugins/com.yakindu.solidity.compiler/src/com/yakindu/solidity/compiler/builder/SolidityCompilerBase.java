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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.yakindu.solidity.compiler.SolidityCompilerActivator;
import com.yakindu.solidity.compiler.builder.processor.OutputHandler;
import com.yakindu.solidity.compiler.parameter.ParameterBuilder;
import com.yakindu.solidity.compiler.parameter.Source;
import com.yakindu.solidity.ui.preferences.SolidityPreferences;
import com.yakindu.solidity.compiler.builder.processor.CompileOutputType;

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

	@Override
	public void compile(List<URI> uris, IProgressMonitor progress) {
		Set<IResource> filesToCompile = getFilesToCompile(uris);
		if (filesToCompile.isEmpty() || progress.isCanceled()) {
			return;
		}
		progress.beginTask("compiling ...", filesToCompile.size());
		try {
			Process process = new ProcessBuilder(getCompilerPath(), "--standard-json").start();
			sendInput(process.getOutputStream(), filesToCompile);
			handler.handleOutput(process.getInputStream(), filesToCompile);
			if (process.waitFor(30, TimeUnit.SECONDS) && process.exitValue() != 0) {
				throw new Exception("Solidity compiler invocation failed with exit code " + process.exitValue() + ".");
			}
			progress.done();

		} catch (Exception e) {
			e.printStackTrace();
			progress.done();
		}

	}

	private Set<IResource> getFilesToCompile(List<URI> uris) {
		Set<IResource> filesToCompile = Sets.newHashSet();
		for (URI uri : uris) {
			IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true));
			filesToCompile.add(resource);
			filesToCompile.addAll(addImports(uri));
		}
		return filesToCompile;
	}

	private Set<IResource> addImports(URI uri) {
		// TODO resolve uris to imported contracts
		return Sets.newHashSet();
	}

	private void sendInput(OutputStream stream, Set<IResource> filesToCompile) {
		try (OutputStreamWriter writer = new OutputStreamWriter(stream, Charset.forName("UTF-8"));) {
			ParameterBuilder builder = new ParameterBuilder();
			boolean bin = preferences.getBoolean(CompileOutputType.BIN.PREFERENCE_KEY);
			boolean ast = preferences.getBoolean(CompileOutputType.AST.PREFERENCE_KEY);
			boolean abi = preferences.getBoolean(CompileOutputType.ABI.PREFERENCE_KEY);
			boolean asm = preferences.getBoolean(CompileOutputType.ASM.PREFERENCE_KEY);
			if (bin) {
				builder.addOutput(CompileOutputType.BIN.outputKey());
			}
			if (abi) {
				builder.addOutput(CompileOutputType.ABI.outputKey());
			}
			if (ast) {
				builder.addOutput(CompileOutputType.AST.outputKey());
			}
			if (asm) {
				builder.addOutput(CompileOutputType.ASM.outputKey());

			}
			for (IResource resource : filesToCompile) {
				if (resource instanceof IFile) {
					IFile file = (IFile) resource;
					builder.addSource(file.getLocation().lastSegment(), new Source(file));
				}
			}
			writer.write(builder.buildJson());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
