package com.yakindu.solidity.compilerparameter;

import com.google.gson.Gson;

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
