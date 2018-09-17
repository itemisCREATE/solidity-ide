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

import com.google.inject.name.Named
import com.yakindu.solidity.SolidityRuntimeModule
import com.yakindu.solidity.solidity.PragmaDirective
import com.yakindu.solidity.solidity.SolidityPackage
import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.validation.Check
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.types.Operation

class SolidityValidator extends AbstractSolidityValidator {
	val public SOLIDITY_VERSION_NOT_DEFAULT = "Solidity version does not match the default version"

	@Inject @Named(SolidityRuntimeModule.SOLIDITY_VERSION) String solcVersion

	override protected assertOperationArguments(Operation operation, List<Expression> args) {
		// TODO Disabled, doesn't work with extension operations
	}

	override checkLeftHandAssignment(AssignmentExpression expression) {
		// TODO Disables, doesn't work with Parameters
	}

	@Check
	def protected checkPragmaVersion(PragmaDirective pragma) {
		if (!("^" + solcVersion).equals(pragma.version)) {
			warning(SOLIDITY_VERSION_NOT_DEFAULT + " (" + solcVersion + ")", pragma,
				SolidityPackage.Literals.PRAGMA_DIRECTIVE__VERSION, IssueCodes.WARNING_SOLIDITY_VERSION_NOT_THE_DEFAULT)
		}
	}
}
