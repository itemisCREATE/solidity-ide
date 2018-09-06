/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.generator.solidity;

import static com.yakindu.sct.generator.solidity.IFeatureConstants.LIBRARY_NAME;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.generator.core.library.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * 
 */
public class SolidityGeneratorDefaultValueProvider extends AbstractDefaultFeatureValueProvider {

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return library.getName().equals(LIBRARY_NAME);
	}

	@Override
	protected void setDefaultValue(FeatureType type, FeatureParameterValue parameterValue, EObject context) {
		if (type.getName().equals(IFeatureConstants.SOLIDITY)) {
			if (parameterValue.getStringValue().isEmpty()) {
				parameterValue.setValue("0.4.16");
			}

		}
	}

	public IStatus validateParameterValue(FeatureParameterValue parameterValue) {
		return Status.OK_STATUS;
	}
}
