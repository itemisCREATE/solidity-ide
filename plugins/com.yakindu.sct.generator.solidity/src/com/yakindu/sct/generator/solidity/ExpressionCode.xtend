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
import java.util.List
import org.yakindu.base.expressions.expressions.Argument
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.VariableDefinition

/**
 * @author Florian Antony
 */
class ExpressionCode extends ExpressionsGenerator {

	@Inject extension Naming

	override dispatch CharSequence code(PrimitiveValueExpression it) {
		'''«it.value.code»'''
	}

	def dispatch CharSequence code(Declaration it) {
		'''«it.name»'''
	}

	def dispatch CharSequence code(EventDefinition it) {
		'''(Events.«it.name» == lastEvent)'''
	}

	def dispatch CharSequence code(Sequence it) {
		'''«FOR step : it.steps»
			«step.code»
		«ENDFOR»'''
	}

	def dispatch CharSequence code(Execution it) {
		'''«it.statement.code»'''
	}

	def dispatch CharSequence code(ExitState it) {
		'''«it.name»'''
	}

	def dispatch CharSequence code(EnterState it) {
		'''«it.name»'''
	}

	def dispatch CharSequence code(StateSwitch it) '''
		«FOR stateCase : cases SEPARATOR "else "»
			if (activeState == States.«stateCase.state.toName»){
				«stateCase.step.code»
			}
		«ENDFOR»
	'''

	def protected dispatch String code(FeatureCall it) {
		'''«owner.code».«(feature as Declaration).codeDeclaration(it)»'''
	}

	def protected codeDeclaration(Declaration it, ArgumentExpression exp) {
		switch it {
			Operation:
				return functionCall(it, exp.expressions)
			Property:
				name
		}
	}

	def protected String functionCall(Operation it, List<Expression> args) {
		'''«code»(«FOR arg : args SEPARATOR ", "»«arg.code»«ENDFOR»)'''
	}

	def dispatch CharSequence code(If it) '''
		if («check.code.toString.trim») {
			«thenStep.code»
		}«IF elseStep !== null» else {
				«elseStep.code»
			}
		«ENDIF»
	'''

	def dispatch CharSequence code(CheckRef it) '''
		«IF check !== null»«comment»«check.code()»«ELSE»true«ENDIF»
	'''

	def dispatch CharSequence code(Check it) '''
		«condition.code()»
	'''

	def dispatch CharSequence code(VariableDefinition it) {
		'''«it.name»'''
	}

	def dispatch CharSequence code(Call it) {
		'''«it.step.code»'''
	}

	override dispatch CharSequence code(AssignmentExpression it) {
		'''
			«it.varRef.code»«it.operator»«it.expression.code»;
		'''
	}

	def dispatch CharSequence code(ElementReferenceExpression it) {
		'''«it.reference.code»«FOR expression : it.expressions»«expression.code»«ENDFOR»'''
	}

	def dispatch CharSequence code(Argument it) {
		'''«it.value.code»'''
	}

	def dispatch String code(EventValueReferenceExpression it) {
		value.code.toString
	}

	override dispatch String code(TypeCastExpression it) {
		'''«type.name»(«it.operand.code»)'''
	}

}
