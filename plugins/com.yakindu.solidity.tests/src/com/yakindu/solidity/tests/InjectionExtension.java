/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	 Andreas Muelder - Itemis AG - initial API and implementation
 * 	 Karsten Thoms   - Itemis AG - initial API and implementation
 *   Florian Antony  - Itemis AG - initial API and implementation
 * 	 committers of YAKINDU 
 * 
 */
package com.yakindu.solidity.tests;

import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.IRegistryConfigurator;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.google.inject.Injector;

/**
 * @author Karsten Thoms - Initial contribution and API
 */
public class InjectionExtension implements BeforeAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {
	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
//		IInjectorProvider injectorProvider = getOrCreateInjectorProvider(context);
//		if (injectorProvider != null) {
//			Injector injector = injectorProvider.getInjector();
//			if (injector != null)
//				injector.injectMembers(context.getRequiredTestInstance());
//		}
	}

	@Override
	public void beforeTestExecution(ExtensionContext context) throws Exception {
		IInjectorProvider injectorProvider = getOrCreateInjectorProvider(context);
		if (injectorProvider instanceof IRegistryConfigurator) {
			final IRegistryConfigurator registryConfigurator = (IRegistryConfigurator) injectorProvider;
			registryConfigurator.setupRegistry();
		}
		if (injectorProvider != null) {
			Injector injector = injectorProvider.getInjector();
			if (injector != null)
				injector.injectMembers(context.getRequiredTestInstance());
		}
	}

	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception {
		IInjectorProvider injectorProvider = getOrCreateInjectorProvider(context);
		if (injectorProvider instanceof IRegistryConfigurator) {
			final IRegistryConfigurator registryConfigurator = (IRegistryConfigurator) injectorProvider;
			registryConfigurator.restoreRegistry();
		}
	}


	protected IInjectorProvider getOrCreateInjectorProvider(ExtensionContext context) {
		return InjectorProviders.getOrCreateInjectorProvider(context);
	}

	protected IInjectorProvider getInjectorProvider(ExtensionContext context) {
		return InjectorProviders.getInjectorProvider(context);
	}

	protected IInjectorProvider createInjectorProvider(ExtensionContext context) {
		return InjectorProviders.createInjectorProvider(context);
	}

}
