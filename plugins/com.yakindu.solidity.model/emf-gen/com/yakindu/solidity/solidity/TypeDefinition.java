/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.TypeDefinition#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getTypeDefinition()
 * @model
 * @generated
 */
public interface TypeDefinition extends Declaration {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference.
	 * @see #setDefinition(Type)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getTypeDefinition_Definition()
	 * @model containment="true"
	 * @generated
	 */
	Type getDefinition();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.TypeDefinition#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(Type value);

} // TypeDefinition
