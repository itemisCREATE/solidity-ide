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
package com.yakindu.solidity.ui.preferences;

/**
 * Preference constants.
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 * @author Karsten Thoms
 */
public interface SolidityPreferences {

	String COMPILER_ENABLED = "compiler.enabled";
	String COMPILER_PATH = "compiler.path";

	String COMPILER_OUTPUT_BIN = "compiler.output.bin";
	String COMPILER_OUTPUT_ABI = "compiler.output.abi";
//	String COMPILER_OUTPUT_AST = "compiler.output.ast";
	String COMPILER_OUTPUT_ASM = "compiler.output.asm";
	String COMPILER_OUTPUT_GAS = "compiler.output.gas";
	String COMPILER_OUTPUT_PATH = "compiler.output.path";

	String FOLDING_COMMENT_AUTOFOLD = "folding.comment.autofold";
	String FOLDING_COMMENT_AUTOFOLD_NONE = "folding.comment.autofold.none";
	String FOLDING_COMMENT_AUTOFOLD_HEADER = "folding.comment.autofold.header";
	String FOLDING_COMMENT_AUTOFOLD_ALL = "folding.comment.autofold.all";
	String FOLDING_COMMENT_LINECOUNT = "folding.comment.line_count";
}
