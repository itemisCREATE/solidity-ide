package com.yakindu.solidity.ui.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import com.google.common.base.CaseFormat

@FinalFieldsConstructor
class NewFileTemplate {
	val String fileName
	val String solidityVersion

	def generate() '''
		pragma solidity ^«solidityVersion»;
		
		contract «contractName» {
		    address creator;
		
		    function «contractName» () {
		        creator = msg.sender;
		    }
		
		    // TODO Add functions
		
		    /**********
		     Standard kill() function to recover funds 
		     **********/
		    function kill() {
		        if (msg.sender == creator) {
		            suicide(creator); // kills this contract and sends remaining funds back to creator
		        }
		    }
		}
	'''
	
	def getContractName () {
		CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, fileName)
	}
}
