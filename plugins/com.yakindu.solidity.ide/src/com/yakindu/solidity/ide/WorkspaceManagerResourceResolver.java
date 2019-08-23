package com.yakindu.solidity.ide;

import java.io.File;
import java.net.URI;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ProjectConfigProvider;

import com.google.inject.Inject;
import com.yakindu.solidity.IWorkspaceResourceResolver;

@SuppressWarnings("restriction")
public class WorkspaceManagerResourceResolver implements IWorkspaceResourceResolver {

	@Inject
	UriExtensions uriExtensions;
	
	@Override
	public File resolve(Resource resource) {
		IProjectConfig projectConfig = new ProjectConfigProvider().getProjectConfig(resource.getResourceSet());
		String absoluteResourcePath = projectConfig.getPath().scheme() + ":" + resource.getURI().toFileString();
		return new File(URI.create(absoluteResourcePath));
	}

}
