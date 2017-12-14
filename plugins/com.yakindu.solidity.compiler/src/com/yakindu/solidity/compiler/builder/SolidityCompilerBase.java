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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.yakindu.solidity.compiler.SolidityCompilerActivator;
import com.yakindu.solidity.compiler.builder.processor.OutputHandler;
import com.yakindu.solidity.compiler.parameter.ParameterBuilder;
import com.yakindu.solidity.compiler.parameter.Source;
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

	@Override
	public void compile(List<URI> uris, IProgressMonitor progress) {
		Set<IPath> filesToCompile = Sets.newHashSet();
		for (URI uri : uris) {
			filesToCompile
					.add(ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true)).getLocation());
			filesToCompile.addAll(addImports(uri));
		}
		if (filesToCompile.isEmpty() || progress.isCanceled()) {
			return;
		}
		progress.beginTask("compiling ...", filesToCompile.size());
		try {
			Process process = new ProcessBuilder(getCompilerPath(), "--standard-json").start();
			sendInput(process.getOutputStream(), filesToCompile);
			handler.handleOutput(process.getInputStream());
			if (process.waitFor(30, TimeUnit.SECONDS) && process.exitValue() != 0) {
				throw new Exception("Solidity compiler invocation failed with exit code " + process.exitValue() + ".");
			}
			progress.done();

		} catch (Exception e) {
			e.printStackTrace();
			progress.done();
		}

	}

	private List<IPath> addImports(URI uri) {
		// TODO resolve uris to imported contracts
		return Lists.newArrayList();
	}

	public void compile(IFile file, IProgressMonitor progress) {
		if (file == null) {
			return;
		}
		progress.beginTask("compiling ..." + file.getName(), 10);
		try {
			Process process = new ProcessBuilder(getCompilerPath(), "--standard-json").start();
			sendInput(process.getOutputStream(), file);
			handler.handleOutput(process.getInputStream(), file);
			handler.handleError(process.getErrorStream(), file);
			if (process.waitFor(30, TimeUnit.SECONDS) && process.exitValue() != 0) {
				throw new Exception("Solidity compiler invocation failed with exit code " + process.exitValue() + ".");
			}
			progress.done();

		} catch (Exception e) {
			e.printStackTrace();
			progress.done();
		}
	}

	private void sendInput(OutputStream stream, IFile file) {
		try (OutputStreamWriter writer = new OutputStreamWriter(stream, Charset.forName("UTF-8"));) {
			writer.write(new ParameterBuilder().addSource(file.getName(), new Source(file)).buildJson());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendInput(OutputStream stream, Set<IPath> filesToCompile) {
		try (OutputStreamWriter writer = new OutputStreamWriter(stream, Charset.forName("UTF-8"));) {
			ParameterBuilder builder = new ParameterBuilder();
			for (IPath path : filesToCompile) {
				builder.addSource(path.lastSegment(), new Source(path));
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
