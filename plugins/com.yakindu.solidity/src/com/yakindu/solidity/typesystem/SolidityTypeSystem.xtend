/**
 * Copyright (c) 2017 committers of YAKINDU and others.
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
package com.yakindu.solidity.typesystem;

import com.google.inject.Singleton
import com.yakindu.solidity.solidity.ContractDefinition
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.GenericTypeSystem

/**
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 */
@Singleton
class SolidityTypeSystem extends GenericTypeSystem {

	public static val String BOOL = "bool"
	public static val String UINT = "uint"
	public static val String UINT8 = "uint8"
	public static val String UINT256 = "uint256"
	public static val String INT = "int"
	public static val String BYTE = "byte"
	public static val String BYTES = "bytes"
	public static val String BYTES4 = "bytes4"
	public static val String BYTES20 = "bytes20"
	public static val String BYTES32 = "bytes32"
	public static val String ADDRESS = "address"
	public static val String BALANCE = "balance"

	public static val String ABI = "abi"
	public static val String ABI_ENCODE = "encode"
	public static val String ABI_ENCODE_PACKAGE = "encodePacked"
	public static val String ABI_ENCODE_WITH_SELECTOR = "encodeWithSelector"
	public static val String ABI_ENCODE_WITH_SIGNATURE = "encodeWithSignature"

	public static val String BLOCK = "block"
	public static val String BLOCK_NUMBER = "number"
	public static val String BLOCK_TIMESTAMP = "timestamp"
	public static val String BLOCK_HASH = "blockhash"

	public static val String MESSAGE = "message"
	public static val String DATA = "data"
	public static val String SENDER = "sender"
	public static val String SIG = "sig"

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

	static extension TypesFactory typesFactory = TypesFactory.eINSTANCE

	val static INSTANCE = new SolidityTypeSystem();

