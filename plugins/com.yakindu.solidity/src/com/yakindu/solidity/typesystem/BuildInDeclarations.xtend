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
package com.yakindu.solidity.typesystem

import com.google.inject.Inject
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.FunctionModifier
import com.yakindu.solidity.solidity.SolidityFactory
import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.AbstractTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem

import static com.yakindu.solidity.typesystem.SolidityTypeSystem.*
import static org.yakindu.base.types.typesystem.ITypeSystem.*

/**
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 * @author Karsten Thoms
 */
@Accessors(PUBLIC_GETTER)
class BuildInDeclarations {

	ITypeSystem typeSystem
	TypesFactory typesFactory

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
	Property abi
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
	new(ITypeSystem typeSystem, TypesFactory typesFactory, SolidityFactory solidityFactory) {
		/************************
		 *     ERROR HANDLING 
		 ************************/
		this.typeSystem = typeSystem
		this.typesFactory = typesFactory

		val ADDRESS = ADDRESS.typeForName
		val ANY = ANY.typeForName
		val BOOL = BOOL.typeForName
		val BYTES = BYTES.typeForName
		val BYTES20 = BYTES20.typeForName
		val BYTES32 = BYTES32.typeForName
		val INT = INT.typeForName
		val UINT = UINT.typeForName
		val UINT8 = UINT8.typeForName
		val VOID = VOID.typeForName

		assert_ = createOperation("assert", VOID) => [
			parameters += createParameter("condition", BOOL)
		]

		require = createOperation("require", VOID) => [
			parameters += createParameter("condition", BOOL)
		]

		revert = createOperation("revert", VOID)

		/************************
		 *     MATH and CRYPTO
		 ************************/
		abi = createConstant("abi", ABI.typeForName)

		addmod = createOperation("addmod", UINT) => [
			parameters += createParameter("x", UINT)
			parameters += createParameter("y", UINT)
			parameters += createParameter("k", UINT)
		]

		mulmod = createOperation("mulmod", UINT) => [
			parameters += createParameter("x", UINT)
			parameters += createParameter("y", UINT)
			parameters += createParameter("k", UINT)
		]

		keccak256 = createOperation("keccak256", BYTES32) => [
			parameters += createParameter("argument", BYTES) => [varArgs = false]
		]

		sha256 = createOperation("sha256", BYTES32) => [
			parameters += createParameter("argument", ANY) => [varArgs = true]
		]

		sha3 = createOperation("sha3", BYTES32) => [
			parameters += createParameter("argument", ANY) => [varArgs = true]
		]

		ripemd160 = createOperation("ripemd160", BYTES20) => [
			parameters += createParameter("argument", ANY) => [varArgs = true]
		]

		ecrecover = createOperation("ecrecover", ADDRESS) => [
			parameters += createParameter("hash", BYTES32)
			parameters += createParameter("v", UINT8)
			parameters += createParameter("r", BYTES32)
			parameters += createParameter("s", BYTES32)
		]

		now = createConstant("now", UINT)

		this_ = createConstant("this", ADDRESS)

		super_ = createConstant("super", ANY)

		suicide = createOperation("suicide", VOID) => [
			parameters += createParameter("address", ADDRESS)
		]

		selfdestruct = createOperation("selfdestruct", VOID) => [
			parameters += createParameter("address", ADDRESS)
		]

		msg = createConstant("msg", MESSAGE.typeForName)

		tx = createConstant("tx", TRANSACTION.typeForName)

		block = createConstant("block", BLOCK.typeForName)

		length = createProperty("length", INT)

		push = createOperation("push", INT) => [
			parameters += createParameter("element", ANY)
		]

		owned = solidityFactory.createContractDefinition() => [
			(typeSystem as AbstractTypeSystem).resource.contents += it
			name = "owned"
			features += solidityFactory.createVariableDefinition() => [
				name = "owner"
				typeSpecifier = typesFactory.createTypeSpecifier() => [
					type = ADDRESS
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
			(typeSystem as AbstractTypeSystem).resource.contents += it
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
	}

	def all() {
		#[msg, assert_, require, revert, abi, addmod, mulmod, keccak256, sha3, sha256, length, push, ripemd160,
			ecrecover, block, suicide, selfdestruct, this_, super_, now, tx, owned, mortal]
	}

	def protected Type getTypeForName(String typeName) {
		typeSystem.getType(typeName)
	}

	def protected Operation createOperation(String name, Type type) {
		typesFactory.createOperation => [
			(typeSystem as AbstractTypeSystem).resource.contents += it
			it.name = name
			typeSpecifier = typesFactory.createTypeSpecifier => [
				it.type = type
			]
		]
	}

	def protected Parameter createParameter(String name, Type type) {
		typesFactory.createParameter => [
			(typeSystem as AbstractTypeSystem).resource.contents += it
			it.name = name
			typeSpecifier = typesFactory.createTypeSpecifier => [
				it.type = type
			]
		]
	}

	def protected Property createConstant(String name, Type type) {
		createProperty(name, type, true, true)
	}

	def protected Property createProperty(String name, Type type) {
		createProperty(name, type, false, false)
	}

	def protected Property createProperty(String name, Type type, boolean const, boolean readonly) {
		typesFactory.createProperty => [
			(typeSystem as AbstractTypeSystem).resource.contents += it
			it.name = name
			typeSpecifier = typesFactory.createTypeSpecifier => [
				it.type = type
			]
			it.const = const
			it.readonly = readonly
		]
	}
}
