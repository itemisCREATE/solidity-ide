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
package com.yakindu.solidity.typesystem;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;

import com.yakindu.solidity.solidity.PragmaSolidityDirective;
import com.yakindu.solidity.solidity.SourceUnit;

/**
 * 
 * @author Florian Antony - initial contribution and API.
 *
 * @param <T>
 */
public interface IPragmaAwareProvider<T> {

	public static final String SOLIDITY_VERSION = "SOLIDITY_VERSION";
	public static final String DEFAULT_VERSION = "^0.4.25";
	
	public enum MajorSolidityVersion {
		FOUR("^0.4"), FIVE("^0.5");

		protected final String version;

		MajorSolidityVersion(String version) {
			this.version = version;
		}
		
		public static MajorSolidityVersion versionFor(String pragmaString) {
			if (pragmaString == null) {
				return versionFor(DEFAULT_VERSION);
			}
			for (MajorSolidityVersion major : values()) {
				if (pragmaString.startsWith(major.version)) {
					return major;
				}
			}
			return versionFor(DEFAULT_VERSION);
		}
	}

	default String calculatePragma(Resource resource) {
		PragmaSolidityDirective pragma = (PragmaSolidityDirective) EcoreUtil2.eAllContentsAsList(resource).stream()
				.filter(eObject -> eObject instanceof PragmaSolidityDirective).findFirst().orElseGet(() -> null);
		if (pragma != null) {
			return pragma.getVersion();
		}
		return DEFAULT_VERSION;
	}

	default String calculatePragma(EObject element) {
		SourceUnit sourceUnit = (SourceUnit) EcoreUtil2.getContainerOfType(element, SourceUnit.class);
		List<PragmaSolidityDirective> pragmaDirectives = EcoreUtil2.getAllContentsOfType(sourceUnit,
				PragmaSolidityDirective.class);
		if (!pragmaDirectives.isEmpty()) {
			PragmaSolidityDirective pragmaDirective = pragmaDirectives.get(0);
			if (pragmaDirective != null) {
				return pragmaDirective.getVersion();
			}
		}
		return DEFAULT_VERSION;
	}

	public T provideFor(EObject element);
	
	public T provideFor(Resource resource);
}
