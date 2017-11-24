package com.yakindu.solidity.ui.quickfix

import com.google.inject.Inject
import com.yakindu.solidity.solidity.Block
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.FunctionModifier
import com.yakindu.solidity.solidity.IfStatement
import com.yakindu.solidity.solidity.SolidityFactory
import com.yakindu.solidity.solidity.SourceUnit
import com.yakindu.solidity.solidity.ThrowStatement
import com.yakindu.solidity.solidity.TypeSpecifier
import com.yakindu.solidity.typesystem.BuildInDeclarations
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.ui.quickfix.ExpressionsQuickfixProvider

import static extension org.eclipse.xtext.EcoreUtil2.*

class SolidityQuickfixProvider extends ExpressionsQuickfixProvider {

	@Inject BuildInDeclarations declarations

	@Fix("WARNING_FUNCTION_VISIBILITY")
	def makeVisibilityExplicit(Issue issue, IssueResolutionAcceptor acceptor) {
		val modifier = SolidityFactory.eINSTANCE.createBuildInModifier
		acceptor.accept(issue, 'Make this function public', 'Public function.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof FunctionDefinition) {
					val definition = element as FunctionDefinition
					modifier.type = FunctionModifier.PUBLIC
					definition.modifier += modifier
				}
			}
		})

		acceptor.accept(issue, 'Make this function private', 'Private function.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof FunctionDefinition) {
					val definition = element as FunctionDefinition
					modifier.type = FunctionModifier.PRIVATE
					definition.modifier += modifier
				}
			}
		})

		acceptor.accept(issue, 'Make this function internal', 'Internal function.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof FunctionDefinition) {
					val definition = element as FunctionDefinition
					modifier.type = FunctionModifier.INTERNAL
					definition.modifier += modifier
				}
			}
		})
	}

	@Fix("WARNING_FILE_NO_PRAGMA_SOLIDITY")
	def addDefaultSolidityPragma(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add default solidity pragma', 'Add solidity pragma ^0.4.18.', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element.eContainer instanceof SourceUnit) {
						val sourceUnit = element.eContainer as SourceUnit
						val pragma = SolidityFactory.eINSTANCE.createPragmaDirective
						pragma.version = "^0.4.18"
						sourceUnit.pragma = pragma
					}
				}
			})
	}

	@Fix("WARNING_DEPRECATED_SUICIDE")
	def replaceDeprecatedSuicide(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace with selfdestruct', 'selfdestruct', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof ElementReferenceExpression) {
					element.reference = declarations.createSelfdestruct
				}
			}
		})
	}

	@Fix("WARNING_VARIABLE_STORAGE_POINTER")
	def makeStoragePointerExplicit(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add explicit storage keyword', 'storage.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
				println("TODO: makeStoragePointerExplicit")
			}
		})

		acceptor.accept(issue, 'Add explicit memory keyword', 'memory.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
				println("TODO: makeStoragePointerExplicit")
			}
		})

	}

	@Fix("WARNING_FUNCTION_UNUSED_PARAMETER")
	def removeUnusedFunctionParameter(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Removed unused parameter declaration', 'Removed unused parameter declaration.', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof TypeSpecifier) {
						var parameter = element.eContainer
						var function = element.eContainer.eContainer as FunctionDefinition
						function.parameters.remove(parameter)
					}
				}
			})
	}

	@Fix("WARNING_LOCAL_VARIABLE_UNUSED")
	def removeUnusedLocalVariable(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove unused local variable', 'remove unused local variable', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof TypeSpecifier) {
						var definition = element.eContainer
						var block = element.eContainer.eContainer as Block;
						block.statements.remove(definition)
					}
				}
			})
	}

	@Fix("WARNING_MSG_VALUE_IN_NON_PAYABLE")
	def makeFunctionPayable(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add payable to function', 'Add payable.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof ElementReferenceExpression) {
					val modifier = SolidityFactory.eINSTANCE.createBuildInModifier
					modifier.type = FunctionModifier.PAYABLE
					val functionDefinition = element.getContainerOfType(FunctionDefinition)
					}
			}

		})
	}

	@Fix("WARNING_DEPRECATED_THROW")
	def replaceDeprecatedThrow(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace with revert', 'revert(\'Something bad happened\').', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					if (element instanceof ThrowStatement) {
						val block = element.getContainerOfType(Block)
						block.statements.remove(element)
						block.statements += SolidityFactory.eINSTANCE.createExpressionStatement => [
							expression = ExpressionsFactory.eINSTANCE.createElementReferenceExpression => [
								val revert = declarations.createRevert
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
							SolidityFactory.eINSTANCE.createExpressionStatement => [
								expression = ExpressionsFactory.eINSTANCE.createElementReferenceExpression => [
									reference = declarations.builtin_assert
									arguments += ExpressionsFactory.eINSTANCE.createArgument => [
										value = condition
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
							SolidityFactory.eINSTANCE.createExpressionStatement => [
								expression = ExpressionsFactory.eINSTANCE.createElementReferenceExpression => [
									reference = declarations.createRequire
									arguments += ExpressionsFactory.eINSTANCE.createArgument => [
										value = condition
									]
								]
							]
						)
					}
				}
			}
		})
	}

	@Fix("WARNING_DEPRECATED_CALLCODE")
	def replaceDeprecatedCallcode(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace callcode with delegatecall', 'Add payable.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof ElementReferenceExpression) {
					print(element);
				}
			}
		})
	}

	@Fix("WARNING_DEPRECATED_UNARY")
	def replaceDeprecatedUnaryExpression(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace unary expression', 'x++ to x=x+1.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
				println("TODO: replaceDeprecatedUnaryExpression")
			}
		})
	}

	@Fix("WARNING_DEPRECATED_SHA3")
	def replaceDeprecatedSha3(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace Sha3 with keccak256', 'keccak256(...) returns (bytes32).', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
					println("TODO: replaceDeprecatedSha3")
				}
			})
	}

	@Fix("WARNING_DEPRECATED_NAMED_FUNCTION_PARAMETER")
	def replaceDeprecatedNamedFunctionParameter(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove parameter name', 'remove parameter name', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
				println("TODO: replaceDeprecatedNamedFunctionParameter")
			}
		})
	}

	@Fix("WARNING_DEPRECATED_NAMED_FUNCTION_RETURN_VALUES")
	def replaceDeprecatedNamedFunctionReturnValues(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove named return values', 'remove named return values', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
					println("TODO: replaceDeprecatedNamedFunctionReturnValues")
				}
			})
	}

	@Fix("WARNING_AMBIGUES_TYPE_INFERRENCE")
	def replaceVarWithSpecificType(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Infer runtime type', 'var a = 5; -> int a = 5', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
				println("TODO: replaceVarWithSpecificType")
			}
		})
	}

	@Fix("WARNING_USSAGE_OF_SEND")
	def replaceSendWithTransfer(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace send with transfer', 'address.send(amount); -> address.transfer(amount);', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
					println("TODO: replaceSendWithTransfer")
				}
			})
	}

	@Fix("WARNING_FUNCTION_STATE_MUTABILITY_VIEW")
	def addViewModifier(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add \'view\' modifier', 'view function', null, new ISemanticModification() {
			val modifier = SolidityFactory.eINSTANCE.createBuildInModifier

			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof FunctionDefinition) {
					val definition = element as FunctionDefinition
					modifier.type = FunctionModifier.VIEW
					definition.modifier += modifier
				}
			}
		})
	}

}
