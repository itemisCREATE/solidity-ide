package com.yakindu.solidity.typesystem

import com.google.inject.Inject
import com.yakindu.solidity.solidity.AddressLiteral
import com.yakindu.solidity.solidity.BigIntLiteral
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrer
import org.yakindu.base.types.Type
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class SolidityTypeInferrer extends ExpressionsTypeInferrer {
	
	@Inject protected ITypeSystem ts;

	def doInfer(BigIntLiteral literal){
		InferenceResult.from(ts.getType(SolidityTypeSystem.INTEGER));
	}
	
	def doInfer(AddressLiteral literal){
		InferenceResult.from(ts.getType(SolidityTypeSystem.ADDRESS));
	}
	
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
	
	//Type Cast	
	override doInfer(ElementReferenceExpression e){
		if (e.isOperationCall() && (e.reference instanceof Type)) {
			return inferTypeDispatch(e.reference)
		}
		return super.doInfer(e)
	}

}
