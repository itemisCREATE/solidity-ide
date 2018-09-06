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
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Event
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.stext.stext.InterfaceScope

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * 
 */
class Declarations {

	@Inject extension ExpressionCode
	@Inject extension ICodegenTypeSystemAccess

	def dispatch declaration(EventDefinition definition) {
		'''
			«IF definition.direction.value == 1»
				function «definition.name»() public react {
					lastInteraction = block.timestamp;
					lastEvent = Events.«definition.name»;
				}	
			«ENDIF»
		'''
	}

	def dispatch declaration(Event declaration) {
		''''''
	}

	def dispatch declaration(Enumerator declaration) {
		''''''
	}

	def dispatch declaration(Operation declaration) {
		''''''
	}

	def dispatch declaration(VariableDefinition variable) {
		var String interfaceDeclarationName;
		if(variable.eContainer instanceof InterfaceScope){
			interfaceDeclarationName = (variable.eContainer as InterfaceScope).name;
		}
		'''«variable.type.targetLanguageName» public «variable.name»«interfaceDeclarationName»«IF variable.initialValue !== null»=«variable.initialValue.code»«ENDIF»;'''
	}
}
