/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.eclipse.emf.common.util.EList;

import org.yakindu.base.types.PackageMember;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.SourceUnit#getPragma <em>Pragma</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.SourceUnit#getImports <em>Imports</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getSourceUnit()
 * @model
 * @generated
 */
public interface SourceUnit extends org.yakindu.base.types.Package {
	/**
	 * Returns the value of the '<em><b>Pragma</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.PackageMember}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pragma</em>' containment reference list.
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getSourceUnit_Pragma()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageMember> getPragma();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.PackageMember}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getSourceUnit_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageMember> getImports();

} // SourceUnit
