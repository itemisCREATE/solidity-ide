/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.Parameter#getStorage <em>Storage</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends org.yakindu.base.types.Parameter {
	/**
	 * Returns the value of the '<em><b>Storage</b></em>' attribute.
	 * The literals are from the enumeration {@link com.yakindu.solidity.solidity.StorageLocation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storage</em>' attribute.
	 * @see com.yakindu.solidity.solidity.StorageLocation
	 * @see #setStorage(StorageLocation)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getParameter_Storage()
	 * @model
	 * @generated
	 */
	StorageLocation getStorage();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.Parameter#getStorage <em>Storage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storage</em>' attribute.
	 * @see com.yakindu.solidity.solidity.StorageLocation
	 * @see #getStorage()
	 * @generated
	 */
	void setStorage(StorageLocation value);

} // Parameter
