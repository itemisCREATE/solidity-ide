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
package com.yakindu.solidity.compiler.parameter;

import com.google.gson.Gson;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public class ParameterBuilder {

	private Parameter parameter;

	public ParameterBuilder() {
		this("Solidity");
	}

	public ParameterBuilder(String language) {
		this.parameter = new Parameter();
		this.parameter.setLanguage(language);
	}

	public String buildJson() {
		return new Gson().toJson(parameter);
	}

	public ParameterBuilder addSource(String name, Source source) {
		this.parameter.getSources().put(name, source);
		return this;
	}

	public ParameterBuilder setStettings(Settings settings) {
		parameter.setSettings(settings);
		return this;
	}
}
