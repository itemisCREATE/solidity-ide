/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - Itemis AG - initial API and implementation
 * 
 */
package com.yakindu.solidity.solc.preferences;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.osgi.service.prefs.BackingStoreException;

import com.yakindu.solidity.solc.SolidityCompilerActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 */
public class CompilerPreferenceInitializer extends AbstractPreferenceInitializer {

	private static final String DEFAULT_OUTPUT_PATH = "solidity-gen";

	@Override
	public void initializeDefaultPreferences() {
		IEclipsePreferences preferenceStore = getPreferenceStore();
		boolean compilerInstalled = Platform.getBundle(SolidityCompilerActivator.PLUGIN_ID) != null;
		preferenceStore.putBoolean(ICompilerPreferences.COMPILER_ENABLED, compilerInstalled);
		preferenceStore.putBoolean(ICompilerPreferences.COMPILER_OUTPUT_ABI, false);
		preferenceStore.putBoolean(ICompilerPreferences.COMPILER_OUTPUT_BIN, true);
		preferenceStore.putBoolean(ICompilerPreferences.COMPILER_OUTPUT_ASM, false);
		preferenceStore.put(ICompilerPreferences.COMPILER_OUTPUT_PATH, DEFAULT_OUTPUT_PATH);
		try {
			preferenceStore.flush();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	protected IEclipsePreferences getPreferenceStore() {
		return DefaultScope.INSTANCE.getNode(SolidityCompilerActivator.PLUGIN_ID);
	}

}
