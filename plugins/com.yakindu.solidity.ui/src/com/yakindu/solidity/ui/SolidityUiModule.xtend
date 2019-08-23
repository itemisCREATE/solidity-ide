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
package com.yakindu.solidity.ui

import com.google.inject.Binder
import com.google.inject.name.Names
import com.yakindu.solidity.IWorkspaceResourceResolver
import com.yakindu.solidity.ui.contentassist.SolidityContentProposalPriorities
import com.yakindu.solidity.ui.editor.SolidityFoldingRegionProvider
import com.yakindu.solidity.ui.editor.SolidityHyperlinkHelper
import com.yakindu.solidity.ui.editor.SolidityIndentationInformation
import com.yakindu.solidity.ui.help.CustomCSSHelpHoverProvider
import com.yakindu.solidity.ui.help.SolidityUserHelpDocumentationProvider
import com.yakindu.solidity.ui.highlighting.SolidityHighlightingConfiguration
import com.yakindu.solidity.ui.highlighting.SoliditySemanticHighlighter
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.formatting.IIndentationInformation
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalPriorities
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import org.yakindu.base.utils.jface.help.CrossRefObjectTextHover

/**
 * @author Andreas Muelder - Initial contribution and API
 * @author Karsten Thoms
 * @author Florian Antony
 */
@FinalFieldsConstructor
class SolidityUiModule extends AbstractSolidityUiModule {

	override configure(Binder binder) {
		super.configure(binder)
		binder.bind(ISemanticHighlightingCalculator).to(SoliditySemanticHighlighter)
		binder.bind(IHighlightingConfiguration).to(SolidityHighlightingConfiguration)
		binder.bind(IEObjectDocumentationProvider).to(SolidityUserHelpDocumentationProvider)
		binder.bind(DispatchingEObjectTextHover).to(CrossRefObjectTextHover)
		binder.bind(String).annotatedWith(Names.named("stylesheet")).toInstance("/sphinx_rtd_theme.css")
		binder.bind(IEObjectHoverProvider).to(CustomCSSHelpHoverProvider)
		binder.bind(IWorkspaceResourceResolver).to(WorkspaceResourceResolver);
	}

	override bindIEObjectHover() {
		CrossRefObjectTextHover
	}

	def Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() { SolidityHyperlinkHelper }

	def Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() { SolidityFoldingRegionProvider }

	def Class<? extends IContentProposalPriorities> bindIContentProposalPriorities() {
		SolidityContentProposalPriorities
	}

	override Class<? extends IIndentationInformation> bindIIndentationInformation() {
		return SolidityIndentationInformation;
	}

}
