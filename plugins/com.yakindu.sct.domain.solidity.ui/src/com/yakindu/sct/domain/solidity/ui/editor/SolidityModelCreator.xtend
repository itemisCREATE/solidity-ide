/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.domain.solidity.ui.editor

import org.yakindu.sct.ui.editor.wizards.DefaultModelCreator

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class SolidityModelCreator extends DefaultModelCreator {
	
	override protected getInitialSpecification() {
		'''
			interface:
			// Define events and variables here. 
			// Use CTRL + Space for content assist.;
		'''
	}
}
