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
package com.yakindu.solidity.ui.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import com.google.common.base.CaseFormat
import com.yakindu.solidity.solidity.PragmaVersion
import static extension com.yakindu.solidity.SolidityVersion.*

/** 
 * 
 * @author Karsten Thoms
 */
@FinalFieldsConstructor
class NewFileTemplate {
	val String fileName
	val PragmaVersion solidityVersion

	def generate() '''
		pragma solidity «toString(solidityVersion)»;
		
		contract «contractName» {
		    address creator;
		
		    constructor() public{
		        creator = msg.sender;
		    }
		
		    // TODO Add functions
		
		    function kill() public {
		        if (msg.sender == creator) {
		            selfdestruct(creator);
		        }
		    }
		}
	'''

	def getContractName() {
		CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, fileName)
	}
}
