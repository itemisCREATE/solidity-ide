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
package com.yakindu.solidity.solc.parameter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.GsonBuilder;

/**
 * @author Florian Antony - Initial contribution and API
 */
public class ParameterBuilder {

	private Parameter parameter;
	private GsonBuilder gsonBuilder;

	public ParameterBuilder() {
		this("Solidity");
	}

	public ParameterBuilder(String language) {
		gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		this.parameter = new Parameter();
		this.parameter.setLanguage(language);
		this.parameter.setSettings(defaultSettings());
	}

	private Settings defaultSettings() {
		Settings settings = new Settings();
		settings.setOptimizer(defaultOptimizer());
		settings.setParserErrorRecovery(true);
		Map<String, Map<String, List<String>>> output = Maps.newHashMap();
		HashMap<String, List<String>> internalOutputs = Maps.newHashMap();
		internalOutputs.put("*", Lists.newArrayList());
		output.put("*", internalOutputs);
		settings.setOutputSelection(output);
		return settings;
	}

	private Optimizer defaultOptimizer() {
		Optimizer optimizer = new Optimizer();
		optimizer.setEnabled(false);
		optimizer.setRuns(0);
		return optimizer;
	}

	public String buildJson() {
		return gsonBuilder.create().toJson(parameter);
	}

	public ParameterBuilder addOutput(String key) {
		List<String> outputKeys = this.parameter.getSettings().getOutputSelection().get("*").get("*");
		if (!outputKeys.contains(key)) {
			outputKeys.add(key);
		}
		return this;
	}

	public ParameterBuilder addSource(String name, Source source) {
		this.parameter.getSources().put(name, source);
		return this;
	}
}
