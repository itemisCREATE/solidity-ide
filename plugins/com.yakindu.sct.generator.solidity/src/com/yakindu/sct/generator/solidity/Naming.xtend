/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Florian Antony - itemis AG
 * 
 */
package com.yakindu.sct.generator.solidity

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.stext.EventDefinition

/**
 * @author Florian Antony
 */
class Naming {

	@Inject extension IQualifiedNameProvider

	def dispatch String toName(Void woid) {
		""
	}

	def dispatch String toName(EventDefinition eventdefinition) {
		eventdefinition.name
	}

	def dispatch String toName(Vertex vertex) {
		vertex.name.toName
	}

	def dispatch String toName(ExecutionFlow flow) {
		flow.name.toName
	}

	def dispatch String toName(ExecutionState state) {
		(state.sourceElement as State).fullyQualifiedName.toString.toName;
	}

	def dispatch String toName(String string) {
		string.replace('.', '_');
	}
}
