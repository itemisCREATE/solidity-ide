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
import org.yakindu.base.types.Event
import org.yakindu.sct.model.sexec.ExecutionFlow
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
			pragma solidity ^0.4.18;
			contract «flow.toName» {
			    «flow.generateStateEnum»
			    
			    «flow.generateEventEnum»
			    // This is the current state.
			    States public activeState = States.«flow.states.get(0).toName»;
			    
			    address private owner; 
				«FOR declaration : flow.interfaceScopes.map[declarations].flatten»
			  	    «declaration.declaration»
				«ENDFOR»
				«FOR declaration : flow.internalScope.declarations»
			    	«declaration.declaration»
				«ENDFOR»
			
			    modifier exit() {
				«FOR state : flow.states.filter[it.exitAction !== null]»
				    if(activeState == States.«state.toName»){
					    «state.exitAction?.code»;
				    }
				«ENDFOR» 
				    _;
			    }
			
				modifier entry() {
					_;
				«FOR state : flow.states.filter[it.entryAction !== null]»
				if(activeState == States.«state.toName»){
				        «state.entryAction?.code»;
					}
				«ENDFOR» 
			    }
			
				modifier react() {
					_;
					«FOR state : flow.states.filter[reactSequence !== null && reactSequence.steps.size > 0] SEPARATOR "else "»
						«IF !state.reactSequence.steps.isNullOrEmpty»
							if(activeState == States.«state.toName»){
									«state.reactSequence.code»
							}
						«ENDIF» 
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
		«IF flow.hasEvents»
			Events private lastEvent = Events.nullEvent;
			
			enum Events {
				«FOR declaration : flow.interfaceScopes.map[declarations].flatten.filter(EventDefinition) SEPARATOR ',' AFTER ', nullEvent'»
					«declaration.toName»
				«ENDFOR»
			}
			«ENDIF»
		'''
	}
	
	def protected hasEvents(ExecutionFlow it){
		eAllContents.filter(Event).size > 0
	}
}
