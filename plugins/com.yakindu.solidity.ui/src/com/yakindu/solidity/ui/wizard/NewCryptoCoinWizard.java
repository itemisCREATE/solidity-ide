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

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.util.StringInputStream;

import com.yakindu.solidity.typesystem.builtin.SolidityVersions;

/**
 * @author Florian Antony - initial contribution and API
 */
public class NewCryptoCoinWizard extends BasicNewProjectResourceWizard implements INewWizard {

	// @Inject
	// private IImageDescriptorHelper imageHelper;

	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	String fileExtensions;

	@Inject
	@Named(SolidityVersions.SOLIDITY_VERSION)
	String solidityVersion;

	// private IFile newFile;
	private Text nameText;
	// private Text outputDirectoryText;
	private Text symbol;
	private Text decimalText;
	private Text totalSupplyText;
	private WizardPage configurationPage;

	ModifyListener modListener = new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
			getContainer().updateButtons();
		}
	};

	@Override
	public void addPages() {
		super.addPages();
		configurationPage = new WizardPage("Token Configuration") {

			@Override
			public void createControl(Composite parent) {
				final Composite composite = new Composite(parent, SWT.NONE);
				GridDataFactory.fillDefaults().grab(true, true).applyTo(composite);
				GridLayoutFactory.fillDefaults().numColumns(1).applyTo(composite);
				GridLayoutFactory.fillDefaults().spacing(0,0).applyTo(composite);

				final Group tokenNameConfigurationGroup = new Group(composite, SWT.NONE);
				tokenNameConfigurationGroup.setText("Token Name");

				GridLayoutFactory.fillDefaults().numColumns(2).applyTo(tokenNameConfigurationGroup);
				GridDataFactory.fillDefaults().grab(true, true).applyTo(tokenNameConfigurationGroup);

				// Label spacer = new Label(tokenNameConfigurationGroup, SWT.NONE);
				// GridDataFactory.fillDefaults().span(2, 1).applyTo(spacer);

				Label nameLabel = new Label(tokenNameConfigurationGroup, SWT.NONE);
				nameLabel.setText("Name:");
				nameText = new Text(tokenNameConfigurationGroup, SWT.BORDER);
				nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				GridDataFactory.fillDefaults().span(2, 1).applyTo(tokenNameConfigurationGroup);
				nameText.setMessage("Example Token");
				nameText.addModifyListener(modListener);

				Label abbreviationLable = new Label(tokenNameConfigurationGroup, SWT.NONE);
				abbreviationLable.setText("Symbol:");
				symbol = new Text(tokenNameConfigurationGroup, SWT.BORDER);
				symbol.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				GridDataFactory.fillDefaults().span(2, 1).applyTo(tokenNameConfigurationGroup);
				symbol.setMessage("EXT");
				symbol.addModifyListener(modListener);

				final Group tokenAmountConfigurationGroup = new Group(composite, SWT.NONE);
				tokenAmountConfigurationGroup.setText("Token Configuration");
				GridLayoutFactory.fillDefaults().numColumns(2).applyTo(tokenAmountConfigurationGroup);
				GridDataFactory.fillDefaults().grab(true, true).applyTo(tokenAmountConfigurationGroup);

				Label decimalLable = new Label(tokenAmountConfigurationGroup, SWT.NONE);
				decimalLable.setText("Decimals:");
				decimalText = new Text(tokenAmountConfigurationGroup, SWT.BORDER);
				decimalText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				GridDataFactory.fillDefaults().span(2, 1).applyTo(tokenAmountConfigurationGroup);
				decimalText.setMessage("18");
				decimalText.addModifyListener(modListener);

				Label totalSupplyLable = new Label(tokenAmountConfigurationGroup, SWT.NONE);
				totalSupplyLable.setText("Total supply:");
				totalSupplyText = new Text(tokenAmountConfigurationGroup, SWT.BORDER);
				totalSupplyText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
				GridDataFactory.fillDefaults().span(2, 1).applyTo(tokenAmountConfigurationGroup);
				totalSupplyText.setMessage("100000");
				totalSupplyText.addModifyListener(modListener);
				setControl(composite);
			}

			@Override
			public boolean isPageComplete() {
				return super.isPageComplete() && !decimalText.getText().isEmpty() && !symbol.getText().isEmpty()
						&& !totalSupplyText.getText().isEmpty() && !decimalText.getText().isEmpty();
			}
		};
		configurationPage.setTitle("Token Configuration");
		configurationPage.setDescription("Configure your token.");
		addPage(configurationPage);

		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean performFinish() {
		boolean projectCreated = super.performFinish();
		if (projectCreated) {
			int decimal = Integer.parseUnsignedInt(decimalText.getText());
			int supply = Integer.parseUnsignedInt(totalSupplyText.getText());
			NewTokenTemplate template = new NewTokenTemplate(solidityVersion, nameText.getText(), symbol.getText(),
					decimal, supply);
			IProject project = getNewProject();
			try {
				IProjectDescription description = project.getDescription();
				description.setNatureIds(new String[] { "org.eclipse.xtext.ui.shared.xtextNature" });
				project.setDescription(description, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			generateTokenFiles(project, template);
		}
		return true;
	}

	private void generateTokenFiles(IProject project, NewTokenTemplate template) {
		generateFile(project.getFile("SafeMath.sol"), template.generateSafeMath());
		generateFile(project.getFile("Owned.sol"), template.generateOwned());
		generateFile(project.getFile("ERC20Interface.sol"), template.generateERC20());
//		generateFile(project.getFile("ApproveAndCallFallBack.sol"), template.generateApproveAndCallFallBack());
		String name = nameText.getText().replaceAll(" ", "") + "." + fileExtensions;
		generateFile(project.getFile(name), template.generateToken());
	}

	private void generateFile(IFile file, CharSequence content) {
		try (StringInputStream stream = new StringInputStream(content.toString())) {
			file.create(stream, IResource.NONE, null);
			selectAndReveal(file, getWorkbench().getActiveWorkbenchWindow());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New ERC20 Standard Token Project");
		setNeedsProgressMonitor(true);
	}
}
