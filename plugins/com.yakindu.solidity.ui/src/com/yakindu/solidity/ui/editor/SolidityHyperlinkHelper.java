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

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.yakindu.base.types.typesystem.AbstractTypeSystem;

import com.yakindu.solidity.typesystem.AbstractSolidityTypeSystem;
import com.yakindu.solidity.typesystem.IPragmaAwareProvider;

/**
 * Hyperlinking customizations:
 * <ul>
 * <li>Disable hyperlinks for build-in elements
 * 
 * @author Karsten Thoms - Initial contribution and API
 *
 */
public class SolidityHyperlinkHelper extends HyperlinkHelper {
	@Inject
	IPragmaAwareProvider<AbstractSolidityTypeSystem> typeSystemProvider;

	@Override
	public void createHyperlinksTo(XtextResource from, Region region, EObject target, IHyperlinkAcceptor acceptor) {
		if (((AbstractTypeSystem) typeSystemProvider.provideFor(target)).getResource() == target.eResource()) {
			// build-in elements are defined in the resource of the type system
			// don't create hyperlinks to them
			return;
		}
		super.createHyperlinksTo(from, region, target, acceptor);
	}
}
