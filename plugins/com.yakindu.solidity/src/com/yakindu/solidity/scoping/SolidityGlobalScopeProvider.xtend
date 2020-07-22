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

import com.google.common.base.Predicate
import com.yakindu.solidity.typesystem.builtin.BuiltInDeclarations
import javax.inject.Inject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider
import org.eclipse.xtext.util.IResourceScopeCache
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Karsten Thoms
 */
class SolidityGlobalScopeProvider extends ImportUriGlobalScopeProvider {

	@Inject
	protected ITypeSystem typeSystem
	@Inject
	protected IQualifiedNameProvider qualifiedNameProvider
	@Inject
	protected IResourceScopeCache cache;
	@Inject
	protected BuiltInDeclarations buildInDeclarations
	@Inject
	protected ImportedUrisResolver uriResolver

	override getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		val libraryScope = resource.getScopeWithLibrary(reference)
		return new TypeSystemAwareScope(libraryScope, typeSystem, qualifiedNameProvider, reference.getEReferenceType());
	}

	override protected getImportedUris(Resource resource) {
		return uriResolver.getImportedUris(resource)
	}

	private def IScope getScopeWithLibrary(Resource resource, EReference reference) {
		return Scopes.scopeFor(buildInDeclarations.all, super.getScope(resource, reference, null))
	}
}
