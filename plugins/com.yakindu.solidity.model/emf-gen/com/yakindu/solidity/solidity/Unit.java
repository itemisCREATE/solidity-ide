/**
 * (c) committers of YAKINDU
 */
package com.yakindu.solidity.solidity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Unit</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.yakindu.solidity.solidity.SolidityPackage#getUnit()
 * @model
 * @generated
 */
public enum Unit implements Enumerator {
	/**
	 * The '<em><b>SECONDS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECONDS_VALUE
	 * @generated
	 * @ordered
	 */
	SECONDS(0, "SECONDS", "seconds"),

	/**
	 * The '<em><b>MINUTES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINUTES_VALUE
	 * @generated
	 * @ordered
	 */
	MINUTES(1, "MINUTES", "minutes"),

	/**
	 * The '<em><b>HOURS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOURS_VALUE
	 * @generated
	 * @ordered
	 */
	HOURS(2, "HOURS", "hours"),

	/**
	 * The '<em><b>DAYS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DAYS_VALUE
	 * @generated
	 * @ordered
	 */
	DAYS(3, "DAYS", "days"),

	/**
	 * The '<em><b>WEEKS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEEKS_VALUE
	 * @generated
	 * @ordered
	 */
	WEEKS(4, "WEEKS", "weeks"),

	/**
	 * The '<em><b>YEARS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YEARS_VALUE
	 * @generated
	 * @ordered
	 */
	YEARS(5, "YEARS", "years"),

	/**
	 * The '<em><b>WEI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEI_VALUE
	 * @generated
	 * @ordered
	 */
	WEI(6, "WEI", "wei"),

	/**
	 * The '<em><b>FINNEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINNEY_VALUE
	 * @generated
	 * @ordered
	 */
	FINNEY(7, "FINNEY", "finney"),

	/**
	 * The '<em><b>SZABO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SZABO_VALUE
	 * @generated
	 * @ordered
	 */
	SZABO(8, "SZABO", "szabo"),

	/**
	 * The '<em><b>ETHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETHER_VALUE
	 * @generated
	 * @ordered
	 */
	ETHER(9, "ETHER", "ether");

	/**
	 * The '<em><b>SECONDS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECONDS
	 * @model literal="seconds"
	 * @generated
	 * @ordered
	 */
	public static final int SECONDS_VALUE = 0;

	/**
	 * The '<em><b>MINUTES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MINUTES
	 * @model literal="minutes"
	 * @generated
	 * @ordered
	 */
	public static final int MINUTES_VALUE = 1;

	/**
	 * The '<em><b>HOURS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HOURS
	 * @model literal="hours"
	 * @generated
	 * @ordered
	 */
	public static final int HOURS_VALUE = 2;

	/**
	 * The '<em><b>DAYS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DAYS
	 * @model literal="days"
	 * @generated
	 * @ordered
	 */
	public static final int DAYS_VALUE = 3;

	/**
	 * The '<em><b>WEEKS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEEKS
	 * @model literal="weeks"
	 * @generated
	 * @ordered
	 */
	public static final int WEEKS_VALUE = 4;

	/**
	 * The '<em><b>YEARS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #YEARS
	 * @model literal="years"
	 * @generated
	 * @ordered
	 */
	public static final int YEARS_VALUE = 5;

	/**
	 * The '<em><b>WEI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEI
	 * @model literal="wei"
	 * @generated
	 * @ordered
	 */
	public static final int WEI_VALUE = 6;

	/**
	 * The '<em><b>FINNEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINNEY
	 * @model literal="finney"
	 * @generated
	 * @ordered
	 */
	public static final int FINNEY_VALUE = 7;

	/**
	 * The '<em><b>SZABO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SZABO
	 * @model literal="szabo"
	 * @generated
	 * @ordered
	 */
	public static final int SZABO_VALUE = 8;

	/**
	 * The '<em><b>ETHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ETHER
	 * @model literal="ether"
	 * @generated
	 * @ordered
	 */
	public static final int ETHER_VALUE = 9;

	/**
	 * An array of all the '<em><b>Unit</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Unit[] VALUES_ARRAY =
		new Unit[] {
			SECONDS,
			MINUTES,
			HOURS,
			DAYS,
			WEEKS,
			YEARS,
			WEI,
			FINNEY,
			SZABO,
			ETHER,
		};

	/**
	 * A public read-only list of all the '<em><b>Unit</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Unit> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Unit</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Unit get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Unit result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Unit</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Unit getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Unit result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Unit</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Unit get(int value) {
		switch (value) {
			case SECONDS_VALUE: return SECONDS;
			case MINUTES_VALUE: return MINUTES;
			case HOURS_VALUE: return HOURS;
			case DAYS_VALUE: return DAYS;
			case WEEKS_VALUE: return WEEKS;
			case YEARS_VALUE: return YEARS;
			case WEI_VALUE: return WEI;
			case FINNEY_VALUE: return FINNEY;
			case SZABO_VALUE: return SZABO;
			case ETHER_VALUE: return ETHER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Unit(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Unit
