package com.yakindu.solidity.remix.plugin.functions;

import org.eclipse.swt.browser.Browser;

import com.yakindu.solidity.remix.plugin.RemixPluginManager;

public class SendFunction extends SolidityBrowserFunction {

	public static final String NAME = "eclipse_send";

	public SendFunction(RemixPluginManager manager, Browser browser) {
		super(manager, browser, NAME);
	}

	public Object function(final Object[] arguments) {
		super.function(arguments);
		RemixMessage message = this.gson.fromJson((String) arguments[0], RemixMessage.class);
		this.manager.dispatch(message);
		return Void.TYPE;
	}

}
