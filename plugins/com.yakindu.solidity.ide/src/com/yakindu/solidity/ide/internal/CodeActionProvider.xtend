package com.yakindu.solidity.ide.internal

import static com.yakindu.solidity.validation.IssueCodes.*
import com.google.inject.Inject
import com.google.inject.name.Named
import com.yakindu.solidity.SolidityVersion

class CodeActionProvider {
	
	@Inject @Named(SolidityVersion.SOLIDITY_VERSION) String solcVersion
	
	def String getLabel(String issueCode) {
		switch (issueCode) {
			case WARNING_SOLIDITY_VERSION_NOT_THE_DEFAULT : '''Change version to «solcVersion»'''
			case ERROR_STATE_MUTABILITY_ONLY_ALLOWED_FOR_ADDRESS : '''Remove payable declaration'''
			case ERROR_MEMBER_TRANSFER_NOT_FOUND_OR_VISIBLE: '''Add payable to declaration'''
			case ERROR_INVALID_IMPLICID_CONVERSION_TO_ADDRESS_PAYABLE: ''''''
			default: ""
		}
	}
	
	def String getFix(String issueCode) {
		switch (issueCode) {
			case WARNING_SOLIDITY_VERSION_NOT_THE_DEFAULT : solcVersion
			case ERROR_STATE_MUTABILITY_ONLY_ALLOWED_FOR_ADDRESS: ""
			case ERROR_MEMBER_TRANSFER_NOT_FOUND_OR_VISIBLE : ''' payable'''
			case ERROR_INVALID_IMPLICID_CONVERSION_TO_ADDRESS_PAYABLE : ''' payable'''
			default: ""
		}
	}
	
	def boolean hasSolution(String issueCode) {
		return !issueCode.label.nullOrEmpty
	}
}