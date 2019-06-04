/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pragma Solidity Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.PragmaSolidityDirective#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getPragmaSolidityDirective()
 * @model
 * @generated
 */
public interface PragmaSolidityDirective extends PragmaDirective {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getPragmaSolidityDirective_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.PragmaSolidityDirective#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // PragmaSolidityDirective
