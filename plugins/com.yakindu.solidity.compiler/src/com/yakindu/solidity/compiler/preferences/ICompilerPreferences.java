/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - Itemis AG - initial API and implementation
 * 
 */
package com.yakindu.solidity.compiler.preferences;

import java.util.Optional;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

import com.google.inject.ImplementedBy;
import com.yakindu.solidity.compiler.SolidityCompilerActivator;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 */
@ImplementedBy(ICompilerPreferences.DefaultPreferences.class)
public interface ICompilerPreferences {

	String COMPILER_ENABLED = "compiler.enabled";
	String COMPILER_PATH = "compiler.path";

	String COMPILER_OUTPUT_BIN = "compiler.output.bin";
	String COMPILER_OUTPUT_ABI = "compiler.output.abi";
	String COMPILER_OUTPUT_ASM = "compiler.output.asm";
	String COMPILER_OUTPUT_GAS = "compiler.output.gas";
	String COMPILER_OUTPUT_PATH = "compiler.output.path";

	boolean isWriteABIFile();

	boolean isWriteASMFile();

	boolean isWriteBINFile();

	String getCompilerOutputPath();

	Optional<String> getCompilerPath();

	boolean isCompilerEnabled();

	/**
	 * 
	 * @author Thomas Kutz - Initial contribution and API
	 *
	 */
	public static class DefaultPreferences implements ICompilerPreferences {

		@Override
		public boolean isWriteABIFile() {
			return getPreferences().getBoolean(COMPILER_OUTPUT_ABI, false);
		}

		@Override
		public boolean isWriteASMFile() {
			return getPreferences().getBoolean(COMPILER_OUTPUT_ASM, false);
		}

		@Override
		public boolean isWriteBINFile() {
			return getPreferences().getBoolean(COMPILER_OUTPUT_BIN, false);
		}

		@Override
		public String getCompilerOutputPath() {
			return getPreferences().get(COMPILER_OUTPUT_PATH, "bin");
		}

		@Override
		public Optional<String> getCompilerPath() {
			String string = getPreferences().get(COMPILER_PATH, "");
			if (string.isEmpty())
				return Optional.empty();
			return Optional.of(string);
		}

		@Override
		public boolean isCompilerEnabled() {
			return getPreferences().getBoolean(COMPILER_ENABLED, true);
		}

		public IEclipsePreferences getPreferences() {
			return InstanceScope.INSTANCE.getNode(SolidityCompilerActivator.PLUGIN_ID);
		}
	}

}