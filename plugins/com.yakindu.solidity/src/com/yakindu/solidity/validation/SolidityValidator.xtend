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
import com.yakindu.solidity.compiler.ISolidityCompiler
import com.yakindu.solidity.compiler.output.FileOutputProcessor
import com.yakindu.solidity.compiler.output.SolidityMarkerCreator
import com.yakindu.solidity.solidity.SolidityPackage
import com.yakindu.solidity.solidity.SourceUnit
import java.util.List
import java.util.Set
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.xtext.validation.Check
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.validation.ExpressionsJavaValidator
import org.yakindu.base.types.Operation

class SolidityValidator extends ExpressionsJavaValidator {
	val public SOLIDITY_VERSION_NOT_DEFAULT = "Solidity version does not match the default version"

	@Inject(optional=true) ISolidityCompiler compiler;

	@Inject
	SolidityMarkerCreator markerCreator;

	@Inject
	FileOutputProcessor outputWriter;

	override protected assertOperationArguments(Operation operation, List<Expression> args) {
		// TODO Disabled, doesn't work with extension operations
	}

	override checkLeftHandAssignment(AssignmentExpression expression) {
		// TODO Disables, doesn't work with Parameters
	}

	@Check(NORMAL)
	def protected compilerValidations(SourceUnit unit) {
		if (compiler !== null) {
			val monitor = SubMonitor.convert(null);
			val Set<IResource> resources = Sets.newHashSet(
				ResourcesPlugin.getWorkspace().getRoot().findMember(unit.eResource.URI.toPlatformString(true)))
			val output = compiler.compile(resources, monitor).get
			markerCreator.createMarkers(output, resources);
			outputWriter.writeOutputFiles(output, resources);
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, monitor);
		}
	}

	override getEPackages() {
		val superPackages = super.EPackages
		superPackages += SolidityPackage.eINSTANCE
		return superPackages
	}
}
