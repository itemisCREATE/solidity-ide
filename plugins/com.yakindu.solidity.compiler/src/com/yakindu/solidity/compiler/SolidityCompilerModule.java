package com.yakindu.solidity.compiler;

import org.eclipse.jface.preference.IPreferenceStore;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.yakindu.solidity.compiler.builder.ISolidityCompiler;
import com.yakindu.solidity.ui.internal.SolidityActivator;

public class SolidityCompilerModule implements Module {

	@SuppressWarnings("unchecked")
	@Override
	public void configure(Binder binder) {
		try {
			// try to instantiate platform specific implementation
			// will fail currently on Mac, thus the binding does not happen there
			Class<? extends ISolidityCompiler> solidityCompilerClass = (Class<? extends ISolidityCompiler>) Class
					.forName("com.yakindu.solidity.compiler.builder.SolidityCompiler");
			binder.bind(ISolidityCompiler.class).to(solidityCompilerClass);
		} catch (ClassNotFoundException e) {
			System.err.println("SolidityCompilerModule: " + e.getMessage());
		}
		binder.bind(IPreferenceStore.class)
				.toInstance((IPreferenceStore) SolidityActivator.getInstance().getPreferenceStore());
	}
}
