/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.domain.solidity.ui.simulation;

import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.generic.simulation.GenericSimulationModule;

import com.yakindu.solidity.typesystem.SolidityTypeSystem;
/**
 * 
 * @author Andreas Muelder - Initial contribution and API
 * 
 */
public class SoliditySimulationModule extends GenericSimulationModule {

	@Override
	protected ITypeSystem getTypeSystem() {
		return SolidityTypeSystem.getInstance();
	}
}
