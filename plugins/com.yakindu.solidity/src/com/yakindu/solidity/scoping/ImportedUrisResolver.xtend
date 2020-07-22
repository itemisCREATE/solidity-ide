package com.yakindu.solidity.scoping

import com.google.inject.Inject
import org.eclipse.xtext.util.IResourceScopeCache
import com.yakindu.solidity.solidity.ImportDirective
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import java.util.Set
import java.util.LinkedHashSet
import com.google.inject.Singleton

@Singleton
class ImportedUrisResolver {
	@Inject
	protected IResourceScopeCache cache;
	
	def LinkedHashSet<URI> getImportedUris(Resource resource) {
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
}