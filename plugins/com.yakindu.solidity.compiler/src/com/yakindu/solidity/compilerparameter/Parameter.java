package com.yakindu.solidity.compilerparameter;

import java.util.Map;

import com.google.common.collect.Maps;

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
