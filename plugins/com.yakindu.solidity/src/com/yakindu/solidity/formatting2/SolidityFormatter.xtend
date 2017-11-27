package com.yakindu.solidity.formatting2

import com.google.inject.Inject
import com.yakindu.solidity.services.SolidityGrammarAccess
import com.yakindu.solidity.solidity.ContractDefinition
import com.yakindu.solidity.solidity.ImportDirective
import com.yakindu.solidity.solidity.SolidityModel
import com.yakindu.solidity.solidity.SolidityPackage
import com.yakindu.solidity.solidity.SourceUnit
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.yakindu.base.types.Package
import org.yakindu.base.types.PackageMember

/**
 * Code formatter for Solidity according to 
 * <a href="http://solidity.readthedocs.io/en/develop/style-guide.html">Solidity Styleguide</a>.
 */
class SolidityFormatter extends AbstractFormatter2 {
	
	@Inject extension SolidityGrammarAccess
	@Inject extension SolidityPackage

	def dispatch void format(SolidityModel solidityModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Package _package : solidityModel.getSourceunit()) {
			_package.format;
		}
		solidityModel.allRegionsFor.keywords(';').forEach[prepend[noSpace]]

		solidityModel.allRegionsFor.keywordPairs('{','}').forEach[
			key.append[newLine]
			interior[indent]
			value.prepend[newLine]
		]
	}

	def dispatch void format(SourceUnit sourceUnit, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		sourceUnit.getPragma.format;
		for (PackageMember packageMember : sourceUnit.getImports()) {
			packageMember.format;
		}
		for (PackageMember packageMember : sourceUnit.getMember()) {
			packageMember.format;
		}
	}
	
	def dispatch void format(ImportDirective element, extension IFormattableDocument document) {
		element.regionFor.keyword("import").append[oneSpace]
	}

	def dispatch void format(ContractDefinition element, extension IFormattableDocument document) {
		element.append[setNewLines(2,2,2)]
	}
}
