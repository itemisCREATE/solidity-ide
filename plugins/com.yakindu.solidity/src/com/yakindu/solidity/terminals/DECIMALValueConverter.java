
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