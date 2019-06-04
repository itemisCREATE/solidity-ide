/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.impl;

import com.yakindu.solidity.solidity.Block;
import com.yakindu.solidity.solidity.ModifierDefinition;
import com.yakindu.solidity.solidity.SolidityPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.types.impl.OperationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modifier Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.impl.ModifierDefinitionImpl#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModifierDefinitionImpl extends OperationImpl implements ModifierDefinition {
	/**
	 * The cached value of the '{@link #getBlock() <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlock()
	 * @generated
	 * @ordered
	 */
	protected Block block;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifierDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolidityPackage.Literals.MODIFIER_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Block getBlock() {
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBlock(Block newBlock, NotificationChain msgs) {
		Block oldBlock = block;
		block = newBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolidityPackage.MODIFIER_DEFINITION__BLOCK, oldBlock, newBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBlock(Block newBlock) {
		if (newBlock != block) {
			NotificationChain msgs = null;
			if (block != null)
				msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.MODIFIER_DEFINITION__BLOCK, null, msgs);
			if (newBlock != null)
				msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.MODIFIER_DEFINITION__BLOCK, null, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.MODIFIER_DEFINITION__BLOCK, newBlock, newBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolidityPackage.MODIFIER_DEFINITION__BLOCK:
				return basicSetBlock(null, msgs);
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
			case SolidityPackage.MODIFIER_DEFINITION__BLOCK:
				return getBlock();
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
			case SolidityPackage.MODIFIER_DEFINITION__BLOCK:
				setBlock((Block)newValue);
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
			case SolidityPackage.MODIFIER_DEFINITION__BLOCK:
				setBlock((Block)null);
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
			case SolidityPackage.MODIFIER_DEFINITION__BLOCK:
				return block != null;
		}
		return super.eIsSet(featureID);
	}

} //ModifierDefinitionImpl
