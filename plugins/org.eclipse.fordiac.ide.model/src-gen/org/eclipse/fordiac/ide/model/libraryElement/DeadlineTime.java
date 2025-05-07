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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deadline Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.DeadlineTime#getDeadlineType <em>Deadline Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage#getDeadlineTime()
 * @model
 * @generated
 */
public interface DeadlineTime extends VarDeclaration {

	/**
	 * Returns the value of the '<em><b>Deadline Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.fordiac.ide.model.libraryElement.DeadlineType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deadline Type</em>' attribute.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.DeadlineType
	 * @see #setDeadlineType(DeadlineType)
	 * @see org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage#getDeadlineTime_DeadlineType()
	 * @model
	 * @generated
	 */
	DeadlineType getDeadlineType();

	/**
	 * Sets the value of the '{@link org.eclipse.fordiac.ide.model.libraryElement.DeadlineTime#getDeadlineType <em>Deadline Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deadline Type</em>' attribute.
	 * @see org.eclipse.fordiac.ide.model.libraryElement.DeadlineType
	 * @see #getDeadlineType()
	 * @generated
	 */
	void setDeadlineType(DeadlineType value);
} // DeadlineTime
