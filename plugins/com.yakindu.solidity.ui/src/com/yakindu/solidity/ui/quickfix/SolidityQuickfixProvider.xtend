package com.yakindu.solidity.ui.quickfix

import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.FunctionModifier
import com.yakindu.solidity.solidity.SolidityFactory
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.yakindu.base.expressions.ui.quickfix.ExpressionsQuickfixProvider
import org.yakindu.base.types.Operation
import com.yakindu.solidity.solidity.SourceUnit

class SolidityQuickfixProvider extends ExpressionsQuickfixProvider {

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
				if (element instanceof Operation) {
					// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
					val operation = element as Operation
					operation.name = "selfdestruct"
				}
			}
		})
	}

	@Fix("WARNING_VARIABLE_STORAGE_POINTER")
	def makeStoragePointerExplicit(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add payable to function', 'Add payable.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
				println("TODO: makeStoragePointerExplicit")
			}
		})

	}

	@Fix("WARNING_FUNCTION_UNUSED_PARAMETER")
	def removeUnusedFunctionParameter(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Removed unused parameter', 'Removed unused parameter.', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
					println("TODO: removeUnusedFunctionParameter")
				}
			})
	}

	@Fix("WARNING_LOCAL_VARIABLE_UNUSED")
	def removeUnusedLocalVariable(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Remove unused local variable', 'remove unused local variable', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
					println("TODO: removeUnusedLocalVariable")
				}
			})
	}

	@Fix("WARNING_MSG_VALUE_IN_NON_PAYABLE")
	def makeFunctionPayable(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Add payable to function', 'Add payable.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
				println("TODO: makeFunctionPayable")
			}
		})
	}

	@Fix("WARNING_DEPRECATED_THROW")
	def replaceDeprecatedThrow(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace with revert', 'revert(\'Something bad happened\').', null,
			new ISemanticModification() {
				override apply(EObject element, IModificationContext context) throws Exception {
					// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
					println("TODO: replaceDeprecatedCallcode -> revert")
				}
			})
		acceptor.accept(issue, 'Replace with assert', 'assert(condition)', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
				// TODO This is a little complicated since the surrounding if statement needes to be replaced as well
				println("TODO: replaceDeprecatedCallcode -> assert")
			}
		})
		acceptor.accept(issue, 'Replace with require', 'require(condition)', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
				// TODO This is a little complicated since the surrounding if statement needes to be replaced as well
				println("TODO: replaceDeprecatedCallcode -> require")
			}
		})
	}

	@Fix("WARNING_DEPRECATED_CALLCODE")
	def replaceDeprecatedCallcode(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace callcode with delegatecall', 'Add payable.', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// FIXME This gets never called since ResourceServiceProviderRegistryImpl#getServiceProvider(URI uri, String contentType) returns null
				println("TODO: replaceDeprecatedCallcode")
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

}
