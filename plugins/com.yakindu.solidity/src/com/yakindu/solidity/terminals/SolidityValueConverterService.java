package com.yakindu.solidity.terminals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.yakindu.base.expressions.terminals.ExpressionsValueConverterService;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SolidityValueConverterService extends ExpressionsValueConverterService {

	public static final String DECIMAL = "DECIMAL";
	public static final String ADDRESS = "ADDRESS";

	@Inject
	private DECIMALValueConverter decimalConverter;
	@Inject
	private ADDRESSValueConverter addressConverter;
	
	@ValueConverter(rule = DECIMAL)
	public IValueConverter<BigDecimal> BIGINT() {
		return decimalConverter;
	}
	
	@ValueConverter(rule = ADDRESS)
	public IValueConverter<BigInteger> ADDRESS() {
		return addressConverter;
	}

}
