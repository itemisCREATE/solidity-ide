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
import com.yakindu.solidity.scoping.ImportedUrisResolver
import com.yakindu.solidity.solc.ISolidityCompiler
import com.yakindu.solidity.solc.output.FileOutputProcessor
import com.yakindu.solidity.solc.output.SolidityIssueCreator
import com.yakindu.solidity.solc.preferences.ICompilerPreferences
import com.yakindu.solidity.solidity.PragmaVersion
import com.yakindu.solidity.solidity.PragmaVersionConstraint
import com.yakindu.solidity.solidity.SolidityModel
import com.yakindu.solidity.solidity.SolidityPackage
import com.yakindu.solidity.solidity.VersionOperator
import java.io.File
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
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

	@Inject
	ImportedUrisResolver uriResolver

	override protected assertOperationArguments(Operation operation, List<Expression> args) {
		// TODO Disabled, doesn't work with extension operations
	}

	override checkLeftHandAssignment(AssignmentExpression expression) {
		// TODO Disables, doesn't work with Parameters
	}

	@Check(NORMAL)
	def protected compilerValidations(SolidityModel model) {
		if (compiler !== null && prefs.isCompilerEnabled) {
			val monitor = SubMonitor.convert(null)
			if (resourceResolver === null) {
				throw new IllegalStateException("Resource resolver is mandatory for compiler adoption.");
			}
			val Set<File> resources = Sets.newHashSet(resourceResolver.resolve(model.eResource));
			val Set<URI> visited = Sets.newHashSet(model.eResource.URI)
			val Set<URI> importedURIs = uriResolver.getImportedUris(model.eResource);
			resources.addAll(getImportedFiles(importedURIs, visited))
			val output = compiler.compile(resources, monitor).get
			issueCreator.createErrors(output.errors, resources, currentObject, messageAcceptor)
			issueCreator.createInfos(output.contracts, resources, currentObject, messageAcceptor)
			outputWriter.writeOutputFiles(output, resources);
		/*resources.forEach [
		 * 	it.project.refreshLocal(IResource.DEPTH_ONE, monitor);
		 ]*/
		}
	}
	
	def protected Set<File> getImportedFiles(Set<URI> importedURIs, Set<URI> visited) {
		val Set<File> importedFiles = new HashSet;
		for (URI importedURI : importedURIs) {
			if (!visited.contains(URI)) {
				val Resource importedResource = new ResourceSetImpl().createResource(importedURI)
				importedFiles.add(resourceResolver.resolve(importedResource))
				val Set<URI> transitiveImports = uriResolver.getImportedUris(importedResource);
				importedFiles.addAll(getImportedFiles(transitiveImports, visited))
			}
		}
		return importedFiles
	}

	@Check
	def protected checkSolidityVersion(PragmaVersion pragmaVersion) {
		val PragmaVersionConstraint minorConstraint = pragmaVersion.minorConstraint
		val String version = minorConstraint.version
		val String[] splittedVersion = version.split("\\.")
		val int major = Integer.parseInt(splittedVersion.get(0))
		val int minor = Integer.parseInt(splittedVersion.get(1))
		val int micro = splittedVersion.length > 2 ? Integer.parseInt(splittedVersion.get(2)) : 0
		if (major == 0 && minor < 6) {
			error("Yakindu Solidity Tools only works with Solidity version 0.6 or higher", pragmaVersion,
				SolidityPackage.Literals.PRAGMA_VERSION__MINOR_CONSTRAINT)
		}
		if (minorConstraint.versionOperator == VersionOperator.SMALLER) {
			if (major == 0 && minor == 6 && micro == 0) {
				error("Yakindu Solidity Tools only works with Solidity version 0.6 or higher", pragmaVersion,
					SolidityPackage.Literals.PRAGMA_VERSION__MINOR_CONSTRAINT)
			}
		}
	}

	override getEPackages() {
		val superPackages = super.EPackages
		superPackages += SolidityPackage.eINSTANCE
		return superPackages
	}
}
