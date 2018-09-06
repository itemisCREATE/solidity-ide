/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.domain.solidity.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.yakindu.sct.model.stext.ui.STextUiModule;

import com.yakindu.solidity.ui.highlighting.SoliditySemanticHighlighter;
/**
 * 
 * @author Andreas Muelder - Initial contribution and API
 * 
 */
public class SolidityUIModule extends STextUiModule {

	public SolidityUIModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SoliditySemanticHighlighter.class;
	}
	
}
