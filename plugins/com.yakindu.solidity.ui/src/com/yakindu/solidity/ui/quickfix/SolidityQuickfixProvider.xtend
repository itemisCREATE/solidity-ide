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
package com.yakindu.solidity.ui.quickfix

import com.google.inject.Inject
import com.yakindu.solidity.SolidityVersion
import com.yakindu.solidity.solidity.ArrayTypeSpecifier
import com.yakindu.solidity.solidity.Block
import com.yakindu.solidity.solidity.BuildInModifier
import com.yakindu.solidity.solidity.ConstructorDefinition
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.ContractType
import com.yakindu.solidity.solidity.DecimalNumberLiteral
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.FunctionModifier
import com.yakindu.solidity.solidity.IfStatement
import com.yakindu.solidity.solidity.MappingTypeSpecifier
import com.yakindu.solidity.solidity.Modifier
import com.yakindu.solidity.solidity.Parameter
import com.yakindu.solidity.solidity.PragmaSolidityDirective
import com.yakindu.solidity.solidity.SolidityFactory
import com.yakindu.solidity.solidity.SourceUnit
import com.yakindu.solidity.solidity.StorageLocation
import com.yakindu.solidity.solidity.ThrowStatement
import com.yakindu.solidity.solidity.TypeSpecifier
import com.yakindu.solidity.solidity.Unit
import com.yakindu.solidity.solidity.VariableDefinition
import com.yakindu.solidity.typesystem.SolidityTypeSystem
import com.yakindu.solidity.typesystem.builtin.BuiltInDeclarations
import java.math.BigDecimal
import javax.inject.Named
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.Fixes
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.ui.quickfix.ExpressionsQuickfixProvider
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.inferrer.ITypeSystemInferrer

import static com.yakindu.solidity.validation.IssueCodes.*

import static extension org.eclipse.xtext.EcoreUtil2.*

/** 
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 * @author Karsten Thoms
 */
class SolidityQuickfixProvider extends ExpressionsQuickfixProvider {

	@Inject BuiltInDeclarations declarations
	@Inject extension SolidityFactory
	@Inject ITypeSystemInferrer typeInferrer
	@Inject @Named(SolidityVersion.SOLIDITY_VERSION) String solcVersion
	ExpressionsFactory factory = ExpressionsFactory.eINSTANCE

