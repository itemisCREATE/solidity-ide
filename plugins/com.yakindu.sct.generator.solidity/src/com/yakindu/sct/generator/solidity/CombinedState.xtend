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
import org.yakindu.base.types.Event
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.base.types.TypedDeclaration

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * 
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
					
					// Owner of the contract
					address private owner; 
			
					// Owner of the contract
					uint private lastInteraction; 
						
					// Internal scope
					«IF flow.internalScope !== null»
						«FOR declaration : flow.internalScope.declarations.filter[it instanceof TypedDeclaration]»
							«(declaration as TypedDeclaration).declaration»
						«ENDFOR»
					«ENDIF»
					«IF flow.interfaceScope !== null»
						«FOR interfaceScope : flow.interfaceScopes»
							//«interfaceScope.name» Scope
							«FOR declaration : interfaceScope.declarations.filter[it instanceof VariableDefinition] »
								«(declaration as VariableDefinition).declaration»
							«ENDFOR»
						«ENDFOR»
					«ENDIF»
					
					modifier react() {
						_;
						«FOR state : flow.states.filter[reactSequence !== null && reactSequence.steps.size > 0]»
							«IF !state.reactSequence.steps.isNullOrEmpty»
								if(activeState == States.«state.toName»){
									«FOR steps : state.reactSequence.steps»
										«steps.code»
									«ENDFOR»
								}
							«ENDIF» 
						«ENDFOR» 
					}
					
					// constructor
					function «flow.toName»Statemachine()public {
						owner = msg.sender;
					}
					
					// default function
					function() public payable {}			
					
					«FOR interfaceScope : flow.interfaceScopes»
						//«interfaceScope.name» Scope
						«FOR declaration : interfaceScope.declarations.filter[it instanceof EventDefinition] »
							«(declaration as EventDefinition).declaration»
							
						«ENDFOR»
					«ENDFOR»
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
				Events private lastEvent;
				
				enum Events {
					«FOR declaration : flow.interfaceScopes.map[declarations].flatten.filter(EventDefinition) SEPARATOR ','»
						«declaration.toName»
					«ENDFOR»
				}
			«ENDIF»
		'''
	}

	def protected hasEvents(ExecutionFlow it) {
		eAllContents.filter(Event).size > 0
	}
}
