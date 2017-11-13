package com.yakindu.solidity.compiler.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;

public interface ISolidityCompiler {

	public void compile(IFile file, IProgressMonitor progress);
}
