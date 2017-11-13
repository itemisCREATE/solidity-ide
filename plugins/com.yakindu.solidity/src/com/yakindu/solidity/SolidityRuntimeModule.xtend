package com.yakindu.solidity

import com.google.inject.Binder
import com.yakindu.solidity.scoping.SolidityGlobalScopeProvider
import com.yakindu.solidity.typesystem.SolidityTypeInferrer
import com.yakindu.solidity.typesystem.SolidityTypeSystem
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem
import com.yakindu.solidity.scoping.SolidityScopeProvider
import com.yakindu.solidity.terminals.SolidityValueConverterService
import org.eclipse.xtext.validation.CompositeEValidator
import com.google.inject.name.Names

class SolidityRuntimeModule extends AbstractSolidityRuntimeModule {

	override configure(Binder binder) {
		super.configure(binder)
		binder.bind(ITypeSystem).to(SolidityTypeSystem);
		binder.bind(ITypeSystemInferrer).to(SolidityTypeInferrer)
		binder.bind(boolean).annotatedWith(Names.named(CompositeEValidator.USE_EOBJECT_VALIDATOR)).toInstance(false)
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

}
