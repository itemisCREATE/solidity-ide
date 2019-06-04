/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.impl;

import com.yakindu.solidity.solidity.Block;
import com.yakindu.solidity.solidity.FunctionDefinition;
import com.yakindu.solidity.solidity.Modifier;
import com.yakindu.solidity.solidity.SolidityPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.base.types.Parameter;

import org.yakindu.base.types.impl.OperationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.impl.FunctionDefinitionImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.FunctionDefinitionImpl#getReturnParameters <em>Return Parameters</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.FunctionDefinitionImpl#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionDefinitionImpl extends OperationImpl implements FunctionDefinition {
	/**
	 * The cached value of the '{@link #getModifier() <em>Modifier</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected EList<Modifier> modifier;

	/**
	 * The cached value of the '{@link #getReturnParameters() <em>Return Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> returnParameters;

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
	protected FunctionDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolidityPackage.Literals.FUNCTION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Modifier> getModifier() {
		if (modifier == null) {
			modifier = new EObjectContainmentEList<Modifier>(Modifier.class, this, SolidityPackage.FUNCTION_DEFINITION__MODIFIER);
		}
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameter> getReturnParameters() {
		if (returnParameters == null) {
			returnParameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, SolidityPackage.FUNCTION_DEFINITION__RETURN_PARAMETERS);
		}
		return returnParameters;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolidityPackage.FUNCTION_DEFINITION__BLOCK, oldBlock, newBlock);
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
				msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.FUNCTION_DEFINITION__BLOCK, null, msgs);
			if (newBlock != null)
				msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.FUNCTION_DEFINITION__BLOCK, null, msgs);
			msgs = basicSetBlock(newBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.FUNCTION_DEFINITION__BLOCK, newBlock, newBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolidityPackage.FUNCTION_DEFINITION__MODIFIER:
				return ((InternalEList<?>)getModifier()).basicRemove(otherEnd, msgs);
			case SolidityPackage.FUNCTION_DEFINITION__RETURN_PARAMETERS:
				return ((InternalEList<?>)getReturnParameters()).basicRemove(otherEnd, msgs);
			case SolidityPackage.FUNCTION_DEFINITION__BLOCK:
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
			case SolidityPackage.FUNCTION_DEFINITION__MODIFIER:
				return getModifier();
			case SolidityPackage.FUNCTION_DEFINITION__RETURN_PARAMETERS:
				return getReturnParameters();
			case SolidityPackage.FUNCTION_DEFINITION__BLOCK:
				return getBlock();
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
			case SolidityPackage.FUNCTION_DEFINITION__MODIFIER:
				getModifier().clear();
				getModifier().addAll((Collection<? extends Modifier>)newValue);
				return;
			case SolidityPackage.FUNCTION_DEFINITION__RETURN_PARAMETERS:
				getReturnParameters().clear();
				getReturnParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case SolidityPackage.FUNCTION_DEFINITION__BLOCK:
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
			case SolidityPackage.FUNCTION_DEFINITION__MODIFIER:
				getModifier().clear();
				return;
			case SolidityPackage.FUNCTION_DEFINITION__RETURN_PARAMETERS:
				getReturnParameters().clear();
				return;
			case SolidityPackage.FUNCTION_DEFINITION__BLOCK:
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
			case SolidityPackage.FUNCTION_DEFINITION__MODIFIER:
				return modifier != null && !modifier.isEmpty();
			case SolidityPackage.FUNCTION_DEFINITION__RETURN_PARAMETERS:
				return returnParameters != null && !returnParameters.isEmpty();
			case SolidityPackage.FUNCTION_DEFINITION__BLOCK:
				return block != null;
		}
		return super.eIsSet(featureID);
	}

} //FunctionDefinitionImpl
