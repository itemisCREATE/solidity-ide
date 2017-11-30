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

package com.yakindu.solidity.scoping;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.yakindu.base.types.Declaration;

import com.google.common.collect.Lists;
import com.yakindu.solidity.solidity.ContractDefinition;
import com.yakindu.solidity.solidity.FunctionDefinition;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ElementReferenceScope extends AbstractScope {

	private EObject context;

	protected ElementReferenceScope(IScope parent, EObject context, EReference reference) {
		super(parent, false);
		this.context = context;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		List<EObject> result = Lists.newArrayList();
		result.addAll(functionMembers());
		result.addAll(contractMembers());
		return Scopes.scopedElementsFor(result);
	}

	protected List<EObject> functionMembers() {
		List<EObject> result = Lists.newArrayList();
		FunctionDefinition function = EcoreUtil2.getContainerOfType(context, FunctionDefinition.class);
		if (function != null) {
			result.addAll(function.getParameters());
			result.addAll(function.getReturnParameters());
			result.addAll(EcoreUtil2.getAllContentsOfType(function.getBlock(), Declaration.class));
		}
		return result;
	}

	protected List<Declaration> contractMembers() {
		ContractDefinition contract = EcoreUtil2.getContainerOfType(context, ContractDefinition.class);
		if (contract != null)
			return contract.getAllFeatures();
		return Collections.emptyList();

	}
}
