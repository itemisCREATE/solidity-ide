/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.domain.solidity.scoping;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper;

import com.google.inject.Inject;
/**
 * 
 * @author Andreas Muelder - Initial contribution and API
 * 
 */
public class SolidityImportUriMapper implements IPackageImport2URIMapper {

	@Inject
	private IResourceDescriptions descriptions;

	public Optional<PackageImport> findPackageImport(Resource context, String packageImport) {
		Iterable<IEObjectDescription> exportedObjects = descriptions.getExportedObjects(TypesPackage.Literals.TYPE,
				QualifiedName.create(packageImport), false);
		for (IEObjectDescription ieObjectDescription : exportedObjects) {
			if (ieObjectDescription.getQualifiedName().toString().equals(packageImport))
				return Optional.of(new PackageImport(ieObjectDescription.getName().toString(),
						ieObjectDescription.getEObjectURI(), ""));
		}
		return Optional.empty();
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
