/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assembly Local Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.AssemblyLocalBinding#getLabel <em>Label</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.AssemblyLocalBinding#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getAssemblyLocalBinding()
 * @model
 * @generated
 */
public interface AssemblyLocalBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getAssemblyLocalBinding_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.AssemblyLocalBinding#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(EObject)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getAssemblyLocalBinding_Expression()
	 * @model containment="true"
	 * @generated
	 */
	EObject getExpression();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.AssemblyLocalBinding#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(EObject value);

} // AssemblyLocalBinding
