package com.yakindu.solidity.remix.plugin.functions;

import org.eclipse.swt.browser.Browser;

import com.yakindu.solidity.remix.plugin.RemixPluginManager;

public class SendFunction extends SolidityBrowserFunction {

	public static final String NAME = "eclipse_send";
	private final String pluginName;

	public SendFunction(RemixPluginManager manager, Browser browser, String pluginName) {
		super(manager, browser, NAME);
		this.pluginName = pluginName;
	}

	public Object function(final Object[] arguments) {
		super.function(arguments);
		RemixMessage message = this.gson.fromJson((String) arguments[0], RemixMessage.class);
		if (isRelevant(message)) {
			System.out.println(message);
			this.manager.dispatch(message);
		}
		return Void.TYPE;
	}

	private boolean isRelevant(RemixMessage message) {
		if(message.getAction().equals("request")) {
			return this.pluginName.equals(message.getRequestInfo().getFrom());
		}
		if(message.getAction().equals("response")) {
			return this.pluginName.equals("manager");
		}
		return false;
	};

}
