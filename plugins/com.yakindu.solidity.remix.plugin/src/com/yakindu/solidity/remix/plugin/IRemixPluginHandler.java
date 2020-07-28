package com.yakindu.solidity.remix.plugin;

import com.yakindu.solidity.remix.plugin.functions.RemixMessage;

public interface IRemixPluginHandler {
	public RemixMessage getResponseMessage(RemixMessage request);
}
