/**
 * Copyright (c) 2018 committers of YAKINDU and others.
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
public enum SolidityError {
	ERROR_LOCATION_HAS_TO_BE_MEMORY_FOR_PUBLIC_FUNCTIONS("Location has to be memory for publicly visible functions (remove the \"storage\" keyword)."),
	ERROR_INTERNAL_RECURSIVE_TYPE_NOT_ALLOWED_FOR_PUPLIC_FUNCTIONS("Location has to be memory for publicly visible functions (remove the \\\"storage\\\" keyword).");

	private final String message;

	SolidityError(String message) {
		this.message = message;
	}

	public static String getCodeForMessage(String message) {
		if (message != null) {
			for (SolidityError warning : values()) {
				if (message.startsWith(warning.message)) {
					return warning.name();
				}
			}
		}
		new RuntimeException(message).printStackTrace();
		return "UNKNOWN";
	}
}
