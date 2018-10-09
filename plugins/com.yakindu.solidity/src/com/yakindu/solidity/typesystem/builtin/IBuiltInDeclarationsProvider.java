package com.yakindu.solidity.typesystem.builtin;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;

@ImplementedBy(SolidityBuiltInDeclarationsProvider.class)
public interface IBuiltInDeclarationsProvider {

	public BuiltInDeclarations provideFor(EObject element);

	public BuiltInDeclarations provideFor(Resource resource);
}
