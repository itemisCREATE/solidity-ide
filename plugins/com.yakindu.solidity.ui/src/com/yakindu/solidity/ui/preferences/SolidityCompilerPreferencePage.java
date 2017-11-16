package com.yakindu.solidity.ui.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.yakindu.solidity.ui.internal.SolidityActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 */
public class SolidityCompilerPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

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
		addField(new FileFieldEditor(SolidityPreferences.COMPILER_PATH, "Path to solc", composite));
		addField(new BooleanFieldEditor(SolidityPreferences.COMPILER_ENABLED, "Enable solidity compiler", composite));
		addField(new BooleanFieldEditor(SolidityPreferences.COMPILER_OUTPUT_BIN, "Enable solidity bin output",
				composite));
		addField(new BooleanFieldEditor(SolidityPreferences.COMPILER_OUTPUT_AST, "Enable solidity ast output",
				composite));
		addField(new BooleanFieldEditor(SolidityPreferences.COMPILER_OUTPUT_ASM, "Enable solidity asm output",
				composite));
		addField(new BooleanFieldEditor(SolidityPreferences.COMPILER_OUTPUT_ABI, "Enable solidity abi output",
				composite));
		addField(new StringFieldEditor(SolidityPreferences.COMPILER_OUTPUT_PATH, "Compiler output path", composite));
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

	public void init(IWorkbench workbench) {
		setPreferenceStore(SolidityActivator.getInstance().getPreferenceStore());
	}
}
