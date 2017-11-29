package com.yakindu.solidity.ui.quickfix

import com.google.inject.Inject
import com.yakindu.solidity.SolidityRuntimeModule
import com.yakindu.solidity.solidity.Block
import com.yakindu.solidity.solidity.BuildInModifier
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.FunctionModifier
import com.yakindu.solidity.solidity.IfStatement
import com.yakindu.solidity.solidity.Parameter
import com.yakindu.solidity.solidity.SolidityFactory
import com.yakindu.solidity.solidity.SourceUnit
import com.yakindu.solidity.solidity.StorageLocation
import com.yakindu.solidity.solidity.ThrowStatement
import com.yakindu.solidity.solidity.TypeSpecifier
import com.yakindu.solidity.solidity.VariableDefinition
import com.yakindu.solidity.typesystem.BuildInDeclarations
import com.yakindu.solidity.typesystem.SolidityTypeSystem
import javax.inject.Named
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.ui.quickfix.ExpressionsQuickfixProvider
import org.yakindu.base.types.ComplexType

import static com.yakindu.solidity.validation.IssueCodes.*

import static extension org.eclipse.xtext.EcoreUtil2.*

class SolidityQuickfixProvider extends ExpressionsQuickfixProvider {

	@Inject BuildInDeclarations declarations
	@Inject extension SolidityFactory
	@Inject @Named(SolidityRuntimeModule.SOLIDITY_VERSION) String solcVersion
	
	extension ExpressionsFactory factory = ExpressionsFactory.eINSTANCE

	@Fix(WARNING_FUNCTION_VISIBILITY)
	def makeVisibilityExplicit(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Make this function public', 'Public function.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof FunctionDefinition) {
					val definition = element as FunctionDefinition
					definition.modifier += createBuildInModifier => [
						type = FunctionModifier.PUBLIC

					]
				}
			}
		})

		acceptor.accept(issue, 'Make this function private', 'Private function.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof FunctionDefinition) {
					val definition = element as FunctionDefinition
					definition.modifier += createBuildInModifier => [
						type = FunctionModifier.PRIVATE
					]
				}
			}
		})

		acceptor.accept(issue, 'Make this function internal', 'Internal function.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof FunctionDefinition) {
					val definition = element as FunctionDefinition
					definition.modifier += createBuildInModifier => [
						type = FunctionModifier.INTERNAL
					]
				}
			}
		})
	}

	@Fix(WARNING_FILE_NO_PRAGMA_SOLIDITY)
	def addDefaultSolidityPragma(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add default solidity pragma', 'Add solidity pragma ^'+solcVersion+'.', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element.eContainer instanceof SourceUnit) {
						val sourceUnit = element.eContainer as SourceUnit
						val pragma = createPragmaDirective
						pragma.version = "^"+solcVersion
						sourceUnit.pragma = pragma
					}
				}
			})
	}

	@Fix(WARNING_DEPRECATED_SUICIDE)
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
						var function = element.getContainerOfType(FunctionDefinition)
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

	@Fix(WARNING_MSG_VALUE_IN_NON_PAYABLE)
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

	@Fix(WARNING_DEPRECATED_THROW)
	def replaceDeprecatedThrow(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace with revert', 'revert(\'Something bad happened\').', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof ThrowStatement) {
						val block = element.getContainerOfType(Block)
						block.statements.remove(element)
						block.statements += createExpressionStatement => [
							expression = createElementReferenceExpression => [
								val revert = declarations.revert
								operationCall = true
								reference = revert
							]
						]
					}
				}
			})

		acceptor.accept(issue, 'Replace with assert', 'assert(condition)', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof ThrowStatement) {
					val ifStatement = element.getContainerOfType(IfStatement)
					if (ifStatement !== null) {
						val condition = ifStatement.condition
						val block = ifStatement.eContainer as Block
						block.statements.set(
							block.statements.indexOf(ifStatement),
							createExpressionStatement => [
								expression = createElementReferenceExpression => [
									reference = declarations.assert_
									operationCall = true
									arguments += ExpressionsFactory.eINSTANCE.createArgument => [
										value = createLogicalNotExpression => [
											operand = createParenthesizedExpression => [
												expression = condition

											]
										]
									]
								]
							]
						)
					}
				}
			}
		})

		acceptor.accept(issue, 'Replace with require', 'require(condition)', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof ThrowStatement) {
					val ifStatement = element.getContainerOfType(IfStatement)
					if (ifStatement !== null) {
						val condition = ifStatement.condition
						val block = ifStatement.eContainer as Block
						block.statements.set(
							block.statements.indexOf(ifStatement),
							createExpressionStatement => [
								expression = createElementReferenceExpression => [
									reference = declarations.require
									operationCall = true
									arguments += ExpressionsFactory.eINSTANCE.createArgument => [
										value = createLogicalNotExpression => [
											operand = createParenthesizedExpression => [
												expression = condition

											]
										]
									]
								]
							]
						)
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

	@Fix(WARNING_DEPRECATED_SHA3)
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
	def addPureModifier(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add \'pure\' modifier', 'pure function', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof FunctionDefinition) {
					val definition = element as FunctionDefinition
					definition.modifier += createBuildInModifier => [
						type = FunctionModifier.PURE
					]
				}
			}
		})
	}
}
