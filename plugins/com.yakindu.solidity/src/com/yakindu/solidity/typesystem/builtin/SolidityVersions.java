package com.yakindu.solidity.typesystem.builtin;

public interface SolidityVersions {
	public static final String SOLIDITY_VERSION = "SOLIDITY_VERSION";

	public static final String DEFAULT_VERSION = "^0.4.25";

	public enum Major {
		FOUR("^0.4");

		protected final String version;

		Major(String version) {
			this.version = version;
		}

	}

	public static Major majorVersion(String pragmaString) {
		if (pragmaString == null) {
			return majorVersion(DEFAULT_VERSION);
		}
		for (Major major : Major.values()) {
			if (pragmaString.startsWith(major.version)) {
				return major;
			}
		}
		return majorVersion(DEFAULT_VERSION);
	}
}
