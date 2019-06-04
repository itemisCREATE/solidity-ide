/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.impl;

import com.yakindu.solidity.solidity.SolidityPackage;
import com.yakindu.solidity.solidity.SourceUnit;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.base.types.PackageMember;

import org.yakindu.base.types.impl.PackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.impl.SourceUnitImpl#getPragma <em>Pragma</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.SourceUnitImpl#getImports <em>Imports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceUnitImpl extends PackageImpl implements SourceUnit {
	/**
	 * The cached value of the '{@link #getPragma() <em>Pragma</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPragma()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageMember> pragma;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageMember> imports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolidityPackage.Literals.SOURCE_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PackageMember> getPragma() {
		if (pragma == null) {
			pragma = new EObjectContainmentEList<PackageMember>(PackageMember.class, this, SolidityPackage.SOURCE_UNIT__PRAGMA);
		}
		return pragma;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PackageMember> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<PackageMember>(PackageMember.class, this, SolidityPackage.SOURCE_UNIT__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolidityPackage.SOURCE_UNIT__PRAGMA:
				return ((InternalEList<?>)getPragma()).basicRemove(otherEnd, msgs);
			case SolidityPackage.SOURCE_UNIT__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SolidityPackage.SOURCE_UNIT__PRAGMA:
				return getPragma();
			case SolidityPackage.SOURCE_UNIT__IMPORTS:
				return getImports();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SolidityPackage.SOURCE_UNIT__PRAGMA:
				getPragma().clear();
				getPragma().addAll((Collection<? extends PackageMember>)newValue);
				return;
			case SolidityPackage.SOURCE_UNIT__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends PackageMember>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SolidityPackage.SOURCE_UNIT__PRAGMA:
				getPragma().clear();
				return;
			case SolidityPackage.SOURCE_UNIT__IMPORTS:
				getImports().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SolidityPackage.SOURCE_UNIT__PRAGMA:
				return pragma != null && !pragma.isEmpty();
			case SolidityPackage.SOURCE_UNIT__IMPORTS:
				return imports != null && !imports.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SourceUnitImpl
