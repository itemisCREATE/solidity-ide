/**
 * Copyright (c) 2018 committers of YAKINDU and others.
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
package com.yakindu.solidity.typesystem.builtin

import com.google.inject.Inject
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.FunctionModifier
import com.yakindu.solidity.solidity.SolidityFactory
import com.yakindu.solidity.typesystem.SolidityTypeSystem
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.AbstractTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem

import static com.yakindu.solidity.typesystem.SolidityTypeSystem.*
import org.yakindu.base.types.AnnotationType

/**
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 * @author Karsten Thoms
 */
@Accessors(PUBLIC_GETTER)
class BuiltInDeclarations {

	protected ITypeSystem typeSystem
	protected TypesFactory typesFactory
	protected SolidityFactory solidityFactory

	protected boolean installed
	protected Operation assert_
	protected Operation require
	protected Operation revert
	protected Operation addmod
	protected Operation mulmod
	protected Operation keccak256
	protected Operation sha3
	protected Operation sha256
	protected Operation ripemd160
	protected Operation ecrecover
	protected Operation suicide
	protected Operation selfdestruct
	protected Property abi
	protected Property msg
	protected Property this_
	protected Property super_
	protected Property now
	protected Property tx
	protected Property block
	protected Property length
	protected Operation push
	protected Operation pop
	protected Operation gas
	protected Operation value
	protected ContractDefinition owned
	protected ContractDefinition mortal

	protected Type ADDRESS
	protected Type ANY
	protected Type BOOL
	protected Type BYTES20
	protected Type BYTES32
	protected Type INT
	protected Type UINT
	protected Type UINT8
	protected Type UINT265
	protected Type VOID

	protected AnnotationType payable
	
	@Inject
	protected new(ITypeSystem typeSystem, TypesFactory typesFactory, SolidityFactory solidityFactory) {
		this.typeSystem = typeSystem
		this.typesFactory = typesFactory
		this.solidityFactory = solidityFactory
		ADDRESS = SolidityTypeSystem.ADDRESS.typeForName
		ANY = SolidityTypeSystem.ANY.typeForName
		BOOL = SolidityTypeSystem.BOOL.typeForName
		BYTES20 = SolidityTypeSystem.BYTES20.typeForName
		BYTES32 = SolidityTypeSystem.BYTES32.typeForName
		INT = SolidityTypeSystem.INT.typeForName
		UINT = SolidityTypeSystem.UINT.typeForName
		UINT8 = SolidityTypeSystem.UINT8.typeForName
		UINT265 = SolidityTypeSystem.UINT256.typeForName
		VOID = SolidityTypeSystem.VOID.typeForName
		initialize
	}

	def protected void initialize() {
		/************************
		 *     ERROR HANDLING 
		 ************************/
		assert_ = assert_()
		require = require()
		revert = revert()

		/************************
		 *     MATH and CRYPTO
		 ************************/
		addmod = addmod()
		mulmod = mulmod()
		keccak256 = keccak256()
		sha256 = sha256()
		sha3 = sha3()
		ripemd160 = ripemd160()
		ecrecover = ecrecover()

		/************************
		 * CONSTANTS & GLOBALS
		 ************************/
		abi = abi()
		now = now()
		this_ = this_()
		super_ = super_()
		msg = msg()
		tx = tx()
		block = block()
		length = length()
		gas = gas()
		value = value()
		push = push()
		pop = pop()

		/************************
		 *     DESTRUCTION
		 ************************/
		suicide = suicide()
		selfdestruct = selfdestruct()

		/************************
		 *     SUPERCONTRACTS
		 ************************/
		owned = owned()
		mortal = mortal()

		/************************
		 *     ANNOTATIONS
		 ************************/
		payable = payable()
	}

