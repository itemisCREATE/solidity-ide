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
package com.yakindu.solidity.compiler.builder.processor;

import static com.yakindu.solidity.compiler.preferences.ICompilerPreferences.COMPILER_OUTPUT_ABI;
import static com.yakindu.solidity.compiler.preferences.ICompilerPreferences.COMPILER_OUTPUT_ASM;
import static com.yakindu.solidity.compiler.preferences.ICompilerPreferences.COMPILER_OUTPUT_GAS;

import com.yakindu.solidity.compiler.preferences.ICompilerPreferences;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public enum CompileOutputType {

	BIN(ICompilerPreferences.COMPILER_OUTPUT_BIN, "evm.bytecode.object"), ASM(COMPILER_OUTPUT_ASM, "evm.assembly"),
	ABI(COMPILER_OUTPUT_ABI, "abi"), GAS(COMPILER_OUTPUT_GAS, "evm.gasEstimates");
	public final String PREFERENCE_KEY;
	public final String COMPILER_KEY;

	CompileOutputType(String preferenceKey, String compilerKey) {
		this.PREFERENCE_KEY = preferenceKey;
		this.COMPILER_KEY = compilerKey;
	}

	public String extension() {
		return "." + this.name().toLowerCase();
	}
}
