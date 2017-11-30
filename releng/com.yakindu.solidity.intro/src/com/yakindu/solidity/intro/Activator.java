/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	 Andreas Muelder - Itemis AG - initial API and implementation
 * 	 Karsten Thoms   - Itemis AG - initial API and implementation
 *   Florian Antony  - Itemis AG - initial API and implementation
 * 	 committers of YAKINDU 
 * 
 */ 
package com.yakindu.solidity.intro;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * 
 * @author Andreas Muelder - Initial contribution and API
 *
 */
public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "com.yakindu.solidity.intro"; //$NON-NLS-1$

	private static Activator plugin;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static Activator getDefault() {
		return plugin;
	}

}
