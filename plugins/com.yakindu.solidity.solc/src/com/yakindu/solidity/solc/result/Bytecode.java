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

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public class Bytecode {

	// The bytecode as a hex string.
	private String object;

	// Opcodes list (string)
	private String opcodes;

	// The source mapping as a string. See the source mapping definition.
	private String sourceMap;

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getOpcodes() {
		return opcodes;
	}

	public void setOpcodes(String opcodes) {
		this.opcodes = opcodes;
	}

	public String getSourceMap() {
		return sourceMap;
	}

	public void setSourceMap(String sourceMap) {
		this.sourceMap = sourceMap;
	}

}
