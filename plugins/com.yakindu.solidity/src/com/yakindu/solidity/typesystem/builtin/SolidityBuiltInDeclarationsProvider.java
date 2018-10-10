/**
 * Copyright (c) 2018 committers of YAKINDU and others.
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
package com.yakindu.solidity.typesystem.builtin;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.yakindu.solidity.solidity.PragmaSolidityDirective;
import com.yakindu.solidity.solidity.SourceUnit;



/**
 * @author Florian Antony - initial contribution and API.
 *
 */
@Singleton
public class SolidityBuiltInDeclarationsProvider implements IBuiltInDeclarationsProvider {

	@Inject
	private Map<SolidityVersions.Major, BuiltInDeclarations> builtInDeclarations;

	@Override
	public BuiltInDeclarations provideFor(EObject element) {
		return builtInDeclarations.get(SolidityVersions.majorVersion(calculatePragma(element)));
	}

	@Override
	public BuiltInDeclarations provideFor(Resource resource) {
		return builtInDeclarations.get(SolidityVersions.majorVersion(calculatePragma(resource)));
	}

	private String calculatePragma(Resource resource) {
		PragmaSolidityDirective pragma = (PragmaSolidityDirective) EcoreUtil2.eAllContentsAsList(resource).stream()
				.filter(eObject -> eObject instanceof PragmaSolidityDirective).findFirst().orElseGet(() -> null);
		if (pragma != null) {
			return pragma.getVersion();
		}
		return SolidityVersions.DEFAULT_VERSION;
	}

	private String calculatePragma(EObject element) {
		SourceUnit sourceUnit = (SourceUnit) EcoreUtil2.getContainerOfType(element, SourceUnit.class);
		List<PragmaSolidityDirective> pragmaDirectives = EcoreUtil2.getAllContentsOfType(sourceUnit,
				PragmaSolidityDirective.class);
		if (!pragmaDirectives.isEmpty()) {
			PragmaSolidityDirective pragmaDirective = pragmaDirectives.get(0);
			if (pragmaDirective != null) {
				return pragmaDirective.getVersion();
			}
		}
		return SolidityVersions.DEFAULT_VERSION;
	}
}
