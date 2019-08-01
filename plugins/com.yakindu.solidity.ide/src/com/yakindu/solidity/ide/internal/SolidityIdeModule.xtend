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
package com.yakindu.solidity.ide.internal

import com.yakindu.solidity.ide.AbstractSolidityIdeModule
import org.eclipse.xtext.ide.server.codeActions.ICodeActionService2
import org.eclipse.xtext.ide.server.contentassist.ContentAssistService

/**
 * 
 * 
 * Use this class to register ide components.
 * @author Andreas Muelder - Initial contribution and API
 * @author Florian Antony
 */
class SolidityIdeModule extends AbstractSolidityIdeModule {
	// workaround for https://github.com/eclipse/xtext-eclipse/issues/834
	def Class<? extends ContentAssistService> bindContentAssistService() {
		return CustomContentAssistService
	}
	
	def Class<? extends ICodeActionService2> bindICodeActionService() {
		return SolidityIdeCodeActionService
	}
}
