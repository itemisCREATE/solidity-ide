package com.yakindu.solidity.ui

import com.google.inject.Binder
import com.google.inject.name.Names
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
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalPriorities
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.yakindu.base.utils.jface.help.CrossRefObjectTextHover

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
