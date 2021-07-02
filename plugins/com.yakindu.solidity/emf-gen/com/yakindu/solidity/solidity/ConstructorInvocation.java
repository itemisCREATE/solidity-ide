/**
 * generated by Xtext 2.18.0
 */
package com.yakindu.solidity.solidity;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructor Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.ConstructorInvocation#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getConstructorInvocation()
 * @model
 * @generated
 */
public interface ConstructorInvocation extends ModifierInvocation {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(ContractDefinition)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getConstructorInvocation_Reference()
	 * @model
	 * @generated
	 */
	ContractDefinition getReference();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.ConstructorInvocation#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(ContractDefinition value);

} // ConstructorInvocation