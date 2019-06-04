/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.impl;

import com.yakindu.solidity.solidity.IdentifierList;
import com.yakindu.solidity.solidity.SolidityPackage;
import com.yakindu.solidity.solidity.StorageLocation;
import com.yakindu.solidity.solidity.VariableDefinition;
import com.yakindu.solidity.solidity.Visibility;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.expressions.expressions.Expression;

import org.yakindu.base.types.impl.PropertyImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.impl.VariableDefinitionImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.VariableDefinitionImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.VariableDefinitionImpl#getStorage <em>Storage</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.VariableDefinitionImpl#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableDefinitionImpl extends PropertyImpl implements VariableDefinition {
	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility VISIBILITY_EDEFAULT = Visibility.PUBLIC;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected Visibility visibility = VISIBILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected Expression initialValue;

	/**
	 * The default value of the '{@link #getStorage() <em>Storage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorage()
	 * @generated
	 * @ordered
	 */
	protected static final StorageLocation STORAGE_EDEFAULT = StorageLocation.MEMORY;

	/**
	 * The cached value of the '{@link #getStorage() <em>Storage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorage()
	 * @generated
	 * @ordered
	 */
	protected StorageLocation storage = STORAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected IdentifierList identifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolidityPackage.Literals.VARIABLE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisibility(Visibility newVisibility) {
		Visibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.VARIABLE_DEFINITION__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getInitialValue() {
		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialValue(Expression newInitialValue, NotificationChain msgs) {
		Expression oldInitialValue = initialValue;
		initialValue = newInitialValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolidityPackage.VARIABLE_DEFINITION__INITIAL_VALUE, oldInitialValue, newInitialValue);
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
	public void setInitialValue(Expression newInitialValue) {
		if (newInitialValue != initialValue) {
			NotificationChain msgs = null;
			if (initialValue != null)
				msgs = ((InternalEObject)initialValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.VARIABLE_DEFINITION__INITIAL_VALUE, null, msgs);
			if (newInitialValue != null)
				msgs = ((InternalEObject)newInitialValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.VARIABLE_DEFINITION__INITIAL_VALUE, null, msgs);
			msgs = basicSetInitialValue(newInitialValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.VARIABLE_DEFINITION__INITIAL_VALUE, newInitialValue, newInitialValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StorageLocation getStorage() {
		return storage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStorage(StorageLocation newStorage) {
		StorageLocation oldStorage = storage;
		storage = newStorage == null ? STORAGE_EDEFAULT : newStorage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.VARIABLE_DEFINITION__STORAGE, oldStorage, storage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IdentifierList getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifier(IdentifierList newIdentifier, NotificationChain msgs) {
		IdentifierList oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolidityPackage.VARIABLE_DEFINITION__IDENTIFIER, oldIdentifier, newIdentifier);
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
	public void setIdentifier(IdentifierList newIdentifier) {
		if (newIdentifier != identifier) {
			NotificationChain msgs = null;
			if (identifier != null)
				msgs = ((InternalEObject)identifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.VARIABLE_DEFINITION__IDENTIFIER, null, msgs);
			if (newIdentifier != null)
				msgs = ((InternalEObject)newIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.VARIABLE_DEFINITION__IDENTIFIER, null, msgs);
			msgs = basicSetIdentifier(newIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.VARIABLE_DEFINITION__IDENTIFIER, newIdentifier, newIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolidityPackage.VARIABLE_DEFINITION__INITIAL_VALUE:
				return basicSetInitialValue(null, msgs);
			case SolidityPackage.VARIABLE_DEFINITION__IDENTIFIER:
				return basicSetIdentifier(null, msgs);
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
			case SolidityPackage.VARIABLE_DEFINITION__VISIBILITY:
				return getVisibility();
			case SolidityPackage.VARIABLE_DEFINITION__INITIAL_VALUE:
				return getInitialValue();
			case SolidityPackage.VARIABLE_DEFINITION__STORAGE:
				return getStorage();
			case SolidityPackage.VARIABLE_DEFINITION__IDENTIFIER:
				return getIdentifier();
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
			case SolidityPackage.VARIABLE_DEFINITION__VISIBILITY:
				setVisibility((Visibility)newValue);
				return;
			case SolidityPackage.VARIABLE_DEFINITION__INITIAL_VALUE:
				setInitialValue((Expression)newValue);
				return;
			case SolidityPackage.VARIABLE_DEFINITION__STORAGE:
				setStorage((StorageLocation)newValue);
				return;
			case SolidityPackage.VARIABLE_DEFINITION__IDENTIFIER:
				setIdentifier((IdentifierList)newValue);
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
			case SolidityPackage.VARIABLE_DEFINITION__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case SolidityPackage.VARIABLE_DEFINITION__INITIAL_VALUE:
				setInitialValue((Expression)null);
				return;
			case SolidityPackage.VARIABLE_DEFINITION__STORAGE:
				setStorage(STORAGE_EDEFAULT);
				return;
			case SolidityPackage.VARIABLE_DEFINITION__IDENTIFIER:
				setIdentifier((IdentifierList)null);
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
			case SolidityPackage.VARIABLE_DEFINITION__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case SolidityPackage.VARIABLE_DEFINITION__INITIAL_VALUE:
				return initialValue != null;
			case SolidityPackage.VARIABLE_DEFINITION__STORAGE:
				return storage != STORAGE_EDEFAULT;
			case SolidityPackage.VARIABLE_DEFINITION__IDENTIFIER:
				return identifier != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (visibility: ");
		result.append(visibility);
		result.append(", storage: ");
		result.append(storage);
		result.append(')');
		return result.toString();
	}

} //VariableDefinitionImpl
