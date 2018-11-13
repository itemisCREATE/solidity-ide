package com.yakindu.solidity.tests;

import java.nio.file.Path;

public class FormatterTestData {
	
	private Path formatPath;
	
	private Path comparePath;
	
	public FormatterTestData(Path formatPath, Path comparePath) {
		this.comparePath = comparePath;
		this.formatPath = formatPath;
	}
	
	public Path getFormatPath() {
		return formatPath;
	}
	
	public void setFormatPath(Path formatPath) {
		this.formatPath = formatPath;
	}
	
	public Path getComparePath() {
		return comparePath;
	}
	
	public void setComparePath(Path comparePath) {
		this.comparePath = comparePath;
	}
}