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
package com.yakindu.solidity.typesystem.builtin;

import com.yakindu.solidity.typesystem.builtin.SolidityVersions;

/**
 * @author Florian Antony - initial contribution and API.
 *
 */
public interface SolidityVersions {
	public static final String SOLIDITY_VERSION = "SOLIDITY_VERSION";

	public static final String DEFAULT_VERSION = "^0.4.25";

	public enum Major {
		FOUR("^0.4"), FIVE("^0.5");

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
