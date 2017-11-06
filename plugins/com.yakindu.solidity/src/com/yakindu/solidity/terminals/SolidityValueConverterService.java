package com.yakindu.solidity.terminals;

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

	public static final String BIGINT = "BIGINT";
	public static final String ADDRESS = "ADDRESS";

	@Inject
	private BIGINTValueConverter bigIntConverter;
	@Inject
	private ADDRESSValueConverter addressConverter;
	
	@ValueConverter(rule = BIGINT)
	public IValueConverter<BigInteger> BIGINT() {
		return bigIntConverter;
	}
	
	@ValueConverter(rule = ADDRESS)
	public IValueConverter<BigInteger> ADDRESS() {
		return addressConverter;
	}

}
