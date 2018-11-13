package com.yakindu.solidity.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.ImmutableSet;
import com.yakindu.solidity.solidity.SolidityModel;

@InjectWith(SolidityInjectorProvider.class)
@RunWith(Parameterized.class)
@Parameterized.UseParametersRunnerFactory(XtextParametersRunnerFactory.class)
public class FormatterTest {
	@Inject
	protected ParseHelper<SolidityModel> parseHelper;
	
	@Inject 
	protected ISerializer serializer;
	
	@Inject
	protected ResourceSet set;
	// FIXME
	static Set<String> toFormat = ImmutableSet.of(
			 "my_contract.sol"
	);
	
	static Set<String> expectedResults = ImmutableSet.of(
			"my_contractExpected.sol"
	);
	
	private FormatterTestData testData;
    
	public FormatterTest(FormatterTestData testData) {
		this.testData = testData;
	}
	
	@Test
	public void formatFiles() throws Exception {
		String content = new String(Files.readAllBytes(testData.getFormatPath()));
		SolidityModel model = parseHelper.parse(content, URI.createFileURI(testData.getFormatPath().toAbsolutePath().toString()), set);
		String expectedResult = new String(Files.readAllBytes(testData.getComparePath()));
		String result = serializer.serialize(model, SaveOptions.newBuilder().format().getOptions());
		System.out.println(result.equals(expectedResult));
		assertEquals(expectedResult, result);
	}
	
	@Parameters
	public static Iterable<FormatterTestData> getFilesToFormat() throws IOException {
		File file2 = new File("../../examples/com.yakindu.solidity.examples/formatter/");
		Assert.assertTrue(file2.exists());
		Path baseDir = Paths.get("../../examples/com.yakindu.solidity.examples/formatter/");
		Assert.assertTrue(baseDir.toFile().exists());
		List<Path> filesToFormat = Files.walk(baseDir, new FileVisitOption[0]).filter(f -> f.toString().endsWith(".sol"))
				.filter(p -> toFormat.contains(p.getName(p.getNameCount()-1).toString())).collect(Collectors.toList());
		
		List<Path> filesToCompare = Files.walk(baseDir, new FileVisitOption[0]).filter(f -> f.toString().endsWith(".sol"))
				.filter(p -> expectedResults.contains(p.getName(p.getNameCount()-1).toString())).collect(Collectors.toList());
		
		Set<FormatterTestData> testData = new HashSet<FormatterTestData>();
		
		Assert.assertTrue(filesToFormat.size() == filesToCompare.size());
		
		for (int i = 0; i < filesToFormat.size(); i++) {
			FormatterTestData data = new FormatterTestData(filesToFormat.get(i), filesToCompare.get(i));
			testData.add(data);
		}
		return testData;
	}
}


