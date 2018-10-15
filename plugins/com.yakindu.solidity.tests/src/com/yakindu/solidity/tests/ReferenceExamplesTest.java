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

import static com.google.common.collect.Iterables.isEmpty;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.yakindu.solidity.solidity.SolidityModel;

/**
 * This test reads all .sol files from project com.yakindu.solidity.examples and
 * parses and validates them.
 * 
 * @author Karsten Thoms
 */
@InjectWith(SolidityInjectorProvider.class)
@RunWith(Parameterized.class)
@Parameterized.UseParametersRunnerFactory(XtextParametersRunnerFactory.class)
public class ReferenceExamplesTest {
	
	@Inject
	protected ParseHelper<SolidityModel> parseHelper;
	@Inject
	protected ValidationTestHelper validationHelper;
	@Inject
	protected ResourceSet set;
	// FIXME
	static Set<String> toFix = ImmutableSet.of(
			 "ico.sol"
			, "LMSRMarketMaker.sol"
			, "StandardMarket.sol"
			, "UltimateOracle.sol"
			, "MilestoneTracker.sol"
			, "MultiSigWallet.sol"
			, "MultiSigWalletWithDailyLimit.sol"
			, "RefundableCrowdsale.sol"
			, "MultisigWallet.sol"
			, "VestedToken.sol"
			, "73_named_parameter_calls.sol"
			, "179_gas_value.sol"
			
	);

	
	private Path path;
	    
	public ReferenceExamplesTest(Path path) {
		this.path = path;
	}

	@Test
	public void parseReferenceFile() throws Exception {
		String content = new String(Files.readAllBytes(path));
		SolidityModel model = parseHelper.parse(content, URI.createFileURI(path.toAbsolutePath().toString()), set);
		Assert.assertNotNull("Could not load model " + path, model);
		Iterable<Issue> issues = Iterables.filter(validationHelper.validate(model), new Predicate<Issue>() {
			@Override
			public boolean apply(Issue input) {
				return Severity.ERROR == input.getSeverity();
			}
		});
		if (!isEmpty(issues))
			fail("Errors in resource: " + path + ": " + issues);
	
	}
	 @Parameters
	public static Iterable<Path> getReferenceFiles() throws IOException {
		Path baseDir = Paths.get("../../examples/com.yakindu.solidity.examples");
		Assert.assertTrue(baseDir.toFile().exists());
		return Files.walk(baseDir, new FileVisitOption[0]).filter(f -> f.toString().endsWith(".sol"))
				.filter(p -> !toFix.contains(p.getName(p.getNameCount()-1).toString())).collect(Collectors.toList());
	}
}
