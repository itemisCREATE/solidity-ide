package com.yakindu.solidity.compiler.builder;

import com.yakindu.solidity.compiler.builder.SolidityCompilerBase;

/**
 * @author Florian Antony - Initial contribution and API
 */
public class SolidityCompiler extends SolidityCompilerBase {

	@Override
	protected String getFallbackCompilerPath() {
		return getClass().getProtectionDomain().getCodeSource().getLocation().getFile() + "/compiler/solc";
	}
}
