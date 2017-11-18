package com.yakindu.solidity.validation

import java.util.List
import org.yakindu.base.types.Operation
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.AssignmentExpression

class SolidityJavaValidator extends AbstractSolidityValidator {

	override protected assertOperationArguments(Operation operation, List<Expression> args) {
		// TODO Disabled, doesn't work with extension operations
	}

	override checkLeftHandAssignment(AssignmentExpression expression) {
		// TODO Disables, doesn't work with Parameters
	}

}
