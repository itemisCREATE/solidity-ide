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
package com.yakindu.solidity.ui.highlighting;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Property;

import com.yakindu.solidity.solidity.VariableDefinition;

/**
 * @author Andreas Muelder - Initial contribution and API
 * @author Florian Antony
 */
@SuppressWarnings("deprecation")
public class SoliditySemanticHighlighter
		implements org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource,
			org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor) {
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next.eIsProxy()) {
				continue;
			}
			if (next instanceof Property) {
				Property property = (Property) next;
				provideHighligtingFor(property, acceptor);
			}
			if (next instanceof Operation) {
				Operation operation = (Operation) next;
				provideHighligtingFor(operation, acceptor);
			}
			if (next instanceof ElementReferenceExpression) {
				ElementReferenceExpression expression = (ElementReferenceExpression) next;
				provideHighligtingFor(expression, acceptor);
			}
			if (next instanceof FeatureCall) {
				FeatureCall featureCall = (FeatureCall) next;
				provideHighligtingFor(featureCall, acceptor);
			}
		}
	}

	private void provideHighligtingFor(FeatureCall featureCall, IHighlightedPositionAcceptor acceptor) {
		EObject feature = featureCall.getFeature();
		if (feature instanceof Property) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(featureCall);
			if (node != null) {
				acceptor.addPosition(node.getOffset(), node.getLength(),
						SolidityHighlightingConfiguration.FEATURESCALL);
			}
		}
	}

	private void provideHighligtingFor(Operation definition, IHighlightedPositionAcceptor acceptor) {
		provideHighligingForFunctionName(definition, acceptor);
		provideHighligingForFunctionParameter(definition, acceptor);
	}

	private void provideHighligingForFunctionParameter(Operation definition, IHighlightedPositionAcceptor acceptor) {
		for (Parameter parameter : definition.getParameters()) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(parameter.getTypeSpecifier());
			if (node != null) {
				acceptor.addPosition(node.getOffset(), node.getLength() + 1, SolidityHighlightingConfiguration.TYPES);
			}
		}

	}

	private void provideHighligingForFunctionName(Operation definition, IHighlightedPositionAcceptor acceptor) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(definition);
		if (node != null && definition.getName() != null) {
			BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
			while (iterator.hasNext()) {
				INode nextNode = iterator.next();
				if (definition.getName().equals(nextNode.getText())) {
					acceptor.addPosition(nextNode.getOffset(), nextNode.getLength() + 1,
							SolidityHighlightingConfiguration.FUNCTION_NAME);

				}
			}
		}
	}

	private void provideHighligtingFor(Property property, IHighlightedPositionAcceptor acceptor) {
		if (property instanceof VariableDefinition) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(property.getTypeSpecifier());
			if (node != null) {
				acceptor.addPosition(node.getOffset(), node.getLength() + 1, SolidityHighlightingConfiguration.TYPES);
			}
		}
	}

	private void provideHighligtingFor(ElementReferenceExpression expression,
			org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor) {

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
