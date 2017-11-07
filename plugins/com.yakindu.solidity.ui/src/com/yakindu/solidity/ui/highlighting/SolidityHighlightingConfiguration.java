package com.yakindu.solidity.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SolidityHighlightingConfiguration extends DefaultHighlightingConfiguration {

	@Override
	public TextStyle keywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(14, 48, 131));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
}
