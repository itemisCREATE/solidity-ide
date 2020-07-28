package com.yakindu.solidity.remix.plugin;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.yakindu.solidity.remix.plugin.view.RemixPluginManager;

public class RemixPluginUIActivator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "com.yakindu.solidity.remix.plugin"; //$NON-NLS-1$
	private static RemixPluginUIActivator plugin;
	private static RemixPluginManager manager;

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		manager = getRemixPluginManager();
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static RemixPluginUIActivator getDefault() {
		return plugin;
	}

	public synchronized static RemixPluginManager getRemixPluginManager() throws PartInitException {
		if (manager != null) {
			return manager;
		}
		return (RemixPluginManager) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.showView(RemixPluginManager.VIEW_ID, "Plugin Manager", IWorkbenchPage.VIEW_ACTIVATE);
	}
}
