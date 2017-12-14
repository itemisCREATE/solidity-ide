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
package com.yakindu.solidity.compiler.result;

import java.util.Map;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public class GasEstimates {
	Map<String, String> creation;
	Map<String, String> external;
	Map<String, String> internal;
	public Map<String, String> getCreation() {
		return creation;
	}
	public void setCreation(Map<String, String> creation) {
		this.creation = creation;
	}
	public Map<String, String> getExternal() {
		return external;
	}
	public void setExternal(Map<String, String> external) {
		this.external = external;
	}
	public Map<String, String> getInternal() {
		return internal;
	}
	public void setInternal(Map<String, String> internal) {
		this.internal = internal;
	}

}
