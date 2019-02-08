/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - Itemis AG - initial API and implementation
 * 	Karsten Thoms   - Itemis AG - initial API and implementation
 * 	Florian Antony  - Itemis AG - initial API and implementation
 * 	committers of YAKINDU 
 * 
 */
package com.yakindu.solidity.ui.wizard;

import java.io.InputStream;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;
import org.eclipse.xtext.util.StringInputStream;

import com.yakindu.solidity.SolidityVersion;

/**
 * 
 * @author Karsten Thoms - Initial contribution and API
 */
public class NewFileWizard extends BasicNewResourceWizard {
	@Inject
	private IImageDescriptorHelper imageHelper;
	@Inject @Named(Constants.FILE_EXTENSIONS)
	String fileExtensions;
	@Inject @Named(SolidityVersion.SOLIDITY_VERSION)
	String solidityVersion;	

	private WizardNewFileCreationPage mainPage;

	@Override
	public void addPages() {
		super.addPages();
		String fileExtension = fileExtensions.split("\\s*,\\s*")[0];
		mainPage = new WizardNewFileCreationPage("New File Page", getSelection()) {
			@Override
			protected InputStream getInitialContents() {
				NewFileTemplate template = new NewFileTemplate(this.getFileName().replace("."+fileExtension, ""), solidityVersion);
				
				return new StringInputStream(template.generate().toString());
			}
		};
		mainPage.setTitle("Solidity File");
		mainPage.setFileName("my_contract");
		mainPage.setFileExtension(fileExtension);
		addPage(mainPage);
	}

	@Override
	protected void initializeDefaultPageImageDescriptor() {
		setDefaultPageImageDescriptor(imageHelper.getImageDescriptor("icon_48x48.png"));
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle("New Solidity file");
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean performFinish() {
		IFile file = mainPage.createNewFile();
		if (file == null) {
			return false;
		}

		selectAndReveal(file);

		// Open editor on new file.
		IWorkbenchWindow dw = getWorkbench().getActiveWorkbenchWindow();
		try {
			if (dw != null) {
				IWorkbenchPage page = dw.getActivePage();
				if (page != null) {
					IDE.openEditor(page, file, true);
				}
			}
		} catch (PartInitException e) {
			openError(dw.getShell(), "Problems opening editor", e.getMessage(), e);
		}

		return true;
	}

	/**
	 * Open an error style dialog for PartInitException by including any extra
	 * information from the nested CoreException if present.
	 * 
	 * Copied from org.eclipse.ui.internal.ide.DialogUtil.openError(Shell, String,
	 * String, PartInitException)
	 */
	private static void openError(Shell parent, String title, String message, PartInitException exception) {
		// Check for a nested CoreException
		CoreException nestedException = null;
		IStatus status = exception.getStatus();
		if (status != null && status.getException() instanceof CoreException) {
			nestedException = (CoreException) status.getException();
		}

		if (nestedException != null) {
			// Open an error dialog and include the extra
			// status information from the nested CoreException
			ErrorDialog.openError(parent, title, message, nestedException.getStatus());
		} else {
			// Open a regular error dialog since there is no
			// extra information to display. Don't use SWT.SHEET because
			// we don't know if the title contains important information.
			MessageDialog.openError(parent, title, message);
		}
	}
	
	
}
