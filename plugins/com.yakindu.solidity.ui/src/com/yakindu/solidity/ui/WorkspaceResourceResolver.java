package com.yakindu.solidity.ui;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.resource.Resource;

import com.yakindu.solidity.IWorkspaceResourceResolver;

public class WorkspaceResourceResolver implements IWorkspaceResourceResolver {

	@Override
	public File resolve(Resource resource) {
		return ResourcesPlugin.getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true)).getRawLocation().makeAbsolute().toFile();
	}
}
