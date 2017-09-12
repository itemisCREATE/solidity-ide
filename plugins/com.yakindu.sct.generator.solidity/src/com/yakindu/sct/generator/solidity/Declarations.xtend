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
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Event
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * @author Florian Antony
 */
class Declarations {

	@Inject extension ExpressionCode

	def dispatch declaration(Event declaration) {
		''''''
	}

	def dispatch declaration(Enumerator declaration) {
		''''''
	}

	def dispatch declaration(Operation declaration) {
		''''''
	}

	def dispatch declaration(
		VariableDefinition variable) {
		'''«variable.type» public «variable.name»«IF variable.initialValue != null»=«variable.initialValue.code»«ENDIF»;'''
	}
}
