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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.yakindu.solidity.solidity.SolidityModel;

/**
 * This test reads all .sol files from project com.yakindu.solidity.examples and
 * parses and validates them.
 * 
 * @author Karsten Thoms
 */
@ExtendWith(InjectionExtension.class)
@InjectWith(SolidityInjectorProvider.class)
public class ReferenceExamplesTest {
	@Inject
	ParseHelper<SolidityModel> parseHelper;
	@Inject
	ValidationTestHelper validationHelper;
	@Inject
	ResourceSet set;

	// FIXME
	static Set<String> toFix = Stream.of(
			  "ether-router.sol"
			, "ico.sol"
			, "moduleHandler.sol"
			, "schelling.sol"
			, "LMSRMarketMaker.sol"
			, "StandardMarket.sol"
			, "UltimateOracle.sol"
			, "MilestoneTracker.sol"
			, "MultiSigWallet.sol"
			, "MultiSigWalletWithDailyLimit.sol"
			, "strings.sol"
			, "Bounty.sol"
			, "RefundableCrowdsale.sol"
			, "MultisigWallet.sol" // double?
			, "VestedToken.sol"
	).collect(Collectors.toSet());

	@ParameterizedTest
	@MethodSource("getReferenceFiles")
	public void test_parseReferenceFile(Path path) throws Exception {
		String content = new String(Files.readAllBytes(path));
		SolidityModel model = parseHelper.parse(content, URI.createFileURI(path.toAbsolutePath().toString()), set);
		Assert.assertNotNull("Could not load model " + path, model);
		validationHelper.assertNoErrors(model);
	}

	@SuppressWarnings("unused")
	private static Stream<Path> getReferenceFiles() throws IOException {
		Path baseDir = Paths.get("../../examples/com.yakindu.solidity.examples");
		assertTrue(baseDir.toFile().exists());
		return Files.walk(baseDir, new FileVisitOption[0]).filter(f -> f.toString().endsWith(".sol"))
				.filter(p -> !toFix.contains(p.getName(p.getNameCount()-1).toString()));
	}
}
