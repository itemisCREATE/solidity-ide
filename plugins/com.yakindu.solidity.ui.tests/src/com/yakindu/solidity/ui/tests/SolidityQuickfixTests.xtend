/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Muelder - Itemis AG - initial API and implementation
 * 	Karsten Thoms   - Itemis AG - initial API and implementation
 * 	Florian Antony  - Itemis AG - initial API and implementation
 * 	committers of YAKINDU 
 * 
 */
package com.yakindu.solidity.ui.tests

import com.google.inject.Inject
import com.google.inject.name.Named
import com.yakindu.solidity.SolidityVersion
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static com.yakindu.solidity.validation.IssueCodes.*

/**
 * This class tests the quickfixes for the solidity ide
 * @author Jonathan Thoene - Initial contribution
 */

@RunWith(XtextRunner)
@InjectWith(SolidityUiInjectorProvider)
class SolidityQuickfixTests extends AbstractQuickfixTest {

	@Inject @Named(SolidityVersion.SOLIDITY_VERSION) String solcVersion

	@Before
	def void setup() {
	}

	@Test
	def void testFixForMissingPayableDeclaration() {
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

	@Test
	def void testFixForMissingSolidityPragma() {
		var modelToFix = '''
			contract MyContract {
			    constructor() public{}
			}
		'''

		var expectedResult = '''
			pragma solidity «solcVersion» ; contract MyContract {
			    constructor() public{}
			}
			
			
		'''
		testQuickfixesOn(
			modelToFix,
			WARNING_FILE_NO_PRAGMA_SOLIDITY,
			new Quickfix("Add default solidity pragma", '''Add solidity pragma «solcVersion».''', expectedResult)
		)
	}

	@Test
	def void testFixForViewModifierInsteadOfPureModifier() {
		var modelToFix1 = '''
			pragma solidity ^0.5.4;
			
			contract Contract {
			    function f() public view returns (uint) {
			        return 0;
			    }
			}
		'''

		var expectedResult1 = '''
			pragma solidity ^0.5.4;
			
			contract Contract {
			    function f() public pure returns (uint) {
			        return 0;
			    }
			}
		'''
		testQuickfixesOn(
			modelToFix1,
			WARNING_FUNCTION_STATE_MUTABILITY_PURE,
			new Quickfix('Use "pure" instead.', 'Use "pure" instead.', expectedResult1)
		)
	}

	@Test
	def void testFixForUnusedParameter() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test(address payable create) pure public returns (uint){
			         return 0;
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test() pure public returns (uint){
			         return 0;
			    }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			WARNING_FUNCTION_UNUSED_PARAMETER,
			new Quickfix('Removed unused parameter declaration', 'Removed unused parameter declaration.',
				expectedResult)
		)
	}

