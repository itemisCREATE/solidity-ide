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
package com.yakindu.solidity.ui.preferences;

import static com.yakindu.solidity.compiler.preferences.ICompilerPreferences.COMPILER_ENABLED;
import static com.yakindu.solidity.compiler.preferences.ICompilerPreferences.COMPILER_OUTPUT_ABI;
import static com.yakindu.solidity.compiler.preferences.ICompilerPreferences.COMPILER_OUTPUT_ASM;
import static com.yakindu.solidity.compiler.preferences.ICompilerPreferences.COMPILER_OUTPUT_BIN;
import static com.yakindu.solidity.compiler.preferences.ICompilerPreferences.COMPILER_OUTPUT_PATH;
import static com.yakindu.solidity.compiler.preferences.ICompilerPreferences.COMPILER_PATH;

import java.io.File;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import com.yakindu.solidity.compiler.SolidityCompilerActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 */
public class SolidityCompilerPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private FileFieldEditor compilerPathFieldEditor;

	public SolidityCompilerPreferencePage() {
		super(GRID);
		setDescription("Change solidity compiler options");
	}

	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		addFields(parent);
	}

	protected void addFields(Composite parent) {
		Composite main = createPageLayout(parent);
		createCompilerSettings(main);
	}

	protected void createCompilerSettings(Composite parent) {
		Composite composite = createGroupComposite(parent, "Solc compiler");
		compilerPathFieldEditor = new FileFieldEditor(COMPILER_PATH, "Path to solc", composite);
		addField(compilerPathFieldEditor);
		addField(new BooleanFieldEditor(COMPILER_ENABLED, "Enable solidity compiler", composite));
		addField(new BooleanFieldEditor(COMPILER_OUTPUT_BIN, "Enable solidity bin output", composite));
		addField(new BooleanFieldEditor(COMPILER_OUTPUT_ASM, "Enable solidity asm output", composite));
		addField(new BooleanFieldEditor(COMPILER_OUTPUT_ABI, "Enable solidity abi output", composite));
		addField(new StringFieldEditor(COMPILER_OUTPUT_PATH, "Compiler output path", composite));
	}

	protected Composite createPageLayout(Composite parent) {
		Composite main = new Composite(parent, SWT.NULL);
		main.setLayout(new GridLayout());
		main.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		return main;
	}

	protected Composite createGroupComposite(Composite parent, String title) {
		Group group = new Group(parent, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setLayout(new GridLayout(3, false));
		Composite composite = new Composite(group, SWT.NONE);
		GridLayout gridLayout = new GridLayout(3, false);
		composite.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		composite.setLayoutData(gridData);
		group.setText(title);
		return composite;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals("field_editor_value") && event.getSource().equals(compilerPathFieldEditor)) {
			validateFile();
		}
		super.propertyChange(event);
	}

	private void validateFile() {
		String pathToSolc = compilerPathFieldEditor.getStringValue();
		if (pathToSolc == null || pathToSolc.isEmpty()) {
			return;
		}
		File file = new File(pathToSolc);
		if (file.exists() && file.isFile() && file.canExecute()
				&& (file.getName().contains("solc") || file.getName().contains("solcjs"))) {
			if (file.getName().contains("solcjs")) {
				setMessage("Use of 'solcjs' is discuraged!", DialogPage.WARNING);
			}
		} else {
			setValid(false);
			setErrorMessage("Path must point to 'solc' or 'solcjs' executable");
		}
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(new ScopedPreferenceStore(InstanceScope.INSTANCE, SolidityCompilerActivator.PLUGIN_ID));
	}
}
