package com.yakindu.solidity.compiler;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.yakindu.solidity.compiler.builder.ISolidityCompiler;

public class SolidityCompilerModule implements Module {

	@SuppressWarnings("unchecked")
	@Override
	public void configure(Binder binder) {
		try {
			binder.bind(ISolidityCompiler.class).to((Class<? extends ISolidityCompiler>) Class
					.forName("com.yakindu.solidity.compiler.builder.SolidityCompiler"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
