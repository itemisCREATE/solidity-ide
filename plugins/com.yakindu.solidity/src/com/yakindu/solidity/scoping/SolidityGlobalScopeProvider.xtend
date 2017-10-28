package com.yakindu.solidity.scoping

import com.google.common.base.Predicate
import com.google.inject.Inject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider
import org.yakindu.base.types.typesystem.ITypeSystem

class SolidityGlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	ITypeSystem typeSystem
	@Inject
	IQualifiedNameProvider qualifiedNameProvider

	override getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		var parentScope = super.getScope(resource, reference, filter)
		return new TypeSystemAwareScope(parentScope, typeSystem, qualifiedNameProvider, reference.getEReferenceType());
	}

}
