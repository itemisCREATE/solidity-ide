/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package com.yakindu.sct.generator.solidity;

import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.IGeneratorModule;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Binder;
import com.yakindu.solidity.typesystem.SolidityTypeSystem4;

/**
 * 
 * @author Florian Antony - Initial contribution and API
 * 
 */
public class SolidityGeneratorModule implements IGeneratorModule {

    public void configure(GeneratorEntry entry, Binder binder) {
        binder.bind(IExecutionFlowGenerator.class).to(SolidityGenerator.class);
        binder.bind(ITypeSystem.class).to(SolidityTypeSystem4.class);
        binder.bind(IQualifiedNameProvider.class).to(QualifiedNameProvider.class);
        binder.bind(ICodegenTypeSystemAccess.class).to(SolidityTypeSystemAccess.class);
    }
}
