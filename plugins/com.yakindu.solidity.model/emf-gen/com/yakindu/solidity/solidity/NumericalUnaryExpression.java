/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.yakindu.base.expressions.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.NumericalUnaryExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.NumericalUnaryExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getNumericalUnaryExpression()
 * @model
 * @generated
 */
public interface NumericalUnaryExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link com.yakindu.solidity.solidity.UnaryOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see com.yakindu.solidity.solidity.UnaryOperator
	 * @see #setOperator(UnaryOperator)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getNumericalUnaryExpression_Operator()
	 * @model
	 * @generated
	 */
	UnaryOperator getOperator();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.NumericalUnaryExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see com.yakindu.solidity.solidity.UnaryOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(UnaryOperator value);

	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference.
	 * @see #setOperand(Expression)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getNumericalUnaryExpression_Operand()
	 * @model containment="true"
	 * @generated
	 */
	Expression getOperand();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.NumericalUnaryExpression#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(Expression value);

} // NumericalUnaryExpression
