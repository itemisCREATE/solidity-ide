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

import com.yakindu.solidity.solidity.ArrayTypeSpecifier
import com.yakindu.solidity.solidity.AssemblyForExpression
import com.yakindu.solidity.solidity.Block
import com.yakindu.solidity.solidity.ConstructorDefinition
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.EmitExpression
import com.yakindu.solidity.solidity.EventDefinition
import com.yakindu.solidity.solidity.ExponentialExpression
import com.yakindu.solidity.solidity.ForStatement
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.FunctionalAssemblyExpression
import com.yakindu.solidity.solidity.IfStatement
import com.yakindu.solidity.solidity.ImportDirective
import com.yakindu.solidity.solidity.InlineAssemblyBlock
import com.yakindu.solidity.solidity.MappingTypeSpecifier
import com.yakindu.solidity.solidity.ModifierDefinition
import com.yakindu.solidity.solidity.NamedArgument
import com.yakindu.solidity.solidity.NewInstanceExpression
import com.yakindu.solidity.solidity.NumericalUnaryExpression
import com.yakindu.solidity.solidity.PragmaDirective
import com.yakindu.solidity.solidity.SimpleArgument
import com.yakindu.solidity.solidity.SolidityModel
import com.yakindu.solidity.solidity.SourceUnit
import com.yakindu.solidity.solidity.StructDefinition
import com.yakindu.solidity.solidity.TupleExpression
import com.yakindu.solidity.solidity.VariableDefinition
import com.yakindu.solidity.solidity.WhileStatement
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.types.EnumerationType

import static org.eclipse.xtext.EcoreUtil2.getContainerOfType
import com.yakindu.solidity.solidity.AssemblyIfExpression
import com.yakindu.solidity.solidity.AssemblySwitchExpression
import com.yakindu.solidity.solidity.AssemblySwitchCase
import com.yakindu.solidity.solidity.AssemblyDefaultSwitchCase
import com.yakindu.solidity.solidity.AssemblyFunctionDefinition
import com.yakindu.solidity.solidity.AssemblyLocalBinding
import com.yakindu.solidity.solidity.SolidityPackage
import com.yakindu.solidity.solidity.AssemblyAssignment

/**
 * Code formatter for Solidity according to 
 * <a href="http://solidity.readthedocs.io/en/develop/style-guide.html">Solidity Styleguide</a>.
 * 
 * @author Karsten Thoms - Initial contribution and API
 * @author Florian Antony
 */
class SolidityFormatter extends AbstractFormatter2 {

	def dispatch void format(SolidityModel it, extension IFormattableDocument document) {
		sourceunit.forEach[format]

	}

	def dispatch void format(SourceUnit it, extension IFormattableDocument document) {
		imports.forEach[format]

		allRegionsFor.keywordPairs('[', ']').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		allRegionsFor.keywordPairs('(', ')').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		pragma.forEach[format]
		member.forEach[format]
		append[noSpace]
	}

	def dispatch void format(PragmaDirective it, extension IFormattableDocument document) {
		append[newLines(1, 1, 1); priority = IHiddenRegionFormatter.LOW_PRIORITY;]
	}

	def dispatch void format(ImportDirective it, extension IFormattableDocument document) {
		prepend[newLines]
	}

	def dispatch void format(ContractDefinition it, extension IFormattableDocument document) {
		prepend[newLines(2, 3, 3)]
		append[newLines(3, 3, 3); priority = IHiddenRegionFormatter.HIGH_PRIORITY;]
		interior[indent]
		regionFor.keywordPairs('{', '}').forEach [
			key.append[newLine; priority = IHiddenRegionFormatter.LOW_PRIORITY;].prepend [
				oneSpace;
				priority = IHiddenRegionFormatter.LOW_PRIORITY;
			]
			value.surround[newLines; priority = IHiddenRegionFormatter.LOW_PRIORITY;]
		]

		regionFor.keyword("is").surround[oneSpace]
		allRegionsFor.keywordPairs('(', ')').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		features.forEach[format]
	}

	def dispatch void format(VariableDefinition it, extension IFormattableDocument document) {
		prepend[newLines]
		initialValue.format
	}

	def dispatch void format(ConstructorDefinition it, extension IFormattableDocument document) {
		prepend[newLines(2, 2, 3)]
		allRegionsFor.keywords("constructor", ",").forEach [
			append[oneSpace]
		]
		allRegionsFor.keywordPairs('(', ')').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		modifier.forEach [
			prepend[oneSpace]
		]
		block.format
	}

