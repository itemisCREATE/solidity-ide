/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.impl;

import com.yakindu.solidity.solidity.ContractDefinition;
import com.yakindu.solidity.solidity.SolidityPackage;
import com.yakindu.solidity.solidity.UsingForDeclaration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.types.impl.DeclarationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Using For Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.impl.UsingForDeclarationImpl#getContract <em>Contract</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UsingForDeclarationImpl extends DeclarationImpl implements UsingForDeclaration {
	/**
	 * The cached value of the '{@link #getContract() <em>Contract</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContract()
	 * @generated
	 * @ordered
	 */
	protected ContractDefinition contract;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsingForDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolidityPackage.Literals.USING_FOR_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContractDefinition getContract() {
		if (contract != null && contract.eIsProxy()) {
			InternalEObject oldContract = (InternalEObject)contract;
			contract = (ContractDefinition)eResolveProxy(oldContract);
			if (contract != oldContract) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolidityPackage.USING_FOR_DECLARATION__CONTRACT, oldContract, contract));
			}
		}
		return contract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContractDefinition basicGetContract() {
		return contract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContract(ContractDefinition newContract) {
		ContractDefinition oldContract = contract;
		contract = newContract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.USING_FOR_DECLARATION__CONTRACT, oldContract, contract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SolidityPackage.USING_FOR_DECLARATION__CONTRACT:
				if (resolve) return getContract();
				return basicGetContract();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SolidityPackage.USING_FOR_DECLARATION__CONTRACT:
				setContract((ContractDefinition)newValue);
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
			case SolidityPackage.USING_FOR_DECLARATION__CONTRACT:
				setContract((ContractDefinition)null);
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
			case SolidityPackage.USING_FOR_DECLARATION__CONTRACT:
				return contract != null;
		}
		return super.eIsSet(featureID);
	}

} //UsingForDeclarationImpl
