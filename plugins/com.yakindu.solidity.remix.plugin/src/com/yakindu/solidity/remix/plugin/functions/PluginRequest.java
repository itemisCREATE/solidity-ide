package com.yakindu.solidity.remix.plugin.functions;

public class PluginRequest {

	private String from;
	private boolean isFromNative;
	private String path;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public boolean isFromNative() {
		return isFromNative;
	}

	public void setFromNative(boolean isFromNative) {
		this.isFromNative = isFromNative;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
