package com.yakindu.solidity.compiler;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class SolidityCompilerExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return SolidityCompilerActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new SolidityCompilerModule());
	}
}
