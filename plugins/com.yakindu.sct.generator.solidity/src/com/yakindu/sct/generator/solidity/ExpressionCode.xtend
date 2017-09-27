/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Florian Antony - itemis AG
 * 
 */
package com.yakindu.sct.generator.solidity

import org.yakindu.base.expressions.expressions.Argument
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.sct.generator.core.templates.Expressions
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.EnterState

/**
 * @author Florian Antony
 */
class ExpressionCode extends Expressions {

	def dispatch CharSequence code(PrimitiveValueExpression it) {
		'''«it.value.code»'''
	}

	def dispatch CharSequence code(OperationDefinition it) {
		'''«it.name»'''
	}

	def dispatch CharSequence code(Sequence it) {
		'''«FOR step : it.steps»«step.code»«ENDFOR»'''
	}

	def dispatch CharSequence code(Execution it) {
		'''«it.statement.code»'''
	}

	def dispatch CharSequence code(EventDefinition it) {
		'''(Events.«it.name» == lastEvent)'''
	}

	def dispatch CharSequence code(ExitState it) {
		'''«it.name»'''
	}

	def dispatch CharSequence code(EnterState it) {
		'''«it.name»'''
	}

	def dispatch CharSequence code(VariableDefinition it) {
		'''«it.name»'''
	}

	def dispatch CharSequence code(Call it) {
		'''«it.step.code»'''
	}

	def dispatch CharSequence code(AssignmentExpression it) {
		'''
			«it.varRef.code»«it.operator»«it.expression.code»;
		'''
	}

	def dispatch CharSequence code(ElementReferenceExpression it) {
		'''«it.reference.code»«FOR expression : it.expressions»«expression.code»«ENDFOR»'''
	}
	def dispatch CharSequence code(ParenthesizedExpression it) {
		'''«it.expression.code»'''
	}
	def dispatch CharSequence code(Argument it) {
		'''«it.value.code»'''
	}

	def dispatch CharSequence code(BoolLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(IntLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(DoubleLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(FloatLiteral it) '''«value.toString»'''
	

}
