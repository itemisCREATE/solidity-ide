package com.yakindu.solidity.compiler;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class SolidityCompilerActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "com.yakindu.solidity.compiler";
	
	private static SolidityCompilerActivator INSTANCE;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		INSTANCE = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		INSTANCE = null;
		super.stop(context);
	}

	public static SolidityCompilerActivator getInstance() {
		return INSTANCE;
	}
}
