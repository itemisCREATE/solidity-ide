/**
 * Copyright (c) 2016 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 
 */
package com.yakindu.solidity.intro;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.osgi.framework.Bundle;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class KickStartNewProjectAction extends Action implements IIntroAction {

	private static final String HELLO_WORLD = "hello-world";

	@Override
	public void run(IIntroSite site, Properties params) {
		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				IProject project = createProject(monitor);
				createExample(project);
			}
		};
		try {
			PlatformUI.getWorkbench().getProgressService().run(true, true, op);
			final IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
			IIntroPart part = introManager.getIntro();
			introManager.closeIntro(part);
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IDE.openEditor(page, ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("hello-world/greeter.sol")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void createExample(IProject project) {
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
		try (InputStream stream = FileLocator.openStream(bundle, new Path("examples/greeter.sol"), false)) {
			IFile file = project.getFile("greeter.sol");
			file.create(stream, true, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected IProject createProject(IProgressMonitor monitor) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(HELLO_WORLD);
		try {
			if (project.exists())
				project.delete(true, monitor);
			project.create(monitor);
			project.open(monitor);
			addNature(project);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return project;
	}

	public void addNature(IProject project) {
		try {
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = XtextProjectHelper.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}