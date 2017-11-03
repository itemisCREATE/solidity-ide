package com.yakindu.solidity.ide.builder.processor;

public enum CompileOutputType {

	BINARY(".bin"), AST(".ast"), ASM(".asm"), ABI(".abi");

	public final String EXTENSION;

	CompileOutputType(String fileExtension) {
		this.EXTENSION = fileExtension;
	}

	public static CompileOutputType getTypeForTrigger(String trigger) {
		if (trigger.startsWith("Contract JSON ABI")) {
			return CompileOutputType.ABI;
		} else if (trigger.startsWith("Binary:")) {
			return CompileOutputType.BINARY;
		} else if (trigger.startsWith("Syntax trees:") || trigger.startsWith("JSON AST (compact format):")) {
			return CompileOutputType.AST;
		} else if (trigger.startsWith("EVM assembly:")) {
			return CompileOutputType.ASM;
		}
		return null;
	}
}
