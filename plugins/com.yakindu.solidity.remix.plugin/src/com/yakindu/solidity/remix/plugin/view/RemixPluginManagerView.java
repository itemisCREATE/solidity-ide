package com.yakindu.solidity.remix.plugin.view;

import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.google.common.collect.Maps;
import com.yakindu.solidity.remix.plugin.IRemixPluginHandler;
import com.yakindu.solidity.remix.plugin.RemixFileManager;
import com.yakindu.solidity.remix.plugin.RemixPluginHandlerManager;
import com.yakindu.solidity.remix.plugin.functions.RemixMessage;
import com.yakindu.solidity.remix.plugin.functions.RemixPlugin;

public class RemixPluginManager extends RemixViewPart {
	private static final String MANAGER = "manager";
	public static final String VIEW_ID = "com.yakindu.solidity.remix.plugin.RemixPluginManager";
	private static final String PLUGIN_MANAGER = "http://localhost:4200/#/manager";

	private Map<String, RemixPluginView> activePlugins;
	private RemixFileManager filemanager;
	private RemixPluginHandlerManager pluginHandlerManager;
	
	

	@Override
	public void createPartControl(Composite root) {
		super.createPartControl(root);
		this.activePlugins = Maps.newHashMap();
		this.pluginHandlerManager = new RemixPluginHandlerManager();
		initializeBrowser(PLUGIN_MANAGER, MANAGER);
	}

	@Override
	protected RemixPluginManager getPluginManager() {
		return this;
	}

	@Override
	public void dispose() {
		this.activePlugins.values().forEach(view -> view.dispose());
		this.activePlugins.clear();
		super.dispose();
	}
	
	
	
	public String connect(RemixPlugin plugin) {
		if (plugin.getName().equals("fileManager") && filemanager == null) {
			this.filemanager = new RemixFileManager();
			pluginHandlerManager.createFileManagerHandler(filemanager);
		}

//		RemixPluginView view = this.activePlugins.get(plugin.getName());
//		if (view == null) {
//			this.activePlugins.put(plugin.getName(), createPluginView(plugin));
//		} else {
//			view.setFocus();
//		}
		return plugin.getName();
	}

	public boolean disconnect(String pluginID) {
		RemixPluginView pluginView = this.activePlugins.remove(pluginID);
		if (pluginView != null) {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(pluginView);
			pluginView.dispose();
			this.getBrowser().refresh();
			return true;
		}
		return false;
	}

	public void dispatch(RemixMessage message) {
		if (message.getAction().equals("request")) {
			IRemixPluginHandler remixPluginHandler = pluginHandlerManager.getResponsibleHandler(message);
			if (remixPluginHandler != null) {
				RemixMessage responseMessage = remixPluginHandler.getResponseMessage(message);
				this.dispatchMessage(responseMessage);
			}
		}
	}

	private RemixPluginView createPluginView(RemixPlugin plugin) {
		RemixPluginView pluginView = null;
		try {
			pluginView = (RemixPluginView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.showView(RemixPluginView.VIEW_ID, plugin.getName(), IWorkbenchPage.VIEW_ACTIVATE);
			pluginView.initialize(plugin, this);
		} catch (PartInitException e) {
		}
		return pluginView;
	}

}
