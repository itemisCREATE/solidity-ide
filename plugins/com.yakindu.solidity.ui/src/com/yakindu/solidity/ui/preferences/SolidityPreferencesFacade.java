package com.yakindu.solidity.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import com.google.inject.Inject;

/**
 * 
 * @author Thomas Kutz - Initial contribution and API
 *
 */
public class SolidityPreferencesFacade {

	@Inject
	private IPreferenceStore store;
	
	public boolean isWriteASTFile() {
		return store.getBoolean(SolidityPreferences.COMPILER_OUTPUT_AST);
	}
	
	public boolean isWriteABIFile() {
		return store.getBoolean(SolidityPreferences.COMPILER_OUTPUT_ABI);
	}
	
	public boolean isWriteASMFile() {
		return store.getBoolean(SolidityPreferences.COMPILER_OUTPUT_ASM);
	}
	
	public boolean isWriteBINFile() {
		return store.getBoolean(SolidityPreferences.COMPILER_OUTPUT_BIN);
	}
	
	public String getCompilerOutputPath() {
		return store.getString(SolidityPreferences.COMPILER_OUTPUT_PATH);
	}
	
	public String getCompilerPath() {
		return store.getString(SolidityPreferences.COMPILER_PATH);
	}
	
	public boolean isCompilerEnabled() {
		return store.getBoolean(SolidityPreferences.COMPILER_ENABLED);
	}
}
