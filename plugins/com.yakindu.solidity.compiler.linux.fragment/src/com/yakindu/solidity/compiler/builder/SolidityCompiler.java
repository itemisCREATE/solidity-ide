package com.yakindu.solidity.compiler.builder;

import org.eclipse.core.runtime.Path;

import com.yakindu.solidity.compiler.builder.SolidityCompilerBase;

/**
 * @author Florian Antony - Initial contribution and API
 */
public class SolidityCompiler extends SolidityCompilerBase {

	@Override
	protected Path getPath() {
		return new Path("compiler/solc");
	}

}
