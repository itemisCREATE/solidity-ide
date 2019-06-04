/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.yakindu.base.expressions.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exponential Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.ExponentialExpression#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.ExponentialExpression#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getExponentialExpression()
 * @model
 * @generated
 */
public interface ExponentialExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(Expression)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getExponentialExpression_LeftOperand()
	 * @model containment="true"
	 * @generated
	 */
	Expression getLeftOperand();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.ExponentialExpression#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(Expression value);

	/**
	 * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operand</em>' containment reference.
	 * @see #setRightOperand(Expression)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getExponentialExpression_RightOperand()
	 * @model containment="true"
	 * @generated
	 */
	Expression getRightOperand();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.ExponentialExpression#getRightOperand <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' containment reference.
	 * @see #getRightOperand()
	 * @generated
	 */
	void setRightOperand(Expression value);

} // ExponentialExpression
