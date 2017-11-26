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
	new (ITypeSystem typeSystem) {
		/************************
		 *     ERROR HANDLING 
		 ************************/
		
		
		assert_ = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.BOOL)
				]
				name = "condition"
			]
			name = "assert"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.VOID)
			]
		]
	
		require = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.BOOL)
				]
				name = "condition"
			]
			name = "require"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.VOID)
			]
		]
	
		revert = TypesFactory.eINSTANCE.createOperation() => [
			name = "revert"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.VOID)
			]
		]
	
		/************************
		 *     MATH and CRYPTO
		 ************************/
		addmod = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "x"
			]
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "y"
			]
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "k"
			]
			name = "addmod"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.UINT)
			]
	
		]
	
		mulmod = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "x"
			]
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "y"
			]
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT)
				]
				name = "k"
			]
			name = "mulmod"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.UINT)
			]
	
		]
	
		keccak256 = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ANY)
				]
				name = "argument"
				varArgs = true
			]
			name = "keccak256"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BYTES32)
			]
	
		]
	
		sha256 = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ANY)
				]
				name = "argument"
				varArgs = true
			]
			name = "sha256"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BYTES32)
			]
	
		]
	
		sha3 = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ANY)
				]
				name = "argument"
				varArgs = true
			]
			name = "sha3"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BYTES32)
			]
	
		]
	
		ripemd160 = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ANY)
				]
				varArgs = true
				name = "argument"
			]
			name = "ripemd160"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BYTES20)
			]
	
		]
	
		ecrecover = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.BYTES32)
				]
				name = "hash"
			]
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.UINT8)
				]
				name = "v"
			]
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.BYTES32)
				]
				name = "r"
			]
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.BYTES32)
				]
				name = "s"
			]
			name = "ecrecover"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
			]
	
		]
	
		now = TypesFactory.eINSTANCE.createProperty => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.UINT)
			]
			name = "now"
			const = true
			readonly = true
		]
	
		this_ = TypesFactory.eINSTANCE.createProperty => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
			]
			name = "this"
			const = true
			readonly = true
		]
	
		super_ = TypesFactory.eINSTANCE.createProperty => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.ANY)
			]
			name = "super"
			const = true
			readonly = true
		]
	
		suicide = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
				]
				name = "address"
			]
			name = "suicide"
		]
	
		selfdestruct = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
				]
				name = "address"
			]
			name = "selfdestruct"
		]
	
		msg = TypesFactory.eINSTANCE.createProperty() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.MESSAGE)
			]
			name = "msg"
			const = true
			readonly = true
		]
	
		tx = TypesFactory.eINSTANCE.createProperty() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.TRANSACTION)
			]
			name = "tx"
			const = true
			readonly = true
		]
	
		block = TypesFactory.eINSTANCE.createProperty() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BLOCK)
			]
			name = "block"
			const = true
			readonly = true
		]
	
		length = TypesFactory.eINSTANCE.createProperty() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.INT)
			]
			name = "length"
		]
	
		push = TypesFactory.eINSTANCE.createOperation() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.INT)
			]
			parameters += TypesFactory.eINSTANCE.createParameter() => [
				name = "element"
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ANY)
				]
			]
			name = "push"
		]
	
		owned = SolidityFactory.eINSTANCE.createContractDefinition() => [
			name = "owned"
			features += SolidityFactory.eINSTANCE.createVariableDefinition() => [
				name = "owner"
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
				]
			]
			features += SolidityFactory.eINSTANCE.createFunctionDefinition() => [
				name = "owned"
				modifier += SolidityFactory.eINSTANCE.createBuildInModifier() => [
					type = FunctionModifier.PUBLIC
				]
			]
			features += SolidityFactory.eINSTANCE.createModifierDefinition() => [
				name = "onlyOwner"
			]
	
		]
	
		mortal = SolidityFactory.eINSTANCE.createContractDefinition() => [
			name = "mortal"
			superTypes += owned
			features += SolidityFactory.eINSTANCE.createFunctionDefinition() => [
				name = "close"
				modifier += SolidityFactory.eINSTANCE.createBuildInModifier() => [
					type = FunctionModifier.PUBLIC
				]
				modifier += SolidityFactory.eINSTANCE.createModifierInvocation() => [
					reference = SolidityFactory.eINSTANCE.createModifierDefinition() => [
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
