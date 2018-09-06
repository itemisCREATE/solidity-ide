/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.generator.solidity

import javax.inject.Inject
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

import static org.yakindu.base.types.typesystem.ITypeSystem.*
/**
 * 
 * @author Florian Antony - Initial contribution and API
 * 
 */
class SolidityTypeSystemAccess implements ICodegenTypeSystemAccess{
	
	@Inject
	extension ITypeSystem

	override getTargetLanguageName(Type type) {
		val originalType = type?.originType
		switch (originalType) {
			case originalType === null || isSame(originalType, getType(VOID)) : 'void'
			case isSame(originalType, getType(INTEGER)): 'int32'
			case isSame(originalType, getType(REAL)): 'int32'
			case isSame(originalType, getType(BOOLEAN)): 'bool'
			case isSame(originalType, getType(STRING)): 'string'
			default: throw new IllegalArgumentException("Target language name could not be inferred for type " + type)
		}
	}
	
	override getTargetLanguageName(TypeSpecifier typeSpecifier) {
		return getTargetLanguageName(typeSpecifier?.type)
	}
	
}
