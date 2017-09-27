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
import org.yakindu.sct.model.stext.stext.EventDefinition

/**
 * @author Florian Antony
 */
class CombinedState implements Template {
	@Inject extension Navigation
	@Inject extension Naming
	@Inject extension Declarations
	@Inject extension ExpressionCode

	override content(ExecutionFlow flow, GeneratorEntry entry) {
		'''
			pragma solidity ^0.4.16;
			contract «flow.toName»Statemachine {
				enum States {
					«FOR state : flow.states SEPARATOR ','»        
						«state.toName»
					«ENDFOR» 
				}
				
				enum Events {
					«FOR scope : flow.interfaceScopes»
						«FOR declaration : scope.declarations.filter[it instanceof EventDefinition] SEPARATOR ','»«declaration.toName»«ENDFOR»,nullEvent
					«ENDFOR»
				}
					
				// This is the current state.
				States public activeState = States.«flow.states.get(0).toName»;
				
				Events private lastEvent = Events.nullEvent;
			
				modifier exit() {
					«FOR state : flow.states.filter[it.exitAction != null]»
						if(activeState == States.«state.toName»){
							«state.exitAction?.code»
						}
					«ENDFOR» 
					_;
				}
				
				modifier entry() {
					_;
					«FOR state : flow.states.filter[it.entryAction != null]»
						if(activeState == States.«state.toName»){
							«state.entryAction?.code» 
						}
					«ENDFOR» 
				}
				
				function nextState(States _state) internal exit entry {
					activeState = States(uint(_state));
				}
				
				modifier react() {
					_;
					«FOR state : flow.states»
						«FOR reaction: state.reactions.filter[it.isTransition]»
							if(activeState == States.«(reaction.sourceElement as Transition).source.toName»){
								«IF reaction?.check?.condition != null»
									if(«reaction?.check?.condition?.code»){
								«ENDIF»
								nextState(States.«(reaction.sourceElement as Transition).target.toName»);
								«IF reaction?.check?.condition != null»
									}
								«ENDIF»
							}
						«ENDFOR» 
					«ENDFOR» 
				}
				
				«FOR scope : flow.interfaceScopes»
					«FOR declaration : scope.declarations»
						«declaration.declaration»
					«ENDFOR»
				«ENDFOR»
				
				function «flow.toName»Statemachine()public {
				}
				
				function() public payable {
					
				}
			}
		'''
	}
}
