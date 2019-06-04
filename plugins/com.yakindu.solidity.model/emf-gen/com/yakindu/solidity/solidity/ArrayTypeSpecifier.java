/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.eclipse.emf.common.util.EList;

import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;

import org.yakindu.base.types.TypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.ArrayTypeSpecifier#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getArrayTypeSpecifier()
 * @model
 * @generated
 */
public interface ArrayTypeSpecifier extends TypeSpecifier {
	/**
	 * Returns the value of the '<em><b>Index</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.expressions.expressions.PrimitiveValueExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' containment reference list.
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getArrayTypeSpecifier_Index()
	 * @model containment="true"
	 * @generated
	 */
	EList<PrimitiveValueExpression> getIndex();

} // ArrayTypeSpecifier
