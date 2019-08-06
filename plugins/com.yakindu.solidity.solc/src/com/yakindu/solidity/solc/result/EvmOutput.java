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
package com.yakindu.solidity.solc.result;

import java.util.Map;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public class EvmOutput {
	// Assembly (string)
	private String assembly;

	// Bytecode and related details.
	private Bytecode bytecode;

	private Bytecode deployedBytecode;

	private Map<String, String> methodIdentifiers;

	private GasEstimates gasEstimates;

	public String getAssembly() {
		return assembly;
	}

	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}

	public Bytecode getBytecode() {
		return bytecode;
	}

	public void setBytecode(Bytecode bytecode) {
		this.bytecode = bytecode;
	}

	public Bytecode getDeployedBytecode() {
		return deployedBytecode;
	}

	public void setDeployedBytecode(Bytecode deployedBytecode) {
		this.deployedBytecode = deployedBytecode;
	}

	public Map<String, String> getMethodIdentifiers() {
		return methodIdentifiers;
	}

	public void setMethodIdentifiers(Map<String, String> methodIdentifiers) {
		this.methodIdentifiers = methodIdentifiers;
	}

	public GasEstimates getGasEstimates() {
		return gasEstimates;
	}

	public void setGasEstimates(GasEstimates gasEstimates) {
		this.gasEstimates = gasEstimates;
	}

}
