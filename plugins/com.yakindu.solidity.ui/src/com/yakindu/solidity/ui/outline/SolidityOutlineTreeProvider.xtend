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
package com.yakindu.solidity.ui.outline

import com.yakindu.solidity.SolidityVersion
import com.yakindu.solidity.solidity.ConstructorDefinition
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.ImportDirective
import com.yakindu.solidity.solidity.PragmaVersion
import com.yakindu.solidity.solidity.SolidityModel
import com.yakindu.solidity.solidity.SourceUnit
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import org.yakindu.base.types.Declaration
import com.yakindu.solidity.solidity.PragmaDirective
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode
import com.yakindu.solidity.solidity.UsingForDeclaration
import org.yakindu.base.types.AnnotatableElement

/**
 * @author Florian Antony - Initial contribution and API
 * @author Karsten Thoms
 * @author Jonathan Thoene
 */
class SolidityOutlineTreeProvider extends DefaultOutlineTreeProvider {

	def void _createNode(DocumentRootNode parentNode, SolidityModel it) {
		sourceunit.forEach [ unit |
			createNode(parentNode, unit)
		]
	}

	def void _createNode(DocumentRootNode parentNode, SourceUnit it) {
		pragma.forEach [ pragma |
			_createNode(parentNode, pragma)
		]
		imports.forEach [ import |
			_createNode(parentNode, import)
		]
		member.forEach [ member |
			createNode(parentNode, member)
		]
	}
	
	def void _createNode(DocumentRootNode parentNode, ContractDefinition it) {
		val EObjectNode contractNode = createEObjectNode(parentNode, it)
		features.forEach [feature |
			_createNode(contractNode, feature)
		]
	}
	
	override protected Object _text(Object element) {
		switch element {
			ConstructorDefinition: return "constructor"
			UsingForDeclaration: return 'Using ' + element.contract.name + ' for ' + element.typeSpecifier.type.name
			ImportDirective : return element.importedNamespace.shortenImportedNamespace
			PragmaDirective: return super._text(element.domainID)
			PragmaVersion: return 'pragma solidity' + SolidityVersion.toString(element)
			default: return super._text(element)
		}
	}

	override protected _isLeaf(EObject element) {
		switch element {
			ContractDefinition: false
			Declaration: true
			PragmaVersion: true
			default: return super._isLeaf(element)
		}
	}
	
	def protected String shortenImportedNamespace (String namespace) {
		var segments = namespace.split("/");
		return segments.get(segments.length-1).replace(".sol","")
	}
}
