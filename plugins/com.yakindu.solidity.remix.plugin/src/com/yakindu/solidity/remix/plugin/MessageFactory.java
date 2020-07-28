package com.yakindu.solidity.remix.plugin;

import java.util.List;

import com.yakindu.solidity.remix.plugin.functions.PluginRequest;
import com.yakindu.solidity.remix.plugin.functions.RemixMessage;

public class MessageFactory {

	public RemixMessage createCompileMessage(List<String> files) {
		RemixMessage remixMessage = new RemixMessage();
		remixMessage.setAction("request");
		PluginRequest pluginRequest = new PluginRequest();
		pluginRequest.setFrom("YAKINDU");
		pluginRequest.setPath("solidity");
		remixMessage.setRequestInfo(pluginRequest);
		remixMessage.setName("solidity");
		remixMessage.setKey("compile");
		remixMessage.setPayload(files);
		return remixMessage;
	}

}
