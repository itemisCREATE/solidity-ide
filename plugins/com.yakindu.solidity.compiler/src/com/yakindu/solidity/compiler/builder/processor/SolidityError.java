package com.yakindu.solidity.compiler.builder.processor;

public enum SolidityError {
	ERROR_VAR_KEYWORD_DISALLOWED("Use of the \"var\" keyword is disallowed."),
	ERROR_FUNCTION_NAME_EQUALS_CONTRACT_NAME_DISALLOWED("Functions are not allowed to have the same name as the contract."),
	ERROR_CONSTANT_MODIFIER_WAS_REMOVED("The state mutability modifier \"constant\" was removed in version 0.5.0."),
	ERROR_THROW_KEYWORD_DISALLOWED("\"throw\" is deprecated in favour of \"revert()\", \"require()\" and \"assert()\""),
	ERROR_YEARS_IS_DISALLOWED("Using \"years\" as a unit denomination is deprecated."),
	ERROR_DATA_LOCATION_MUST_BE_SPECIFIED_FOR_VARIABLE("Data location must be \"storage\" or \"memory\" for variable, but none was given."),
	ERROR_DATA_LOCATION_MUST_BE_CALLDATA_FOR_EXTERNAL_PARAMETER("Data location must be \"calldata\" for parameter in external function, but none was given."),
	ERROR_DATA_LOCATION_MUST_BE_MEMORY_FOR_PARAMETER("Data location must be \"memory\" for parameter in function, but none was given."),
	ERROR_DATA_LOCATION_MUST_BE_MEMORY_FOR_RETURN_PARAMETER("Data location must be \"memory\" for return parameter in function, but none was given."),
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
