package com.yakindu.solidity.remix.plugin.functions;

import org.eclipse.swt.browser.Browser;

import com.yakindu.solidity.remix.plugin.RemixPluginManager;

public class ConnectFunction extends SolidityBrowserFunction {
	
	
	public static final String NAME = "eclipse_connect";

	public ConnectFunction(RemixPluginManager manager, Browser browser) {
		super(manager, browser, NAME);
	}

	public Object function(final Object[] arguments) {
		super.function(arguments);
		return this.manager.connect(this.gson.fromJson((String) arguments[0], RemixPlugin.class));
	};
	
	
}
