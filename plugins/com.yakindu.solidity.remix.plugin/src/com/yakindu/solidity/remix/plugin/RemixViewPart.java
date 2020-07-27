package com.yakindu.solidity.remix.plugin;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.google.gson.GsonBuilder;
import com.yakindu.solidity.remix.plugin.functions.ConnectFunction;
import com.yakindu.solidity.remix.plugin.functions.DisconnectFunction;
import com.yakindu.solidity.remix.plugin.functions.RemixMessage;
import com.yakindu.solidity.remix.plugin.functions.SendFunction;
import com.yakindu.solidity.remix.plugin.functions.SolidityBrowserFunction;

public abstract class RemixViewPart extends ViewPart {

	private Composite parent;
	private Browser browser;

	private SolidityBrowserFunction connectFunction;
	private SolidityBrowserFunction disconnectFunction;
	private SolidityBrowserFunction sendFunction;

	@Override
	public void createPartControl(Composite root) {
		root.setLayout(new FillLayout());
		Composite parent = new Composite(root, SWT.NONE);
		parent.setLayout(new FillLayout());
		this.parent = parent;
	}

	private Browser createBrowser(String pluginName) {
		Browser browser = new Browser(this.parent, SWT.NONE);
		browser.setJavascriptEnabled(true);
		this.connectFunction = new ConnectFunction(getPluginManager(), browser);
		this.disconnectFunction = new DisconnectFunction(getPluginManager(), browser);
		this.sendFunction = new SendFunction(getPluginManager(), browser);
		return browser;

	}

	protected void initializeBrowser(String url, String pluginName) {
		this.browser = createBrowser(pluginName);
		this.browser.setUrl(url);
		this.browser.refresh();
		this.parent.layout();

	}

	protected abstract RemixPluginManager getPluginManager();

	public Browser getBrowser() {
		return this.browser;
	}

	@Override
	public void setFocus() {
		if (browser != null && !browser.isDisposed()) {
			browser.setFocus();
		}
	}

	@Override
	public void dispose() {
		if (browser != null) {
			browser.dispose();
			browser = null;
		}
		this.connectFunction = disposeFunction(this.connectFunction);
		this.disconnectFunction = disposeFunction(this.disconnectFunction);
		this.sendFunction = disposeFunction(this.sendFunction);
		super.dispose();
	}

	private SolidityBrowserFunction disposeFunction(SolidityBrowserFunction function) {
		if (function != null) {
			function.dispose();
			function = null;
		}
		return function;
	}

	protected void asyncExec(Runnable runnable) {
		Display display = getDisplay();
		if (!display.isDisposed()) {
			display.asyncExec(runnable);
		}
	}

	private Display getDisplay() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		Display display = Display.getCurrent();
		if (display == null && workbench != null) {
			display = workbench.getDisplay();
		}
		if (display == null) {
			display = Display.getDefault();
			assert display != null;
		}
		return display;
	}

	public void dispatchMessage(RemixMessage message) {
		if (browser.isDisposed()) {
			return;
		}
		final String script = "{" //
				+ "var event = document.createEvent('CustomEvent');" //
				+ "event.initCustomEvent('on_eclipse', false, false, " + new GsonBuilder().create().toJson(message)
				+ ");" //
				+ "document.dispatchEvent(event);" //
				+ "}";
		asyncExec(() -> browser.execute(script));
	}
}
