package com.yakindu.solidity.scoping

import com.google.inject.Inject
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.ModifierDefinition
import com.yakindu.solidity.solidity.UsingForDeclaration
import com.yakindu.solidity.typesystem.BuildInDeclarations
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class SolidityScopeProvider extends AbstractSolidityScopeProvider {

	@Inject BuildInDeclarations declarations
	@Inject ITypeSystem typeSystem
	@Inject ITypeSystemInferrer inferrer;

	override getScope(EObject context, EReference ref) {
		return super.getScope(context, ref)
	}

	def scope_ModifierInvocation_reference(FunctionDefinition context, EReference reference) {
		var outerScope = IScope.NULLSCOPE;
		if (context.constructor) {
			val ctors = context.contract.superTypes.map[allFeatures].flatten.filter(FunctionDefinition).filter [
				isConstructor
			]
			outerScope = Scopes.scopeFor(ctors)
		}
		Scopes.scopeFor(context.contract.allFeatures.filter(ModifierDefinition), outerScope)
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
		}
		return Scopes.scopeFor(usings(context),
			new FeatureCallScope(context, reference, declarations, typeSystem, inferrer))
	}

	def usings(EObject context) {
		val root = EcoreUtil2.getContainerOfType(context, ContractDefinition)
		val List<ComplexType> contracts = newArrayList()
		root.getAllSuperTypes(contracts)
		contracts += root.superTypes
		val elements = contracts.map[eAllContents.toList].flatten.filter(UsingForDeclaration).map[contract].map [
			allFeatures
		].toList.flatten.toList
		return elements
	}

	def protected void getAllSuperTypes(ComplexType type, List<ComplexType> result) {
		result += type
		result += type.superTypes
		type.superTypes.forEach[it.getAllSuperTypes(result)]
	}

	def scope_ComplexType_superTypes(EObject context, EReference reference) {
		val outer = delegate.getScope(context, reference)
		Scopes.scopeFor(declarations.superContracts, outer)

	}

	def protected isConstructor(FunctionDefinition it) {
		val contract = EcoreUtil2.getContainerOfType(it, ContractDefinition)
		return contract?.name == name

	}

	def protected getContract(EObject context) {
		EcoreUtil2.getContainerOfType(context, ContractDefinition)
	}
}
