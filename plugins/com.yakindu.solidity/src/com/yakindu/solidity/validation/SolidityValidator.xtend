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

import com.google.common.collect.Sets
import com.google.inject.Inject
import com.yakindu.solidity.IWorkspaceResourceResolver
import com.yakindu.solidity.solc.ISolidityCompiler
import com.yakindu.solidity.solc.output.FileOutputProcessor
import com.yakindu.solidity.solc.output.SolidityIssueCreator
import com.yakindu.solidity.solc.preferences.ICompilerPreferences
import com.yakindu.solidity.solidity.PragmaSolidityDirective
import com.yakindu.solidity.solidity.SolidityPackage
import com.yakindu.solidity.solidity.SourceUnit
import java.io.File
import java.util.List
import java.util.Set
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.xtext.validation.Check
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.validation.ExpressionsValidator
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation

class SolidityValidator extends ExpressionsValidator {
	val public SOLIDITY_VERSION_NOT_DEFAULT = "Solidity version does not match the default version"

	@Inject(optional=true) ISolidityCompiler compiler;

	@Inject
	SolidityIssueCreator issueCreator;

	@Inject
	FileOutputProcessor outputWriter;
	
	@Inject(optional=true)
	IWorkspaceResourceResolver resourceResolver;

	@Inject
	ICompilerPreferences prefs;
	
	override protected assertOperationArguments(Operation operation, List<Expression> args) {
		// TODO Disabled, doesn't work with extension operations
	}

	override checkLeftHandAssignment(AssignmentExpression expression) {
		// TODO Disables, doesn't work with Parameters
	}
	
	@Check
	def protected checkPragmaVersion(PragmaSolidityDirective pragma) {
		warning(SOLIDITY_VERSION_NOT_DEFAULT + " (BULLSHIT)", pragma,
				SolidityPackage.Literals.PRAGMA_SOLIDITY_DIRECTIVE__VERSION,
				IssueCodes.WARNING_SOLIDITY_VERSION_NOT_THE_DEFAULT)
		
	}

	@Check(NORMAL)
	def protected compilerValidations(SourceUnit unit) {
		if (compiler !== null && prefs.isCompilerEnabled) {
			val monitor = SubMonitor.convert(null)
			if(resourceResolver === null) {
				throw new IllegalStateException("Resource resolver is mandatory for compiler adoption.");
			}
			val Set<File> resources = Sets.newHashSet(resourceResolver.resolve(unit.eResource));
			val output = compiler.compile(resources, monitor).get
			issueCreator.createErrors(output.errors, resources, currentObject, messageAcceptor)
			issueCreator.createInfos(output.contracts, resources, currentObject, messageAcceptor)
			outputWriter.writeOutputFiles(output, resources);
			/*resources.forEach [
				it.project.refreshLocal(IResource.DEPTH_ONE, monitor);
			]*/
		}
	}

	override getEPackages() {
		val superPackages = super.EPackages
		superPackages += SolidityPackage.eINSTANCE
		return superPackages
	}
}
