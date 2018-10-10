package com.yakindu.solidity.typesystem.builtin

import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.TypesFactory
import com.yakindu.solidity.solidity.SolidityFactory
import javax.inject.Inject

class BuiltInDeclarations5 extends BuiltInDeclarations {

	@Inject
	protected new(ITypeSystem typeSystem, TypesFactory typesFactory, SolidityFactory solidityFactory) {
		super(typeSystem, typesFactory, solidityFactory)
	}

}
