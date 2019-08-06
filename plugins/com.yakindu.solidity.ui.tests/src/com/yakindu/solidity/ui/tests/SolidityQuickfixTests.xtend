package com.yakindu.solidity.ui.tests

import org.eclipse.xtext.ui.testing.AbstractQuickfixTest
import org.junit.Before
import org.junit.Test

import static com.yakindu.solidity.validation.IssueCodes.*
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith

@RunWith(XtextRunner)
@InjectWith(SolidityUiInjectorProvider)
class SolidityQuickfixTests extends AbstractQuickfixTest {

	@Before
	def void setup() {
	}

	@Test
	def void fixNotSolidityDefaultVersion() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
			
			contract MyContract {
			    address creator;
			
			    constructor() public{
			        creator = msg.sender;
			    }
			
			    // TODO Add functions
			
			    function kill() public {
			        if (msg.sender == creator) {
			            selfdestruct(creator);
			        }
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
			
			contract MyContract {
			    address payable creator;
			
			    constructor() public{
			        creator = msg.sender;
			    }
			
			    // TODO Add functions
			
			    function kill() public {
			        if (msg.sender == creator) {
			            selfdestruct(creator);
			        }
			    }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			ERROR_INVALID_IMPLICID_CONVERSION_TO_ADDRESS_PAYABLE,
			new Quickfix("Add payable to declaration", "Add payable to declaration", expectedResult)
		)
	}
}
