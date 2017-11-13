package com.yakindu.solidity.scoping

import com.google.common.base.Predicate
import com.google.inject.Inject
import com.yakindu.solidity.solidity.ImportDirective
import java.util.LinkedHashSet
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider
import org.yakindu.base.types.typesystem.ITypeSystem
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.URIConverter

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class SolidityGlobalScopeProvider extends ImportUriGlobalScopeProvider {

	@Inject
	ITypeSystem typeSystem
	@Inject
	IQualifiedNameProvider qualifiedNameProvider

	override getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		var parentScope = super.getScope(resource, reference, filter)
		return new TypeSystemAwareScope(parentScope, typeSystem, qualifiedNameProvider, reference.getEReferenceType());
	}

	override protected getImportedUris(Resource resource) {
		// TODO hack, use user date from import for that, add caching
		val LinkedHashSet<URI> result = new LinkedHashSet<URI>()
		getTransientImportUris(resource, result)
		result
	}

	// TODO: check for dead locks when A -> B -> A
	def protected void getTransientImportUris(Resource resource, Set<URI> result) {
		resource.allContents.filter(ImportDirective).forEach [
			val URI uri = URI.createURI(resource.URI.trimSegments(1).toString + "/" +
				if(importedNamespace.toLowerCase.endsWith(".sol")) importedNamespace else importedNamespace + ".sol")
			if (URIConverter.INSTANCE.exists(uri, null)) {
				getTransientImportUris(resource.resourceSet.getResource(uri, true), result)
				result += uri
			}
		]
	}

}
