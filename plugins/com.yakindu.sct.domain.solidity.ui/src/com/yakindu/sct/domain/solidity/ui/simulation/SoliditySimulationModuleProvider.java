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

import org.yakindu.sct.domain.extension.IModuleProvider;
import org.yakindu.sct.domain.generic.simulation.SimulationModuleProvider;

import com.google.inject.Module;

public class SoliditySimulationModuleProvider extends SimulationModuleProvider implements IModuleProvider {

	@Override
	public Module getModule(String... options) {
		return new SoliditySimulationModule();
	}
	
}
