package com.yakindu.solidity.remix.plugin.functions;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yakindu.solidity.remix.plugin.RemixPluginManager;

public abstract class SolidityBrowserFunction extends BrowserFunction {

	protected RemixPluginManager manager;
	protected Gson gson;

	public SolidityBrowserFunction(RemixPluginManager manager, Browser browser, String name) {
		super(browser, name);
		this.manager = manager;
		this.gson = new GsonBuilder().create();
	}

	@Override
	public void dispose() {
		this.manager = null;
		super.dispose();
	}
}
