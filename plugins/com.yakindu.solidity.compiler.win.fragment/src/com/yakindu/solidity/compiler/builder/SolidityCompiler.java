package com.yakindu.solidity.compiler.builder;

import com.yakindu.solidity.compiler.builder.SolidityCompilerBase;

public class SolidityCompiler extends SolidityCompilerBase {

	@Override
	protected String getCompiler() {
		return getClass().getProtectionDomain().getCodeSource().getLocation().getFile() + "/compiler/solc.exe";
	}
}
