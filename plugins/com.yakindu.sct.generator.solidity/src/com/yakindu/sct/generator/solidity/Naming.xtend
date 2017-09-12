/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Florian Antony - itemis AG
 * 
 */
package com.yakindu.sct.generator.solidity

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sgraph.Vertex

/**
 * @author Florian Antony
 */
class Naming {
	
	def dispatch String toName(Void woid) {
		""
	}

	def dispatch String toName(Vertex vertex) {
		vertex.name.toName
	}

	def dispatch String toName(ExecutionFlow flow) {
		flow.name.toName
	}

	def dispatch String toName(ExecutionState state) {
		state.simpleName.toName;
	}

	def dispatch String toName(String string) {
		string.replace('.', '_');
	}
}