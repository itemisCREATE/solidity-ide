package com.yakindu.solidity.ide

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.util.CancelIndicator

class SoliditySemanticHighlightingCalculator extends DefaultSemanticHighlightingCalculator {
	
	override protected highlightElement(EObject it, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		// TODO Add specific highlighting
		return false
	}
	
}