package com.yakindu.solidity.ui.editor;

import org.eclipse.xtext.formatting.IIndentationInformation;

/**
 * Use four whitespace instead of \t for indentation.
 * 
 * @author Florian Antony
 */
public class SolidityIndentationInformation implements IIndentationInformation {

	@Override
	public String getIndentString() {
		return "    ";
	}

}
