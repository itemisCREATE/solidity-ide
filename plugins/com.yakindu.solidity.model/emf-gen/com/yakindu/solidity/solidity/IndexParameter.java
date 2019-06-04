/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.yakindu.base.types.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.IndexParameter#isIndexed <em>Indexed</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getIndexParameter()
 * @model
 * @generated
 */
public interface IndexParameter extends Parameter {
	/**
	 * Returns the value of the '<em><b>Indexed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Indexed</em>' attribute.
	 * @see #setIndexed(boolean)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getIndexParameter_Indexed()
	 * @model
	 * @generated
	 */
	boolean isIndexed();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.IndexParameter#isIndexed <em>Indexed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Indexed</em>' attribute.
	 * @see #isIndexed()
	 * @generated
	 */
	void setIndexed(boolean value);

} // IndexParameter
