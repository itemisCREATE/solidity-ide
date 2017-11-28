package com.yakindu.solidity.ui.contentassist;

import java.util.Collections;
import java.util.Set;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Sets;

/**
 * Order proposals such that perfectly matching prefix proposals come first followed by proposals that at least have the
 * prefix as the start.
 * 
 * @author Arne Deutsch
 */
public class SolidityContentProposalPriorities extends org.eclipse.xtext.ui.editor.contentassist.ContentProposalPriorities {
	public SolidityContentProposalPriorities() {
		sameTextMultiplier = 3.0;
		proposalWithPrefixMultiplier = 2;
	}

	@Override
	protected void adjustPriority(ICompletionProposal proposal, String prefix, int priority) {
		if (proposal == null || !(proposal instanceof ConfigurableCompletionProposal))
			return;
		ConfigurableCompletionProposal castedProposal = (ConfigurableCompletionProposal) proposal;
		if (castedProposal.getPriority() != getDefaultPriority())
			return;
		int adjustedPriority = priority;
		if (!Strings.isEmpty(prefix)) {
			if (castedProposal.getReplacementString().equals(prefix))
				adjustedPriority = (int) (adjustedPriority * sameTextMultiplier);
			else if (castedProposal.getReplacementString().startsWith(prefix))
				adjustedPriority = adjustedPriority * proposalWithPrefixMultiplier;
		}
		castedProposal.setPriority(adjustedPriority);
	}

}
