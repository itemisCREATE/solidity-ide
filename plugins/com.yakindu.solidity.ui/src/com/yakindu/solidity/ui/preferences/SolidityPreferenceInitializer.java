package com.yakindu.solidity.ui.preferences;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.yakindu.solidity.ui.internal.SolidityActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SolidityPreferenceInitializer extends AbstractPreferenceInitializer {

	private static final String COMPILER_PLUGIN = "com.yakindu.solidity.compiler";

	@Override
	public void initializeDefaultPreferences() {
		boolean compilerInstalled = Platform.getBundle(COMPILER_PLUGIN) != null;
		getPreferenceStore().setDefault(SolidityPreferences.COMPILER_ENABLED, compilerInstalled);
		getPreferenceStore().setDefault(SolidityPreferences.COMPILER_PATH, "");
	}

	protected IPreferenceStore getPreferenceStore() {
		return SolidityActivator.getInstance().getPreferenceStore();
	}

}
