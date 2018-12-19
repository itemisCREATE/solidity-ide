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
import com.yakindu.solidity.solidity.ImportDirective
import com.yakindu.solidity.typesystem.BuiltInDeclarations
import java.util.LinkedHashSet
import java.util.Set
import javax.inject.Inject
import org.eclipse.emf.common.util.URI
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
	protected BuiltInDeclarations buildInDeclarationsProvider

	override getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		val libraryScope = resource.getScopeWithLibrary(reference)
		return new TypeSystemAwareScope(libraryScope, typeSystem, qualifiedNameProvider, reference.getEReferenceType());
	}

	override protected getImportedUris(Resource resource) {
		return cache.get(
			SolidityGlobalScopeProvider.name,
			resource,
			[
				val LinkedHashSet<URI> result = new LinkedHashSet<URI>()
				getTransientImportUris(resource, result)
				result
			]
		);
	}

	def protected void getTransientImportUris(Resource resource, Set<URI> result) {
		resource.allContents.filter(ImportDirective).forEach [
			val normalizedURI = createNormalizedURI(it, resource)
			if (resource.resourceSet.URIConverter.exists(normalizedURI, null) && !result.contains(normalizedURI)) {
				result += normalizedURI
				getTransientImportUris(resource.resourceSet.getResource(normalizedURI, true), result)
			}
		]
	}

	def createNormalizedURI(ImportDirective it, Resource resource) {
		val URI uri = URI.createURI(resource.URI.trimSegments(1).toString + "/" +
			if(importedNamespace.toLowerCase.endsWith(".sol")) importedNamespace else importedNamespace + ".sol")
		return resource.normalize(uri)
	}

	/**
	 * removes dot segments of the uri
	 */
	def protected normalize(Resource resource, URI uri) {
		var normalizedURI = resource.resourceSet.URIConverter.normalize(uri)
		val newSegments = newArrayList()
		normalizedURI.segmentsList.filter[it != "."].forEach [
			if (it == "..") {
				newSegments.remove(it)
				newSegments.remove(newSegments.size - 1)
			} else
				newSegments.add(it)
		]
		normalizedURI = normalizedURI.trimSegments(normalizedURI.segmentCount)
		normalizedURI = normalizedURI.appendSegments(newSegments.toArray(#[]))
		normalizedURI
	}

	private def IScope getScopeWithLibrary(Resource resource, EReference reference) {
		return Scopes.scopeFor(buildInDeclarationsProvider.all, super.getScope(resource, reference, null))
//		var stdlib = (typeSystem as AbstractTypeSystem).resource
// 		if (resourceDescriptionsData === null) {
//			resourceDescriptionsData = new ResourceDescriptionsData(
//				#[descriptionManager.getResourceDescription(stdlib)])
//		}
//		return SelectableBasedScope.createScope(super.getScope(resource, reference, null), resourceDescriptionsData,
//			reference.getEReferenceType(), false);
	}
}