	@Fix(WARNING_SOLIDITY_VERSION_NOT_THE_DEFAULT)
	def changeToDefaultPragma(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, '''Change version to «solcVersion»''', 'solidity version', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof PragmaSolidityDirective) {
						element.version = solcVersion
					}
				}
			})
	}

	@Fix(ERROR_STATE_MUTABILITY_ONLY_ALLOWED_FOR_ADDRESS)
	def removePayableToNonAddressDeclaration(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, '''Remove payable declaration''', '''Remove payable declaration''', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof Parameter) {
						val param = (element as Parameter)
						val document = context.xtextDocument
						val node = NodeModelUtils.getNode(param)
						val fixed = document.get(node.offset, node.length).replace("payable", "")
						document.replace(node.offset, node.length, fixed)
					}
				}
			})
	}

	@Fixes(@Fix(ERROR_MEMBER_TRANSFER_NOT_FOUND_OR_VISIBLE),
	@Fix(ERROR_INVALID_IMPLICID_CONVERSION_TO_ADDRESS_PAYABLE))
	def addPayableToAddressDeclaration(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add payable to declaration', 'Add payable to declaration', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof ElementReferenceExpression) {
						if (element.reference instanceof Parameter) {
							val typeSpecifier = (element.reference as Parameter).typeSpecifier
							if (typeSpecifier.type.name === SolidityTypeSystem.ADDRESS) {
								val document = context.xtextDocument
								val node = NodeModelUtils.getNode(typeSpecifier)
								val fixed = document.get(node.offset, node.length) + ''' payable'''
								document.replace(node.offset, node.length, fixed)
							}
						}
						if (element.reference instanceof VariableDefinition) {
							val typeSpecifier = (element.reference as VariableDefinition).typeSpecifier
							if (typeSpecifier.type.name === SolidityTypeSystem.ADDRESS) {
								val document = context.xtextDocument
								val node = NodeModelUtils.getNode(typeSpecifier)
								val fixed = document.get(node.offset, node.length) + ''' payable'''
								document.replace(node.offset, node.length, fixed)
							}
						}
					}
				}
			})
	}

	@Fix(ERROR_INTERFACE_FUNCTIONS_CAN_NOT_HAVE_MODIFIERS)
	def removeDisallowedModifiers(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			'Remove all disallowed modifiers.',
			'Remove all disallowed modifiers.',
			null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof FunctionDefinition) {
						element.modifier.filter[!(it instanceof BuildInModifier)].toList.forEach [
							element.modifier.remove(it)
						]
					}
				}
			}
		)
	}

	@Fix(ERROR_DATA_LOCATION_MUST_BE_CALLDATA_FOR_EXTERNAL_PARAMETER)
	def changeStorageModifierToCalldata(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			'Add \'calldata\' modifier.',
			'Data location must be \"calldata\" for parameter in external function.',
			null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof ArrayTypeSpecifier || element instanceof MappingTypeSpecifier) {
					}
				}
			}
		)
	}

	@Fixes(@Fix(ERROR_DATA_LOCATION_MUST_BE_MEMORY_FOR_PARAMETER),		
	@Fix(ERROR_DATA_LOCATION_MUST_BE_MEMORY_FOR_RETURN_PARAMETER))
	def changeStorageModifierToMemory(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			'Add \'memory\' modifier.',
			'Data location must be "memory" here. Add \'memory\' modifier.',
			null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof TypeSpecifier) {
						(element.eContainer as Parameter).fixDeclaration(StorageLocation.MEMORY, issue, context)
					}
				}
			}
		)
	}

	@Fix(ERROR_DATALOCATION_MUST_BE_STORAGE)
	def changeStorageModifierToStorage(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			'Add \'storage\' modifier.',
			'Data location must be "storage" here. Add \'storage\' modifier.',
			null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof TypeSpecifier || element instanceof MappingTypeSpecifier) {
						element.eContainer.fixDeclaration(StorageLocation.STORAGE, issue, context)
					}
				}
			}
		)
	}

	@Fixes(@Fix(ERROR_DATA_LOCATION_MUST_BE_STORAGE_OR_MEMORY_FOR_PARAMETER),
	@Fix(ERROR_DATA_LOCATION_MUST_BE_MEMORY_OR_STORAGE_FOR_RETURN_PARAMETER))
	def addStorageModifierStorageOrMemoryForParameter(Issue issue, IssueResolutionAcceptor acceptor) {
		changeStorageModifierToMemory(issue, acceptor)
		changeStorageModifierToStorage(issue, acceptor)
	}

	@Fixes(@Fix(ERROR_DATA_LOCATION_MUST_BE_SPECIFIED_FOR_VARIABLE))
	def addStorageModifierSorageOrMemoryForVariable(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add \'memory\' modifier.', 'Add \'memory\' modifier.', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof ArrayTypeSpecifier || element instanceof MappingTypeSpecifier) {
						element.eContainer.fixDeclaration(StorageLocation.MEMORY, issue, context)
					}
				}
			})
		acceptor.accept(issue, 'Add \'storage\' modifier.', 'Add \'storage\' modifier.', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof ArrayTypeSpecifier || element instanceof MappingTypeSpecifier) {
						// TODO FIXME: This is only valid IF there is no initial value, or the 'return type' of the initial value has the same storage modifier e.g. in the case of a function call. 
						element.eContainer.fixDeclaration(StorageLocation.STORAGE, issue, context)
					}
				}
			})
	}

	def dispatch fixDeclaration(VariableDefinition definition, StorageLocation location, Issue issue,
		IModificationContext context) {
		if (definition.storage != location) {
			definition.storage = location
		} else {
			context.getXtextDocument().fixNamedDeclaration(definition.name, location, issue, context)
		}
	}

	def dispatch fixDeclaration(Parameter param, StorageLocation location, Issue issue, IModificationContext context) {
		if (param.storage != location) {
			param.storage = location
		} else {
			context.getXtextDocument().fixNamedDeclaration(param.name, location, issue, context)
		}
	}

	def void fixNamedDeclaration(IXtextDocument document, String name, StorageLocation location, Issue issue,
		IModificationContext context) {
		if (name === null) {
			val fixed = document.get(issue.offset, issue.length) + " " + location.literal
			document.replace(issue.offset, issue.length, fixed)
		} else {
			val issueString = document.get(issue.offset, issue.length)
			val index = document.get(issue.offset, issue.length).lastIndexOf(name)
			val fixed = issueString.substring(0, index) + location.literal + " " + name;
			document.replace(issue.offset, issue.length, fixed)
		}
	}

	/**
	 * FROM THE COMPILER
	 */
	@Fix(ERROR_VAR_KEYWORD_DISALLOWED)
	def replaceVarKeyword(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Inferr type information', 'Inferr type information', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof VariableDefinition) {
					val definition = element as VariableDefinition
					val inferredType = typeInferrer.infer(definition).type
					val block = definition.eContainer as Block
					val index = block.statements.indexOf(definition)
					block.statements.remove(definition)
					block.statements.add(index, createVariableDefinition => [
						var identifier = definition.identifier.identifier
						if (identifier.size == 1) {
							name = identifier.get(0).name
						} else {
							// FIXME this relates to #230 tuple expressions have multiple identifiers
							name = "x"
						}
						visibility = definition.visibility
						initialValue = definition.initialValue
						storage = definition.storage
						typeSpecifier = createTypeSpecifier => [
							type = inferredType
						]
					])
				}
			}
		})
	}

	def changeFunctionModifierTo(Modifier modifierToChange, FunctionModifier modifier) {
		val function = modifierToChange.eContainer as FunctionDefinition
		val index = function.modifier.indexOf(modifierToChange);
		function.modifier.remove(index)
		function.modifier.add(index, createBuildInModifier => [
			type = modifier
		])
	}

	@Fix(ERROR_YEARS_IS_DISALLOWED)
	def replaceYearsUnit(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Change years unit denomination to days', 'Change years unit denomination to days', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof DecimalNumberLiteral) {
						element.unit = Unit.DAYS
						element.value = element.value.multiply(new BigDecimal(365))
					}
				}
			})
	}

	@Fix(ERROR_FUNCTION_DECLARED_AS_PURE_BUT_MUST_BE_VIEW)
	def declareFunctionAsView(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Use "view" instead.', 'Use "view" instead.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				val functionDefinition = EcoreUtil2.getContainerOfType(element, FunctionDefinition)
				val pure = functionDefinition.modifier.findFirst [
					it instanceof BuildInModifier && (it as BuildInModifier).type === FunctionModifier.PURE
				]
				pure?.changeFunctionModifierTo(FunctionModifier.VIEW)
			}
		})
	}

	@Fix(ERROR_FUNCTION_DECLARED_AS_VIEW_BUT_MUST_BE_PAYABLE_OR_NON_PAYABLE)
	def declareFunctionAsPayableOrNonPayable(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Change to "payable".', 'Change to "payable".', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				val functionDefinition = EcoreUtil2.getContainerOfType(element, FunctionDefinition)
				val view = functionDefinition.modifier.findFirst [
					it instanceof BuildInModifier && (it as BuildInModifier).type === FunctionModifier.VIEW
				]
				view?.changeFunctionModifierTo(FunctionModifier.PAYABLE)
			}
		})
		acceptor.accept(issue, 'Remove \"view\" and make function non-payable.',
			'Remove \"view\" and make function non-payable.', null, new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					val functionDefinition = EcoreUtil2.getContainerOfType(element, FunctionDefinition)
					val view = functionDefinition.modifier.findFirst [
						it instanceof BuildInModifier && (it as BuildInModifier).type === FunctionModifier.VIEW
					]
					if (view !== null) {
						functionDefinition.modifier.remove(view);
					}
				}
			})
	}

	@Fix(ERROR_CONSTANT_MODIFIER_WAS_REMOVED)
	def replaceConstantModifier(Issue issue, IssueResolutionAcceptor acceptor) {
		declareFunctionAsView(issue, acceptor)
		acceptor.accept(issue, 'Use "pure" instead.', 'Use "pure" instead.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof BuildInModifier) {
					element.changeFunctionModifierTo(FunctionModifier.VIEW)
				}
			}
		})
	}

	@Fixes(@Fix(WARNING_DEPRECATED_FUNCTION_CONSTRUCTOR),
	@Fix(ERROR_FUNCTION_NAME_EQUALS_CONTRACT_NAME_DISALLOWED))
	def useConstructorKeywordInsteadOfFunction(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Use constructor keyword instead', 'contructor keyword', null,
			new ISemanticModification() {

				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof FunctionDefinition) {
						val definition = element as FunctionDefinition
						val contract = definition.eContainer as ContractDefinition
						val index = contract.features.indexOf(definition);
						contract.features.remove(definition);
						contract.features.add(index, createConstructorDefinition => [
							block = definition.block
							parameters += definition.parameters
							modifier += definition.modifier
						])
					}
				}
			})
	}

	@Fixes(@Fix(WARNING_FUNCTION_VISIBILITY),
	@Fix(ERROR_NO_VISIBILITY_SPECIFIED))
	def makeVisibilityExplicit(Issue issue, IssueResolutionAcceptor acceptor) {
		val operation = (new ResourceSetImpl().getEObject(issue.uriToProblem, true) as Operation);
		val contract = (operation.eContainer as ContractDefinition)
		if (contract.type != ContractType.INTERFACE && !operation.name.nullOrEmpty) {
			if (!(operation instanceof ConstructorDefinition)) {

				acceptor.accept(issue, 'Make this function private', 'Private function.', null,
					new ISemanticModification() {
						override apply(EObject element, IModificationContext context) throws Exception {
							element.fixVisibility(createBuildInModifier => [
								type = FunctionModifier.PRIVATE
							])
						}
					})
			}
			acceptor.accept(issue, 'Make this function \'public\'', 'Public function.', null,
				new ISemanticModification() {
					override apply(EObject element, IModificationContext context) throws Exception {
						element.fixVisibility(createBuildInModifier => [
							type = FunctionModifier.PUBLIC

						])
					}

				})
			acceptor.accept(issue, 'Make this function \'internal\'', 'Internal function.', null,
				new ISemanticModification() {
					override apply(EObject element, IModificationContext context) throws Exception {
						element.fixVisibility(createBuildInModifier => [
							type = FunctionModifier.INTERNAL
						])
					}
				})
		}

		acceptor.accept(issue, 'Make this function \'external\'', 'External function.', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					element.fixVisibility(createBuildInModifier => [
						type = FunctionModifier.EXTERNAL
					])
				}
			})
	}

	def dispatch fixVisibility(EObject element, BuildInModifier modifier) {
	}

	def dispatch fixVisibility(FunctionDefinition function, BuildInModifier modifier) {
		function.modifier += modifier
	}

	def dispatch fixVisibility(ConstructorDefinition constructor, BuildInModifier modifier) {
		constructor.modifier += modifier
	}

	@Fix(WARNING_FILE_NO_PRAGMA_SOLIDITY)
	def addDefaultSolidityPragma(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add default solidity pragma', 'Add solidity pragma ^' + solcVersion + '.', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element.eContainer instanceof SourceUnit) {
						val sourceUnit = element.eContainer as SourceUnit
						val pragma = createPragmaSolidityDirective => [
						version = solcVersion
						]
						sourceUnit.pragma += pragma
					}
				}
			})
	}

	@Fixes(@Fix(WARNING_DEPRECATED_SUICIDE),
		@Fix(ERROR_DEPRECATED_SUICIDE))
	def replaceDeprecatedSuicide(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace with selfdestruct', 'selfdestruct', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof ElementReferenceExpression) {
					element.reference = declarations.selfdestruct
				}
			}
		})
	}

	@Fix(WARNING_VARIABLE_STORAGE_POINTER)
	def makeStoragePointerExplicit(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add explicit storage keyword', 'storage.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				var definition = element.getContainerOfType(VariableDefinition)
				definition.storage = StorageLocation.STORAGE;
			}
		})

		acceptor.accept(issue, 'Add explicit memory keyword', 'memory.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				var definition = element.getContainerOfType(VariableDefinition)
				definition.storage = StorageLocation.MEMORY;

			}
		})

	}

	@Fix(WARNING_FUNCTION_UNUSED_PARAMETER)
	def removeUnusedFunctionParameter(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Removed unused parameter declaration', 'Removed unused parameter declaration.', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof TypeSpecifier) {
						var parameter = element.getContainerOfType(Parameter)
						var function = element.getContainerOfType(Operation)
						if (!function.parameters.remove(parameter)) {
							parameter.name = null
						}
					}
				}
			})
	}

	@Fix(WARNING_LOCAL_VARIABLE_UNUSED)
	def removeUnusedLocalVariable(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove unused local variable', 'remove unused local variable', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof TypeSpecifier) {
						var definition = element.getContainerOfType(VariableDefinition)
						var block = element.getContainerOfType(Block)
						block.statements.remove(definition)
					}
				}
			})
	}

	@Fixes(@Fix(WARNING_MSG_VALUE_IN_NON_PAYABLE), 
		@Fix(ERROR_MSG_VALUE_ONLY_ALLOWED_IN_PAYABLE))
	def makeFunctionPayable(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add payable to function', 'Add payable.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof ElementReferenceExpression) {
					val functionDefinition = element.getContainerOfType(FunctionDefinition)
					val functionModifiers = functionDefinition.modifier
					functionModifiers.filter [
						it instanceof BuildInModifier && (
							(it as BuildInModifier).type == FunctionModifier.CONSTANT ||
							(it as BuildInModifier).type == FunctionModifier.PURE ||
							(it as BuildInModifier).type == FunctionModifier.VIEW ||
							(it as BuildInModifier).type == FunctionModifier.INTERNAL ||
							(it as BuildInModifier).type == FunctionModifier.PRIVATE 
						)
					].filterNull.forEach[incompatible|functionDefinition.modifier.remove(incompatible)]
					functionDefinition.modifier += createBuildInModifier => [
						type = FunctionModifier.PAYABLE
					]
				}
			}

		})
	}

	@Fixes(@Fix(WARNING_DEPRECATED_THROW),
	@Fix(ERROR_THROW_KEYWORD_DISALLOWED))
	def replaceDeprecatedThrow(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			'Replace with revert',
			'revert(\'Something bad happened\').',
			null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof ThrowStatement) {
						val block = element.getContainerOfType(Block)
						val index = block.statements.indexOf(element)
						block.statements.remove(element)
						block.statements.add(index, createExpressionStatement => [
							expression = factory.createElementReferenceExpression => [
								operationCall = true
								reference = declarations.revert
								arguments += createSimpleArgument => [
									value = createPrimitiveValueExpression => [
										value = factory.createStringLiteral => [
											value = "Something bad happened"
										]
									]
								]
							]
						])
					}
				}
			}
		)

		acceptor.accept(issue, 'Replace with assert', 'assert(condition)', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof ThrowStatement) {
					val ifStatement = element.getContainerOfType(IfStatement)
					if (ifStatement !== null) {
						val condition = ifStatement.condition
						val thenBlock = ifStatement.then as Block
						val elseBlock = ifStatement.^else as Block
						// only fix this if the throw statement is the only statement in the if clause
						if (thenBlock.statements.size == 1 && elseBlock === null) {
							val containingBlock = ifStatement.eContainer as Block
							val index = containingBlock.statements.indexOf(ifStatement);
							containingBlock.statements.remove(ifStatement)
							containingBlock.statements.add(
								index,
								createExpressionStatement => [
									expression = factory.createElementReferenceExpression => [
										operationCall = true
										reference = declarations.assert_
										arguments += createSimpleArgument => [
											value = condition
										]
									]
								]
							)
						}
					}
				}
			}
		})

		acceptor.accept(issue, 'Replace with require', 'require(condition, \'Precondition are not met\')', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof ThrowStatement) {
						val ifStatement = element.getContainerOfType(IfStatement)
						if (ifStatement !== null) {
							val condition = ifStatement.condition
							val thenBlock = ifStatement.then as Block
							val elseBlock = ifStatement.^else as Block
							// only fix this if the throw statement is the only statement in the if clause
							if (thenBlock.statements.size == 1 && elseBlock === null) {
								val containingBlock = ifStatement.eContainer as Block
								val index = containingBlock.statements.indexOf(ifStatement);
								containingBlock.statements.remove(ifStatement)
								containingBlock.statements.add(
									index,
									createExpressionStatement => [
										expression = factory.createElementReferenceExpression => [
											operationCall = true
											reference = declarations.require
											arguments += createSimpleArgument => [
												value = condition
											]
											arguments += createSimpleArgument => [
												value = createPrimitiveValueExpression => [
													value = factory.createStringLiteral => [
														value = "Preconditions are not satisfied"
													]
												]
											]
										]
									]
								)
							}
						}
					}
				}
			})
	}

	@Fix(WARNING_DEPRECATED_CALLCODE)
	def replaceDeprecatedCallcode(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace callcode with delegatecall', 'Add payable.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof ElementReferenceExpression) {
					val featureCall = element.getContainerOfType(FeatureCall)
					val features = featureCall.feature.getContainerOfType(ComplexType).features
					featureCall.feature = features.findFirst[name == SolidityTypeSystem.DELEGATECALL]
				}
			}
		})
	}

	@Fixes(@Fix(ERROR_DEPRECATED_SHA3),	
	@Fix(WARNING_DEPRECATED_SHA3))
	def replaceDeprecatedSha3(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace Sha3 with keccak256', 'keccak256(...) returns (bytes32).', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof ElementReferenceExpression) {
						element.reference = declarations.keccak256
					}
				}
			})
	}