	def dispatch void format(FunctionDefinition it, extension IFormattableDocument document) {
		prepend[newLines(2, 2, 3)]
		val int functionSignatureLength = getLengthOfFunctionSignature
		if (functionSignatureLength > 80) {
			allRegionsFor.keywordPairs('(', ')').forEach[pair|pair.interior[indent];]
			allRegionsFor.keywordPairs('(', ')').head.key.append[newLines(1, 1, 1)];
			allRegionsFor.keywordPairs('(', ')').head.value.prepend[newLines(1, 1, 1)].append [
				newLines(1, 1, 1);
				priority = IHiddenRegionFormatter.HIGH_PRIORITY
			];
			allRegionsFor.keywordPairs('(', ')').head.key.prepend[noSpace]
			for (parameter : parameters) {
				parameter.prepend[newLines(1, 1, 1); priority = IHiddenRegionFormatter.HIGH_PRIORITY]
			}
			for (modifier : modifier) {
				modifier.prepend[newLines(1, 1, 1)]
				modifier.indent(document)
			}
			if (regionFor.keyword("returns") !== null) {
				regionFor.keyword("returns").indent(document).append[oneSpace]
			}
			allRegionsFor.keywordPairs('(', ')').get(1).key.prepend[oneSpace]
			allRegionsFor.keywordPairs('(', ')').get(1).key.append[newLines(1, 1, 1)];
			allRegionsFor.keywordPairs('(', ')').get(1).value.prepend[newLines(1, 1, 1)].append [
				newLines(1, 1, 1);
				priority = IHiddenRegionFormatter.HIGH_PRIORITY
			];
			allRegionsFor.keywordPairs('(', ')').get(1).value.indent(document)
			for (returnParam : returnParameters) {
				returnParam.prepend[newLines(1, 1, 1)]
				returnParam.indent(document)
			}

		} else {
			allRegionsFor.keywordPairs('(', ')').forEach [ p |
				p.key.append[noSpace]
				p.value.prepend[noSpace]
			]
			regionFor.keyword(",").append[oneSpace].prepend[noSpace]
			modifier.forEach [
				prepend[oneSpace]
			]
		}
		block.format
	}

	def dispatch void format(MappingTypeSpecifier it, extension IFormattableDocument document) {
		prepend[newLines(2, 2, 3)]
		regionFor.keyword("mapping").append[oneSpace]
		regionFor.keyword("'=>").surround[oneSpace]
		allRegionsFor.keywordPairs('(', ')').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
	}

	def dispatch void format(ArrayTypeSpecifier it, extension IFormattableDocument document) {
		prepend[newLines]
		allRegionsFor.keywordPairs('[', ']').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
	}

	def dispatch void format(ModifierDefinition it, extension IFormattableDocument document) {
		prepend[newLines(2, 2, 3)]
		regionFor.keyword("modifier").append[oneSpace]
		regionFor.keyword(",").append[oneSpace].prepend[noSpace]
		allRegionsFor.keywordPairs('(', ')').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		block.format
	}

	def dispatch void format(EventDefinition it, extension IFormattableDocument document) {
		prepend[newLines]
	}

	def dispatch void format(EnumerationType it, extension IFormattableDocument document) {
		prepend[newLines(2, 2, 3)]
		interior[indent]
		regionFor.keyword("enum").append[oneSpace]
		regionFor.keywordPairs('{', '}').forEach [
			key.append[newLines].prepend[oneSpace]
			value.surround[newLines; priority = IHiddenRegionFormatter.LOW_PRIORITY;]
		]
		enumerator.forEach[prepend[newLines]]
	}

	def dispatch void format(StructDefinition it, extension IFormattableDocument document) {
		prepend[newLines(2, 2, 3)]
		interior[indent]
		regionFor.keyword("struct").append[oneSpace]
		regionFor.keywordPairs('{', '}').forEach [
			key.append[newLines].prepend[oneSpace]
			value.surround[newLines; priority = IHiddenRegionFormatter.LOW_PRIORITY;]
		]
		features.forEach[prepend[newLines]]
	}

	def dispatch void format(Block it, extension IFormattableDocument document) {
		interior[indent]
		regionFor.keywordPairs('{', '}').forEach [
			key.append[newLines]
			key.prepend[oneSpace]
			value.prepend[noSpace]
		]

		statements.forEach [
			format;
			prepend[noSpace];
			append[newLines(1, 1, 2); priority = IHiddenRegionFormatter.HIGH_PRIORITY];
		]
	}

	def dispatch void format(AssignmentExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
	}

