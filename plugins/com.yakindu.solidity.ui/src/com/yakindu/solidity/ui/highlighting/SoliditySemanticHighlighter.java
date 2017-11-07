package com.yakindu.solidity.ui.highlighting;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.types.Declaration;

@SuppressWarnings("deprecation")
public class SoliditySemanticHighlighter
		implements
			org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator {

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
			if (decl.getName().equals("msg")) {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(expression);
				acceptor.addPosition(node.getTotalOffset(), node.getLength() + 1,
						DefaultHighlightingConfiguration.KEYWORD_ID);
			}
			if (decl.getName().equals("block")) {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(expression);
				acceptor.addPosition(node.getTotalOffset(), node.getLength() + 1,
						DefaultHighlightingConfiguration.KEYWORD_ID);
			}
			if (decl.getName().equals("tx")) {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(expression);
				acceptor.addPosition(node.getTotalOffset(), node.getLength() + 1,
						DefaultHighlightingConfiguration.KEYWORD_ID);
			}
			if (decl.getName().equals("now")) {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(expression);
				acceptor.addPosition(node.getTotalOffset(), node.getLength() + 1,
						DefaultHighlightingConfiguration.KEYWORD_ID);
			}
		}
	}
}
