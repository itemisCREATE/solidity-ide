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
 * Default value provider for Solidity generator for SCT feature library
 */
public class SolidityGeneratorDefaultValueProvider extends AbstractDefaultFeatureValueProvider {


	public boolean isProviderFor(FeatureTypeLibrary library) {
		return library.getName().equals(LIBRARY_NAME);
	}

	@Override
	protected void setDefaultValue(FeatureType type, FeatureParameterValue parameterValue, EObject context) {
		if(type.getName().equals(IFeatureConstants.SOLIDITY)){
			if(parameterValue.getStringValue().isEmpty()){
				parameterValue.setValue("0.4.16");
			}
			
		}
		System.out.println();
	}

	public IStatus validateParameterValue(FeatureParameterValue parameterValue) {
		return Status.OK_STATUS;
	}
}
