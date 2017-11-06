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
public class ADDRESSValueConverter extends AbstractLexerBasedConverter<BigInteger> {

	public static final String HEX_PREFIX = "0x";

	public BigInteger toValue(String string, INode node) {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to number.", node, null);
		try {
			return new BigInteger(string.substring(2), 16);
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to number.", node, null);
		}
	}

	@Override
	protected String toEscapedString(BigInteger value) {
		return HEX_PREFIX + value.toString(16);
	}

}