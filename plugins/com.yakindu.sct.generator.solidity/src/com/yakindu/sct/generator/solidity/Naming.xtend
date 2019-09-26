/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * 
 * @author Florian Antony - Initial contribution and API
 * 
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
		(state.sourceElement as Vertex).fullyQualifiedName.toString.toName;
	}

	def dispatch String toName(String string) {
		string.replace('.', '_');
	}
}
