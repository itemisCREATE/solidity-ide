package com.yakindu.solidity.ide.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.SubMonitor;

public interface ISolidityCompiler {

	public void compile(IFile file, SubMonitor progress);
}
