package com.yakindu.solidity.compiler.builder.processor;

public enum SolidityError {
	ERROR_VAR_KEYWORD_DISALLOWED("Use of the \"var\" keyword is disallowed."),
	ERROR_FUNCTION_NAME_EQUALS_CONTRACT_NAME_DISALLOWED("Functions are not allowed to have the same name as the contract."),
	ERROR_THROW_KEYWORD_DISALLOWED("\"throw\" is deprecated in favour of \"revert()\", \"require()\" and \"assert()\""),
	ERROR_YEARS_IS_DISALLOWED("Using \"years\" as a unit denomination is deprecated."),
	ERROR_DATA_LOCATION_MUST_BE_MEMORY("Data location must be \"memory\" for parameter in function, but none was given."),
	ERROR_NO_VISIBILITY_SPECIFIED("No visibility specified.");

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
