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
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.types.Declaration;


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
			if (next instanceof ElementReferenceExpression) {
				if (next instanceof ElementReferenceExpression) {
					ElementReferenceExpression expression = (ElementReferenceExpression) next;
					provideHighligtingFor(expression, acceptor);
				}
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
