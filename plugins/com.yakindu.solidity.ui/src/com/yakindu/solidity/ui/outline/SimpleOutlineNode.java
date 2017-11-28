package com.yakindu.solidity.ui.outline;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.AbstractOutlineNode;

public class SimpleOutlineNode extends AbstractOutlineNode {

	protected SimpleOutlineNode(IOutlineNode parent, Image image, Object text, boolean isLeaf) {
		super(parent, image, text, isLeaf);
	}

}
