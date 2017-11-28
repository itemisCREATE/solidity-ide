/**
 * Copyright (c) 2016 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
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