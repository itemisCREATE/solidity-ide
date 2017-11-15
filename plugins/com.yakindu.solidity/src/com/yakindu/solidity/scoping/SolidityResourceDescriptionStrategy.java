package com.yakindu.solidity.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;

import com.yakindu.solidity.solidity.FunctionDefinition;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SolidityResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {

	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (eObject instanceof FunctionDefinition) {
			super.createEObjectDescriptions(eObject, acceptor);
			return false;
		}
		return super.createEObjectDescriptions(eObject, acceptor);

	}

}
