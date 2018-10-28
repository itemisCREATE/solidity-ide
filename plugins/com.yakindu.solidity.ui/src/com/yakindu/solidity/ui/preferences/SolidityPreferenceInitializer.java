/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - Itemis AG - initial API and implementation
 * 	Karsten Thoms   - Itemis AG - initial API and implementation
 * 	Florian Antony  - Itemis AG - initial API and implementation
 * 	committers of YAKINDU 
 * 
 */
package com.yakindu.solidity.ui.preferences;

import static com.yakindu.solidity.ui.preferences.ISolidityPreferencesConstants.FOLDING_COMMENT_AUTOFOLD;
import static com.yakindu.solidity.ui.preferences.ISolidityPreferencesConstants.FOLDING_COMMENT_AUTOFOLD_HEADER;
import static com.yakindu.solidity.ui.preferences.ISolidityPreferencesConstants.FOLDING_COMMENT_LINECOUNT;

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

	@Override
	public void initializeDefaultPreferences() {
		getPreferenceStore().setDefault(FOLDING_COMMENT_AUTOFOLD, FOLDING_COMMENT_AUTOFOLD_HEADER);
		getPreferenceStore().setDefault(FOLDING_COMMENT_LINECOUNT, 5);
	}

	protected IPreferenceStore getPreferenceStore() {
		return SolidityActivator.getInstance().getPreferenceStore();
	}

}
