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
			binder.bind(ISolidityCompiler.class).to((Class<? extends ISolidityCompiler>) Class
					.forName("com.yakindu.solidity.compiler.builder.SolidityCompiler"));
			binder.bind(IPreferenceStore.class)
					.toInstance((IPreferenceStore) SolidityActivator.getInstance().getPreferenceStore());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
