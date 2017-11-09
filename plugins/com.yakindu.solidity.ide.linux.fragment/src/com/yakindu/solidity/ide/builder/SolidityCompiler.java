package com.yakindu.solidity.ide.builder;

public class SolidityCompiler extends SolidityCompilerBase {

	@Override
	protected String getCompiler() {
		return getClass().getProtectionDomain().getCodeSource().getLocation().getFile() + "/compiler/solc";
	}
}
