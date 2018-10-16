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
package com.yakindu.solidity.ui.editor;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.yakindu.base.types.typesystem.AbstractTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.yakindu.solidity.solidity.ImportDirective;
import com.yakindu.solidity.solidity.SolidityPackage;

/**
 * Hyperlinking customizations:
 * <ul>
 * <li>Disable hyperlinks for build-in elements
 * 
 * @author Karsten Thoms - Initial contribution and API 
 * @author Jonathan Thoene
 *
 */
public class SolidityHyperlinkHelper extends HyperlinkHelper {
	@Inject ITypeSystem typeSystem;
	
	@Override
	public void createHyperlinksTo(XtextResource from, Region region, EObject target, IHyperlinkAcceptor acceptor) {
		if (((AbstractTypeSystem)typeSystem).getResource() == target.eResource()) {
			// build-in elements are defined in the resource of the type system
			// don't create hyperlinks to them
			return;
		}
		super.createHyperlinksTo(from, region, target, acceptor);
	}
	
	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		createImportedNamespacesHyperlinksByOffset(resource, offset, acceptor);
		super.createHyperlinksByOffset(resource, offset, acceptor);
	}

	protected void createImportedNamespacesHyperlinksByOffset(XtextResource resource, int offset,
			IHyperlinkAcceptor acceptor) {
		INode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
		if (node != null) {			
			List<INode> importNodes = NodeModelUtils.findNodesForFeature(node.getSemanticElement(), SolidityPackage.Literals.IMPORT_DIRECTIVE__IMPORTED_NAMESPACE);
			if (importNodes != null && !importNodes.isEmpty()) {
				for (INode importNode : importNodes) {
					ImportDirective importElement = (ImportDirective) importNode.getSemanticElement();
					URI targetURI = getFileURIOfImport(importElement);
					XtextHyperlink result = getHyperlinkProvider().get();
					result.setURI(targetURI);
					Region region = new Region(importNode.getOffset(), importNode.getLength());
					result.setHyperlinkRegion(region);
					result.setHyperlinkText(targetURI.toString());
					acceptor.accept(result);
				}
			}
		}
	}
	
	protected URI getFileURIOfImport (ImportDirective importElement) {
		URI fileURI = importElement.eResource().getURI().trimSegments(1);
		String importURI = importElement.getImportedNamespace();
		while (importURI.startsWith("../")) {
			fileURI = fileURI.trimSegments(1);
			importURI = importURI.replaceFirst("../", "");
		}
		String[] segments = importURI.split("/");
		for (String segment : segments) {
			fileURI = fileURI.appendSegment(segment);
		}
		return fileURI;
	}
}
