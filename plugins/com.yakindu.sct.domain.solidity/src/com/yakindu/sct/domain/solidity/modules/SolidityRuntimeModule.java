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

import org.eclipse.xtext.scoping.IScopeProvider;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.model.stext.STextRuntimeModule;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper;
import org.yakindu.sct.model.stext.validation.STextJavaValidator;

import com.google.inject.Binder;
import com.google.inject.name.Names;
import com.yakindu.sct.domain.solidity.scoping.SolidityImportUriMapper;
import com.yakindu.sct.domain.solidity.validation.SolidityJavaValidator;
import com.yakindu.solidity.scoping.SolidityScopeProvider;
import com.yakindu.solidity.typesystem.SolidityTypeInferrer;
import com.yakindu.solidity.typesystem.SolidityTypeSystem;

public class SolidityRuntimeModule extends STextRuntimeModule {

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named(DomainRegistry.DOMAIN_ID))
				.toInstance("com.yakindu.domain.solidity");
	}
	
	public Class<? extends IPackageImport2URIMapper> bindIPackageImport2URIMapper() {
		return SolidityImportUriMapper.class;
	}


	@Override
	protected ITypeSystem getTypeSystem() {
		return SolidityTypeSystem.getInstance();
	}

	@Override
	@org.eclipse.xtext.service.SingletonBinding(eager = true)
	public Class<? extends STextJavaValidator> bindSTextJavaValidator() {
		return SolidityJavaValidator.class;
	}

	@Override
	public Class<? extends ITypeSystemInferrer> bindITypeSystemInferrer() {
		return SolidityTypeInferrer.class;
	}
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return SolidityScopeProvider.class;
	}
}
