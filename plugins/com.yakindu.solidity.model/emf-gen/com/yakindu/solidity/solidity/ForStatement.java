/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import org.yakindu.base.expressions.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.yakindu.solidity.solidity.ForStatement#getInitialization <em>Initialization</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.ForStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.ForStatement#getAfterthought <em>Afterthought</em>}</li>
 *   <li>{@link com.yakindu.solidity.solidity.ForStatement#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see com.yakindu.solidity.solidity.SolidityPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Initialization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialization</em>' containment reference.
	 * @see #setInitialization(SimpleStatement)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getForStatement_Initialization()
	 * @model containment="true"
	 * @generated
	 */
	SimpleStatement getInitialization();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.ForStatement#getInitialization <em>Initialization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialization</em>' containment reference.
	 * @see #getInitialization()
	 * @generated
	 */
	void setInitialization(SimpleStatement value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getForStatement_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.ForStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Afterthought</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Afterthought</em>' containment reference.
	 * @see #setAfterthought(Expression)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getForStatement_Afterthought()
	 * @model containment="true"
	 * @generated
	 */
	Expression getAfterthought();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.ForStatement#getAfterthought <em>Afterthought</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Afterthought</em>' containment reference.
	 * @see #getAfterthought()
	 * @generated
	 */
	void setAfterthought(Expression value);

	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference.
	 * @see #setStatement(Statement)
	 * @see com.yakindu.solidity.solidity.SolidityPackage#getForStatement_Statement()
	 * @model containment="true"
	 * @generated
	 */
	Statement getStatement();

	/**
	 * Sets the value of the '{@link com.yakindu.solidity.solidity.ForStatement#getStatement <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' containment reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(Statement value);

} // ForStatement
