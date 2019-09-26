package com.yakindu.sct.domain.solidity.scoping

import org.yakindu.sct.model.stext.scoping.STextScopeProvider
import com.google.inject.Inject
import com.yakindu.solidity.typesystem.builtin.BuiltInDeclarations
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.scoping.Scopes

class SoliditySCTScopeProvider extends STextScopeProvider {
	
	@Inject BuiltInDeclarations builtInDeclarations
	
	
	override scope_ElementReferenceExpression_reference(EObject context, EReference reference) {
		var outer = super.scope_ElementReferenceExpression_reference(context, reference)
		return Scopes.scopeFor(builtInDeclarations.all, outer)
	}

}
