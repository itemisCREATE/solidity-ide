/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.domain.solidity.modules;

import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.yakindu.base.types.TypesFactory;
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
import com.yakindu.solidity.scoping.SolidityGlobalScopeProvider;
import com.yakindu.solidity.scoping.SolidityScopeProvider;
import com.yakindu.solidity.solidity.SolidityFactory;
import com.yakindu.solidity.typesystem.SolidityTypeInferrer;
import com.yakindu.solidity.typesystem.AbstractSolidityTypeSystem;
/**
 * 
 * @author Andreas Muelder - Initial contribution and API
 * 
 */
public class SolidityRuntimeModule extends STextRuntimeModule {

	public static final String DOMAIN_SOLIDITY = "com.yakindu.domain.solidity";

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class).annotatedWith(Names.named(DomainRegistry.DOMAIN_ID)).toInstance(DOMAIN_SOLIDITY);
		binder.bind(TypesFactory.class).toInstance(TypesFactory.eINSTANCE);
		binder.bind(SolidityFactory.class).toInstance(SolidityFactory.eINSTANCE);
		binder.bind(ITypeSystem.class).toInstance(getTypeSystem());
	}

	public Class<? extends IPackageImport2URIMapper> bindIPackageImport2URIMapper() {
		return SolidityImportUriMapper.class;
	}

	@Override
	protected ITypeSystem getTypeSystem() {
		return AbstractSolidityTypeSystem.getInstance();
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
	
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return SolidityGlobalScopeProvider.class;
	}
}
