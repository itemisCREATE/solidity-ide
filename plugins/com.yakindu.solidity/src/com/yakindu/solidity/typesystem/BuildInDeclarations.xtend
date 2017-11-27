package com.yakindu.solidity.typesystem

import com.google.inject.Inject
import com.yakindu.solidity.solidity.FunctionModifier
import com.yakindu.solidity.solidity.SolidityFactory
import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.AbstractTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.types.Operation
import com.yakindu.solidity.solidity.ContractDefinition

/**
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 */
@Accessors(PUBLIC_GETTER)
class BuildInDeclarations {

	ITypeSystem typeSystem
	
	boolean installed
	Operation assert_
	Operation require
	Operation revert
	Operation addmod
	Operation mulmod
	Operation keccak256
	Operation sha3
	Operation sha256
	Operation ripemd160
	Operation ecrecover
	Operation suicide
	Operation selfdestruct
	Property msg
	Property this_
	Property super_
	Property now
	Property tx
	Property block
	Property length
	Operation push
	ContractDefinition owned
	ContractDefinition mortal
	
	
	def create new ArrayList<EObject>() superContracts() {
		addAll(#[owned, mortal])
	}

	@Inject
	new (ITypeSystem typeSystem, TypesFactory typesFactory, SolidityFactory solidityFactory) {
		/************************
		 *     ERROR HANDLING 
		 ************************/
		
		
		assert_ = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.BOOL)
				]
				name = "condition"
			]
			name = "assert"
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.VOID)
			]
		]
	
		require = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.BOOL)
				]
				name = "condition"
			]
			name = "require"
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.VOID)
			]
		]
	
		revert = typesFactory.createOperation() => [
			name = "revert"
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.VOID)
			]
		]
	
		/************************
		 *     MATH and CRYPTO
		 ************************/
		addmod = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "x"
			]
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "y"
			]
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "k"
			]
			name = "addmod"
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.UINT)
			]
	
		]
	
		mulmod = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "x"
			]
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "y"
			]
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "k"
			]
			name = "mulmod"
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.UINT)
			]
	
		]
	
		keccak256 = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ANY)
				]
				name = "argument"
				varArgs = true
			]
			name = "keccak256"
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BYTES32)
			]
	
		]
	
		sha256 = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ANY)
				]
				name = "argument"
				varArgs = true
			]
			name = "sha256"
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BYTES32)
			]
	
		]
	
		sha3 = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ANY)
				]
				name = "argument"
				varArgs = true
			]
			name = "sha3"
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BYTES32)
			]
	
		]
	
		ripemd160 = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ANY)
				]
				varArgs = true
				name = "argument"
			]
			name = "ripemd160"
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BYTES20)
			]
	
		]
	
		ecrecover = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.BYTES32)
				]
				name = "hash"
			]
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT8)
				]
				name = "v"
			]
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.BYTES32)
				]
				name = "r"
			]
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.BYTES32)
				]
				name = "s"
			]
			name = "ecrecover"
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
			]
	
		]
	
		now = typesFactory.createProperty => [
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.UINT)
			]
			name = "now"
			const = true
			readonly = true
		]
	
		this_ = typesFactory.createProperty => [
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
			]
			name = "this"
			const = true
			readonly = true
		]
	
		super_ = typesFactory.createProperty => [
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.ANY)
			]
			name = "super"
			const = true
			readonly = true
		]
	
		suicide = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
				]
				name = "address"
			]
			name = "suicide"
		]
	
		selfdestruct = typesFactory.createOperation() => [
			parameters += typesFactory.createParameter => [
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
				]
				name = "address"
			]
			name = "selfdestruct"
		]
	
		msg = typesFactory.createProperty() => [
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.MESSAGE)
			]
			name = "msg"
			const = true
			readonly = true
		]
	
		tx = typesFactory.createProperty() => [
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.TRANSACTION)
			]
			name = "tx"
			const = true
			readonly = true
		]
	
		block = typesFactory.createProperty() => [
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BLOCK)
			]
			name = "block"
			const = true
			readonly = true
		]
	
		length = typesFactory.createProperty() => [
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.INT)
			]
			name = "length"
		]
	
		push = typesFactory.createOperation() => [
			typeSpecifier = typesFactory.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.INT)
			]
			parameters += typesFactory.createParameter() => [
				name = "element"
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ANY)
				]
			]
			name = "push"
		]
	
		owned = solidityFactory.createContractDefinition() => [
			name = "owned"
			features += solidityFactory.createVariableDefinition() => [
				name = "owner"
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
				]
			]
			features += solidityFactory.createFunctionDefinition() => [
				name = "owned"
				modifier += solidityFactory.createBuildInModifier() => [
					type = FunctionModifier.PUBLIC
				]
			]
			features += solidityFactory.createModifierDefinition() => [
				name = "onlyOwner"
			]
	
		]
	
		mortal = solidityFactory.createContractDefinition() => [
			name = "mortal"
			superTypes += owned
			features += solidityFactory.createFunctionDefinition() => [
				name = "close"
				modifier += solidityFactory.createBuildInModifier() => [
					type = FunctionModifier.PUBLIC
				]
				modifier += solidityFactory.createModifierInvocation() => [
					reference = solidityFactory.createModifierDefinition() => [
						name = "onlyOwner"
					]
				]
			]
		]
		
		all.forEach[(typeSystem as AbstractTypeSystem).resource.contents += it]
	}
	
	def all(){
	#[msg, assert_, require, revert, addmod, mulmod, keccak256, sha3, sha256,  length, push,
		ripemd160, ecrecover, block, suicide, selfdestruct, this_, super_, now, tx, owned, mortal]	
	}
}
