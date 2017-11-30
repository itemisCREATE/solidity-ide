/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - Itemis AG - initial API and implementation
 * 	Karsten Thoms   - Itemis AG - initial API and implementation
 * 	Florian Antony  - Itemis AG - initial API and implementation
 * 	committers of YAKINDU 
 * 
 */
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
