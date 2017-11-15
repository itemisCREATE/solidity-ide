package com.yakindu.solidity

class SolidityStandaloneSetup extends SolidityStandaloneSetupGenerated {

	def static void doSetup() {
		new SolidityStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
