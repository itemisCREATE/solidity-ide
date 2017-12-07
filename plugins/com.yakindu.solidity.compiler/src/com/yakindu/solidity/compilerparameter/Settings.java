package com.yakindu.solidity.compilerparameter;

import java.util.List;
import java.util.Map;

public class Settings {

	private List<String> remappings;

	private Optimizer optimizer;

	private Metadata metadata;

	private Map<String, Library> libraries;

	private OutputSelection outputSelection;
	
	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Optimizer getOptimizer() {
		return optimizer;
	}

	public void setOptimizer(Optimizer optimizer) {
		this.optimizer = optimizer;
	}

	public List<String> getRemappings() {
		return remappings;
	}

	public void setRemappings(List<String> remappings) {
		this.remappings = remappings;
	}

	public Map<String, Library> getLibraries() {
		return libraries;
	}

	public void setLibraries(Map<String, Library> libraries) {
		this.libraries = libraries;
	}

	public OutputSelection getOutputSelection() {
		return outputSelection;
	}

	public void setOutputSelection(OutputSelection outputSelection) {
		this.outputSelection = outputSelection;
	}
}
