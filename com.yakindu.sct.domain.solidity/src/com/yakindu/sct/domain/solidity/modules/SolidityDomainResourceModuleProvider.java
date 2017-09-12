/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 	Florian Antony - itemis AG
 * 
 */
package com.yakindu.sct.domain.solidity.modules;

import org.yakindu.sct.domain.extension.IModuleProvider;
import org.yakindu.sct.domain.generic.resource.ResourceModuleProvider;

import com.google.inject.Module;

public class SolidityDomainResourceModuleProvider extends ResourceModuleProvider implements IModuleProvider {

	@Override
	protected Module getLanguageRuntimeModule() {
		return new SolidityRuntimeModule();
	}
}
