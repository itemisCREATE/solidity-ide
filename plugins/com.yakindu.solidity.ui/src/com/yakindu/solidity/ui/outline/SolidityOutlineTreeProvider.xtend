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

import com.yakindu.solidity.solidity.SolidityModel
import com.yakindu.solidity.solidity.SourceUnit
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import org.yakindu.base.types.Declaration

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 * 
 * @author Florian Antony - Initial contribution and API
 * @author Karsten Thoms
 */
 
class SolidityOutlineTreeProvider extends DefaultOutlineTreeProvider {

	def void _createNode(DocumentRootNode parentNode, SolidityModel it) {
		sourceunit.forEach [ unit |
			createNode(parentNode, unit)
		]

	}

	def void _createNode(DocumentRootNode parentNode, SourceUnit it) {
		if(pragma !== null){
			_createNode(parentNode, pragma)
		}
		imports.forEach [ import |
			_createNode(parentNode, import)
		]
		member.forEach [ member |
			_createNode(parentNode, member)
		]
	}

	override protected _isLeaf(EObject element) {
		switch element {
			Declaration: true
			default: return super._isLeaf(element)
		}
	}
}
