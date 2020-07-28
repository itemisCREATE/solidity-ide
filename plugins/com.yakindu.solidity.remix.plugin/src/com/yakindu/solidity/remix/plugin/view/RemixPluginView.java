package com.yakindu.solidity.remix.plugin.view;

import com.yakindu.solidity.remix.plugin.functions.RemixPlugin;

public class RemixPluginView extends RemixViewPart {

	public static final String VIEW_ID = "com.yakindu.solidity.remix.plugin.RemixPluginView";
	public static final String BASE_URL = "http://localhost:4200/#/plugin/";

	private RemixPlugin plugin;
	private RemixPluginManager manager;

	@Override
	protected RemixPluginManager getPluginManager() {
		return this.manager;
	}

	public void initialize(RemixPlugin plugin, RemixPluginManager manager) {
		if (manager == null | plugin == null) {
			throw new IllegalStateException("no plugin or manager found");
		}
		this.manager = manager;
		this.plugin = plugin;
		this.setPartName(plugin.getDisplayName());
		super.initializeBrowser(plugin.getUrl(), plugin.getName());
//		super.initializeBrowser(BASE_URL + plugin.getName(), plugin.getName());
	}

}
