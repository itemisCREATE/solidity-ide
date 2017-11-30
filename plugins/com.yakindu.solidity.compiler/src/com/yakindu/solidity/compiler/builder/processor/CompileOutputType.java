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

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public enum CompileOutputType {

	BINARY(".bin"), AST(".ast"), ASM(".asm"), ABI(".abi");

	public final String EXTENSION;

	CompileOutputType(String fileExtension) {
		this.EXTENSION = fileExtension;
	}

	public static CompileOutputType getTypeForTrigger(String trigger) {
		if (trigger.startsWith("Contract JSON ABI")) {
			return CompileOutputType.ABI;
		} else if (trigger.startsWith("Binary:")) {
			return CompileOutputType.BINARY;
		} else if (trigger.startsWith("Syntax trees:") || trigger.startsWith("JSON AST (compact format):")) {
			return CompileOutputType.AST;
		} else if (trigger.startsWith("EVM assembly:")) {
			return CompileOutputType.ASM;
		}
		return null;
	}
}
