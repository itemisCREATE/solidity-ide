/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Florian Antony - itemis AG
 * 
 */
package com.yakindu.sct.generator.solidity

import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.sct.generator.core.templates.Expressions

/**
 * @author Florian Antony
 */
class ExpressionCode extends Expressions {

	def dispatch CharSequence code(PrimitiveValueExpression it) {
		'''«it.value.code»'''
	}

	def dispatch CharSequence code(BoolLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(IntLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(DoubleLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(FloatLiteral it) '''«value.toString»'''
}
