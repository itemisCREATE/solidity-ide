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

import com.yakindu.solidity.solidity.ContractDefinition
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property

/**
 * @author Florian Antony - initial contribution and API.
 *
 */
@Accessors(PUBLIC_GETTER)
abstract class BuiltInDeclarations {
	
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
	protected Property msg
	protected Property this_
	protected Property super_
	protected Property now
	protected Property tx
	protected Property block
	protected Property length
	protected Operation push
	protected Operation gas
	protected Operation value
	protected ContractDefinition owned
	protected ContractDefinition mortal
	
	def List<EObject> superContracts()
	
	def List<EObject> all()

}
