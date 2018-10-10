/**
 * Copyright (c) 2018 committers of YAKINDU and others.
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
package com.yakindu.solidity.typesystem.builtin

import com.google.inject.Inject
import com.google.inject.Singleton
import com.yakindu.solidity.solidity.SolidityFactory
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * @author andreas muelder - Initial contribution and API
 * @author Florian Antony
 * @author Karsten Thoms
 */
 @Singleton
class BuiltInDeclarations4 extends BuiltInDeclarations {
	
	protected new(ITypeSystem typeSystem, TypesFactory typesFactory, SolidityFactory solidityFactory) {
		super(typeSystem, typesFactory, solidityFactory)
	}
}
