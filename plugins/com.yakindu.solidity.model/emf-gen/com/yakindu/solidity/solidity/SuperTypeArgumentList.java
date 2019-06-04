/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.base.expressions.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Super Type Argument List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.SuperTypeArgumentList#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getSuperTypeArgumentList()
 * @model
 * @generated
 */
public interface SuperTypeArgumentList extends EObject {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.expressions.expressions.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getSuperTypeArgumentList_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArguments();

} // SuperTypeArgumentList
