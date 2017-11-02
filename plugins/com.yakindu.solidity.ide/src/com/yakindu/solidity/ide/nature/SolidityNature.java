package com.yakindu.solidity.ide.nature;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import com.yakindu.solidity.ide.builder.SolidityBuilder;

/**
 * @author Florian Antony - Initial contribution and API
 */
public class SolidityNature implements IProjectNature {

	public static final String ID = "com.yakindu.solidity.ide.nature.solidityNature";
	private IProject project;
	@Override
	public void configure() throws CoreException {
		new Job("Adding Solidity Nature") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				IProjectDescription projectDescription = SolidityNature.this.getProjectDescription();
				if (projectDescription != null) {
					addSolidityBuilder(projectDescription);
					return SolidityNature.this.setProjectDescription(projectDescription, monitor);
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	@Override
	public void deconfigure() throws CoreException {
		new Job("Removing Solidity Nature") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				IProjectDescription projectDescription = SolidityNature.this.getProjectDescription();
				if (projectDescription != null) {
					removeSolidityBuilder(projectDescription);
					return SolidityNature.this.setProjectDescription(projectDescription, monitor);
				}
				return Status.OK_STATUS;
			}

		}.schedule();
	}

	@Override
	public IProject getProject() {
		return this.project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

	protected void removeSolidityBuilder(IProjectDescription projectDescription) {
		ICommand[] commands = projectDescription.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			ICommand command = commands[i];
			if (command.getBuilderName().equals(SolidityBuilder.ID)) {
				ICommand[] newCommands = new ICommand[commands.length - 1];
				System.arraycopy(commands, 0, newCommands, 0, i);
				System.arraycopy(commands, i + 1, newCommands, i, commands.length - i - 1);
				projectDescription.setBuildSpec(newCommands);
			}
		}
	}

	protected void addSolidityBuilder(IProjectDescription projectDescription) {
		ICommand[] commands = projectDescription.getBuildSpec();
		for (ICommand command : commands) {
			if (command.getBuilderName().equals(SolidityBuilder.ID)) {
				return;
			}
		}
		ICommand solidityBuilder = projectDescription.newCommand();
		solidityBuilder.setBuilderName(SolidityBuilder.ID);
		ICommand[] newCommands = new ICommand[commands.length + 1];
		System.arraycopy(commands, 0, newCommands, 0, commands.length);
		// add as last command
		newCommands[commands.length] = solidityBuilder;
		projectDescription.setBuildSpec(newCommands);
	}

	private IProjectDescription getProjectDescription() {
		try {
			return this.project.getDescription();
		} catch (CoreException e) {
			return null;
		}
	}

	private IStatus setProjectDescription(IProjectDescription projectDescription, IProgressMonitor monitor) {
		try {
			project.setDescription(projectDescription, monitor);
			return Status.OK_STATUS;
		} catch (CoreException e) {
			// TODO meaningfull plugin ID
			return new Status(Status.ERROR, "Solidity", e.getMessage(), e);
		}
	}

}
