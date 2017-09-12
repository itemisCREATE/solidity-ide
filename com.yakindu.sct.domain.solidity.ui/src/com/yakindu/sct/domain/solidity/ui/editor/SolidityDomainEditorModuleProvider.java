/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 	Florian Antony - itemis AG
 * 
 */
package com.yakindu.sct.domain.solidity.ui.editor;

import org.yakindu.sct.domain.extension.IModuleProvider;
import org.yakindu.sct.domain.generic.editor.EditorModuleProvider;

import com.google.inject.Module;
import com.yakindu.sct.domain.solidity.modules.SolidityRuntimeModule;

public class SolidityDomainEditorModuleProvider extends EditorModuleProvider implements IModuleProvider {

	@Override
	protected Module getLanguageRuntimeModule() {
		return new SolidityRuntimeModule();
	}
}
