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
	public static final String VERSION = "VERSION";

	@Inject
	private DECIMALValueConverter decimalConverter;
	@Inject
	private ADDRESSValueConverter addressConverter;
	@Inject
	private VERSIONValueConverter versionConverter;

	@ValueConverter(rule = DECIMAL)
	public IValueConverter<BigDecimal> BIGINT() {
		return decimalConverter;
	}

	@ValueConverter(rule = ADDRESS)
	public IValueConverter<BigInteger> ADDRESS() {
		return addressConverter;
	}
	
	@ValueConverter(rule = VERSION)
	public IValueConverter<String> VERSION() {
		return versionConverter;
	}

}
