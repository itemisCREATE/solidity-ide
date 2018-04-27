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
 * @author Andreas Muelder
 *
 */
public enum SolidityWarning {
	WARNING_FILE_NO_PRAGMA_SOLIDITY("Source file does not specify required compiler version!"),
	WARNING_FUNCTION_VISIBILITY("No visibility specified. Defaulting to"),
	WARNING_FUNCTION_UNUSED_PARAMETER("Unused function parameter."),
	WARNING_LOCAL_VARIABLE_UNUSED("Unused local variable."),
	WARNING_MSG_VALUE_IN_NON_PAYABLE("\"msg.value\" used in non-payable function."),
	WARNING_DEPRECATED_CALLCODE("\"callcode\" has been deprecated in favour of \"delegatecall\"."),
	WARNING_DEPRECATED_THROW("\"throw\" is deprecated"),
	WARNING_DEPRECATED_SHA3("\"sha3\" has been deprecated in favour of \"keccak256\""),
	WARNING_DEPRECATED_SUICIDE("\"suicide\" has been deprecated in favour of \"selfdestruct\""),
	WARNING_DEPRECATED_NAMED_FUNCTION_RETURN_VALUES("Naming function type return parameters is deprecated."),
	WARNING_DEPRECATED_NAMED_FUNCTION_PARAMETERS("Naming function type parameters is deprecated."),
	WARNING_DEPRECATED_FUNCTION_CONSTRUCTOR("Defining constructors as functions with the same name as the contract is deprecated. Use \"constructor(...) { ... }\" instead."),
	WARNING_AMBIGUES_ADDRESS("This looks like an address but has an invalid checksum."),
	WARNING_USSAGE_OF_SEND("Failure condition of 'send' ignored."),
	WARNING_VARIABLE_STORAGE_POINTER("Variable is declared as a storage pointer."),
	WARNING_FUNCTION_STATE_MUTABILITY_VIEW("Function state mutability can be restricted to view"),
	WARNING_FUNCTION_STATE_MUTABILITY_PURE("Function state mutability can be restricted to pure"),
	WARNING_SHADOWED_DECLARATION("This declaration shadows an existing declaration.");

	private final String message;

	SolidityWarning(String message) {
		this.message = message;
	}

	public static String getCodeForMessage(String message) {
		if (message != null) {
			for (SolidityWarning warning : values()) {
				if (message.startsWith(warning.message)) {
					return warning.name();
				}
			}
		}
		new RuntimeException(message).printStackTrace();
		return "UNKNOWN";
	}
}