	def static GenericTypeSystem getInstance() {
		return INSTANCE;
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

		declarePrimitive(SolidityTypeSystem.BYTES)
		declarePrimitive(SolidityTypeSystem.BYTE)
		declareSuperType(getType(SolidityTypeSystem.BYTES), getType(INTEGER))
		declareSuperType(getType(SolidityTypeSystem.BYTE), getType(INTEGER))
		SolidityTypeSystem.BYTES.declareExplicitSizeTypes(1);

		var abi = createAbi()
		declareType(abi, ABI)
		resource.getContents().add(abi)

		var address = createAddress()
		declareType(address, ADDRESS)
		resource.getContents().add(address);
		declareSuperType(getType(ADDRESS), getType(INTEGER))

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

	override getDirectSuperTypes(Type type) {
		var superTypes = super.getDirectSuperTypes(type)
		if (type instanceof ContractDefinition)
			superTypes += getType(ADDRESS)
		return superTypes
	}

	def createAbi() {
		createComplexType => [ type |
			type.name = ABI
			type.abstract = true
			type.features += createOperation => [ operation |
				operation.name = ABI_ENCODE
				operation.typeSpecifier = createTypeSpecifier => [
					type = getType(BYTES)
				]
				operation.parameters += createParameter => [ param |
					param.varArgs = true
					param.optional = false;
					param.typeSpecifier = createTypeSpecifier => [
						type = getType(ANY)
					]
				]
			]
			type.features += createOperation => [ operation |
				operation.name = ABI_ENCODE_PACKAGE
				operation.typeSpecifier = createTypeSpecifier => [
					type = getType(BYTES)
				]
				operation.parameters += createParameter => [ param |
					param.varArgs = true
					param.optional = false;
					param.typeSpecifier = createTypeSpecifier => [
						type = getType(ANY)
					]
				]
			]
			type.features += createOperation => [ operation |
				operation.name = ABI_ENCODE_WITH_SELECTOR
				operation.typeSpecifier = createTypeSpecifier => [
					type = getType(BYTES)
				]
				operation.parameters += createParameter => [ param |
					param.name = "selector"
					param.optional = false;
					param.typeSpecifier = createTypeSpecifier => [
						type = getType(BYTES4)
					]
				]
				operation.parameters += createParameter => [ param |
					param.varArgs = true
					param.optional = true;
					param.typeSpecifier = createTypeSpecifier => [
						type = getType(ANY)
					]
				]
			]
			type.features += createOperation => [ operation |
				operation.name = ABI_ENCODE_WITH_SIGNATURE
				operation.typeSpecifier = createTypeSpecifier => [
					type = getType(BYTES)
				]
				operation.parameters += createParameter => [ param |
					param.name = "signature"
					param.optional = false;
					param.typeSpecifier = createTypeSpecifier => [
						type = getType(STRING)
					]
				]
				operation.parameters += createParameter => [ param |
					param.varArgs = true
					param.optional = true;
					param.typeSpecifier = createTypeSpecifier => [
						type = getType(ANY)
					]
				]
			]
		]
	}

	def createMessage() {
		createComplexType => [ type |
			type.name = MESSAGE
			type.abstract = true
			type.features += createProperty => [
				name = GAS
				typeSpecifier = createTypeSpecifier => [
					type = getType(INTEGER)
				]
				readonly = true
			]
			type.features += createProperty => [
				name = SENDER
				typeSpecifier = createTypeSpecifier => [
					type = getType(ADDRESS)
				]
			]
			type.features += createProperty => [
				name = SIG
				typeSpecifier = createTypeSpecifier => [
					type = getType(BYTES4)
				]
			]
			type.features += createProperty => [
				name = VALUE
				typeSpecifier = createTypeSpecifier => [
					type = getType(INTEGER)
				]
			]
			type.features += createProperty => [
				name = DATA
				typeSpecifier = createTypeSpecifier => [
					type = getType(BYTES)
				]
			]
		]

	}

	def createTransaction() {
		createComplexType => [ type |
			type.name = TRANSACTION
			type.features += createProperty => [
				name = GAS_PRICE
				typeSpecifier = createTypeSpecifier => [
					type = getType(UINT)
				]
				readonly = true
			]

			type.features += createProperty => [
				name = ORIGIN
				typeSpecifier = createTypeSpecifier => [
					type = getType(ADDRESS)
				]
				readonly = true
			]
		]
	}

	def createBlock() {
		createComplexType => [ type |
			type.name = BLOCK
			type.features += createProperty => [
				name = COINBASE
				typeSpecifier = createTypeSpecifier => [
					type = getType(ADDRESS)
				]
				readonly = true
			]

			type.features += createProperty => [
				name = DIFFICULTY
				typeSpecifier = createTypeSpecifier => [
					type = getType(UINT)
				]
				readonly = true
			]
			type.features += createProperty => [
				name = GAS_LIMIT
				typeSpecifier = createTypeSpecifier => [
					type = getType(UINT)
				]
				readonly = true
			]
			type.features += createProperty => [
				name = BLOCK_NUMBER
				typeSpecifier = createTypeSpecifier => [
					type = getType(UINT)
				]
				readonly = true
			]
			type.features += createProperty => [
				name = BLOCK_TIMESTAMP
				typeSpecifier = createTypeSpecifier => [
					type = getType(UINT)
				]
				readonly = true
			]
			type.features += createOperation => [
				name = BLOCK_HASH
				typeSpecifier = createTypeSpecifier => [
					type = getType(SolidityTypeSystem.BYTES + "32")
				]
				parameters += createParameter => [
					typeSpecifier = createTypeSpecifier => [
						type = getType(UINT)
					]
					name = BLOCK_NUMBER
				]
			]
		]

	}

	def createAddress() {
		createComplexType => [ type |
			type.name = ADDRESS
			type.features += createProperty => [
				name = BALANCE
				typeSpecifier = createTypeSpecifier => [
					type = getType(INTEGER)
				]
				readonly = true
			]
			type.features += createOperation => [
				name = TRANSFER
				typeSpecifier = createTypeSpecifier => [
					type = getType(VOID)
				]
				parameters += createParameter => [
					typeSpecifier = createTypeSpecifier => [
						type = getType(UINT + "256")
					]
					name = AMOUNT
				]
			]
			type.features += createOperation => [
				name = SEND
				typeSpecifier = createTypeSpecifier => [
					type = getType(BOOL)
				]
				parameters += createParameter => [
					typeSpecifier = createTypeSpecifier => [
						type = getType(UINT + "256")
					]
					name = AMOUNT
				]
			]
			type.features += createOperation => [
				parameters += createParameter => [
					typeSpecifier = createTypeSpecifier => [
						type = getType(ANY)
					]
					name = "target"
					varArgs = true;
				]
				name = CALL
				typeSpecifier = createTypeSpecifier => [
					type = getType(BOOL)
				]
			]
			type.features += createOperation => [
				parameters += createParameter => [
					typeSpecifier = createTypeSpecifier => [
						type = getType(ANY)
					]
					name = "target"
					varArgs = true;
				]
				name = CALLCODE
				typeSpecifier = createTypeSpecifier => [
					type = getType(BOOL)
				]
			]
			type.features += createOperation => [
				parameters += createParameter => [
					typeSpecifier = createTypeSpecifier => [
						type = getType(ANY)
					]
					name = "target"
					varArgs = true
				]
				name = DELEGATECALL
				typeSpecifier = createTypeSpecifier => [
					type = getType(BOOL)
				]
			]
		]
	}
}
