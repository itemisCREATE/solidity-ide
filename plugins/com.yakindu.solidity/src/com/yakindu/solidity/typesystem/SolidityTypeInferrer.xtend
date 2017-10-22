package com.yakindu.solidity.typesystem

import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer
import com.google.inject.Inject

class SolidityTypeInferrer extends STextTypeInferrer {
	@Inject protected ITypeSystem ts;

	override assertAssignable(InferenceResult varResult, InferenceResult valueResult, String msg) {
		if (ts.isSame(valueResult.type, ts.getType(ITypeSystem.INTEGER)) &&
			ts.isSuperType(varResult.type, ts.getType(ITypeSystem.INTEGER))) {
			return;
		}
		super.assertAssignable(varResult, valueResult, msg);
	}

}
