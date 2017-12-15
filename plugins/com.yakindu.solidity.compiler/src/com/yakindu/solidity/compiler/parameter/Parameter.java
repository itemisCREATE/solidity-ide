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

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 *
 */
public class Parameter {
	private String language;
	private Map<String, Source> sources;
	private Settings settings;

	public Parameter() {
		sources = Maps.newHashMap();
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public Map<String, Source> getSources() {
		return sources;
	}

	public void setSources(Map<String, Source> sources) {
		this.sources = sources;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
