/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.impl;

import com.yakindu.solidity.solidity.AssemblyAssignment;
import com.yakindu.solidity.solidity.FunctionalAssemblyExpression;
import com.yakindu.solidity.solidity.SolidityPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.impl.AssemblyAssignmentImpl#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.AssemblyAssignmentImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.AssemblyAssignmentImpl#getRightOpernd <em>Right Opernd</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssemblyAssignmentImpl extends MinimalEObjectImpl.Container implements AssemblyAssignment {
	/**
	 * The default value of the '{@link #getLeftOperand() <em>Left Operand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftOperand()
	 * @generated
	 * @ordered
	 */
	protected static final String LEFT_OPERAND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLeftOperand() <em>Left Operand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftOperand()
	 * @generated
	 * @ordered
	 */
	protected String leftOperand = LEFT_OPERAND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected FunctionalAssemblyExpression expression;

	/**
	 * The default value of the '{@link #getRightOpernd() <em>Right Opernd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightOpernd()
	 * @generated
	 * @ordered
	 */
	protected static final String RIGHT_OPERND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRightOpernd() <em>Right Opernd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightOpernd()
	 * @generated
	 * @ordered
	 */
	protected String rightOpernd = RIGHT_OPERND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssemblyAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolidityPackage.Literals.ASSEMBLY_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLeftOperand() {
		return leftOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLeftOperand(String newLeftOperand) {
		String oldLeftOperand = leftOperand;
		leftOperand = newLeftOperand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.ASSEMBLY_ASSIGNMENT__LEFT_OPERAND, oldLeftOperand, leftOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionalAssemblyExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(FunctionalAssemblyExpression newExpression, NotificationChain msgs) {
		FunctionalAssemblyExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolidityPackage.ASSEMBLY_ASSIGNMENT__EXPRESSION, oldExpression, newExpression);
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
	public void setExpression(FunctionalAssemblyExpression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.ASSEMBLY_ASSIGNMENT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.ASSEMBLY_ASSIGNMENT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.ASSEMBLY_ASSIGNMENT__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRightOpernd() {
		return rightOpernd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRightOpernd(String newRightOpernd) {
		String oldRightOpernd = rightOpernd;
		rightOpernd = newRightOpernd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.ASSEMBLY_ASSIGNMENT__RIGHT_OPERND, oldRightOpernd, rightOpernd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__EXPRESSION:
				return basicSetExpression(null, msgs);
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
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__LEFT_OPERAND:
				return getLeftOperand();
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__EXPRESSION:
				return getExpression();
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__RIGHT_OPERND:
				return getRightOpernd();
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
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__LEFT_OPERAND:
				setLeftOperand((String)newValue);
				return;
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__EXPRESSION:
				setExpression((FunctionalAssemblyExpression)newValue);
				return;
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__RIGHT_OPERND:
				setRightOpernd((String)newValue);
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
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__LEFT_OPERAND:
				setLeftOperand(LEFT_OPERAND_EDEFAULT);
				return;
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__EXPRESSION:
				setExpression((FunctionalAssemblyExpression)null);
				return;
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__RIGHT_OPERND:
				setRightOpernd(RIGHT_OPERND_EDEFAULT);
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
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__LEFT_OPERAND:
				return LEFT_OPERAND_EDEFAULT == null ? leftOperand != null : !LEFT_OPERAND_EDEFAULT.equals(leftOperand);
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__EXPRESSION:
				return expression != null;
			case SolidityPackage.ASSEMBLY_ASSIGNMENT__RIGHT_OPERND:
				return RIGHT_OPERND_EDEFAULT == null ? rightOpernd != null : !RIGHT_OPERND_EDEFAULT.equals(rightOpernd);
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
		result.append(" (leftOperand: ");
		result.append(leftOperand);
		result.append(", rightOpernd: ");
		result.append(rightOpernd);
		result.append(')');
		return result.toString();
	}

} //AssemblyAssignmentImpl
