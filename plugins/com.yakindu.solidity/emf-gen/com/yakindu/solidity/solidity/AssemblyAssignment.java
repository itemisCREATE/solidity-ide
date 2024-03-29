/**
 * generated by Xtext 2.18.0
 */
package com.yakindu.solidity.solidity;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assembly Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.AssemblyAssignment#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.AssemblyAssignment#getExpression <em>Expression</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.AssemblyAssignment#getRightOpernd <em>Right Opernd</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getAssemblyAssignment()
 * @model
 * @generated
 */
public interface AssemblyAssignment extends EObject {
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' attribute.
	 * @see #setLeftOperand(String)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getAssemblyAssignment_LeftOperand()
	 * @model
	 * @generated
	 */
	String getLeftOperand();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.AssemblyAssignment#getLeftOperand <em>Left Operand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' attribute.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(FunctionalAssemblyExpression)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getAssemblyAssignment_Expression()
	 * @model containment="true"
	 * @generated
	 */
	FunctionalAssemblyExpression getExpression();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.AssemblyAssignment#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(FunctionalAssemblyExpression value);

	/**
	 * Returns the value of the '<em><b>Right Opernd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Opernd</em>' attribute.
	 * @see #setRightOpernd(String)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getAssemblyAssignment_RightOpernd()
	 * @model
	 * @generated
	 */
	String getRightOpernd();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.AssemblyAssignment#getRightOpernd <em>Right Opernd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Opernd</em>' attribute.
	 * @see #getRightOpernd()
	 * @generated
	 */
	void setRightOpernd(String value);

} // AssemblyAssignment
