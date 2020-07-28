package com.yakindu.solidity.remix.plugin;

import com.yakindu.solidity.remix.plugin.functions.RemixMessage;

public class RemixPluginHandlerManager {
	
	public static final String FILEMANAGER_NAME = "fileManager";
	private RemixFileManagerHandler fileManagerHandler;
	
	public IRemixPluginHandler getResponsibleHandler(RemixMessage message) {
		if (message.getName().equals(FILEMANAGER_NAME)) {
			return fileManagerHandler;
		} else {
			return null;
		}
	}
	
	public void createFileManagerHandler(RemixFileManager fileManager) {
		fileManagerHandler = new RemixFileManagerHandler(fileManager);
	}
}
