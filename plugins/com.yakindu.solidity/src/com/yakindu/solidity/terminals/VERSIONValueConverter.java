package com.yakindu.solidity.terminals;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

public class VERSIONValueConverter implements IValueConverter<String> {
	
	@Override
	public String toValue(String string, INode node) throws ValueConverterException {
		if (string.contains("e") | string.contains("E"))
			throw new ValueConverterException("VERSION-value may not contain an exponent (value: " + string + ").",
					null, null);
		return string;
	}

	@Override
	public String toString(String value) throws ValueConverterException {
		if (value.contains("e") | value.contains("E"))
			throw new ValueConverterException("VERSION-value may not contain an exponent (value: " + value + ").",
					null, null);
		return value.toString();
	}

}
