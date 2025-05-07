/**
 * *******************************************************************************
 * Copyright (c) 2008 - 2018 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 *               2022-2023 Martin Erich Jobst
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Gerhard Ebenhofer, Alois Zoitl, Ingo Hegny, Monika Wenger, Martin Jobst
 *      - initial API and implementation and/or initial documentation
 * *******************************************************************************
 */
package org.eclipse.fordiac.ide.model.libraryElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Deadline Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage#getDeadlineType()
 * @model
 * @generated
 */
public enum DeadlineType implements Enumerator {
	/**
	 * The '<em><b>Soft Deadline</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOFT_DEADLINE_VALUE
	 * @generated
	 * @ordered
	 */
	SOFT_DEADLINE(0, "SoftDeadline", "SOFT"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Firm Deadline</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRM_DEADLINE_VALUE
	 * @generated
	 * @ordered
	 */
	FIRM_DEADLINE(1, "FirmDeadline", "FIRM"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Hard Deadline</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HARD_DEADLINE_VALUE
	 * @generated
	 * @ordered
	 */
	HARD_DEADLINE(2, "HardDeadline", "HARD"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Soft Deadline</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOFT_DEADLINE
	 * @model name="SoftDeadline" literal="SOFT"
	 * @generated
	 * @ordered
	 */
	public static final int SOFT_DEADLINE_VALUE = 0;

	/**
	 * The '<em><b>Firm Deadline</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRM_DEADLINE
	 * @model name="FirmDeadline" literal="FIRM"
	 * @generated
	 * @ordered
	 */
	public static final int FIRM_DEADLINE_VALUE = 1;

	/**
	 * The '<em><b>Hard Deadline</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HARD_DEADLINE
	 * @model name="HardDeadline" literal="HARD"
	 * @generated
	 * @ordered
	 */
	public static final int HARD_DEADLINE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Deadline Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DeadlineType[] VALUES_ARRAY =
		new DeadlineType[] {
			SOFT_DEADLINE,
			FIRM_DEADLINE,
			HARD_DEADLINE,
		};

	/**
	 * A public read-only list of all the '<em><b>Deadline Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<DeadlineType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Deadline Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DeadlineType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DeadlineType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Deadline Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DeadlineType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DeadlineType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Deadline Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static DeadlineType get(int value) {
		switch (value) {
			case SOFT_DEADLINE_VALUE: return SOFT_DEADLINE;
			case FIRM_DEADLINE_VALUE: return FIRM_DEADLINE;
			case HARD_DEADLINE_VALUE: return HARD_DEADLINE;
			default: return null;
		}
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
	private DeadlineType(int value, String name, String literal) {
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
	
} //DeadlineType
