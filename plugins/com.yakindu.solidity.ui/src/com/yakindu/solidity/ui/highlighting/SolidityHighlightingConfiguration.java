/*
 * Copyright (c) 2018 committers of YAKINDU and others.
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
package com.yakindu.solidity.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author florian antony
 * 
 */
public class SolidityHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static final String STATE_VARIABLE = "state_variable";
	public static final String FUNCTION_PARAMETER = "function_parameter";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(STATE_VARIABLE, "StateVariable", stateVariableTextStyle());
		acceptor.acceptDefaultHighlighting(FUNCTION_PARAMETER, "FunctionParameter", localVariableTextStyle());

	}

	private TextStyle localVariableTextStyle() {
		TextStyle textStyle = keywordTextStyle();
		textStyle.setStyle(SWT.NONE);
		return textStyle;
	}

	private TextStyle stateVariableTextStyle() {
		TextStyle textStyle = keywordTextStyle();
		textStyle.setColor(new RGB(49, 132, 149));
		textStyle.setStyle(SWT.NONE);
		return textStyle;
	}

	@Override
	public TextStyle keywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(14, 48, 131));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
}
