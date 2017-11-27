package com.yakindu.solidity.ui.preferences;

import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.preferences.AbstractPreferencePage;

/**
 * Prefernce page for Code Folding.
 * 
 * @author Karsten Thoms - Initial contribution and API
 */
public class FoldingPreferences extends AbstractPreferencePage {
	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		
		RadioGroupFieldEditor autoFoldCommentChoice = new RadioGroupFieldEditor(
				SolidityPreferences.FOLDING_COMMENT_AUTOFOLD
				, "Auto-fold comments"
				, 1
				, new String[][] {
					 {"None", SolidityPreferences.FOLDING_COMMENT_AUTOFOLD_NONE}
					,{"Only header comment", SolidityPreferences.FOLDING_COMMENT_AUTOFOLD_HEADER}
					,{"All", SolidityPreferences.FOLDING_COMMENT_AUTOFOLD_ALL}
				}
				, parent);
		addField(autoFoldCommentChoice);
		
		IntegerFieldEditor longCommentLineCount = new IntegerFieldEditor(
				SolidityPreferences.FOLDING_COMMENT_LINECOUNT
				, "Enable folding for comments exceeding line count"
				, parent);
		addField(longCommentLineCount);
	}

}
