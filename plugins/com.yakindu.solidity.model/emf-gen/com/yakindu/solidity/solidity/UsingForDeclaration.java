/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.yakindu.base.types.Declaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Using For Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.UsingForDeclaration#getContract <em>Contract</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getUsingForDeclaration()
 * @model
 * @generated
 */
public interface UsingForDeclaration extends Declaration {
	/**
	 * Returns the value of the '<em><b>Contract</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contract</em>' reference.
	 * @see #setContract(ContractDefinition)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getUsingForDeclaration_Contract()
	 * @model
	 * @generated
	 */
	ContractDefinition getContract();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.UsingForDeclaration#getContract <em>Contract</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contract</em>' reference.
	 * @see #getContract()
	 * @generated
	 */
	void setContract(ContractDefinition value);

} // UsingForDeclaration
