/**
 * Copyright (c) 2017 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Florian Antony - itemis AG
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
import com.yakindu.solidity.typesystem.SolidityTypeSystem;

/**
 * @author Florian Antony
 */
public class SolidityGeneratorModule implements IGeneratorModule {

    public void configure(GeneratorEntry entry, Binder binder) {
        binder.bind(IExecutionFlowGenerator.class).to(SolidityGenerator.class);
        binder.bind(ITypeSystem.class).to(SolidityTypeSystem.class);
        binder.bind(IQualifiedNameProvider.class).to(QualifiedNameProvider.class);
        binder.bind(ICodegenTypeSystemAccess.class).to(SolidityCodegenTypeSystemAccess.class);
    }
}
