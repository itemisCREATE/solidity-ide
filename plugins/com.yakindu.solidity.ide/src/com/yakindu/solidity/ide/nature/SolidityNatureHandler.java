package com.yakindu.solidity.ide.nature;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author Florian Antony - Initial contribution and API
 */
public class SolidityNatureHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		final AtomicReference<IStatus> status = new AtomicReference<IStatus>();
		Job job = new Job("Set Solidity Nature...") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
				if (currentSelection instanceof IStructuredSelection) {
					Object firstElement = ((IStructuredSelection) currentSelection).getFirstElement();
					IAdapterManager adapterManager = Platform.getAdapterManager();
					IResource resourceAdapter = adapterManager.getAdapter(firstElement, IResource.class);
					if (resourceAdapter != null) {
						IProject project = resourceAdapter.getProject();
						try {
							return addSolidityNature(project, monitor);
						} catch (CoreException e) {
							return new Status(IStatus.ERROR, "solidity", e.getMessage(), e);
						}
					}
				}
				return Status.CANCEL_STATUS;
			}
		};
		job.schedule();
		try {
			job.join();
		} catch (InterruptedException e) {
			Thread.interrupted();
		}
		status.set(job.getResult());
		return status.get();
	}

	protected IStatus addSolidityNature(IProject project, IProgressMonitor monitor) throws CoreException {
		IProjectDescription projectDescription = project.getDescription();
		String[] natureIds = projectDescription.getNatureIds();
		for (String id : natureIds) {
			if (id.equals(SolidityNature.ID)) {
				return Status.CANCEL_STATUS;
			}
		}
		String[] newNatureIds = new String[natureIds.length + 1];
		System.arraycopy(natureIds, 0, newNatureIds, 0, natureIds.length);
		newNatureIds[natureIds.length] = SolidityNature.ID;
		IStatus status = validateNatures(newNatureIds);
		if (status.getCode() == IStatus.OK) {
			projectDescription.setNatureIds(newNatureIds);
			project.setDescription(projectDescription, monitor);
			return status;
		}
		return status;
	}

	private IStatus validateNatures(String[] newNatureIds) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		return workspace.validateNatureSet(newNatureIds);
	}

}
