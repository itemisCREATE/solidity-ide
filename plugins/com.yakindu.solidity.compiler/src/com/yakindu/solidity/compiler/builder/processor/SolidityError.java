package com.yakindu.solidity.compiler.builder.processor;

public enum SolidityError {
	ERROR_VAR_KEYWORD_DISALLOWED("Use of the \"var\" keyword is disallowed."),
	ERROR_FUNCTION_NAME_EQUALS_CONTRACT_NAME_DISALLOWED("Functions are not allowed to have the same name as the contract."),
	ERROR_CONSTANT_MODIFIER_WAS_REMOVED("The state mutability modifier \"constant\" was removed in version 0.5.0."),
	ERROR_THROW_KEYWORD_DISALLOWED("\"throw\" is deprecated in favour of \"revert()\", \"require()\" and \"assert()\""),
	ERROR_INVALID_IMPLICID_CONVERSION_TO_ADDRESS_PAYABLE("Invalid type for argument in function call. Invalid implicit conversion from address to address payable requested."),
	ERROR_FUNCTION_DECLARED_AS_PURE_BUT_MUST_BE_VIEW("Function declared as pure, but this expression (potentially) reads from the environment or state and thus requires \"view\"."),
	ERROR_YEARS_IS_DISALLOWED("Using \"years\" as a unit denomination is deprecated."),
	ERROR_DATA_LOCATION_MUST_BE_SPECIFIED_FOR_VARIABLE("Data location must be \"storage\" or \"memory\" for variable, but none was given."),
	ERROR_DATA_LOCATION_MUST_BE_CALLDATA_FOR_EXTERNAL_PARAMETER("Data location must be \"calldata\" for parameter in external function, but none was given."),
	ERROR_DATA_LOCATION_MUST_BE_MEMORY_FOR_PARAMETER("Data location must be \"memory\" for parameter in function, but none was given."),
	ERROR_DATA_LOCATION_MUST_BE_STORAGE_OR_MEMORY_FOR_PARAMETER("Data location must be \"storage\" or \"memory\" for parameter in function, but none was given."),
	ERROR_DATA_LOCATION_MUST_BE_MEMORY_FOR_RETURN_PARAMETER("Data location must be \"memory\" for return parameter in function, but none was given."),
	ERROR_DATA_LOCATION_MUST_BE_MEMORY_OR_STORAGE_FOR_RETURN_PARAMETER("Data location must be \"storage\" or \"memory\" for return parameter in function, but none was given."),
	ERROR_MEMBER_TRANSFER_NOT_FOUND_OR_VISIBLE("Member \"transfer\" not found or not visible after argument-dependent lookup in address."),
	ERROR_STATE_MUTABILITY_ONLY_ALLOWED_FOR_ADDRESS("State mutability can only be specified for address types."),
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
