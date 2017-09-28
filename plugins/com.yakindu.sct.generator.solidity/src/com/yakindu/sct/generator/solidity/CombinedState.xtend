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
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.Reaction
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sgen.GeneratorEntry
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
				«flow.generateStateEnum»
				
				«flow.generateEventEnum»
				// This is the current state.
				States public activeState = States.«flow.states.get(0).toName»;
				
				Events private lastEvent = Events.nullEvent;
			
				address private owner; 
				«FOR scope : flow.interfaceScopes»
					«FOR declaration : scope.declarations»
						«declaration.declaration»
					«ENDFOR»
				«ENDFOR»
			
				modifier exit() {
					«FOR state : flow.states.filter[it.exitAction != null]»
						if(activeState == States.«state.toName»){
							«state.exitAction?.code»
						}
					«ENDFOR» 
					_;
				}
				
				modifier reset() {
					_;
					lastEvent = Events.nullEvent;
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
					«FOR state : flow.states.filter[reactSequence !== null] SEPARATOR "else "»
«««						«FOR reaction: state.reactions.filter[it.isTransition] SEPARATOR 'else '»
							if(activeState == States.«state.toName»){
									«state.reactSequence.code»
							}
«««						«ENDFOR» 
					«ENDFOR» 
				}
				
				
				function «flow.toName»Statemachine()public {
					owner = msg.sender;
				}
				
				function() public payable {
					
				}
			}
		'''
	}

	def protected generateStateEnum(ExecutionFlow flow) {
		'''
			enum States {
				«FOR state : flow.states SEPARATOR ','»        
					«state.toName»
				«ENDFOR» 
			}
		'''
	}

	def protected generateEventEnum(ExecutionFlow flow) {
		'''
			enum Events {
				«FOR scope : flow.interfaceScopes»
					«FOR declaration : scope.declarations.filter[it instanceof EventDefinition] SEPARATOR ','»«declaration.toName»«ENDFOR»,nullEvent
				«ENDFOR»
			}
		'''
	}
}
