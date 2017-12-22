/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - Itemis AG - initial API and implementation
 * 	Karsten Thoms   - Itemis AG - initial API and implementation
 * 	Florian Antony  - Itemis AG - initial API and implementation
 * 	committers of YAKINDU 
 * 
 */
package com.yakindu.solidity.scoping

import com.yakindu.solidity.solidity.ArrayTypeSpecifier
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.Identifier
import com.yakindu.solidity.solidity.MappingTypeSpecifier
import com.yakindu.solidity.solidity.VariableDefinition
import com.yakindu.solidity.typesystem.BuildInDeclarations
import com.yakindu.solidity.typesystem.SolidityTypeSystem
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractScope
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.PrimitiveType
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.TypedElement
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Karsten Thoms
 * @author Thomas Kutz
 */
class FeatureCallScope extends AbstractScope {

	var FeatureCall context
	var EReference ref
	var BuildInDeclarations declarations
	var ITypeSystem typeSystem
	var ITypeSystemInferrer inferrer

	protected new(FeatureCall context, EReference ref, BuildInDeclarations declarations, ITypeSystem typeSystem,
		ITypeSystemInferrer inferrer) {
		super(IScope.NULLSCOPE, false)
		this.context = context
		this.ref = ref
		this.declarations = declarations
		this.typeSystem = typeSystem
		this.inferrer = inferrer
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
		// TODO: only constant 
		it.allFeatures
	}

	def dispatch List<? extends EObject> getLocalElements(FeatureCall it) {
		it.feature.localElements
	}

	def dispatch List<? extends EObject> getLocalElements(TypeSpecifier it) {
		type?.getLocalElements
	}

	def dispatch List<? extends EObject> getLocalElements(ArrayTypeSpecifier it) {
		newArrayList(declarations.length, declarations.push)
	}

	def dispatch List<? extends EObject> getLocalElements(MappingTypeSpecifier it) {
		value.getLocalElements
	}

	def dispatch List<? extends EObject> getLocalElements(TypedElement it) {
		return if (typeSystem.isSuperType(it.type, typeSystem.getType(SolidityTypeSystem.BYTES))) {
			newArrayList(declarations.length, declarations.push)
		} else if (typeSpecifier === null && it instanceof VariableDefinition) {
			inferrer.infer(it)?.type?.localElements
		} else if (it instanceof FunctionDefinition) {
			// TODO handle multi return parameters properly
			return it.returnParameters?.head?.getLocalElements
		} else {
			typeSpecifier?.getLocalElements
		}
	}

	def dispatch List<? extends EObject> getLocalElements(ComplexType it) {
		allFeatures.toList
	}

	def dispatch List<? extends EObject> getLocalElements(EnumerationType it) {
		enumerator.toList
	}
	
	
	def dispatch List<? extends EObject> getLocalElements(PrimitiveType it) {
		return if (typeSystem.isSuperType(it, typeSystem.getType(SolidityTypeSystem.BYTES))) {
			newArrayList(declarations.length, declarations.push)
		} else {
			newArrayList()
		}
	}

	def dispatch List<EObject> getLocalElements(EObject obj) {
		// Fallback
		newArrayList()
	}

	def dispatch List<? extends EObject> getLocalElements(Identifier identifier) {
		var definition = EcoreUtil2.getContainerOfType(identifier, VariableDefinition)
		definition?.initialValue.getLocalElements
	}
}
