/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 	Florian Antony - itemis AG
 * 
 */
package com.yakindu.sct.domain.solidity.typesystem;

import com.google.inject.Singleton
import org.yakindu.base.types.typesystem.GenericTypeSystem

import static org.yakindu.base.types.TypesFactory.*

/**
 * @author andreas muelder - Initial contribution and API
 * @author florian antony 
 * 
 */
@Singleton
public class SolidityTypeSystem extends GenericTypeSystem {

	private static val SolidityTypeSystem INSTANCE = new SolidityTypeSystem()

	public static val String BOOL = "bool"
	public static val String UINT = "unit"
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

		declareType(createAddress(), ADDRESS)
		declareSuperType(getType(INTEGER), getType(ADDRESS))
		
		declareType(createMessage(), MESSAGE)
		declareType(createMapping(), MAPPING)
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

	def createMapping() {
		eINSTANCE.createComplexType => [ type |
			type.name = "mapping"
			type.typeParameters += eINSTANCE.createTypeParameter => [
				name = "key"
			]
			type.typeParameters += eINSTANCE.createTypeParameter => [
				name = "value"
			]
			type.features += eINSTANCE.createOperation => [
				name = "get"
				parameters += eINSTANCE.createParameter => [
					name = "key"
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = type.typeParameters.head
					]
				]
				typeSpecifier = eINSTANCE.createTypeSpecifier => [
					type = type.typeParameters.get(1)
				]
			]
			type.features += eINSTANCE.createOperation => [
				name = "put"
				parameters += eINSTANCE.createParameter => [
					name = "key"
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = type.typeParameters.head
					]
				]
				parameters += eINSTANCE.createParameter => [
					name = "value"
					typeSpecifier = eINSTANCE.createTypeSpecifier => [
						type = type.typeParameters.get(1)
					]
				]
			]
		]
	}

	def createMessage() {
		eINSTANCE.createComplexType => [ type |
			type.name = "message"
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
