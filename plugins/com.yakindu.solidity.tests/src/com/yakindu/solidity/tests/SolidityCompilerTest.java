package com.yakindu.solidity.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.model.TestClass;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.yakindu.solidity.solidity.SolidityModel;
import com.yakindu.solidity.validation.SolidityValidator;

@InjectWith(SolidityInjectorProvider.class)
public class SolidityCompilerTest {
	
	@Inject
	protected ParseHelper<SolidityModel> parseHelper;
	
	@Inject
	protected ResourceSet set;
	
	@Inject
	protected Injector injector;
	
	protected ValidatorTester<SolidityValidator> tester;
	
	@Inject
	protected SolidityValidator validator;
	
	@Before
	public void setup() {
		IInjectorProvider injectorProvider = getOrCreateInjectorProvider();
		if (injectorProvider != null) {
			Injector injector = injectorProvider.getInjector();
			if (injector != null)
				injector.injectMembers(this);
		}
		tester = new ValidatorTester<>(validator, injector);
	}
	
	protected IInjectorProvider getOrCreateInjectorProvider() {
		return SolidityInjectorsProvider.getOrCreateInjectorProvider(new TestClass(getClass()));
	}
	
	@After
	public void teardown() {
		tester = null;
	}

	@Test
	public void validateRefFile() throws Exception {
		Path path = getReferenceFile();
		String content = new String(Files.readAllBytes(path));
		
		SolidityModel testModel = parseHelper.parse(content, URI.createFileURI(path.toAbsolutePath().toString()), set);
		
		AssertableDiagnostics validationResult = tester.validate(testModel);
		
		Iterable<Diagnostic> allDiagnostics = validationResult.getAllDiagnostics();
		
		assertNotNull(allDiagnostics);
		assertTrue(allDiagnostics.iterator().hasNext());
	}
	
	public static Path getReferenceFile() throws IOException {
		return Paths.get("../../examples/com.yakindu.solidity.examples/filesWithErrors/shouldContainErrors.sol");
	}
}
