package com.yakindu.solidity.scoping

import com.google.inject.Inject
import com.yakindu.solidity.typesystem.BuildInDeclarations
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class SolidityScopeProvider extends AbstractSolidityScopeProvider {

	@Inject BuildInDeclarations declarations
	@Inject ITypeSystem typeSystem

	override getScope(EObject context, EReference ref) {
		return super.getScope(context, ref)
	}

	def scope_ElementReferenceExpression_reference(EObject context, EReference reference) {
		var outer = delegate.getScope(context, reference)
		return new ElementReferenceScope(createImplicitVariables(outer), context, reference);
	}

	def protected createImplicitVariables(IScope outer) {
		return Scopes.scopeFor(declarations.all, outer)
	}

	def scope_FeatureCall_feature(FeatureCall context, EReference reference) {
		return new FeatureCallScope(context, reference, declarations, typeSystem)
	}

}
