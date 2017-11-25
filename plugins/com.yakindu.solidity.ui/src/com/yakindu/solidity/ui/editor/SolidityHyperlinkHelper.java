package com.yakindu.solidity.ui.editor;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.yakindu.base.types.typesystem.AbstractTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;

/**
 * Hyperlinking customizations:
 * <ul>
 * <li>Disable hyperlinks for build-in elements
 * 
 * @author thoms
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
}
