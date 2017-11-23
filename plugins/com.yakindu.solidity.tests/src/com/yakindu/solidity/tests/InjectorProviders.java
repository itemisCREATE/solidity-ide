package com.yakindu.solidity.tests;

import static org.eclipse.xtext.util.Exceptions.throwUncheckedException;

import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * Maintains a map of injector provider types to their instance.
 * 
 * Clients will usually use {@link #getOrCreateInjectorProvider(TestClass)} to obtain
 * an valid injector provider in the context of a given {@link TestClass}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InjectorProviders {

	private static ClassToInstanceMap<IInjectorProvider> injectorProviderClassCache = MutableClassToInstanceMap.create();
	
	public static IInjectorProvider getOrCreateInjectorProvider(ExtensionContext context) {
		InjectWith injectWith = context.getRequiredTestClass().getAnnotation(InjectWith.class);
		if (injectWith != null) {
			Class<? extends IInjectorProvider> klass = injectWith.value();
			IInjectorProvider injectorProvider = injectorProviderClassCache.get(klass);
			if (injectorProvider == null) {
				try {
					injectorProvider = klass.newInstance();
					injectorProviderClassCache.put(klass, injectorProvider);
				} catch (Exception e) {
					throwUncheckedException(e);
				}
			}
			return injectorProvider;
		}
		return null;
	}

	public static IInjectorProvider getInjectorProvider(ExtensionContext context) {
		InjectWith injectWith = context.getRequiredTestClass().getAnnotation(InjectWith.class);
		if (injectWith != null) {
			return injectorProviderClassCache.get(injectWith.value());
		}
		return null;
	}

	public static IInjectorProvider createInjectorProvider(ExtensionContext context) {
		InjectWith injectWith = context.getRequiredTestClass().getAnnotation(InjectWith.class);
		if (injectWith != null) {
			try {
				return injectWith.value().newInstance();
			} catch (Exception e) {
				throwUncheckedException(e);
			}
		}
		return null;
	}

}