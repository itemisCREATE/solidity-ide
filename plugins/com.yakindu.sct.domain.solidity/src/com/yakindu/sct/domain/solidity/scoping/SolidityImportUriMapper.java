package com.yakindu.sct.domain.solidity.scoping;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper;

import com.google.inject.Inject;

public class SolidityImportUriMapper implements IPackageImport2URIMapper {

	@Inject
	private IResourceDescriptions descriptions;

	public PackageImport findPackageImport(Resource context, String packageImport) {
		Iterable<IEObjectDescription> exportedObjects = descriptions.getExportedObjects(TypesPackage.Literals.TYPE,
				QualifiedName.create(packageImport), false);
		for (IEObjectDescription ieObjectDescription : exportedObjects) {
			if (ieObjectDescription.getQualifiedName().toString().equals(packageImport))
				return new PackageImport(ieObjectDescription.getName().toString(), ieObjectDescription.getEObjectURI(),
						"");
		}
		return null;
	}

	public Set<PackageImport> getAllImports(Resource context) {
		Set<PackageImport> result = new HashSet<IPackageImport2URIMapper.PackageImport>();
		Iterable<IEObjectDescription> exportedObjects = descriptions.getExportedObjects();
		for (IEObjectDescription ieObjectDescription : exportedObjects) {
			result.add(new PackageImport(ieObjectDescription.getName().toString(), ieObjectDescription.getEObjectURI(),
					""));
		}
		return result;
	}

}
