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
package com.yakindu.solidity.compiler;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.yakindu.solidity.compiler.builder.ISolidityCompiler;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * @author Karsten Thoms
 *
 */
public class SolidityCompilerModule implements Module {

	@SuppressWarnings("unchecked")
	@Override
	public void configure(Binder binder) {
		try {
			// try to instantiate platform specific implementation
			// will fail currently on Mac, thus the binding does not happen there
			Class<? extends ISolidityCompiler> solidityCompilerClass = (Class<? extends ISolidityCompiler>) Class
					.forName("com.yakindu.solidity.compiler.builder.SolidityCompiler");
			binder.bind(ISolidityCompiler.class).to(solidityCompilerClass);
		} catch (ClassNotFoundException e) {
			System.err.println("SolidityCompilerModule: " + e.getMessage());
		}
	}
}
