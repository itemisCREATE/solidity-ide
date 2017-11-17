package com.yakindu.solidity.scoping

import com.yakindu.solidity.solidity.ArrayTypeSpecifier
import com.yakindu.solidity.solidity.MappingTypeSpecifier
import com.yakindu.solidity.typesystem.BuildInDeclarations
import com.yakindu.solidity.typesystem.SolidityTypeSystem
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractScope
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.TypedElement
import org.yakindu.base.types.typesystem.ITypeSystem
import com.yakindu.solidity.solidity.ContractDefinition

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class FeatureCallScope extends AbstractScope {

	var FeatureCall context
	var EReference ref
	var BuildInDeclarations declarations
	var ITypeSystem typeSystem

	protected new(FeatureCall context, EReference ref, BuildInDeclarations declarations, ITypeSystem typeSystem) {
		super(IScope.NULLSCOPE, false)
		this.context = context
		this.ref = ref
		this.declarations = declarations
		this.typeSystem = typeSystem
	}

	override protected getAllLocalElements() {
		var owner = context?.getOwner()
		val elements = owner?.getLocalElements
		return Scopes.scopedElementsFor(if(elements !== null) elements else newArrayList());
	}

	def dispatch List<? extends EObject> getLocalElements(ElementReferenceExpression it) {
		return if (it.arraySelector.size == 0)
			reference?.getLocalElements()
		else if (reference instanceof TypedElement &&
			(reference as TypedElement).typeSpecifier instanceof MappingTypeSpecifier) {
			(reference as TypedElement).typeSpecifier?.getLocalElements
		} else if (reference instanceof TypedElement) {
			(reference as TypedElement).type?.getLocalElements
		} else
			newArrayList()
	}
	
	def dispatch List<? extends EObject> getLocalElements(ContractDefinition it) {
		//TODO: only constant 
		it.allFeatures 
	}

	def dispatch List<? extends EObject> getLocalElements(FeatureCall it) {
		it.feature.localElements
	}

	def dispatch List<? extends EObject> getLocalElements(TypeSpecifier it) {
		type?.getLocalElements
	}

	def dispatch List<? extends EObject> getLocalElements(ArrayTypeSpecifier it) {
		newArrayList(declarations.createLength, declarations.createPush)
	}

	def dispatch List<? extends EObject> getLocalElements(MappingTypeSpecifier it) {
		value.getLocalElements
	}

	def dispatch List<? extends EObject> getLocalElements(TypedElement it) {
		return if (typeSystem.isSuperType(it.type, typeSystem.getType(SolidityTypeSystem.BYTES))) {
			newArrayList(declarations.createLength, declarations.createPush)
		} else
			typeSpecifier?.getLocalElements
	}

	def dispatch List<? extends EObject> getLocalElements(ComplexType it) {
		allFeatures.toList
	}

	def dispatch List<? extends EObject> getLocalElements(EnumerationType it) {
		enumerator.toList
	}

	def dispatch List<EObject> getLocalElements(EObject obj) {
		// Fallback
		newArrayList()
	}
}
