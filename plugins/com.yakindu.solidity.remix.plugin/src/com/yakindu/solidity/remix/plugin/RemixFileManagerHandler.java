package com.yakindu.solidity.remix.plugin;

import com.google.common.collect.Lists;
import com.yakindu.solidity.remix.plugin.functions.RemixMessage;

public class RemixFileManagerHandler implements IRemixPluginHandler {
	
	public final static String GET_CURRENT_FILE_METHOD = "getCurrentFile";
	public final static String GET_FILE_METHOD = "getFile";
	public final static String GET_FOLDER_METHOD = "getFolder";
	public final static String SET_FILE_METHOD = "setFile";
	public final static String SWITCH_FILE_METHOD = "switchFile";
	
	private final RemixFileManager fileManager;
	
	public RemixFileManagerHandler(RemixFileManager fileManager) {
		this.fileManager = fileManager;
	}
	
	@Override
	public RemixMessage getResponseMessage(RemixMessage request) {
		switch(request.getKey()) {
			case GET_CURRENT_FILE_METHOD: return createCurrentFileResponse(request);
		};
		return null;
	}
	
	protected RemixMessage createCurrentFileResponse(RemixMessage request) {
		RemixMessage result = new RemixMessage();
		result.setAction("response");
		result.setName(request.getName());
		result.setKey(request.getKey());
		result.setPayload(Lists.newArrayList(fileManager.getCurrentFile()));
		result.setRequestInfo(request.getRequestInfo());
		result.setId(request.getId());
				
		return result;
	}
}
