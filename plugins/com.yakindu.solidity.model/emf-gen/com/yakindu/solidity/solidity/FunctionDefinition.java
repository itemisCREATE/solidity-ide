/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.eclipse.emf.common.util.EList;

import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.FunctionDefinition#getModifier <em>Modifier</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.FunctionDefinition#getReturnParameters <em>Return Parameters</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.FunctionDefinition#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getFunctionDefinition()
 * @model
 * @generated
 */
public interface FunctionDefinition extends Operation {
	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' containment reference list.
	 * The list contents are of type {@link com.yakindu.solidity.solidity.Modifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' containment reference list.
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getFunctionDefinition_Modifier()
	 * @model containment="true"
	 * @generated
	 */
	EList<Modifier> getModifier();

	/**
	 * Returns the value of the '<em><b>Return Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Parameters</em>' containment reference list.
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getFunctionDefinition_ReturnParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getReturnParameters();

	/**
	 * Returns the value of the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' containment reference.
	 * @see #setBlock(Block)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getFunctionDefinition_Block()
	 * @model containment="true"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.FunctionDefinition#getBlock <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' containment reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

} // FunctionDefinition
