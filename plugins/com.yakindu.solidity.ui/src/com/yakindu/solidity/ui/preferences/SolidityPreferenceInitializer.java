package com.yakindu.solidity.ui.preferences;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.yakindu.solidity.ui.internal.SolidityActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 * @author Karsten Thoms
 */
public class SolidityPreferenceInitializer extends AbstractPreferenceInitializer {

	private static final String COMPILER_PLUGIN = "com.yakindu.solidity.compiler";
	private static final String DEFAULT_OUTPUT_PATH = "solidity-gen";

	@Override
	public void initializeDefaultPreferences() {
		boolean compilerInstalled = Platform.getBundle(COMPILER_PLUGIN) != null;
		getPreferenceStore().setDefault(SolidityPreferences.COMPILER_ENABLED, compilerInstalled);
		getPreferenceStore().setDefault(SolidityPreferences.COMPILER_OUTPUT_ABI, false);
		getPreferenceStore().setDefault(SolidityPreferences.COMPILER_OUTPUT_AST, false);
		getPreferenceStore().setDefault(SolidityPreferences.COMPILER_OUTPUT_BIN, true);
		getPreferenceStore().setDefault(SolidityPreferences.COMPILER_OUTPUT_ASM, false);
		getPreferenceStore().setDefault(SolidityPreferences.COMPILER_OUTPUT_PATH, DEFAULT_OUTPUT_PATH);

		getPreferenceStore().setDefault(SolidityPreferences.FOLDING_COMMENT_AUTOFOLD, SolidityPreferences.FOLDING_COMMENT_AUTOFOLD_HEADER);
		getPreferenceStore().setDefault(SolidityPreferences.FOLDING_COMMENT_LINECOUNT, 5);
	}

	protected IPreferenceStore getPreferenceStore() {
		return SolidityActivator.getInstance().getPreferenceStore();
	}

}
