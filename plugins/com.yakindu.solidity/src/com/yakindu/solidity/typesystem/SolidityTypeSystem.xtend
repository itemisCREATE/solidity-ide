package com.yakindu.solidity.typesystem;

import com.google.inject.Singleton
import org.yakindu.base.types.typesystem.GenericTypeSystem

import static org.yakindu.base.types.TypesFactory.*

@Singleton
public class SolidityTypeSystem extends GenericTypeSystem {

	private static val SolidityTypeSystem INSTANCE = new SolidityTypeSystem()

	public static val String BOOL = "bool"
	public static val String UINT = "uint"
	public static val String INT = "int"
	public static val String BYTE = "byte"
	public static val String ADDRESS = "address"
	public static val String MESSAGE = "message"
	public static val String MAPPING = "mapping"

	protected new() {
	}

	static def SolidityTypeSystem getInstance() {
		return INSTANCE
	}

	override initRegistries() {
		super.initRegistries()

		getType(BOOLEAN).abstract = true
		getType(INTEGER).abstract = true
		getType(REAL).abstract = true

		declarePrimitive(BOOL)
		declareSuperType(getType(BOOL), getType(BOOLEAN))

		declarePrimitive(UINT)
		declareSuperType(getType(UINT), getType(INTEGER))
		UINT.declareExplicitSizeTypes(8)

		declarePrimitive(INT)
		declareSuperType(getType(INT), getType(INTEGER))
		INT.declareExplicitSizeTypes(8)

		declarePrimitive(BYTE)
		declareSuperType(getType(BYTE), getType(INTEGER))
		BYTE.declareExplicitSizeTypes(1);

		var address = createAddress()
		declareType(address, ADDRESS)
		resource.getContents().add(address);
		
		declareSuperType(getType(INTEGER), getType(ADDRESS))
		var msg = createMessage()
		declareType(msg, MESSAGE)
		resource.getContents().add(msg);
		
		declareType(createTransaction(), "Transaction")
		var block = createBlock()
		declareType(block, "Block")
		resource.getContents().add(block);
	}

	def declareExplicitSizeTypes(String superType,int bitPerStep) {
		var lastType = superType
		for (j : 1 .. 32) {
			var type = superType + j * bitPerStep
			declarePrimitive(type)
			declareSuperType(getType(type), getType(lastType))
			lastType = type
		}
	}

	def createMessage() {
		eINSTANCE.createComplexType => [ type |
			type.name = "message"
			type.abstract = true
			type.features += eINSTANCE.createProperty => [
				name = "gas"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("integer")
				]
				readonly = true
			]
			type.features += eINSTANCE.createProperty => [
				name = "sender"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("address")
				]
			]
			type.features += eINSTANCE.createProperty => [
				name = "value"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("integer")
				]
			]
		]

	}
	
	def createTransaction(){
		 eINSTANCE.createComplexType => [ type |
			type.name = "transaction"
			type.features += eINSTANCE.createProperty => [
				name = "gasprice"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("uint")
				]
				readonly = true
			]
			
			type.features += eINSTANCE.createProperty => [
				name = "origin"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("address")
				]
				readonly = true
			]
		]
	}
	
	def createBlock(){
		 eINSTANCE.createComplexType => [ type |
			type.name = "block"
			type.features += eINSTANCE.createProperty => [
				name = "coinbase"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("address")
				]
				readonly = true
			]
			
			type.features += eINSTANCE.createProperty => [
				name = "difficulty"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("uint")
				]
				readonly = true
			]
			type.features += eINSTANCE.createProperty => [
				name = "gaslimit"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("uint")
				]
				readonly = true
			]
			type.features += eINSTANCE.createProperty => [
				name = "number"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("uint")
				]
				readonly = true
			]
			type.features += eINSTANCE.createProperty => [
				name = "timestamp"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("uint")
				]
				readonly = true
			]
			//Blockhash
			type.features += eINSTANCE.createOperation => [
				name = "blockhash"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("bytes32")
				]
				parameters += eINSTANCE.createParameter => [
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = getType("uint")
					]
					name = "blockNumber"
				]
			]
		]
		 
	}

	def createAddress() {
		eINSTANCE.createComplexType => [ type |
			type.name = "address"
			type.features += eINSTANCE.createProperty => [
				name = "balance"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("integer")
				]
				readonly = true
			]
			type.features += eINSTANCE.createOperation => [
				name = "transfer"
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType("void")
				]
				parameters += eINSTANCE.createParameter => [
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = getType("uint256")
					]
					name = "amount"
				]
			]
		]
	}
}
