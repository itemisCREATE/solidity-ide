/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.base.expressions.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.TupleExpression#getExpressions <em>Expressions</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getTupleExpression()
 * @model
 * @generated
 */
public interface TupleExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getTupleExpression_Expressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getExpressions();

} // TupleExpression
