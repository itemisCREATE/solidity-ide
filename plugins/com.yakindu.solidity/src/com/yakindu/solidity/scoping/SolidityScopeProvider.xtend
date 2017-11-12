package com.yakindu.solidity.scoping

import com.google.common.collect.Lists
import com.google.inject.Inject
import com.yakindu.solidity.typesystem.BuildInDeclarations
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.TypedElement
import com.yakindu.solidity.solidity.ArrayTypeSpecifier
import org.yakindu.base.types.typesystem.ITypeSystem
import com.yakindu.solidity.typesystem.SolidityTypeSystem

class SolidityScopeProvider extends AbstractSolidityScopeProvider {

	@Inject extension BuildInDeclarations
	@Inject ITypeSystem typesystem;

	override getScope(EObject context, EReference ref) {
		return super.getScope(context, ref)
	}

	def scope_ElementReferenceExpression_reference(EObject context, EReference reference) {
		var result = delegate.getScope(context, reference)
		result = result.createImplicitVariables
		return result;
	}

	def protected createImplicitVariables(IScope outer) {
		return Scopes.scopeFor(Lists.newArrayList(
			createMsg(),
			createAssert(),
			createRequire(),
			createRevert(),
			createAddmod(),
			createMulmod(),
			createKeccak256(),
			createSha3(),
			createSha256(),
			createRipemd160(),
			createEcrecover(),
			createBlock(),
			createSuicide(),
			createThis(),
			createNow(),
			createTransaction()
		), outer)
	}

	def scope_FeatureCall_feature(FeatureCall context, EReference reference) {
		var owner = context.owner
		var EObject element = null;
		if (owner instanceof ElementReferenceExpression) {
			element = owner.reference
		} else if (owner instanceof FeatureCall) {
			element = owner.feature
		} else {
			return getDelegate().getScope(context, reference);
		}

		if (element instanceof TypedElement) {
			if (element.typeSpecifier instanceof ArrayTypeSpecifier ||
				typesystem.isSuperType(element.type, typesystem.getType(SolidityTypeSystem.BYTES))) {
				if (owner instanceof ElementReferenceExpression) {
					if (owner.arraySelector.size == 0)
						return Scopes.scopeFor(Lists.newArrayList(createLength));
				}
			}
			if (element.type instanceof ComplexType)
				return Scopes.scopeFor((element.type as ComplexType).getAllFeatures())
		}

		var parentScope = delegate.getScope(context, reference)
		if (element instanceof ComplexType) {
			return Scopes.scopeFor((context as ComplexType).getAllFeatures(), parentScope)
		}

		if (element instanceof Declaration) {
			var type = element.type
			if (type instanceof ComplexType) {
				return Scopes.scopeFor(type.allFeatures)
			}
		}
		return parentScope
	}

}
