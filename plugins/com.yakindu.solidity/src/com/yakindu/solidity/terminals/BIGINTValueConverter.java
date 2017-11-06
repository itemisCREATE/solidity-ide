
package com.yakindu.solidity.terminals;

import java.math.BigInteger;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class BIGINTValueConverter extends AbstractLexerBasedConverter<BigInteger> {

	@Override
	protected String toEscapedString(BigInteger value) {
		return value.toString();
	}

	@Override
	protected void assertValidValue(BigInteger value) {
		super.assertValidValue(value);
		if (value.compareTo(BigInteger.ZERO) == -1)
			throw new ValueConverterException(getRuleName() + "-value may not be negative (value: " + value + ").",
					null, null);
	}

	@Override
	public BigInteger toValue(String string, INode node) {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to an int value.", node, null);
		try {
			return new BigInteger(string, 10);
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to an int value.", node, e);
		}
	}

}