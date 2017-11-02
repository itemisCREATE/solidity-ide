package com.yakindu.solidity.ide.builder;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Florian Antony - Initial contribution and API
 */
public class SolidityBuilder extends IncrementalProjectBuilder {
	public static final String ID = "com.yakindu.solidity.ide.builder.solidityBuilder";

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		System.out.println("TODO Create Builder");
		return null;
	}

}