	def create new ArrayList<EObject>() superContracts() {
		addAll(#[owned, mortal])
	}

	def List<Declaration> all() {
		#[abi, msg, assert_, require, revert, addmod, mulmod, keccak256, sha3, sha256, length, push, pop, ripemd160,
			ecrecover, block, suicide, selfdestruct, this_, super_, now, tx, owned, mortal, payable]
	}

	def protected Operation assert_() {
		createOperation("assert", VOID) => [
			parameters += createParameter("condition", BOOL)
		]
	}

	def protected Operation require() {
		createOperation("require", VOID) => [
			parameters += createParameter("condition", BOOL)
		]
	}

	def protected Operation revert() {
		createOperation("revert", VOID)
	}

	def protected Operation addmod() {
		createOperation("addmod", UINT) => [
			parameters += createParameter("x", UINT)
			parameters += createParameter("y", UINT)
			parameters += createParameter("k", UINT)
		]
	}

	def protected Operation mulmod() {
		createOperation("mulmod", UINT) => [
			parameters += createParameter("x", UINT)
			parameters += createParameter("y", UINT)
			parameters += createParameter("k", UINT)
		]
	}

	def protected Operation keccak256() {
		createOperation("keccak256", BYTES32) => [
			parameters += createParameter("argument", ANY) => [varArgs = true]
		]
	}

	def protected Operation sha3() {
		createOperation("sha3", BYTES32) => [
			parameters += createParameter("argument", ANY) => [varArgs = true]
		]
	}

	def protected Operation sha256() {
		createOperation("sha256", BYTES32) => [
			parameters += createParameter("argument", ANY) => [varArgs = true]
		]
	}

	def protected Operation ripemd160() {
		createOperation("ripemd160", BYTES20) => [
			parameters += createParameter("argument", ANY) => [varArgs = true]
		]
	}

	def protected Operation ecrecover() {
		createOperation("ecrecover", ADDRESS) => [
			parameters += createParameter("hash", BYTES32)
			parameters += createParameter("v", UINT8)
			parameters += createParameter("r", BYTES32)
			parameters += createParameter("s", BYTES32)
		]
	}

	def protected Operation suicide() {
		createOperation("suicide", VOID) => [
			parameters += createParameter("address", ADDRESS)
		]
	}

	def protected Operation selfdestruct() {
		createOperation("selfdestruct", VOID) => [
			parameters += createParameter("address", ADDRESS)
		]
	}

	def protected Operation push() {
		createOperation("push", INT) => [
			parameters += createParameter("element", ANY)
		]
	}

	def protected Operation pop() {
		createOperation("pop", VOID)
	}

	def protected Operation gas() {
		createOperation("gas", VOID) => [
			parameters += createParameter("amount", UINT265)
		]
	}

	def protected Operation value() {
		createOperation("value", VOID) => [
			parameters += createParameter("amount", UINT265)
		]
	}

	def protected Property abi() {
		createConstant("abi", ABI.typeForName)
	}

	def protected Property now() {
		createConstant("now", UINT)
	}

	def protected Property this_() {
		createConstant("this", ADDRESS)
	}

	def protected Property super_() {
		createConstant("super", ANY)
	}

	def protected Property msg() {
		createConstant("msg", MESSAGE.typeForName)
	}

	def protected Property tx() {
		createConstant("tx", TRANSACTION.typeForName)
	}

	def protected Property block() {
		createConstant("block", BLOCK.typeForName)
	}

	def protected Property length() {
		createProperty("length", INT)
	}

	def protected owned() {
		solidityFactory.createContractDefinition() => [
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
	}

	def protected mortal() {
		solidityFactory.createContractDefinition() => [
			(typeSystem as AbstractTypeSystem).resource.contents += it
			name = "mortal"
			superTypes += solidityFactory.createTypeSpecifier() => [
				type=owned
			]
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
	
	def protected AnnotationType payable() {
		typesFactory.createAnnotationType => [
			name = "payable"
		]
	}

	def protected Type typeForName(String typeName) {
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
