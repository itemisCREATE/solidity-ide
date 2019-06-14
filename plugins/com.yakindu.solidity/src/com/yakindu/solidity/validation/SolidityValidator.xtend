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
import com.yakindu.solidity.compiler.builder.ISolidityCompiler
import com.yakindu.solidity.compiler.builder.processor.FileOutputProcessor
import com.yakindu.solidity.compiler.builder.processor.SolidityMarkerCreator
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

	@Inject
	SolidityMarkerCreator markerCreator;

	@Inject
	FileOutputProcessor outputFileWriter;

	@Inject(optional=true) ISolidityCompiler compiler;

	override protected assertOperationArguments(Operation operation, List<Expression> args) {
		// TODO Disabled, doesn't work with extension operations
	}

	override checkLeftHandAssignment(AssignmentExpression expression) {
		// TODO Disables, doesn't work with Parameters
	}

	@Check
	def protected compilerValidations(SourceUnit unit) {
		val Set<IResource> resources = Sets.newHashSet(
			ResourcesPlugin.getWorkspace().getRoot().findMember(unit.eResource.URI.toPlatformString(true)))
		val output = compiler.compile(resources, SubMonitor.convert(null)).get
		markerCreator.createMarkers(output, resources);
		outputFileWriter.writeOutputFiles(output, resources);

	}

	override getEPackages() {
		val superPackages = super.EPackages
		superPackages += SolidityPackage.eINSTANCE
		return superPackages
	}
}
