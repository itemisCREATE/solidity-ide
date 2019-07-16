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

import com.google.inject.Inject
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.EmitExpression
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.ModifierDefinition
import com.yakindu.solidity.solidity.StructDefinition
import com.yakindu.solidity.solidity.UsingForDeclaration
import com.yakindu.solidity.typesystem.SolidityTypeSystem
import com.yakindu.solidity.typesystem.builtin.BuiltInDeclarations
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.Argument
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.scoping.ExpressionsScopeProvider
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider
import org.eclipse.xtext.naming.QualifiedName

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 * @author Karsten Thoms
 */
class SolidityScopeProvider extends ExpressionsScopeProvider {

	@Inject BuiltInDeclarations builtInDeclarations
	@Inject ITypeSystem typeSystem
	@Inject ITypeSystemInferrer inferrer;
	@Inject ImportedNamespaceAwareLocalScopeProvider defaultDelegate

	def scope_NamedArgument_reference(Argument object, EReference ref) {
		var parameters = object?.eContainer?.elements
		return if(parameters !== null) Scopes.scopeFor(parameters) else IScope.NULLSCOPE;
	}

	def scope_NamedArgument_reference(ElementReferenceExpression exp, EReference ref) {
		var parameters = exp?.elements
		return if(parameters !== null) Scopes.scopeFor(parameters) else IScope.NULLSCOPE;
	}

	def scope_NamedArgument_reference(FeatureCall fc, EReference ref) {
		var parameters = fc?.elements
		return if(parameters !== null) Scopes.scopeFor(parameters) else IScope.NULLSCOPE;
	}

	def dispatch getElements(ElementReferenceExpression it) {
		return if (reference instanceof Operation)
			(reference as Operation).parameters
		else if (reference instanceof StructDefinition) {
			(reference as StructDefinition).allFeatures
		} else
			null
	}

	def dispatch getElements(FeatureCall it) {
		return if (feature instanceof Operation)
			(feature as Operation).parameters
		else if (feature instanceof StructDefinition) {
			(feature as StructDefinition).allFeatures
		} else
			null
	}

	def dispatch getElements(EObject object) {
		throw new IllegalStateException("Unknown element " + object)
	}

	def scope_ModifierInvocation_reference(FunctionDefinition context, EReference reference) {
		var outerScope = IScope.NULLSCOPE;
		if (context.constructor) {
			val ctors = context.contract.superTypes.map[type].filter(ComplexType).map[allFeatures].flatten.filter(
				FunctionDefinition).filter [
				isConstructor
			]
			outerScope = Scopes.scopeFor(ctors)
		}
		Scopes.scopeFor(context.contract.allFeatures.filter(ModifierDefinition), outerScope)
	}

	def scope_ElementReferenceExpression_reference(EObject context, EReference reference) {
		var outer = delegate.getScope(context, reference)
		return new ElementReferenceScope(outer, context, reference);
	}

	def scope_EmitExpression_event(EmitExpression context, EReference reference) {
		var outer = delegate.getScope(context, reference)
		return new ElementReferenceScope(outer, context, reference);
	}

	def scope_FeatureCall_feature(FeatureCall context, EReference reference) {
		if (context?.owner instanceof ElementReferenceExpression) {
			var ref = (context.owner as ElementReferenceExpression).reference
			if (ref instanceof NamedElement && ("super".equals((ref as NamedElement).name))) {
				val features = EcoreUtil2.getContainerOfType(context, ContractDefinition)?.superTypes?.map[type].filter(
					ComplexType).map[allFeatures].flatten
				var address = typeSystem.getType(SolidityTypeSystem.ADDRESS) as ComplexType
				return Scopes.scopeFor(features + address.allFeatures)
			} else if (ref instanceof NamedElement && ("this".equals((ref as NamedElement).name))) {
				val features = EcoreUtil2.getContainerOfType(context, ContractDefinition).allFeatures
				var address = typeSystem.getType(SolidityTypeSystem.ADDRESS) as ComplexType
				return Scopes.scopeFor(features + address.allFeatures)
			}
		}
		var contractsViaUsings = usings(context);
		return Scopes.scopeFor(contractsViaUsings, [if(!it.getName().isNullOrEmpty) { QualifiedName.create(it.getName())}]
			, Scopes.scopeFor(contractsViaUsings,
			new FeatureCallScope(context, reference, builtInDeclarations, typeSystem, inferrer)));
	}

	def usings(EObject context) {
		val root = getContract(context);
		if (root === null)
			return newArrayList()
		val List<ComplexType> contracts = newArrayList()
		root.getAllSuperTypes(contracts)
		val elements = contracts.map[eAllContents.toList].flatten.filter(UsingForDeclaration).map[contract].map [
			allFeatures
		].toList.flatten.toList
		return elements
	}

	def protected void getAllSuperTypes(ComplexType complexType, List<ComplexType> result) {
		result += complexType
		var superTypes = complexType.superTypes.map[type].filter(ComplexType)
		result += superTypes
		superTypes.forEach[it.getAllSuperTypes(result)]
	}

	def scope_TypeSpecifier_type(EObject context, EReference reference) {
		if (context instanceof ContractDefinition || context.eContainer instanceof ContractDefinition) {
			val outer = defaultDelegate.getScope(context, reference)
			Scopes.scopeFor(builtInDeclarations.superContracts, outer)
		} else {
			val outer = getDelegate.getScope(context, reference)
			Scopes.scopeFor(builtInDeclarations.superContracts, outer)
		}
	}

	def protected isConstructor(FunctionDefinition it) {
		val contract = EcoreUtil2.getContainerOfType(it, ContractDefinition)
		return contract?.name == name

	}

	def protected getContract(EObject context) {
		EcoreUtil2.getContainerOfType(context, ContractDefinition)
	}
}
