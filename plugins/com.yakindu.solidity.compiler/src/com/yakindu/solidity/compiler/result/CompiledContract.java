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

import java.util.List;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public class CompiledContract {
	private String name;
	private Documentation userdoc;
	private Documentation devdoc;
	private EvmOutput evm;
	private List<Abi> abi;

	public List<Abi> getAbi() {
		return abi;
	}
	public void setAbi(List<Abi> abi) {
		this.abi = abi;
	}
	public Documentation getUserdoc() {
		return userdoc;
	}
	public void setUserdoc(Documentation userdoc) {
		this.userdoc = userdoc;
	}
	public Documentation getDevdoc() {
		return devdoc;
	}
	public void setDevdoc(Documentation devdoc) {
		this.devdoc = devdoc;
	}
	public EvmOutput getEvm() {
		return evm;
	}
	public void setEvm(EvmOutput evm) {
		this.evm = evm;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
