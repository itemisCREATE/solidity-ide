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
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Transition

/**
 * @author Florian Antony
 */
class CombinedState implements Template {
	@Inject extension Navigation
	@Inject extension Naming
	@Inject extension Declarations

	override content(ExecutionFlow flow, GeneratorEntry entry) {
		'''
			pragma solidity ^0.4.16;
			contract «flow.toName»Statemachine {
				enum States {
					«FOR state : flow.states SEPARATOR ','»        
						«state.toName»
					«ENDFOR» 
				}
					
				// This is the current state.
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
								if (activeState == States.«(reaction.sourceElement as Transition).source.toName»){
									nextState(States.«(reaction.sourceElement as Transition).target.toName»);
								}
							«ENDIF»
						«ENDFOR» 
					«ENDFOR» 
					_;
				}
				«FOR scope : flow.interfaceScopes»
					«FOR declaration : scope.declarations»
						«declaration.declaration»
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}
}
