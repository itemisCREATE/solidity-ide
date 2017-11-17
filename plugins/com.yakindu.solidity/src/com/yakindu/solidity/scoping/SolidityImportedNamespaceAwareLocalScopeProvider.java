package com.yakindu.solidity.scoping;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.TypesPackage;

import com.google.common.collect.Lists;
import com.yakindu.solidity.solidity.ContractDefinition;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SolidityImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	protected IScope getResourceScope(Resource res, EReference reference) {
		if (reference == TypesPackage.Literals.COMPLEX_TYPE__SUPER_TYPES)
			return super.getResourceScope(res, reference);
		EObject context = res.getContents().get(0);
		IScope globalScope = getGlobalScope(res, reference);
		List<ImportNormalizer> normalizers = getSuperTypeImports(res, reference);
		if (!normalizers.isEmpty()) {
			globalScope = createImportScope(globalScope, normalizers, null, reference.getEReferenceType(),
					isIgnoreCase(reference));
		}
		return getResourceScope(globalScope, context, reference);
	}

	protected List<ImportNormalizer> getSuperTypeImports(Resource res, EReference reference) {
		List<ImportNormalizer> result = Lists.newArrayList();
		TreeIterator<EObject> allContents = res.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof ContractDefinition) {
				ContractDefinition contract = (ContractDefinition) next;
				EList<ComplexType> superTypes = contract.getSuperTypes();
				for (ComplexType complexType : superTypes) {
					// if (complexType.eIsProxy() || complexType.getName() == null)
					// continue;
					ImportNormalizer resolver = createImportedNamespaceResolver(complexType.getName()+".*", false);
					result.add(resolver);
				}
				allContents.prune();
			}
		}
		return result;
	}
}
