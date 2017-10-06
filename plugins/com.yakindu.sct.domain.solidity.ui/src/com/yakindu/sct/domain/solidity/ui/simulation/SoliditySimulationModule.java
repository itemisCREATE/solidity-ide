/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 	Florian Antony - itemis AG
 * 
 */
package com.yakindu.sct.domain.solidity.ui.simulation;

import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.generic.simulation.GenericSimulationModule;

import com.yakindu.sct.domain.solidity.typesystem.SolidityTypeSystem;

public class SoliditySimulationModule extends GenericSimulationModule {

	@Override
	protected ITypeSystem getTypeSystem() {
		return SolidityTypeSystem.getInstance();
	}
}
