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
package com.yakindu.solidity.formatting2

import com.yakindu.solidity.solidity.Block
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.EventDefinition
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.IfStatement
import com.yakindu.solidity.solidity.ImportDirective
import com.yakindu.solidity.solidity.ModifierDefinition
import com.yakindu.solidity.solidity.SolidityModel
import com.yakindu.solidity.solidity.SourceUnit
import com.yakindu.solidity.solidity.StructDefinition
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.yakindu.base.types.Package
import org.yakindu.base.types.PackageMember
import com.yakindu.solidity.solidity.ConstructorDefinition
import com.yakindu.solidity.solidity.VariableDefinition

/**
 * Code formatter for Solidity according to 
 * <a href="http://solidity.readthedocs.io/en/develop/style-guide.html">Solidity Styleguide</a>.
 * 
 * @author Karsten Thoms - Initial contribution and API
 * @author Florian Antony
 */
class SolidityFormatter extends AbstractFormatter2 {

	def dispatch void format(SolidityModel solidityModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Package _package : solidityModel.getSourceunit()) {
			_package.format;
		}
		solidityModel.allRegionsFor.keywords('=', '==').forEach[
			surround[oneSpace]
		]
		solidityModel.allRegionsFor.keywords(';').forEach[
			prepend[noSpace]
			append[newLine]
		]
		solidityModel.allRegionsFor.keywords('else').forEach[
			surround[oneSpace]
		]

		solidityModel.allRegionsFor.keywordPairs('[', ']').forEach[
			key.append[noSpace]
			value.prepend[noSpace]
		]

		solidityModel.allRegionsFor.keywordPairs('(', ')').forEach[
			key.append[noSpace]
			value.prepend[noSpace]
		]

	// EcoreUtil2.eAllOfType(solidityModel, Block).forEach[format]
	}

	def dispatch void format(SourceUnit sourceUnit, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		sourceUnit.getPragma.format;
		for (PackageMember packageMember : sourceUnit.getImports()) {
			packageMember.format;
		}
		for (PackageMember packageMember : sourceUnit.getMember()) {
			packageMember.format;
		}
	}

	def dispatch void format(ImportDirective element, extension IFormattableDocument document) {
		element.regionFor.keyword("import").append[oneSpace]
	}

	def dispatch void format(ContractDefinition element, extension IFormattableDocument document) {
		element.prepend[setNewLines(1, 3, 3)]
		element.append[setNewLines(1, 3, 3)]

//		element.regionFor.keyword('{') => [
//			append[newLine]
//		]
//		element.regionFor.keyword('}') => [
//			prepend[newLine]
//		]
		element.interior[indent]
		element.features.forEach[format]
	}

	def dispatch void format(FunctionDefinition element, extension IFormattableDocument document) {
		element.prepend[setNewLines(1, 2, 2)]
		element.append[setNewLines(1, 2, 2)]
		element.block.format
	}
	
	def dispatch void format(ConstructorDefinition element, extension IFormattableDocument document) {
		element.prepend[setNewLines(1, 2, 2)]
		element.append[setNewLines(1, 2, 2)]
		element.block.format
	}
	
	def dispatch void format(VariableDefinition element, extension IFormattableDocument document) {
		element.prepend[setNewLines(1, 2, 2)]
		element.append[setNewLines(1, 2, 2)]
	}

	def dispatch void format(ModifierDefinition element, extension IFormattableDocument document) {
		element.prepend[setNewLines(1, 2, 2)]
		element.append[setNewLines(1, 2, 2)]
		element.block.format
	}

	def dispatch void format(EventDefinition element, extension IFormattableDocument document) {
		element.prepend[setNewLines(1, 2, 2)]
		element.append[setNewLines(1, 2, 2)]
	}

	def dispatch void format(StructDefinition element, extension IFormattableDocument document) {
		element.prepend[setNewLines(1, 2, 2)]
		element.append[setNewLines(1, 2, 2)]

		element.interior[indent]
		element.regionFor.keyword('{') => [
			prepend[noSpace]
			append[newLine]
		]
		element.regionFor.keyword('}') => [
			prepend[newLine]
		]
		element.features.forEach[
			prepend[newLine]
		]
	}

	def dispatch void format(Block element, extension IFormattableDocument document) {
		element.interior[indent]
		if (element.eContainer instanceof IfStatement) {
			element.regionFor.keyword('{') => [
				append[newLine]
			]
			element.regionFor.keyword('}') => [
				prepend[noSpace]
			]
		} else {
			element.regionFor.keyword('{') => [
				prepend[noSpace]
				append[newLine]
			]
			element.regionFor.keyword('}') => [
				prepend[newLine]
			]
		}
		element.statements.forEach[
			prepend[newLine]
			format
		]
	}
}
