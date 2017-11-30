/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	 Andreas Muelder - Itemis AG - initial API and implementation
 * 	 Karsten Thoms   - Itemis AG - initial API and implementation
 *   Florian Antony  - Itemis AG - initial API and implementation
 * 	 committers of YAKINDU 
 * 
 */
package com.yakindu.solidity.tests

import com.google.inject.Inject
import com.yakindu.solidity.solidity.SolidityModel
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

import static org.junit.jupiter.api.Assertions.*

/**
 * @author Karsten Thoms - Initial contribution and API
 */
@ExtendWith(InjectionExtension)
@InjectWith(SolidityInjectorProvider)
class SolidityParsingTest {
	@Inject
	ParseHelper<SolidityModel> parseHelper

	@Test
	def void loadModel() {
		val result = parseHelper.parse('''
			pragma solidity ^0.4.11;
			
			contract Example {
				
			}
		''')
		assertNotNull(result)
		val errors = result.eResource.errors
		assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»'''.toString)
	}
}
