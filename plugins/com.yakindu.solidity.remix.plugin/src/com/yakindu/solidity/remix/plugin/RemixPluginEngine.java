package com.yakindu.solidity.remix.plugin;

import java.util.List;

import org.eclipse.ui.PartInitException;

import com.yakindu.solidity.remix.plugin.view.RemixPluginManager;

public class RemixPluginEngine {

	private final MessageFactory factory;

	public RemixPluginEngine() {
		this.factory = new MessageFactory();
	}

	public String compile(List<String> files) {
		try {
			RemixPluginManager pluginManager = RemixPluginUIActivator.getRemixPluginManager();
			if (pluginManager != null) {
				pluginManager.dispatchMessage(factory.createCompileMessage(files));
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

}
