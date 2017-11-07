package com.yakindu.solidity.typesystem;

import com.google.inject.Singleton
import org.yakindu.base.types.typesystem.GenericTypeSystem

import static org.yakindu.base.types.TypesFactory.*
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 */
@Singleton
public class SolidityTypeSystem extends GenericTypeSystem {

	private static val SolidityTypeSystem INSTANCE = new SolidityTypeSystem()

	public static val String BOOL = "bool"
	public static val String UINT = "uint"
	public static val String UINT8 = "uint8"
	public static val String INT = "int"
	public static val String BYTE = "byte"
	public static val String BYTES = "bytes"
	public static val String BYTES20 = "bytes20"
	public static val String BYTES32 = "bytes32"
	public static val String ADDRESS = "address"
	public static val String BALANCE = "balance"

	public static val String BLOCK = "block"
	public static val String BLOCK_NUMBER = "number"
	public static val String BLOCK_TIMESTAMP = "timestamp"
	public static val String BLOCK_HASH = "blockhash"

	public static val String MESSAGE = "message"
	public static val String DATA = "data"
	public static val String SENDER = "sender"

	public static val String MAPPING = "mapping"
	public static val String TRANSACTION = "transaction"
	public static val String CALL = "call"
	public static val String CALLCODE = "callcode"
	public static val String DELEGATECALL = "delegatecall"
	public static val String GAS = "gas"
	public static val String GAS_PRICE = "gasprice"
	public static val String GAS_LIMIT = "gaslimit"
	public static val String VALUE = "value"
	public static val String ORIGIN = "origin"
	public static val String COINBASE = "coinbase"
	public static val String DIFFICULTY = "difficulty"
	public static val String TRANSFER = "transfer"
	public static val String SEND = "send"
	public static val String AMOUNT = "amount"

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
		declareSuperType(getType(BOOL), getType(ANY))

		declarePrimitive(UINT)
		declareSuperType(getType(UINT), getType(INTEGER))
		declareSuperType(getType(UINT), getType(ANY))
		UINT.declareExplicitSizeTypes(8)

		declarePrimitive(INT)
		declareSuperType(getType(INT), getType(INTEGER))
		declareSuperType(getType(INT), getType(ANY))
		INT.declareExplicitSizeTypes(8)

		declarePrimitive(com.yakindu.solidity.typesystem.SolidityTypeSystem.BYTES)
		declarePrimitive(com.yakindu.solidity.typesystem.SolidityTypeSystem.BYTE)
		declareSuperType(getType(com.yakindu.solidity.typesystem.SolidityTypeSystem.BYTES), getType(INTEGER))
		declareSuperType(getType(com.yakindu.solidity.typesystem.SolidityTypeSystem.BYTE), getType(INTEGER))
		com.yakindu.solidity.typesystem.SolidityTypeSystem.BYTES.declareExplicitSizeTypes(1);

		var address = createAddress()
		declareType(address, ADDRESS)
		resource.getContents().add(address);
		declareSuperType(getType(ADDRESS), getType(ANY))

		var msg = createMessage()
		declareType(msg, MESSAGE)
		resource.getContents().add(msg);

		var transaction = createTransaction()
		declareType(transaction, TRANSACTION)
		resource.contents.add(transaction)

		var block = createBlock()
		declareType(block, BLOCK)
		resource.getContents().add(block);
	}

	def declareExplicitSizeTypes(String superType, int bitPerStep) {
		var lastType = superType
		for (j : 1 .. 32) {
			var type = superType + j * bitPerStep
			declarePrimitive(type)
			declareSuperType(getType(type), getType(lastType))
			declareSuperType(getType(type), getType(ANY))
			lastType = type
		}
	}

	def createMessage() {
		eINSTANCE.createComplexType => [ type |
			type.name = MESSAGE
			type.abstract = true
			type.features += eINSTANCE.createProperty => [
				name = GAS
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(INTEGER)
				]
				readonly = true
			]
			type.features += eINSTANCE.createProperty => [
				name = SENDER
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(ADDRESS)
				]
			]
			type.features += eINSTANCE.createProperty => [
				name = VALUE
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(INTEGER)
				]
			]
			type.features += eINSTANCE.createProperty => [
				name = DATA
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(BYTES)
				]
			]
		]

	}

	def createTransaction() {
		eINSTANCE.createComplexType => [ type |
			type.name = TRANSACTION
			type.features += eINSTANCE.createProperty => [
				name = GAS_PRICE
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(UINT)
				]
				readonly = true
			]

			type.features += eINSTANCE.createProperty => [
				name = ORIGIN
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(ADDRESS)
				]
				readonly = true
			]
		]
	}

	def createBlock() {
		eINSTANCE.createComplexType => [ type |
			type.name = BLOCK
			type.features += eINSTANCE.createProperty => [
				name = COINBASE
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(ADDRESS)
				]
				readonly = true
			]

			type.features += eINSTANCE.createProperty => [
				name = DIFFICULTY
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(UINT)
				]
				readonly = true
			]
			type.features += eINSTANCE.createProperty => [
				name = GAS_LIMIT
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(UINT)
				]
				readonly = true
			]
			type.features += eINSTANCE.createProperty => [
				name = BLOCK_NUMBER
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(UINT)
				]
				readonly = true
			]
			type.features += eINSTANCE.createProperty => [
				name = BLOCK_TIMESTAMP
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(UINT)
				]
				readonly = true
			]
			type.features += eINSTANCE.createOperation => [
				name = BLOCK_HASH
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(com.yakindu.solidity.typesystem.SolidityTypeSystem.BYTES + "32")
				]
				parameters += eINSTANCE.createParameter => [
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = getType(UINT)
					]
					name = BLOCK_NUMBER
				]
			]
		]

	}

	def createAddress() {
		eINSTANCE.createComplexType => [ type |
			type.name = ADDRESS
			type.features += eINSTANCE.createProperty => [
				name = BALANCE
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(INTEGER)
				]
				readonly = true
			]
			type.features += eINSTANCE.createOperation => [
				name = TRANSFER
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(VOID)
				]
				parameters += eINSTANCE.createParameter => [
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = getType(UINT + "256")
					]
					name = AMOUNT
				]
			]
			type.features += eINSTANCE.createOperation => [
				name = SEND
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(BOOL)
				]
				parameters += eINSTANCE.createParameter => [
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = getType(UINT + "256")
					]
					name = AMOUNT
				]
			]
			type.features += eINSTANCE.createOperation => [
				parameters += eINSTANCE.createParameter => [
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = getType(ANY)
					]
					name = "target"
					varArgs = true;
				]
				name = CALL
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(ITypeSystem.BOOLEAN)
				]
			]
			type.features += eINSTANCE.createOperation => [
				parameters += eINSTANCE.createParameter => [
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = getType(ANY)
					]
					name = "target"
					varArgs = true;
				]
				name = CALLCODE
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(ITypeSystem.BOOLEAN)
				]
			]
			type.features += eINSTANCE.createOperation => [
				parameters += eINSTANCE.createParameter => [
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = getType(ANY)
					]
					name = "target"
					varArgs = true
				]
				name = DELEGATECALL
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = getType(ITypeSystem.BOOLEAN)
				]
			]
		]
	}
}
