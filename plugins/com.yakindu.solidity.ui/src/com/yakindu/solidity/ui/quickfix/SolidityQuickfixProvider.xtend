package com.yakindu.solidity.ui.quickfix

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.yakindu.base.expressions.ui.quickfix.ExpressionsQuickfixProvider

class SolidityQuickfixProvider extends ExpressionsQuickfixProvider {

	@Fix("TODO")
	def capitalizeName(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, 'Make this function public', 'Public function.', null, new ISemanticModification(){
			override apply(EObject element, IModificationContext context) throws Exception {
//				val definition = element as FunctionDefinition
//				definition.modifier += FunctionModifier.PUBLIC 
//				println(element)
			}
			
		});
	}
}
