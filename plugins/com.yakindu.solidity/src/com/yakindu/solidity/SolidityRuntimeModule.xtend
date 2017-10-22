package com.yakindu.solidity

import com.google.inject.Binder
import com.yakindu.solidity.scoping.SolidityGlobalScopeProvider
import com.yakindu.solidity.typesystem.SolidityTypeInferrer
import com.yakindu.solidity.typesystem.SolidityTypeSystem
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem

class SolidityRuntimeModule extends AbstractSolidityRuntimeModule {

	override configure(Binder binder) {
		super.configure(binder)
		binder.bind(ITypeSystem).to(SolidityTypeSystem);
		binder.bind(ITypeSystemInferrer).to(SolidityTypeInferrer)
	}
	
	override bindIGlobalScopeProvider() {
		SolidityGlobalScopeProvider
	}

} 
