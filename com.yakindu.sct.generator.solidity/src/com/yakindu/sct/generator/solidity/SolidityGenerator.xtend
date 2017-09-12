/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Florian Antony - itemis AG
 * 
 */
package com.yakindu.sct.generator.solidity

import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.IExecutionFlowGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sgraph.Vertex

class SolidityGenerator implements IExecutionFlowGenerator {

	override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess access) {
		access.generateFile("I" + flow.name + '.sol', flow.interfaceContractContent(entry));
		access.generateFile(flow.name + '.sol', flow.implementationContractContent(entry));
	}

	def CharSequence implementationContractContent(ExecutionFlow flow, GeneratorEntry entry) {
		'''
			pragma solidity ^0.4.16;
			contract «flow.toName»Statemachine {
						
						//All available states
						enum States {
							«FOR state : flow.states SEPARATOR ','»        
								«state.toName»
							«ENDFOR» 
						}
						
						// This is the current stage.
						States public activeState = States.«flow.states.get(0).toName»;
						
						modifier atCurrentState(States _state) {
							require(activeState == _state);
							   _;
						}
						
						function nextState(States _state) internal {
							activeState = States(uint(_state));
						}
						
						modifier runCycle() {
							«FOR state : flow.states»
								«FOR reaction: state.reactions»
									«IF reaction.isTransition»
										if (activeState == States.«(reaction.sourceElement as Transition).source.toName» «(reaction.sourceElement as Transition).trigger»){
											nextState(«(reaction.sourceElement as Transition).target.toName»);
										}
									«ENDIF»
								«ENDFOR» 
							«ENDFOR» 
							_;
						}
			}
		'''
	}

	def CharSequence interfaceContractContent(ExecutionFlow flow, GeneratorEntry entry) {
		'''
			pragma solidity ^0.4.16;»
			
			contract «flow.name» {
						
			}
		'''
	}



	def dispatch String toName(Void woid) {
		""
	}

	def dispatch String toName(Vertex vertex) {
		vertex.name.toName
	}

	def dispatch String toName(ExecutionFlow flow) {
		flow.name.toName
	}

	def dispatch String toName(ExecutionState state) {
		state.simpleName.toName;
	}

	def dispatch String toName(String string) {
		string.replace('.', '_');
	}
}
