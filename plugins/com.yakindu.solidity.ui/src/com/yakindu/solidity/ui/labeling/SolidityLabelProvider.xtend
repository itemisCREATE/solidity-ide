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
package com.yakindu.solidity.ui.labeling

import com.google.inject.Inject
import com.yakindu.solidity.solidity.ArrayTypeSpecifier
import com.yakindu.solidity.solidity.BuildInModifier
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.EventDefinition
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.FunctionModifier
import com.yakindu.solidity.solidity.ImportDirective
import com.yakindu.solidity.solidity.IndexParameter
import com.yakindu.solidity.solidity.MappingTypeSpecifier
import com.yakindu.solidity.solidity.Modifier
import com.yakindu.solidity.solidity.ModifierDefinition
import com.yakindu.solidity.solidity.ModifierInvocation
import com.yakindu.solidity.solidity.PragmaDirective
import com.yakindu.solidity.solidity.PragmaExperimentalDirective
import com.yakindu.solidity.solidity.PragmaSolidityDirective
import com.yakindu.solidity.solidity.VariableDefinition
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.yakindu.base.base.NamedElement
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.TypeSpecifier

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 * 
 * @author Karsten Thoms - Initial contribution and API
 * @author Florian Antony
 * @author Andreas Muelder
 */
class SolidityLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	def dispatch String text(Object obj) {
		return null
	}

	def dispatch String text(NamedElement it) {
		name
	}

	def dispatch String text(VariableDefinition it) {
		'''«name» : «typeSpecifier.text()»'''.toString
	}

	def dispatch String text(ImportDirective it) {
		'''import «importedNamespace»'''.toString
	}

	def dispatch String text(PragmaSolidityDirective it) {
		if(maxVersion === null){
			'''pragma solidity ^«minVersion» '''.toString
		}else{
			'''pragma solidity ^«minVersion» < «maxVersion» '''.toString
		}
	}
	
	def dispatch String text(PragmaExperimentalDirective it) {
		'''pragma experimental «value»'''.toString
	}

	def dispatch String text(EventDefinition it) {
		'''«name» («parameters.map[type.name].join(", ")»)'''.toString
	}

	def dispatch String text(EnumerationType it) {
		'''«name»'''.toString
	}

	def dispatch String text(IndexParameter it) {
		'''«name» : «typeSpecifier.text()»'''
	}

	def dispatch String text(FunctionDefinition it) {
		val functionModifier = modifier.filter[!isVisibility].filterNull.map [
			text()
		].join(" ")

		val returnType = if (returnParameters.isEmpty) {
				"void"
			} else {
				returnParameters.map[type.name].join(", ")
			}

		return '''«name»(«parameters.map[type.name].join(", ")»)«IF !functionModifier.empty»[«functionModifier»] «ENDIF» :«returnType» '''
	}

	def dispatch String text(ModifierDefinition it) {
		'''«name»(«parameters.map[type.name].join(", ")»)'''
	}

	def dispatch String text(ModifierInvocation it) {
		'''«reference.name»'''
	}

	def dispatch String text(FunctionModifier it) {
		'''«getName.toLowerCase»'''
	}

	def dispatch String text(BuildInModifier it) {
		'''«type.getName.toLowerCase»'''
	}

	def dispatch boolean isVisibility(BuildInModifier it) {
		type === FunctionModifier.PUBLIC || type === FunctionModifier.INTERNAL || type === FunctionModifier.EXTERNAL ||
			type === FunctionModifier.PRIVATE
	}

	def dispatch boolean isVisibility(Modifier it) {
		false
	}

	def dispatch String text(MappingTypeSpecifier it) {
		'''( «key.text()» => «value.text()»)'''
	}

	def dispatch String text(ArrayTypeSpecifier it) {
		'''«type.text()»[]'''
	}

	def dispatch String text(TypeSpecifier it) {
		type.name;
	}

	def dispatch String image(Object obj) {
		return null
	}

	def dispatch String image(PragmaDirective it) {
		"pragma.gif"
	}

	def dispatch String image(ImportDirective it) {
		"import.gif"
	}

	def dispatch String image(ContractDefinition it) {
		"contract.png"
	}

	def dispatch String image(VariableDefinition it) {
		"variable.gif"
	}

	def dispatch String image(FunctionDefinition it) {
		"function.gif"
	}

	def dispatch String image(EventDefinition it) {
		"event.gif"
	}

	def dispatch String image(ModifierDefinition it) {
		"modifier.gif"
	}

	def dispatch String image(EnumerationType it) {
		"enum.gif"
	}

}
