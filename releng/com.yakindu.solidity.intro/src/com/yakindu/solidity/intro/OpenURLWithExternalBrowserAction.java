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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class OpenURLWithExternalBrowserAction extends Action implements IIntroAction {

	@Override
	public void run(IIntroSite site, Properties params) {

		try {
			PlatformUI.getWorkbench().getBrowserSupport().getExternalBrowser()
					.openURL(new URL(params.getProperty("url")));
		} catch (PartInitException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

}