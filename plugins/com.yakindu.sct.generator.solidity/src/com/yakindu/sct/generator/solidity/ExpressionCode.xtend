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
import java.util.List
import org.yakindu.base.expressions.expressions.Argument
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.types.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
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
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.sexec.TimeEvent

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * 
 */
class ExpressionCode extends ExpressionsGenerator {

	@Inject extension Naming

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
			// TODO implement state reactions
«««			«thenStep.code»
		}«IF elseStep !== null» else {
			// TODO implement state reactions
«««			«elseStep.code»
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

	def dispatch CharSequence code(TimeEvent it) {
		'''block.timestamp > lastInteraction + 500000'''
	}

	def dispatch CharSequence code(ScheduleTimeEvent it) {
		// TODO
	}

	def dispatch CharSequence code(UnscheduleTimeEvent it) {
		'''// TODO implement time events'''
	}
	
	def dispatch CharSequence code(Scope it){
		// TODO
	}

	def dispatch CharSequence code(Call it) {
		'''«it.step.code»'''
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
