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
package com.yakindu.solidity.solc.result;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public class CompiledSource {

	private Integer id;
	private String ast;
	private String name;
	private String src;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAst() {
		return ast;
	}

	public void setAst(String ast) {
		this.ast = ast;
	}

	public void setName(String name) {
		this.name = name;

	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getName() {
		return name;
	}

	public String getSrc() {
		return src;
	}
}
