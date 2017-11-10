package com.yakindu.solidity.typesystem

import com.google.inject.Inject
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.AbstractTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 */
class BuildInDeclarations {

	@Inject
	ITypeSystem typeSystem

	/************************
	 *     ERROR HANDLING 
	 ************************/
	def createAssert() {
		val assert = TypesFactory.eINSTANCE.createOperation() => [
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
		(typeSystem as AbstractTypeSystem).resource.contents += assert
		assert
	}

	def createRequire() {
		val require = TypesFactory.eINSTANCE.createOperation() => [
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
		(typeSystem as AbstractTypeSystem).resource.contents += require
		require
	}

	def createRevert() {
		val revert = TypesFactory.eINSTANCE.createOperation() => [
			name = "revert"
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.VOID)
			]
		]
		(typeSystem as AbstractTypeSystem).resource.contents += revert
		revert
	}

	/************************
	 *     MATH and CRYPTO
	 ************************/
	def createAddmod() {
		val addmod = TypesFactory.eINSTANCE.createOperation() => [
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
		(typeSystem as AbstractTypeSystem).resource.contents += addmod
		addmod
	}

	def createMulmod() {
		val addmod = TypesFactory.eINSTANCE.createOperation() => [
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
		(typeSystem as AbstractTypeSystem).resource.contents += addmod
		addmod
	}

	def createKeccak256() {
		val keccak256 = TypesFactory.eINSTANCE.createOperation() => [
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
		(typeSystem as AbstractTypeSystem).resource.contents += keccak256
		keccak256
	}

	def createSha256() {
		val sha256 = TypesFactory.eINSTANCE.createOperation() => [
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
		(typeSystem as AbstractTypeSystem).resource.contents += sha256
		sha256
	}

	def createSha3() {
		val sha3 = TypesFactory.eINSTANCE.createOperation() => [
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
		(typeSystem as AbstractTypeSystem).resource.contents += sha3
		sha3
	}

	def createRipemd160() {
		val ripemd160 = TypesFactory.eINSTANCE.createOperation() => [
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
		(typeSystem as AbstractTypeSystem).resource.contents += ripemd160
		ripemd160
	}

	def createEcrecover() {
		val ecrecover = TypesFactory.eINSTANCE.createOperation() => [
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
		(typeSystem as AbstractTypeSystem).resource.contents += ecrecover
		ecrecover
	}

	def createNow() {
		var now = TypesFactory.eINSTANCE.createProperty => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.UINT)
			]
			name = "now"
			const = true
			readonly = true
		]
		(typeSystem as AbstractTypeSystem).resource.contents += now
		now
	}

	def createThis() {
		var this_ = TypesFactory.eINSTANCE.createProperty => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
			]
			name = "this"
			const = true
			readonly = true
		]
		(typeSystem as AbstractTypeSystem).resource.contents += this_
		this_
	}

	def createSuicide() {
		val suicide = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType(SolidityTypeSystem.ADDRESS)
				]
				name = "address"
			]
			name = "suicide"
		]
		(typeSystem as AbstractTypeSystem).resource.contents += suicide
		suicide
	}

	def createMsg() {
		val msg = TypesFactory.eINSTANCE.createProperty() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.MESSAGE)
			]
			name = "msg"
			const = true
			readonly = true
		]
		(typeSystem as AbstractTypeSystem).resource.contents += msg
		msg
	}

	def createTransaction() {
		val tx = TypesFactory.eINSTANCE.createProperty() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.TRANSACTION)
			]
			name = "tx"
			const = true
			readonly = true
		]
		(typeSystem as AbstractTypeSystem).resource.contents += tx
		tx
	}

	def createBlock() {
		val block = TypesFactory.eINSTANCE.createProperty() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.BLOCK)
			]
			name = "block"
			const = true
			readonly = true
		]
		(typeSystem as AbstractTypeSystem).resource.contents += block
		block
	}
	
	def createLength(){
		val length = TypesFactory.eINSTANCE.createProperty() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType(SolidityTypeSystem.INT)
			]
			name = "length"
			const = true
			readonly = true
		]
		(typeSystem as AbstractTypeSystem).resource.contents += length
		length
	}

}
