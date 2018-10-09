package com.yakindu.solidity.typesystem.builtin

import com.yakindu.solidity.solidity.ContractDefinition
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property

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
	protected ContractDefinition owned
	protected ContractDefinition mortal
	
	def List<EObject> superContracts()
	
	def List<EObject> all()

}
