package com.yakindu.solidity;

import java.io.File;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;

public interface IWorkspaceResourceResolver {
	
	public File resolve(Resource resource);

}
