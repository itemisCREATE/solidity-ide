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

package com.yakindu.solidity

import com.google.inject.Binder
import com.google.inject.name.Names
import com.yakindu.solidity.scoping.SolidityGlobalScopeProvider
import com.yakindu.solidity.scoping.SolidityImportedNamespaceAwareLocalScopeProvider
import com.yakindu.solidity.scoping.SolidityResourceDescriptionStrategy
import com.yakindu.solidity.scoping.SolidityScopeProvider
import com.yakindu.solidity.solidity.SolidityFactory
import com.yakindu.solidity.solidity.SolidityPackage
import com.yakindu.solidity.terminals.SolidityValueConverterService
import com.yakindu.solidity.typesystem.SolidityTypeInferrer
import com.yakindu.solidity.typesystem.SolidityTypeSystem
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider
import org.eclipse.xtext.validation.CompositeEValidator
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.TypesPackage
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class SolidityRuntimeModule extends AbstractSolidityRuntimeModule {
	public static final String SOLIDITY_VERSION = "SOLIDITY_VERSION"

	override configure(Binder binder) {
		super.configure(binder)
		binder.bind(ITypeSystem).to(SolidityTypeSystem);
		binder.bind(ITypeSystemInferrer).to(SolidityTypeInferrer)
		binder.bind(boolean).annotatedWith(Names.named(CompositeEValidator.USE_EOBJECT_VALIDATOR)).toInstance(false)
		binder.bind(IDefaultResourceDescriptionStrategy).to(SolidityResourceDescriptionStrategy);
		binder.bind(SolidityPackage).toInstance(SolidityPackage.eINSTANCE)
		binder.bind(SolidityFactory).toInstance(SolidityFactory.eINSTANCE)
		binder.bind(TypesPackage).toInstance(TypesPackage.eINSTANCE)
		binder.bind(TypesFactory).toInstance(TypesFactory.eINSTANCE)
		binder.bind(String).annotatedWith(Names.named(SOLIDITY_VERSION)).toInstance("0.4.19")
	}

	override bindIGlobalScopeProvider() {
		SolidityGlobalScopeProvider
	}

	override bindIScopeProvider() {
		SolidityScopeProvider
	}

	override bindIValueConverterService() {
		SolidityValueConverterService
	}

	override configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(
			SolidityImportedNamespaceAwareLocalScopeProvider);
	}
}