// TODO: This is not possible due to a missing feature in our solidity language
//	@Fix(WARNING_DEPRECATED_NAMED_FUNCTION_RETURN_VALUES)
//	def replaceDeprecatedNamedFunctionReturnValues(Issue issue, IssueResolutionAcceptor acceptor) {
//		acceptor.accept(issue, 'Remove named return values', 'remove named return values', null,
//			new ISemanticModification() {
//				override apply(EObject element, IModificationContext context) throws Exception {
//				}
//			})
//	}
	@Fix(WARNING_USSAGE_OF_SEND)
	def replaceSendWithTransfer(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace send with transfer', 'address.send(amount); -> address.transfer(amount);', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof ElementReferenceExpression) {
						val featureCall = element.getContainerOfType(FeatureCall)
						val features = featureCall.feature.getContainerOfType(ComplexType).features
						featureCall.feature = features.findFirst[name == SolidityTypeSystem.TRANSFER]
					}
				}
			})
	}

	@Fix(WARNING_FUNCTION_STATE_MUTABILITY_VIEW)
	def addViewModifier(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add \'view\' modifier', 'view function', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof FunctionDefinition) {
					val definition = element as FunctionDefinition
					definition.modifier += createBuildInModifier => [
						type = FunctionModifier.VIEW
					]
				}
			}
		})
	}

	@Fix(WARNING_FUNCTION_STATE_MUTABILITY_PURE)
	def declareFunctionAsPure(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Use "pure" instead.', 'Use "pure" instead.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof FunctionDefinition) {
					val definition = element as FunctionDefinition
					// Constant & pure exclude each other
					val constant = definition.modifier.findFirst [ it |
						it instanceof BuildInModifier && (it as BuildInModifier).type == FunctionModifier.VIEW
					]
					constant?.changeFunctionModifierTo(FunctionModifier.PURE)
				}
			}
		})
	}
}
