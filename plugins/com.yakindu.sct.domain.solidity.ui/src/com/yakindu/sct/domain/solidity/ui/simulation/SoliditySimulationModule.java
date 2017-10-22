package com.yakindu.sct.domain.solidity.ui.simulation;

import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.generic.simulation.GenericSimulationModule;

import com.yakindu.solidity.typesystem.SolidityTypeSystem;

public class SoliditySimulationModule extends GenericSimulationModule {

	@Override
	protected ITypeSystem getTypeSystem() {
		return SolidityTypeSystem.getInstance();
	}
}
