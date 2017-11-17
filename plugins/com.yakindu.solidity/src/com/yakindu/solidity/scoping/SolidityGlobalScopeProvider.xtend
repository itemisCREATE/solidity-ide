package com.yakindu.solidity.scoping

import com.google.common.base.Predicate
import com.google.inject.Inject
import com.google.inject.Singleton
import com.yakindu.solidity.solidity.ImportDirective
import java.util.LinkedHashSet
import java.util.Set
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider
import org.eclipse.xtext.util.IResourceScopeCache
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
class SolidityGlobalScopeProvider extends ImportUriGlobalScopeProvider {

	@Inject
	ITypeSystem typeSystem
	@Inject
	IQualifiedNameProvider qualifiedNameProvider
	@Inject
	private IResourceScopeCache cache;

	override getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		var parentScope = super.getScope(resource, reference, filter)
		return new TypeSystemAwareScope(parentScope, typeSystem, qualifiedNameProvider, reference.getEReferenceType());
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
			if (URIConverter.INSTANCE.exists(normalizedURI, null) && !result.contains(normalizedURI)) {
				result += normalizedURI
				getTransientImportUris(resource.resourceSet.getResource(normalizedURI, true), result)
			}
		]
	}

	def createNormalizedURI(ImportDirective it, Resource resource) {
		val URI uri = URI.createURI(resource.URI.trimSegments(1).toString + "/" +
			if(importedNamespace.toLowerCase.endsWith(".sol")) importedNamespace else importedNamespace + ".sol")
		// for whatever reason URIConverter normalize does not remove ../ segments so we have to convert to an IFile and back
		var normalizedURI = resource.resourceSet.URIConverter.normalize(uri)
		val file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(normalizedURI.toPlatformString(true)))
		normalizedURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true)
	}
}
