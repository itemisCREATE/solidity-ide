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

import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.yakindu.solidity.solidity.SolidityPackage;
import com.yakindu.solidity.ui.preferences.ISolidityPreferencesConstants;

/**
 * Additionally to the default behavior all leading single comment lines are
 * combined to a initially collapsed region. This region usually contains CVS
 * log comments and can be rather long.
 * 
 * @author Karsten Thoms (karsten.thoms@itemis.de)
 */
public class SolidityFoldingRegionProvider extends DefaultFoldingRegionProvider {
	private static final Logger log = Logger.getLogger(SolidityFoldingRegionProvider.class);
	private static final Set<EClass> FOLDING_TYPES = Sets.newHashSet(SolidityPackage.Literals.CONTRACT_DEFINITION,
			SolidityPackage.Literals.FUNCTION_DEFINITION);

	@Inject
	private IPreferenceStoreAccess prefs;

	@Override
	protected void computeObjectFolding(EObject eObject, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor,
			boolean initiallyFolded) {
		if (FOLDING_TYPES.contains(eObject.eClass())) {
			super.computeObjectFolding(eObject, foldingRegionAcceptor, initiallyFolded);
		}
	}

	@Override
	protected void computeCommentFolding(IXtextDocument xtextDocument,
			IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor, ITypedRegion typedRegion,
			boolean initiallyFolded) {

		String text;
		try {
			text = xtextDocument.get(typedRegion.getOffset(), typedRegion.getLength());
			int lines = Strings.countLines(text);
			if (shouldCreateCommentFolding(lines)) {
				boolean collapse = shouldCollapse(typedRegion, lines);
				super.computeCommentFolding(xtextDocument, foldingRegionAcceptor, typedRegion, collapse);
			}
		} catch (BadLocationException e) {
			log.error(e, e);
		}

	}

	private boolean shouldCreateCommentFolding(int lines) {
		int threshold = prefs.getPreferenceStore().getInt(ISolidityPreferencesConstants.FOLDING_COMMENT_LINECOUNT);
		return lines > threshold;
	}

	private boolean shouldCollapse(ITypedRegion beginRegion, int lines) {
		String autofoldOption = prefs.getPreferenceStore().getString(ISolidityPreferencesConstants.FOLDING_COMMENT_AUTOFOLD);
		if (ISolidityPreferencesConstants.FOLDING_COMMENT_AUTOFOLD_NONE.equals(autofoldOption))
			return false;
		if (ISolidityPreferencesConstants.FOLDING_COMMENT_AUTOFOLD_ALL.equals(autofoldOption))
			return true;
		if (ISolidityPreferencesConstants.FOLDING_COMMENT_AUTOFOLD_HEADER.equals(autofoldOption))
			return beginRegion.getOffset() == 0;
		return false;
	}
}
