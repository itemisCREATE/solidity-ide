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
package com.yakindu.solidity.ui.contentassist

import com.google.common.base.Function
import com.google.inject.name.Named
import com.yakindu.solidity.SolidityVersion
import java.util.Collections
import java.util.HashSet
import java.util.Set
import javax.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IResourceVisitor
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.provider.ComposedAdapterFactory
import org.eclipse.emf.edit.provider.IItemLabelProvider
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.XtextFactory
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider.DefaultProposalCreator
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.xtext.ui.editor.hover.IEObjectHover
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Type

/**
 * @author Andreas Muelder - Initial contribution and API
 * @author Karsten Thoms
 * @author Florian Antony
 */
class SolidityProposalProvider extends AbstractSolidityProposalProvider {

	val composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	static final String EXTENSION = "sol"

	static final Set<String> IGNORED_KEYWORDS = Collections.unmodifiableSet(
		#{"+", "-", "*", "/", "%", "&", "++", "--", "(", ")", "[", "]", "{", "}", ";", ",", ".", ":", "?", "!", "^",
			"=", "==", "!=", "+=", "-=", "*=", "/=", "%=", "/=", "^=", "&&=", "||=", "&=", "|=", "|", "||", "|||", "or",
			"&", "&&", "and", "<", ">", "<=", ">=", "<<", "=>", "event", "var"}
	);

	@Inject @Named(SolidityVersion.SOLIDITY_VERSION) String solcVersion

	override complete_VERSION(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		acceptor.accept(createCompletionProposal(solcVersion, solcVersion, null, context));
	}

	override completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
		ICompletionProposalAcceptor acceptor) {
		if (IGNORED_KEYWORDS.contains(keyword.value)) {
			return
		}
		super.completeKeyword(keyword, contentAssistContext, new AcceptorDelegate(acceptor, hover))
	}

	override completeImportDirective_ImportedNamespace(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val Set<IFile> result = new HashSet<IFile>();
		val contextFile = WorkspaceSynchronizer.getFile(context.currentModel.eResource)
		var workspace = contextFile.project
		workspace.accept(new IResourceVisitor() {
			override visit(IResource resource) throws CoreException {
				if (resource.type == IResource.FILE) {
					var IFile file = resource as IFile
					if (EXTENSION.equals(file.fileExtension.toLowerCase) && !contextFile.equals(file)) {
						result.add(file)
					}
				}
				return true;
			}
		})
		result.forEach [
			acceptor.accept(
				createCompletionProposal(
					"\"" + rawLocation.makeRelativeTo(contextFile.rawLocation).toString.replaceFirst("../", "") + "\";",
					name, null, context))
		]
	}

	override getDisplayString(EObject element, String qualifiedNameAsString, String shortName) {
		if (element instanceof Type) {
			return super.getDisplayString(element, qualifiedNameAsString, shortName);
		}
		if (element === null || element.eIsProxy()) {
			return qualifiedNameAsString;
		}
		var adapter = composedAdapterFactory.adapt(element, IItemLabelProvider) as IItemLabelProvider;
		if (adapter !== null) {
			return adapter.getText(element);
		}
		return super.getDisplayString(element, qualifiedNameAsString, shortName);
	}

	override Function<IEObjectDescription, ICompletionProposal> getProposalFactory(String ruleName,
		ContentAssistContext contentAssistContext) {
		return new DefaultProposalCreator(contentAssistContext, ruleName, getQualifiedNameConverter()) {
			override ICompletionProposal apply(IEObjectDescription candidate) {
				val proposal = super.apply(candidate)
				val eObjectOrProxy = candidate.getEObjectOrProxy()
				if (eObjectOrProxy.eIsProxy()) {
					return proposal
				}
				if (eObjectOrProxy instanceof Operation) {
					if (eObjectOrProxy.getParameters().size() > 0 &&
						(proposal instanceof ConfigurableCompletionProposal)) {
						val configurableProposal = proposal as ConfigurableCompletionProposal
						configurableProposal.setReplacementString(configurableProposal.getReplacementString() + "()")
						configurableProposal.setCursorPosition(configurableProposal.getCursorPosition() + 1)
					}
				}
				return proposal;
			}
		};
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
