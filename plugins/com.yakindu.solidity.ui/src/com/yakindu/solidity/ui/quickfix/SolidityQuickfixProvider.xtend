package com.yakindu.solidity.ui.quickfix

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.yakindu.base.expressions.ui.quickfix.ExpressionsQuickfixProvider
import com.yakindu.solidity.solidity.SolidityFactory
import com.yakindu.solidity.solidity.FunctionModifier
import com.yakindu.solidity.solidity.FunctionDefinition
import org.yakindu.base.types.Operation

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

	@Fix("WARNING_DEPRECATED_SUICIDE")
	def replaceDeprecatedSuicide(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace with selfdestruct', 'selfdestruct', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				if (element instanceof Operation) {
					val operation = element as Operation
					if(operation.name == "suicide"){
						val container = operation.eContainer;
						
					}
				}
			}
		})
	}

	@Fix("WARNING_VARIABLE_STORAGE_POINTER")
	def makeStoragePointerExplicit(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace with selfdestruct', 'Selfdestruct', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// TODO
				println("TODO: makeStoragePointerExplicit")
			}
		})

	}

	@Fix("WARNING_FUNCTION_UNUSED_PARAMETER")
	def removeUnusedFunctionParameter(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Replace with selfdestruct', 'Selfdestruct', null, new ISemanticModification() {
			override apply(EObject element, IModificationContext context) throws Exception {
				// TODO
				println("TODO: removeUnusedFunctionParameter")
			}
		})
	}

	@Fix("WARNING_LOCAL_VARIABLE_UNUSED")
	def removeUnusedLocalVariable(Issue issue, IssueResolutionAcceptor acceptor) {
		// TODO
		println("TODO: removeUnusedLocalVariable")
	}

	@Fix("WARNING_MSG_VALUE_IN_NON_PAYABLE")
	def makeFunctionPayable(Issue issue, IssueResolutionAcceptor acceptor) {
		// TODO
		println("TODO: makeFunctionPayable")
	}

	@Fix("WARNING_DEPRECATED_CALLCODE")
	def replaceDeprecatedCallcode(Issue issue, IssueResolutionAcceptor acceptor) {
		// TODO
		println("TODO: replaceDeprecatedCallcode")
	}

	@Fix("WARNING_DEPRECATED_THROW")
	def replaceDeprecatedThrow(Issue issue, IssueResolutionAcceptor acceptor) {
		// TODO
		println("TODO: replaceDeprecatedThrow")
	}

	@Fix("WARNING_DEPRECATED_UNARY")
	def replaceDeprecatedUnaryExpression(Issue issue, IssueResolutionAcceptor acceptor) {
		// TODO
		println("TODO: replaceDeprecatedUnaryExpression")
	}

	@Fix("WARNING_DEPRECATED_SHA3")
	def replaceDeprecatedSha3(Issue issue, IssueResolutionAcceptor acceptor) {
		// TODO
		println("TODO: replaceDeprecatedSha3")
	}

	@Fix("WARNING_DEPRECATED_NAMED_FUNCTION_PARAMETER")
	def replaceDeprecatedNamedFunctionParameter(Issue issue, IssueResolutionAcceptor acceptor) {
		// TODO
		println("TODO: replaceDeprecatedNamedFunctionParameter")
	}

	@Fix("WARNING_DEPRECATED_NAMED_FUNCTION_RETURN_VALUES")
	def replaceDeprecatedNamedFunctionReturnValues(Issue issue, IssueResolutionAcceptor acceptor) {
		// TODO
		println("TODO: replaceDeprecatedNamedFunctionReturnValues")
	}

	@Fix("WARNING_AMBIGUES_TYPE_INFERRENCE")
	def replaceVarWithSpecificType(Issue issue, IssueResolutionAcceptor acceptor) {
		// TODO
		println("TODO: replaceVarWithSpecificType")
	}

	@Fix("WARNING_USSAGE_OF_SEND")
	def replaceSendWithTransfer(Issue issue, IssueResolutionAcceptor acceptor) {
		// TODO
		println("TODO: replaceSendWithTransfer")
	}

}
