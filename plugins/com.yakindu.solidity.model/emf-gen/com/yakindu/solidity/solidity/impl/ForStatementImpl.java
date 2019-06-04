/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity.impl;

import com.yakindu.solidity.solidity.ForStatement;
import com.yakindu.solidity.solidity.SimpleStatement;
import com.yakindu.solidity.solidity.SolidityPackage;
import com.yakindu.solidity.solidity.Statement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.expressions.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.impl.ForStatementImpl#getInitialization <em>Initialization</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.ForStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.ForStatementImpl#getAfterthought <em>Afterthought</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.impl.ForStatementImpl#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForStatementImpl extends StatementImpl implements ForStatement {
	/**
	 * The cached value of the '{@link #getInitialization() <em>Initialization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialization()
	 * @generated
	 * @ordered
	 */
	protected SimpleStatement initialization;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression condition;

	/**
	 * The cached value of the '{@link #getAfterthought() <em>Afterthought</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAfterthought()
	 * @generated
	 * @ordered
	 */
	protected Expression afterthought;

	/**
	 * The cached value of the '{@link #getStatement() <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected Statement statement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolidityPackage.Literals.FOR_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleStatement getInitialization() {
		return initialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialization(SimpleStatement newInitialization, NotificationChain msgs) {
		SimpleStatement oldInitialization = initialization;
		initialization = newInitialization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolidityPackage.FOR_STATEMENT__INITIALIZATION, oldInitialization, newInitialization);
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
	public void setInitialization(SimpleStatement newInitialization) {
		if (newInitialization != initialization) {
			NotificationChain msgs = null;
			if (initialization != null)
				msgs = ((InternalEObject)initialization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.FOR_STATEMENT__INITIALIZATION, null, msgs);
			if (newInitialization != null)
				msgs = ((InternalEObject)newInitialization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.FOR_STATEMENT__INITIALIZATION, null, msgs);
			msgs = basicSetInitialization(newInitialization, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.FOR_STATEMENT__INITIALIZATION, newInitialization, newInitialization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
		Expression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolidityPackage.FOR_STATEMENT__CONDITION, oldCondition, newCondition);
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
	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.FOR_STATEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.FOR_STATEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.FOR_STATEMENT__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getAfterthought() {
		return afterthought;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAfterthought(Expression newAfterthought, NotificationChain msgs) {
		Expression oldAfterthought = afterthought;
		afterthought = newAfterthought;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolidityPackage.FOR_STATEMENT__AFTERTHOUGHT, oldAfterthought, newAfterthought);
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
	public void setAfterthought(Expression newAfterthought) {
		if (newAfterthought != afterthought) {
			NotificationChain msgs = null;
			if (afterthought != null)
				msgs = ((InternalEObject)afterthought).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.FOR_STATEMENT__AFTERTHOUGHT, null, msgs);
			if (newAfterthought != null)
				msgs = ((InternalEObject)newAfterthought).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.FOR_STATEMENT__AFTERTHOUGHT, null, msgs);
			msgs = basicSetAfterthought(newAfterthought, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.FOR_STATEMENT__AFTERTHOUGHT, newAfterthought, newAfterthought));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Statement getStatement() {
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatement(Statement newStatement, NotificationChain msgs) {
		Statement oldStatement = statement;
		statement = newStatement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolidityPackage.FOR_STATEMENT__STATEMENT, oldStatement, newStatement);
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
	public void setStatement(Statement newStatement) {
		if (newStatement != statement) {
			NotificationChain msgs = null;
			if (statement != null)
				msgs = ((InternalEObject)statement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.FOR_STATEMENT__STATEMENT, null, msgs);
			if (newStatement != null)
				msgs = ((InternalEObject)newStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolidityPackage.FOR_STATEMENT__STATEMENT, null, msgs);
			msgs = basicSetStatement(newStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolidityPackage.FOR_STATEMENT__STATEMENT, newStatement, newStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolidityPackage.FOR_STATEMENT__INITIALIZATION:
				return basicSetInitialization(null, msgs);
			case SolidityPackage.FOR_STATEMENT__CONDITION:
				return basicSetCondition(null, msgs);
			case SolidityPackage.FOR_STATEMENT__AFTERTHOUGHT:
				return basicSetAfterthought(null, msgs);
			case SolidityPackage.FOR_STATEMENT__STATEMENT:
				return basicSetStatement(null, msgs);
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
			case SolidityPackage.FOR_STATEMENT__INITIALIZATION:
				return getInitialization();
			case SolidityPackage.FOR_STATEMENT__CONDITION:
				return getCondition();
			case SolidityPackage.FOR_STATEMENT__AFTERTHOUGHT:
				return getAfterthought();
			case SolidityPackage.FOR_STATEMENT__STATEMENT:
				return getStatement();
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
			case SolidityPackage.FOR_STATEMENT__INITIALIZATION:
				setInitialization((SimpleStatement)newValue);
				return;
			case SolidityPackage.FOR_STATEMENT__CONDITION:
				setCondition((Expression)newValue);
				return;
			case SolidityPackage.FOR_STATEMENT__AFTERTHOUGHT:
				setAfterthought((Expression)newValue);
				return;
			case SolidityPackage.FOR_STATEMENT__STATEMENT:
				setStatement((Statement)newValue);
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
			case SolidityPackage.FOR_STATEMENT__INITIALIZATION:
				setInitialization((SimpleStatement)null);
				return;
			case SolidityPackage.FOR_STATEMENT__CONDITION:
				setCondition((Expression)null);
				return;
			case SolidityPackage.FOR_STATEMENT__AFTERTHOUGHT:
				setAfterthought((Expression)null);
				return;
			case SolidityPackage.FOR_STATEMENT__STATEMENT:
				setStatement((Statement)null);
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
			case SolidityPackage.FOR_STATEMENT__INITIALIZATION:
				return initialization != null;
			case SolidityPackage.FOR_STATEMENT__CONDITION:
				return condition != null;
			case SolidityPackage.FOR_STATEMENT__AFTERTHOUGHT:
				return afterthought != null;
			case SolidityPackage.FOR_STATEMENT__STATEMENT:
				return statement != null;
		}
		return super.eIsSet(featureID);
	}

} //ForStatementImpl