	def dispatch void format(ConditionalExpression it, extension IFormattableDocument document) {
		allRegionsFor.keywords("?", ":").forEach[surround[oneSpace]]
		trueCase.format
		falseCase.format
	}

	def dispatch void format(LogicalOrExpression it, extension IFormattableDocument document) {
		regionFor.keyword("||").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(LogicalAndExpression it, extension IFormattableDocument document) {
		regionFor.keyword("&&").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(LogicalNotExpression it, extension IFormattableDocument document) {
		regionFor.keyword("!").surround[noSpace; priority = IHiddenRegionFormatter.LOW_PRIORITY;]
		operand.format
	}

	def dispatch void format(LogicalRelationExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(BitwiseOrExpression it, extension IFormattableDocument document) {
		regionFor.keyword("|").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(BitwiseXorExpression it, extension IFormattableDocument document) {
		regionFor.keyword("^").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(BitwiseAndExpression it, extension IFormattableDocument document) {
		regionFor.keyword("&").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(ShiftExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(NumericalAddSubtractExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(NumericalMultiplyDivideExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(ExponentialExpression it, extension IFormattableDocument document) {
		regionFor.keyword("**").surround[oneSpace]
		leftOperand.format
		rightOperand.format
	}

	def dispatch void format(NumericalUnaryExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[oneSpace]
			}
		]
		operand.format
	}

	def dispatch void format(PostFixUnaryExpression it, extension IFormattableDocument document) {
		allSemanticRegions.forEach [ region |
			if (it.operator.literal == region.text) {
				region.surround[noSpace]
			}
		]
		operand.format
	}

	def dispatch void format(NewInstanceExpression it, extension IFormattableDocument document) {
		regionFor.keyword("new").append[oneSpace]
		regionFor.keyword(",").append[oneSpace].prepend[noSpace]
		allRegionsFor.keywordPairs('(', ')').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		operationCall.format

	}

	def dispatch void format(EmitExpression it, extension IFormattableDocument document) {
		regionFor.keyword("emit").append[oneSpace]
		regionFor.keyword(",").append[oneSpace].prepend[noSpace]
		allRegionsFor.keywordPairs('(', ')').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		operationCall.format

	}

	def dispatch void format(TupleExpression it, extension IFormattableDocument document) {
		regionFor.keyword(",").append[oneSpace].prepend[noSpace]
		allRegionsFor.keywordPairs('(', ')').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		allRegionsFor.keywordPairs('[', ']').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		expressions.forEach[format]
	}

	def dispatch void format(FeatureCall it, extension IFormattableDocument document) {
		regionFor.keyword(".").surround[noSpace]
		regionFor.keyword(",").append[oneSpace].prepend[noSpace]
		allRegionsFor.keywordPairs('(', ')').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		allRegionsFor.keywordPairs('[', ']').forEach [
			key.append[noSpace]
			value.prepend[noSpace]
		]
		arguments.forEach[format]
		expressions.forEach[format]
		arraySelector.forEach[format]
	}

	def dispatch void format(IfStatement it, extension IFormattableDocument document) {
		regionFor.keyword("if").append[oneSpace]
		regionFor.keyword("else").surround[oneSpace; priority = IHiddenRegionFormatter.HIGH_PRIORITY]
		condition.format
		then.format
		^else.format
		append[newLines()]
	}

	def dispatch void format(WhileStatement it, extension IFormattableDocument document) {
		regionFor.keyword("while").append[oneSpace]
		condition.format
		body.format
		append[newLines()]
	}

	def dispatch void format(ForStatement it, extension IFormattableDocument document) {
		regionFor.keyword("for").append[oneSpace]
		initialization.prepend[noSpace]
		condition.format
		afterthought.prepend[noSpace]
		statement.format
		append[newLines]
	}

	def dispatch void format(SimpleArgument it, extension IFormattableDocument document) {
		prepend[oneSpace; priority = IHiddenRegionFormatter.LOW_PRIORITY]
		append[noSpace; priority = IHiddenRegionFormatter.LOW_PRIORITY]
		value.format
	}

	def dispatch void format(NamedArgument it, extension IFormattableDocument document) {
		regionFor.keyword(":").surround[oneSpace]
		surround[oneSpace; priority = IHiddenRegionFormatter.LOW_PRIORITY]
		value.format
	}

	def dispatch void format(InlineAssemblyBlock it, extension IFormattableDocument document) {
		interior[indent]
		regionFor.keywordPairs('{', '}').forEach [
			if (getContainerOfType(key.semanticElement, AssemblyForExpression) === null ){
				key.append[newLines]
				key.prepend[oneSpace]
				value.prepend[noSpace]
			}
		]

		items.forEach [
			format;
			prepend[noSpace];
			append[newLines(1, 1, 2); priority = IHiddenRegionFormatter.HIGH_PRIORITY];
		]
	}

	def dispatch void format(FunctionalAssemblyExpression it, extension IFormattableDocument document) {
		val int assemblyExpressionLength = getLengthOfAssemblyExpression
		if (assemblyExpressionLength >= 80) {
			regionFor.keywordPairs('(', ')').forEach [
				key.prepend[noSpace]
				key.append[newLine]
				value.prepend[newLine]
			]
			parameters.forEach [
				prepend[newLine]
				indent(document)
				append[noSpace]
			]
		} else {
			regionFor.keywords(",").forEach[append[oneSpace].prepend[noSpace]]
		}
	}
	
	def dispatch void format(AssemblyIfExpression it, extension IFormattableDocument document) {
		regionFor.keyword("if").append[oneSpace]
		regionFor.keyword("else").surround[oneSpace; priority = IHiddenRegionFormatter.HIGH_PRIORITY]
		condition.format
		body.format
		append[newLines()]
	}
	
	def dispatch void format(AssemblyFunctionDefinition it, extension IFormattableDocument document) {
		val int functionSignatureLength = getLengthOfFunctionSignature
		if (functionSignatureLength > 80) {
			allRegionsFor.keywordPairs('(', ')').forEach[pair|pair.interior[indent];]
			allRegionsFor.keywordPairs('(', ')').head.key.append[newLines(1, 1, 1)];
			allRegionsFor.keywordPairs('(', ')').head.value.prepend[newLines(1, 1, 1)].append [
				newLines(1, 1, 1);
				priority = IHiddenRegionFormatter.HIGH_PRIORITY
			];
			allRegionsFor.keywordPairs('(', ')').head.key.prepend[noSpace]
			for (parameter : parameters) {
				parameter.prepend[newLines(1, 1, 1); priority = IHiddenRegionFormatter.HIGH_PRIORITY]
			}
			if (regionFor.keyword("->") !== null) {
				regionFor.keyword("->").indent(document).append[oneSpace]
			}
			allRegionsFor.keywordPairs('(', ')').get(1).key.prepend[oneSpace]
			allRegionsFor.keywordPairs('(', ')').get(1).key.append[newLines(1, 1, 1)];
			allRegionsFor.keywordPairs('(', ')').get(1).value.prepend[newLines(1, 1, 1)].append [
				newLines(1, 1, 1);
				priority = IHiddenRegionFormatter.HIGH_PRIORITY
			];
			allRegionsFor.keywordPairs('(', ')').get(1).value.indent(document)
			for (returnParam : returnParameters) {
				returnParam.prepend[newLines(1, 1, 1)]
				returnParam.indent(document)
			}

		} else {
			allRegionsFor.keywordPairs('(', ')').forEach [ p |
				p.key.append[noSpace]
				p.value.prepend[noSpace]
			]
			regionFor.keyword("->").append[oneSpace].prepend[oneSpace]
			regionFor.keywords(",").forEach[append[oneSpace].prepend[noSpace]]
		}
		body.format
	}
	
	def dispatch void format(AssemblyLocalBinding it, extension IFormattableDocument document) {
		regionFor.keyword('let').append[oneSpace]
		regionFor.keyword(',').append[oneSpace]
		regionFor.feature(SolidityPackage.Literals.ASSEMBLY_LOCAL_BINDING__LABELS).prepend[oneSpace]
		regionFor.keyword(':=').prepend[oneSpace].append[oneSpace]
		expression.prepend[oneSpace]
		expression.format
	}
	
	def dispatch void format (AssemblyAssignment it, extension IFormattableDocument document) {
		regionFor.keyword(':=').append[oneSpace].prepend[oneSpace]
		regionFor.feature(SolidityPackage.Literals.ASSEMBLY_ASSIGNMENT__LEFT_OPERAND).append[oneSpace]
		regionFor.keyword('=:').append[oneSpace].prepend[oneSpace]
		regionFor.feature(SolidityPackage.Literals.ASSEMBLY_ASSIGNMENT__RIGHT_OPERND).prepend[oneSpace]
		expression.prepend[oneSpace]
		expression.format
	}
	
	def dispatch void format(AssemblyForExpression it, extension IFormattableDocument document) {
		body.regionFor.keywordPairs('{','}').head => [
			key.append[newLines]
			key.prepend[oneSpace]
			interior[indent]
			value.prepend[newLines]
		]
		body.format
	}
	
	def dispatch void format(AssemblySwitchExpression it, extension IFormattableDocument document) {
		condition.prepend[oneSpace].append[newLine]
		cases.forEach[format]
	}
	
	def dispatch void format(AssemblySwitchCase it, extension IFormattableDocument document) {
		body.regionFor.keyword('case').append[oneSpace]
		literal.prepend[oneSpace].append[oneSpace]
		body.format
	}
	
	def dispatch void format(AssemblyDefaultSwitchCase it, extension IFormattableDocument document) {
		
	}
	
	protected def void newLines(IHiddenRegionFormatter it) {
		newLines(1, 2, 3)
	}

	protected def void newLines(IHiddenRegionFormatter it, int lines) {
		newLines(1, lines, 3)
	}

	protected def void newLines(IHiddenRegionFormatter it, int min, int lines, int max) {
		noSpace
		setNewLines(min, lines, max)
	}

	protected def ISemanticRegion previousSemanticRegion(EObject it) {
		return it.regionForEObject.previousSemanticRegion
	}

	protected def ISemanticRegion nextSemanticRegion(EObject it) {
		return it.regionForEObject.nextSemanticRegion
	}

	protected def void indent(EObject it, extension IFormattableDocument document) {
		val Pair<ISemanticRegion, ISemanticRegion> pair = new Pair(previousSemanticRegion, nextSemanticRegion)
		pair.interior[indent]
	}

	protected def ISemanticRegion indent(ISemanticRegion it, extension IFormattableDocument document) {
		val Pair<ISemanticRegion, ISemanticRegion> pair = new Pair(it.previousSemanticRegion, it.nextSemanticRegion)
		pair.interior[indent]
		return it
	}

	protected def Pair<ISemanticRegion, ISemanticRegion> interior(EObject key, EObject value) {
		return new Pair(key.previousSemanticRegion, value.nextSemanticRegion)
	}
	

	protected def int getLengthOfFunctionSignature(FunctionDefinition it) {
		var int functionKeywordLength = 1
		if (regionFor.keyword("function") !== null) {
			functionKeywordLength = regionFor.keyword("function").length + 1
		} else if (regionFor.keyword("fallback") !== null) {
			functionKeywordLength = regionFor.keyword("fallback").length + 1
		} else if (regionFor.keyword("constructor") !== null) {
			functionKeywordLength = regionFor.keyword("constructor").length + 1
		} else if (regionFor.keyword("receive") !== null) {
			functionKeywordLength = regionFor.keyword("receive").length + 1
		}
		val int nameLength = !name.nullOrEmpty? name.length : 0
		var int parametersLength = 0
		for (parameter : parameters) {
			parametersLength += parameter.regionForEObject.length
		}
		var int modifiersLength = 0
		for (modi : modifier) {
			modifiersLength += modi.regionForEObject.length
		}
		var int returnParametersLength = 0
		for (returnParam : returnParameters) {
			returnParametersLength += returnParam.regionForEObject.length
		}
		return (functionKeywordLength + nameLength + parametersLength + modifiersLength + returnParametersLength)
	}
	
	protected def int getLengthOfFunctionSignature(AssemblyFunctionDefinition it) {
		var int functionKeywordLength = 1
		if (regionFor.keyword("function") !== null) {
			functionKeywordLength = regionFor.keyword("function").length + 1
		} else if (regionFor.keyword("fallback") !== null) {
			functionKeywordLength = regionFor.keyword("fallback").length + 1
		} else if (regionFor.keyword("constructor") !== null) {
			functionKeywordLength = regionFor.keyword("constructor").length + 1
		} else if (regionFor.keyword("receive") !== null) {
			functionKeywordLength = regionFor.keyword("receive").length + 1
		}
		val int nameLength = !name.nullOrEmpty ? name.length : 0
		var int parametersLength = 0
		for (parameter : parameters) {
			parametersLength += parameter.regionForEObject.length
		}
		var int returnParametersLength = 0
		for (returnParam : returnParameters) {
			returnParametersLength += returnParam.regionForEObject.length
		}
		return (functionKeywordLength + nameLength + parametersLength + returnParametersLength)
	}

	protected def int getLengthOfAssemblyExpression(FunctionalAssemblyExpression it) {
		var int labelLength = label.length

		var int parametersLength = 0 // + 2(for open/close brackets) - 2(the last parameter is not followed by comma and space)
		for (parameter : parameters) {
			parametersLength += parameter.regionForEObject.length
			parametersLength += 2 // for each comma+space after parameter
		}

		var sum = labelLength + parametersLength;
		return sum;
	}
}
