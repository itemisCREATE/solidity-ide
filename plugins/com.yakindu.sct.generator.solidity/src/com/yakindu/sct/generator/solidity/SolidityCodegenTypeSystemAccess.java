package com.yakindu.sct.generator.solidity;

import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;

public class SolidityCodegenTypeSystemAccess implements ICodegenTypeSystemAccess{

	public String getTargetLanguageName(Type type) {
		return type.getName();
	}

	public String getTargetLanguageName(TypeSpecifier typeSpecifier) {
		return typeSpecifier.getType().getName();
	}

}
