/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.domain.solidity.ui.editor;

import org.yakindu.sct.domain.extension.IModuleProvider;
import org.yakindu.sct.domain.generic.editor.EditorModuleProvider;

import com.google.inject.Module;
import com.yakindu.sct.domain.solidity.modules.SolidityRuntimeModule;
import com.yakindu.sct.domain.solidity.ui.SolidityUIActivator;
import com.yakindu.sct.domain.solidity.ui.SolidityUIModule;
/**
 * 
 * @author Andreas Muelder - Initial contribution and API
 * 
 */
public class SolidityDomainEditorModuleProvider extends EditorModuleProvider implements IModuleProvider {

	@Override
	protected Module getLanguageRuntimeModule() {
		return new SolidityRuntimeModule();
	}

	@Override
	protected Module getLanguageUiModule() {
		return new SolidityUIModule(SolidityUIActivator.getDefault());

	}
}
