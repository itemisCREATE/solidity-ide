/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.generator.solidity

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.IExecutionFlowGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * 
 */
class SolidityGenerator implements IExecutionFlowGenerator {

	@Inject CombinedState combinedState

	override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess access) {
		access.generateFile(flow.name + 'State.sol', combinedState.content(flow, entry));
	}

	def CharSequence interfaceContractContent(ExecutionFlow flow, GeneratorEntry entry) {
		'''
			pragma solidity ^0.5.10;
			
			import '«flow.name»State';
			contract «flow.name» {
			
				address state;
				
				function «flow.name» (){
					// TODO
					state = new «flow.name»State(); 
				}
				
			}
		'''
	}
}
