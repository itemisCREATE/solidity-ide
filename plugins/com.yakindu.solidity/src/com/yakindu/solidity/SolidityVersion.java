package com.yakindu.solidity;

import com.yakindu.solidity.solidity.PragmaVersion;
import com.yakindu.solidity.solidity.PragmaVersionConstraint;
import com.yakindu.solidity.solidity.SolidityFactory;
import com.yakindu.solidity.solidity.VersionOperator;

public interface SolidityVersion {
	public static final String SOLIDITY_VERSION = "solidity_version";
	public static final PragmaVersion DEFAULT_SOLIDITY_VERSION = createDefaultVersion();
	public static final PragmaVersion MIN_SUPPORTED_VERSION = createMinimumVersion();
	
	public static PragmaVersion createDefaultVersion () {
		SolidityFactory factory = SolidityFactory.eINSTANCE;
		final PragmaVersion defaultVersion = factory.createPragmaVersion();
		final PragmaVersionConstraint minorConstraint = factory.createPragmaVersionConstraint();
		minorConstraint.setVersionOperator(VersionOperator.ROOF);
		minorConstraint.setVersion("0.6.9");
		defaultVersion.setMinorConstraint(minorConstraint);
		
		return defaultVersion;
	}
	
	public static PragmaVersion createMinimumVersion () {
		SolidityFactory factory = SolidityFactory.eINSTANCE;
		final PragmaVersion defaultVersion = factory.createPragmaVersion();
		final PragmaVersionConstraint minorConstraint = factory.createPragmaVersionConstraint();
		minorConstraint.setVersionOperator(VersionOperator.ROOF);
		minorConstraint.setVersion("0.6.0");
		defaultVersion.setMinorConstraint(minorConstraint);
		
		return defaultVersion;
	}
}
