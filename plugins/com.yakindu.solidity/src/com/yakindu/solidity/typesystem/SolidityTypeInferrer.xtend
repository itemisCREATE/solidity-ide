package com.yakindu.solidity.typesystem

import com.google.inject.Inject
import com.yakindu.solidity.solidity.AddressLiteral
import com.yakindu.solidity.solidity.BigIntLiteral
import com.yakindu.solidity.solidity.FunctionDefinition
import com.yakindu.solidity.solidity.NumericalMultiplyDivideExpression
import com.yakindu.solidity.solidity.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrer
import org.yakindu.base.types.Type
import org.yakindu.base.types.typesystem.ITypeSystem

import static org.yakindu.base.types.typesystem.ITypeSystem.REAL

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class SolidityTypeInferrer extends ExpressionsTypeInferrer {

	@Inject protected ITypeSystem ts;

	def doInfer(BigIntLiteral literal) {
		InferenceResult.from(ts.getType(SolidityTypeSystem.INTEGER));
	}

	def doInfer(AddressLiteral literal) {
		InferenceResult.from(ts.getType(SolidityTypeSystem.ADDRESS));
	}

	def doInfer(PostFixUnaryExpression exp) {
		return inferTypeDispatch(exp.operand)
	}

	override assertAssignable(InferenceResult varResult, InferenceResult valueResult, String msg) {
		if (ts.isSame(valueResult.type, ts.getType(ITypeSystem.INTEGER)) &&
			ts.isSuperType(varResult.type, ts.getType(ITypeSystem.INTEGER))) {
			return;
		}
		super.assertCompatible(varResult, valueResult, msg)
	}

	override doInfer(BoolLiteral literal) {
		InferenceResult.from(ts.getType(SolidityTypeSystem.BOOL))
	}
	
	def doInfer(NumericalMultiplyDivideExpression e) {
		var result1 = inferTypeDispatch(e.getLeftOperand())
		var result2 = inferTypeDispatch(e.getRightOperand())
		assertCompatible(result1, result2, String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2))
		assertIsSubType(result1, getResultFor(REAL),
				String.format(ARITHMETIC_OPERATORS, e.getOperator(), result1, result2))
		getCommonType(result1, result2)
	}

	// Type Cast	
	override doInfer(ElementReferenceExpression e) {
		if (e.isOperationCall() && (e.reference instanceof Type)) {
			return inferTypeDispatch(e.reference)
		}
		return super.doInfer(e)
	}
	
	def doInfer(FunctionDefinition op) {
		if (op.returnParameters.size == 0 && op.typeSpecifier === null)
			getResultFor(ITypeSystem.VOID)
		else if (op.typeSpecifier !== null)
			return inferTypeDispatch(op.typeSpecifier.type)
		else
			inferTypeDispatch(op.returnParameters.head);
	}

	override protected getResultFor(String name) {
		if (ITypeSystem.BOOLEAN.equals(name))
			return super.getResultFor(SolidityTypeSystem.BOOL)
		else
			return super.getResultFor(name)
	}
}