	@Test
	def void testFixForRemovedConstantModifier() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test() constant public returns (uint){
			         return 0;
			    }
			}
		'''

		var expectedResultQuickfix1 = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test() pure public returns (uint){
			         return 0;
			    }
			}
		'''

		var expectedResultQuickfix2 = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test() view public returns (uint){
			         return 0;
			    }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			ERROR_CONSTANT_MODIFIER_WAS_REMOVED,
			new Quickfix('Use "pure" instead.', 'Use "pure" instead.', expectedResultQuickfix1),
			new Quickfix('Use "view" instead.', 'Use "view" instead.', expectedResultQuickfix2)
		)
	}

	@Test
	def void testFixForMethodWithSameNameAsContract() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			    function Test() public {
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			
				constructor () public {
			
				}
			}
			
			
		'''
		testQuickfixesOn(
			modelToFix,
			ERROR_FUNCTION_NAME_EQUALS_CONTRACT_NAME_DISALLOWED,
			new Quickfix('Use constructor keyword instead', 'contructor keyword', expectedResult)
		)
	}

	@Test
	def void testFixForDeprecatedSuicideFunction() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			    address payable creator;
				function kill() public
				   { 
				       if (msg.sender == creator)
				           suicide(creator);
				   }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			    address payable creator;
				function kill() public
				   { 
				       if (msg.sender == creator)
				           selfdestruct(creator);
				   }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			ERROR_DEPRECATED_SUICIDE,
			new Quickfix('Replace with selfdestruct', 'selfdestruct', expectedResult)
		)
	}

	@Test
	def void testFixForUnusedLocalVariable() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {
				function test() pure internal {
				       bytes memory one = abi.encode("test");
				   }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
						
			contract Test {
				function test() pure internal { }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			WARNING_LOCAL_VARIABLE_UNUSED,
			new Quickfix('Remove unused local variable', 'remove unused local variable', expectedResult)
		)
	}

	@Test
	def void testFixForMissingViewModifier() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    constructor () public {
			    }
			    string  signature ="";
			
			    function test() internal returns (string storage){
			       return signature;
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    constructor () public {
			    }
			    string  signature ="";
			
			    function test() internal view returns (string storage){
			       return signature;
			    }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			WARNING_FUNCTION_STATE_MUTABILITY_VIEW,
			new Quickfix('Add \'view\' modifier', 'view function', expectedResult)
		)
	}

	@Test
	def void testFixForMissingFunctionVisibility() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    string  signature ="";
			
			    function test() returns (string memory){
			       return signature;
			    }
			}
		'''

		var expectedResultPublicModifier = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    string  signature ="";
			
			    function test() public returns (string memory){
			       return signature;
			    }
			}
		'''

		var expectedResultPrivateModifier = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    string  signature ="";
			
			    function test() private returns (string memory){
			       return signature;
			    }
			}
		'''

		var expectedResultInternalModifier = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    string  signature ="";
			
			    function test() internal returns (string memory){
			       return signature;
			    }
			}
		'''

		var expectedResultExternalModifier = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    string  signature ="";
			
			    function test() external returns (string memory){
			       return signature;
			    }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			ERROR_NO_VISIBILITY_SPECIFIED,
			new Quickfix('Make this function \'public\'', 'Public function.', expectedResultPublicModifier),
			new Quickfix('Make this function private', 'Private function.', expectedResultPrivateModifier),
			new Quickfix('Make this function \'internal\'', 'Internal function.', expectedResultInternalModifier),
			new Quickfix('Make this function \'external\'', 'External function.', expectedResultExternalModifier)
		)
	}

	@Test
	def void testFixForMissingMemoryKeyword() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    string  signature ="";
			
			    function test() external view returns (string){
			       return signature;
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    string  signature ="";
			
			    function test() external view returns (string memory){
			       return signature;
			    }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			ERROR_DATA_LOCATION_MUST_BE_MEMORY_FOR_RETURN_PARAMETER,
			new Quickfix('Add \'memory\' modifier.', 'Data location must be "memory" here. Add \'memory\' modifier.',
				expectedResult)
		)
	}

	@Test
	def void testFixForMissingCalldataKeyword() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    string  signature ="";
			
			    function test(string other) external view returns (string memory){
			       return signature;
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    string  signature ="";
			
			    function test(string calldata other) external view returns (string memory){
			       return signature;
			    }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			ERROR_DATA_LOCATION_MUST_BE_CALLDATA_FOR_EXTERNAL_PARAMETER,
			new Quickfix('Add \'calldata\' modifier.',
				'Data location must be \"calldata\" for parameter in external function.', expectedResult)
		)
	}

	@Test
	def void testFixForDeprecatedSha3Function() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    function getSHA3Hash(bytes memory input) public returns (bytes32 hashedOutput)
			    {
			        hashedOutput = sha3(input);
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
						
			contract Test {    
			    function getSHA3Hash(bytes memory input) public returns (bytes32 hashedOutput)
			    {
			        hashedOutput = keccak256(input);
			    }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			ERROR_DEPRECATED_SHA3,
			new Quickfix('Replace Sha3 with keccak256', 'keccak256(...) returns (bytes32).', expectedResult)
		)
	}

// TODO: Quickfix for this does not work and needs to be fixed first (method 'replaceVarKeyword'). See issue #299
//	
//	@Test
//	def void testFixForDisallowedKeywordVar() {
//		var modelToFix = '''
//			pragma solidity ^0.5.9;
//						
//			contract Test {
//			    function return0() pure public returns (uint8)
//			    {
//			        var x = 0;
//			        return x;
//			    }
//			}
//		'''
//
//		var expectedResult = '''
//			pragma solidity ^0.5.9;
//						
//			contract Test {
//			    function return0() pure public returns (uint8)
//			    {
//			        uint8 x = 0;
//			        return x;
//			    }
//			}
//		'''
//		testQuickfixesOn(
//			modelToFix,
//			ERROR_VAR_KEYWORD_DISALLOWED,
//			new Quickfix('Inferr type information', 'Inferr type information', expectedResult)
//		)
//	}
	@Test
	def void testFixForDeprecatedThrowExpression() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			    function test() pure public
			    {
			        if (true) { throw; }
			    }
			}
		'''

		var expectedResultForRevert = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			    function test() pure public
			    {
			        if (true) { revert ( "Something bad happened" ) ; }
			    }
			}
		'''

		var expectedResultForAssert = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			    function test() pure public
			    { assert ( true ) ;
			    }
			}
		'''

		var expectedResultForRequire = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			    function test() pure public
			    { require ( true , "Preconditions are not satisfied" ) ;
			    }
			}
		'''
		testQuickfixesOn(
			modelToFix,
			ERROR_THROW_KEYWORD_DISALLOWED,
			new Quickfix('Replace with revert', 'revert(\'Something bad happened\').', expectedResultForRevert),
			new Quickfix('Replace with assert', 'assert(condition)', expectedResultForAssert),
			new Quickfix('Replace with require', 'require(condition, \'Precondition are not met\')',
				expectedResultForRequire)
		)
	}

	@Test
	def void testFixForDeprecatedYearsUnit() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			
			    function test() pure public returns (uint256) {
			        return 5 years;
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			
			    function test() pure public returns (uint256) {
			        return 1825 days;
			    }
			}
		'''

		testQuickfixesOn(
			modelToFix,
			ERROR_YEARS_IS_DISALLOWED,
			new Quickfix('Change years unit denomination to days', 'Change years unit denomination to days',
				expectedResult)
		)
	}

	@Test
	def void testFixForWrongStateMutability() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			
			    function test() pure public returns (uint8) {
			        uint8 payable x = 15;
			        return x;
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
						
			contract Test {
			
			    function test() pure public returns (uint8) {
			        uint8 x = 15;
			        return x;
			    }
			}
		'''

		testQuickfixesOn(
			modelToFix,
			ERROR_STATE_MUTABILITY_ONLY_ALLOWED_FOR_ADDRESS,
			new Quickfix('Remove payable declaration', 'Remove payable declaration', expectedResult)
		)
	}

	@Test
	def void testFixForFunctionNotDeclaredAsPayable() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
						
			contract  Test {
			    uint amount =0;
			    function payme() view public {
			        amount += msg.value;
			    }
			}
		'''

		var expectedResultChangeToPayable = '''
			pragma solidity ^0.5.9;
						
			contract  Test {
			    uint amount =0;
			    function payme() payable public {
			        amount += msg.value;
			    }
			}
		'''

		var expectedResultRemoveView = '''
			pragma solidity ^0.5.9;
						
			contract  Test {
			    uint amount =0;
			    function payme() public {
			        amount += msg.value;
			    }
			}
		'''

		testQuickfixesOn(
			modelToFix,
			ERROR_FUNCTION_DECLARED_AS_VIEW_BUT_MUST_BE_PAYABLE_OR_NON_PAYABLE,
			new Quickfix('Change to "payable".', 'Change to "payable".', expectedResultChangeToPayable),
			new Quickfix('Remove \"view\" and make function non-payable.',
				'Remove \"view\" and make function non-payable.', expectedResultRemoveView)
		)
	}

	@Test
	def void testFixForInterfaceFunctionWithModifier() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
			
			interface TestInterface {
			    
			    modifier testModifier() {
			  	_;
			  	 }
			  	 function test() testModifier external;
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
			
			interface TestInterface {
			    
			    modifier testModifier() {
			  	_;
			  	 }
			  	 function test() external;
			}
		'''

		testQuickfixesOn(
			modelToFix,
			ERROR_INTERFACE_FUNCTIONS_CAN_NOT_HAVE_MODIFIERS,
			new Quickfix('Remove all disallowed modifiers.', 'Remove all disallowed modifiers.', expectedResult)
		)
	}

	@Test
	def void testFixForMissingParameterDataLocationSpecification() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test(bytes data) pure internal returns (uint transactionId)
			    {
			        return 0;
			    }
			}
		'''

		var expectedResultMemory = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test(bytes memory data) pure internal returns (uint transactionId)
			    {
			        return 0;
			    }
			}
		'''

		var expectedResultStorage = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test(bytes storage data) pure internal returns (uint transactionId)
			    {
			        return 0;
			    }
			}
		'''

		testQuickfixesOn(
			modelToFix,
			ERROR_DATA_LOCATION_MUST_BE_STORAGE_OR_MEMORY_FOR_PARAMETER,
			new Quickfix('Add \'memory\' modifier.', 'Data location must be "memory" here. Add \'memory\' modifier.',
				expectedResultMemory),
			new Quickfix('Add \'storage\' modifier.', 'Data location must be "storage" here. Add \'storage\' modifier.',
				expectedResultStorage)
		)
	}

	@Test
	def void testFixForMissingVariableDataLocationSpecification() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test() pure internal returns (uint transactionId)
			    {
			        bytes data;
			        return 0;
			    }
			}
		'''

		var expectedResultMemory = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test() pure internal returns (uint transactionId)
			    {
			        bytes memory data;
			        return 0;
			    }
			}
		'''

		var expectedResultStorage = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test() pure internal returns (uint transactionId)
			    {
			        bytes storage data;
			        return 0;
			    }
			}
		'''

		testQuickfixesOn(
			modelToFix,
			ERROR_DATA_LOCATION_MUST_BE_SPECIFIED_FOR_VARIABLE,
			new Quickfix('Add \'memory\' modifier.', 'Add \'memory\' modifier.',
				expectedResultMemory),
			new Quickfix('Add \'storage\' modifier.', 'Add \'storage\' modifier.',
				expectedResultStorage)
		)
	}
	
	@Test
	def void testFixForMissingReturnParameterDataLocationSpecification() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test(bytes memory data) pure internal returns (bytes transactionId)
			    {
			        return data;
			    }
			}
		'''

		var expectedResultMemory = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test(bytes memory data) pure internal returns (bytes memory transactionId)
			    {
			        return data;
			    }
			}
		'''

		var expectedResultStorage = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    function test(bytes memory data) pure internal returns (bytes storage transactionId)
			    {
			        return data;
			    }
			}
		'''

		testQuickfixesOn(
			modelToFix,
			ERROR_DATA_LOCATION_MUST_BE_MEMORY_OR_STORAGE_FOR_RETURN_PARAMETER,
			new Quickfix('Add \'memory\' modifier.', 'Data location must be "memory" here. Add \'memory\' modifier.',
				expectedResultMemory),
			new Quickfix('Add \'storage\' modifier.', 'Data location must be "storage" here. Add \'storage\' modifier.',
				expectedResultStorage)
		)
	}
	
	@Test
	def void testFixForMissingMemoryModifierForParameter() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    string public name;
			    function setName(string newName) public {
			        name = newName;
			
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    string public name;
			    function setName(string memory newName) public {
			        name = newName;
			
			    }
			}
		'''

		testQuickfixesOn(
			modelToFix,
			ERROR_DATA_LOCATION_MUST_BE_MEMORY_FOR_PARAMETER,
			new Quickfix('Add \'memory\' modifier.', 'Data location must be "memory" here. Add \'memory\' modifier.',
				expectedResult)
		)
	}
	
	@Test
	def void testFixForDeprecatedSendFunction() {
		var modelToFix = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    string public name;
			    function setName(address payable _add) public payable{
					_add.send(msg.value);
			    }
			}
		'''

		var expectedResult = '''
			pragma solidity ^0.5.9;
			
			contract Test {
			    string public name;
			    function setName(address payable _add) public payable{
					_add.transfer(msg.value);
			    }
			}
		'''

		testQuickfixesOn(
			modelToFix,
			WARNING_USSAGE_OF_SEND,
			new Quickfix('Replace send with transfer', 'address.send(amount); -> address.transfer(amount);',
				expectedResult)
		)
	}
}
