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
package com.yakindu.solidity.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SolidityHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static final String VERSION = "version";
	public static final String TYPES = "types";
	public static final String PARAMETER = "parameter";
	public static final String FUNCTION_NAME = "function_name";
	public static final String FEATURESCALL = "feature";
	
	
	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(VERSION, "VariableDefinition", solidityVersionTextStyle());
		acceptor.acceptDefaultHighlighting(TYPES, "VariableDefinition", typeTextStyle());
		acceptor.acceptDefaultHighlighting(PARAMETER, "VariableDefinition", typeTextStyle());
		acceptor.acceptDefaultHighlighting(FUNCTION_NAME, "VariableDefinition", functionNameTextStyle());
		acceptor.acceptDefaultHighlighting(FEATURESCALL, "VariableDefinition", featureCallTextStyle());
		
	}
	
	private TextStyle typeTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(49, 132, 149));
		return textStyle;
	}
	
	private TextStyle functionNameTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 162));
		return textStyle;
	}

	private TextStyle solidityVersionTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 205));
		return textStyle;
	}

	private TextStyle featureCallTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(6, 150, 14));
		return textStyle;
	}

	@Override
	public TextStyle keywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(00, 00, 255));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
	
	@Override
	public TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(76, 136, 107));
		textStyle.setStyle(SWT.ITALIC);
		return textStyle;
	}
}
