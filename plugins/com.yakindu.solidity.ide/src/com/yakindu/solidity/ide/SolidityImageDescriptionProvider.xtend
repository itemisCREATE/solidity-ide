package com.yakindu.solidity.ide

import org.eclipse.xtext.ide.labels.EClassImageDescriptionProvider

class SolidityImageDescriptionProvider extends EClassImageDescriptionProvider {
	override getImageDescription(Object element) {
		val baseImage = super.getImageDescription(element)
		switch element {
			default:
				baseImage
		}
	}
}