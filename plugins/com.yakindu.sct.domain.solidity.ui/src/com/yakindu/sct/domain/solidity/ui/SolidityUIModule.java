package com.yakindu.sct.domain.solidity.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.yakindu.sct.model.stext.ui.STextUiModule;

import com.yakindu.sct.domain.solidity.ui.highlighting.SoliditySemanticHighlighter;

public class SolidityUIModule extends STextUiModule {

	public SolidityUIModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SoliditySemanticHighlighter.class;
	}

}
