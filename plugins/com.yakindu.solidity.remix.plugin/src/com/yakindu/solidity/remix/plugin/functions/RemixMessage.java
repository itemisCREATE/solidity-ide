package com.yakindu.solidity.remix.plugin.functions;

import java.util.List;

public class RemixMessage {

	private long id;
	private String action;
	private String name;
	private String key;
	private List<String> payload;
	private PluginRequest requestInfo;
	private String error;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<String> getPayload() {
		return payload;
	}

	public void setPayload(List<String> payload) {
		this.payload = payload;
	}

	public PluginRequest getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(PluginRequest requestInfo) {
		this.requestInfo = requestInfo;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "RemixMessage [id=" + id + ", action=" + action + ", name=" + name + ", key=" + key + ", payload="
				+ payload + ", requestInfo=" + requestInfo + ", error=" + error + "]";
	}

	
}
