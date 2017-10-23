package com.yakindu.solidity.typesystem

import com.google.inject.Inject
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.AbstractTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.stext.stext.StextFactory

class BuildInDeclarations {

	@Inject
	ITypeSystem typeSystem

	def createThis() {
		var this_ = TypesFactory.eINSTANCE.createProperty => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType("address")
			]
			name = "this"
		]
		(typeSystem as AbstractTypeSystem).resource.contents += this_
		this_
	}

	def createSuicide() {
		val suicide = TypesFactory.eINSTANCE.createOperation() => [
			parameters += TypesFactory.eINSTANCE.createParameter => [
				typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
					type = typeSystem.getType("address")
				]
				name = "address"
			]

			name = "suicide"
		]
		(typeSystem as AbstractTypeSystem).resource.contents += suicide
		suicide
	}

	def createMsg() {
		val msg = StextFactory.eINSTANCE.createVariableDefinition() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType("message")
			]
			name = "msg"
			const = true
			readonly = true
		]
		(typeSystem as AbstractTypeSystem).resource.contents += msg
		msg
	}

	def createBlock() {
		val block = StextFactory.eINSTANCE.createVariableDefinition() => [
			typeSpecifier = TypesFactory.eINSTANCE.createTypeSpecifier() => [
				type = typeSystem.getType("Block")
			]
			name = "block"
			const = true
			readonly = true
		]
		(typeSystem as AbstractTypeSystem).resource.contents += block
		block
	}

}
