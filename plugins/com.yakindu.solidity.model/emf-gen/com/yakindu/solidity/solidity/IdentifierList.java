/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.base.types.Declaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.IdentifierList#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getIdentifierList()
 * @model
 * @generated
 */
public interface IdentifierList extends EObject {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Declaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' containment reference list.
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getIdentifierList_Identifier()
	 * @model containment="true"
	 * @generated
	 */
	EList<Declaration> getIdentifier();

} // IdentifierList
