package com.yakindu.solidity.remix.plugin.functions;

import org.eclipse.swt.browser.Browser;

import com.yakindu.solidity.remix.plugin.view.RemixPluginManager;

public class DisconnectFunction extends SolidityBrowserFunction {

	public static final String NAME = "eclipse_disconnect";

	public DisconnectFunction(RemixPluginManager manager, Browser browser) {
		super(manager, browser, NAME);
	}

	public Object function(final Object[] arguments) {
		super.function(arguments);
		return this.manager.disconnect((String)arguments[0]);
	};

}
