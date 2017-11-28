package com.yakindu.solidity.ui.contentassist

import java.util.Collections
import java.util.Set
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.XtextFactory
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.xtext.ui.editor.hover.IEObjectHover

class SolidityProposalProvider extends AbstractSolidityProposalProvider {
	private static final Set<String> IGNORED_KEYWORDS = Collections.unmodifiableSet(
		#{"+", "-", "*", "/", "%", "&", "++", "--", "(", ")", "[", "]", "{", "}", ";", ",", ".", ":", "?", "!",
			"^", "=", "==", "!=", "+=", "-=", "*=", "/=", "%=", "/=", "^=", "&&=", "||=", "&=", "|=", "|", "||", "|||",
			"or", "&", "&&", "and", "<", ">", "<=", ">=", "<<", "=>", "event"}
	);

	override completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
		ICompletionProposalAcceptor acceptor) {
		if (IGNORED_KEYWORDS.contains(keyword.value)) {
			return
		}
		super.completeKeyword(keyword, contentAssistContext, acceptor)
	}

	static class AcceptorDelegate implements ICompletionProposalAcceptor {

		val ICompletionProposalAcceptor delegate
		val IEObjectHover hover

		new(ICompletionProposalAcceptor delegate, IEObjectHover hover) {
			this.delegate = delegate
			this.hover = hover
		}

		override accept(ICompletionProposal proposal) {
			if (proposal instanceof ConfigurableCompletionProposal) {
				var keyword = XtextFactory.eINSTANCE.createKeyword()
				keyword.value = proposal.displayString
				proposal.additionalProposalInfo = keyword
				proposal.hover = hover
			}
			delegate.accept(proposal)
		}

		override canAcceptMoreProposals() {
			delegate.canAcceptMoreProposals
		}
	}

}
