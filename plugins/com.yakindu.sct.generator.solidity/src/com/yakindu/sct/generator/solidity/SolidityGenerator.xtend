/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Florian Antony - itemis AG
 * 
 */
package com.yakindu.sct.generator.solidity

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.IExecutionFlowGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

/**
 * @author Florian Antony
 */
class SolidityGenerator implements IExecutionFlowGenerator {

	@Inject CombinedState combinedState

	override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess access) {
		access.generateFile("I" + flow.name + '.sol', flow.interfaceContractContent(entry));
		access.generateFile(flow.name + 'State.sol', combinedState.content(flow, entry));
	}

	def CharSequence interfaceContractContent(ExecutionFlow flow, GeneratorEntry entry) {
		'''
			pragma solidity ^0.4.18;
			
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
