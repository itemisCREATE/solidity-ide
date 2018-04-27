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
package com.yakindu.solidity.ui.highlighting;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.util.CancelIndicator;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;

import com.yakindu.solidity.solidity.Block;
import com.yakindu.solidity.solidity.ContractDefinition;
import com.yakindu.solidity.solidity.VariableDefinition;

/**
 * @author Andreas Muelder - Initial contribution and API
 * @author Florian Antony
 */
public class SoliditySemanticHighlighter
		implements org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor,
			CancelIndicator cancelIndicator) {
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next.eIsProxy()) {
				continue;
			}
			if (next instanceof ContractDefinition) {
				ContractDefinition definition = (ContractDefinition) next;
				provideHighligtingFor(definition, acceptor);
			}
			if (next instanceof Operation) {
				Operation operation = (Operation) next;
				provideHighligtingFor(operation, acceptor);
			}
			if (next instanceof Block) {
				Block block = (Block) next;
				provideHighligtingFor(block, acceptor);
			}
			if (next instanceof ElementReferenceExpression) {
				ElementReferenceExpression expression = (ElementReferenceExpression) next;
				provideHighligtingFor(expression, acceptor);
			}
		}
	}

	private void provideHighligtingFor(Block block, IHighlightedPositionAcceptor acceptor) {
		List<VariableDefinition> variableDefinitions = EcoreUtil2.getAllContentsOfType(block, VariableDefinition.class);
		for (VariableDefinition variableDefinition : variableDefinitions) {
			provideHighLightForNamedElement(variableDefinition, SolidityHighlightingConfiguration.FUNCTION_PARAMETER,
					acceptor);
		}
	}

	private void provideHighligtingFor(ContractDefinition definition, IHighlightedPositionAcceptor acceptor) {
		List<VariableDefinition> variableDefinitions = EcoreUtil2.getAllContentsOfType(definition,
				VariableDefinition.class);
		for (VariableDefinition variableDefinition : variableDefinitions) {
			if (variableDefinition.eContainer().equals(definition)) {
				provideHighLightForNamedElement(variableDefinition, SolidityHighlightingConfiguration.STATE_VARIABLE,
						acceptor);
			}
		}
	}

	private void provideHighligtingFor(Operation definition, IHighlightedPositionAcceptor acceptor) {
		for (Parameter parameter : definition.getParameters()) {
			provideHighLightForNamedElement(parameter, SolidityHighlightingConfiguration.FUNCTION_PARAMETER, acceptor);
		}
	}

	private void provideHighLightForNamedElement(NamedElement namedElement, String textStyle,
			IHighlightedPositionAcceptor acceptor) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(namedElement);
		if (node != null && namedElement.getName() != null) {
			BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
			while (iterator.hasNext()) {
				INode nextNode = iterator.next();
				if (namedElement.getName().equals(nextNode.getText())) {
					provideHighLightForNamedElement(namedElement, nextNode, textStyle, acceptor);
				}
			}
		}
	}

	private void provideHighLightForNamedElement(NamedElement namedElement, INode nextNode, String textStyle,
			IHighlightedPositionAcceptor acceptor) {
		acceptor.addPosition(nextNode.getOffset(), nextNode.getLength() + 1, textStyle);
		List<ElementReferenceExpression> references = EcoreUtil2.getAllContentsOfType(namedElement.eContainer(),
				ElementReferenceExpression.class);
		for (ElementReferenceExpression elementReferenceExpression : references) {
			EObject reference = elementReferenceExpression.getReference();
			if (reference.equals(namedElement)) {
				ICompositeNode referencingNode = NodeModelUtils.findActualNodeFor(elementReferenceExpression);
				BidiIterator<INode> bidiIterator = referencingNode.getChildren().iterator();
				while (bidiIterator.hasNext()) {
					INode currentNode = bidiIterator.next();
					if (currentNode.getText().trim().equals(namedElement.getName())) {
						acceptor.addPosition(currentNode.getOffset(), currentNode.getLength(), textStyle);
					}
				}
			}
		}
	}

	private void provideHighligtingFor(ElementReferenceExpression expression, IHighlightedPositionAcceptor acceptor) {
		EObject reference = expression.getReference();
		if (reference instanceof Declaration) {
			Declaration decl = (Declaration) expression.getReference();
			switch (decl.getName()) {
			case "msg":
			case "block":
			case "tx":
			case "now":
			case "this":
			case "super":
				ICompositeNode node = NodeModelUtils.findActualNodeFor(expression);
				acceptor.addPosition(node.getTotalOffset(), node.getLength() + 1,
						DefaultHighlightingConfiguration.KEYWORD_ID);
			}
		}
	}
}
