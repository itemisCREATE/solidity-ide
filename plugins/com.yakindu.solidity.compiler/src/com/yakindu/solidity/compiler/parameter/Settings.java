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
package com.yakindu.solidity.compiler.parameter;

import java.util.Map;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public class Settings {

	private Optimizer optimizer;

	private Map<String, Library> libraries;

	private OutputSelection outputSelection;
	
	public Optimizer getOptimizer() {
		return optimizer;
	}

	public void setOptimizer(Optimizer optimizer) {
		this.optimizer = optimizer;
	}

	public Map<String, Library> getLibraries() {
		return libraries;
	}

	public void setLibraries(Map<String, Library> libraries) {
		this.libraries = libraries;
	}

	public OutputSelection getOutputSelection() {
		return outputSelection;
	}

	public void setOutputSelection(OutputSelection outputSelection) {
		this.outputSelection = outputSelection;
	}
}
