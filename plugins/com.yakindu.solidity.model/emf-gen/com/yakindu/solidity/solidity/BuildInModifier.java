/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Build In Modifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.BuildInModifier#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getBuildInModifier()
 * @model
 * @generated
 */
public interface BuildInModifier extends Modifier {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.yakindu.solidity.solidity.FunctionModifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.yakindu.solidity.solidity.FunctionModifier
	 * @see #setType(FunctionModifier)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getBuildInModifier_Type()
	 * @model
	 * @generated
	 */
	FunctionModifier getType();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.BuildInModifier#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.yakindu.solidity.solidity.FunctionModifier
	 * @see #getType()
	 * @generated
	 */
	void setType(FunctionModifier value);

} // BuildInModifier
