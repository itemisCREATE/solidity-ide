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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.yakindu.solidity.ui.preferences.SolidityPreferences;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * @author Karsten Thoms
 */
public class SolidityBuilderParticipant implements IXtextBuilderParticipant {

	public static final String ID = "com.yakindu.solidity.ide.builder.solidityBuilder";

	@Inject
	private IPreferenceStore preferences;
	@Inject(optional = true)
	private ISolidityCompiler compiler;

	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor);
		if (!isEnabled(context) || compiler == null) {
			return;
		}
		final List<IResourceDescription.Delta> deltas = getRelevantDeltas(context);
		if (deltas.isEmpty()) {
			return;
		}
		if (progress.isCanceled()) {
			throw new OperationCanceledException();
		}
		progress.beginTask("Compiling solidity...", deltas.size());

		List<URI> uris = deltas.stream().map(delta -> delta.getUri()).collect(Collectors.toList());
		compiler.compile(uris, progress);
		context.getBuiltProject().refreshLocal(IProject.DEPTH_INFINITE, progress);
		progress.done();

	}

	private List<Delta> getRelevantDeltas(IBuildContext context) {
		List<Delta> filtered = Lists.newArrayList();
		for (Delta delta : context.getDeltas()) {
			if (delta.getUri().fileExtension().equals("sol")) {
				filtered.add(delta);
			}
		}
		return filtered;
	}

	// TODO turn it on and off by preference
	private boolean isEnabled(IBuildContext context) {
		return preferences.getBoolean(SolidityPreferences.COMPILER_ENABLED);
	}

	// TODO configure by preference
	protected Map<String, OutputConfiguration> getOutputConfigurations(IBuildContext context) {
		return Maps.newHashMap();
	}

}
