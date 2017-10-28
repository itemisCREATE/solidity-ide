package com.yakindu.solidity.typesystem

import com.google.inject.Inject
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.AbstractTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem

class BuildInDeclarations {

	@Inject
	ITypeSystem typeSystem

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

}
