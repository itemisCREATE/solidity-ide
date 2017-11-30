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
package com.yakindu.solidity.ui.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.util.Strings;

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
