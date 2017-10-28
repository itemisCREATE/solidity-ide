package com.yakindu.solidity.typesystem

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrer
import org.yakindu.base.types.typesystem.ITypeSystem

class SolidityTypeInferrer extends ExpressionsTypeInferrer {
	@Inject protected ITypeSystem ts;

	override assertAssignable(InferenceResult varResult, InferenceResult valueResult, String msg) {
		if (ts.isSame(valueResult.type, ts.getType(ITypeSystem.INTEGER)) &&
			ts.isSuperType(varResult.type, ts.getType(ITypeSystem.INTEGER))) {
			return;
		}
		super.assertAssignable(varResult, valueResult, msg);
	}
	
	override doInfer(BoolLiteral literal) {
		InferenceResult.from(ts.getType(SolidityTypeSystem.BOOL))
	}

}
