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
