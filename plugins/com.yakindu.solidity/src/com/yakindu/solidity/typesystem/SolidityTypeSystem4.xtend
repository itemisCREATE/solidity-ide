package com.yakindu.solidity.typesystem

import org.yakindu.base.types.typesystem.GenericTypeSystem
import com.google.inject.Singleton

@Singleton
class SolidityTypeSystem4 extends AbstractSolidityTypeSystem {
	
	val static INSTANCE = new SolidityTypeSystem4();

	def static GenericTypeSystem getInstance() {
		return INSTANCE;
	}
}
