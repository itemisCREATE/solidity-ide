/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.domain.solidity.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
/**
 * 
 * @author Andreas Muelder - Initial contribution and API
 * 
 */
public class SolidityUIActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "com.yakindu.sct.domain.solidity.ui"; //$NON-NLS-1$
	private static SolidityUIActivator plugin;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static SolidityUIActivator getDefault() {
		return plugin;
	}

}
