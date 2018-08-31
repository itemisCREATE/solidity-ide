package com.yakindu.solidity.tests;

import java.util.List;

import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.parameterized.ParametersRunnerFactory;
import org.junit.runners.parameterized.TestWithParameters;

import com.google.inject.Injector;

public class XtextParametersRunnerFactory implements ParametersRunnerFactory {

	@Override
	public Runner createRunnerForTestWithParameters(TestWithParameters test) throws InitializationError {
		return new ParameterizedXtextRunner(test);
	}

	public static class ParameterizedXtextRunner extends XtextRunner {

		protected List<Object> parameters;

		ParameterizedXtextRunner(TestWithParameters test) throws InitializationError {
			super(test.getTestClass().getJavaClass());
			parameters = test.getParameters();
		}

		@Override
		protected Object createTest() throws Exception {
			Object object = getTestClass().getOnlyConstructor().newInstance(parameters.toArray());
			IInjectorProvider injectorProvider = getOrCreateInjectorProvider();
			if (injectorProvider != null) {
				Injector injector = injectorProvider.getInjector();
				if (injector != null)
					injector.injectMembers(object);
			}
			return object;
		}

		protected void validateConstructor(List<Throwable> errors) {
			validateOnlyOneConstructor(errors);
		}

	}

}
