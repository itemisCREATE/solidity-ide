package com.yakindu.solidity.scoping

import com.google.inject.Inject
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.UsingForDeclaration
import com.yakindu.solidity.typesystem.BuildInDeclarations
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Operation
import org.yakindu.base.types.TypedElement
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
		if (context?.owner instanceof ElementReferenceExpression) {
			var ref = (context.owner as ElementReferenceExpression).reference
			if (ref instanceof NamedElement && ("super".equals((ref as NamedElement).name))) {
				val features = EcoreUtil2.getContainerOfType(context, ContractDefinition)?.superTypes?.map[allFeatures].
					flatten
				return Scopes.scopeFor(features)
			}

			return Scopes.scopeFor(usings(ref), new FeatureCallScope(context, reference, declarations, typeSystem))
		}
		new FeatureCallScope(context, reference, declarations, typeSystem)
	}

	def dispatch List<? extends EObject> usings(TypedElement element) {
		val root = EcoreUtil.getRootContainer(element)
		val elements = root.eAllContents.filter(UsingForDeclaration).map[contract].map[allFeatures].toList.flatten.toList
		return elements
	}

	def dispatch List<? extends EObject> usings(EObject o) {
		newArrayList()
	}

}
