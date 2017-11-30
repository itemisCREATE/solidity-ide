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
package com.yakindu.solidity.terminals;

import java.math.BigDecimal;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DECIMALValueConverter extends AbstractLexerBasedConverter<BigDecimal> {

	@Override
	protected String toEscapedString(BigDecimal value) {
		return value.toString();
	}

	@Override
	protected void assertValidValue(BigDecimal value) {
		super.assertValidValue(value);
		if (value.compareTo(BigDecimal.ZERO) == -1)
			throw new ValueConverterException(getRuleName() + "-value may not be negative (value: " + value + ").",
					null, null);
	}

	@Override
	public BigDecimal toValue(String string, INode node) {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to an int value.", node, null);
		try {
			return new BigDecimal(string);
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to an int value.", node, e);
		}
	}

}