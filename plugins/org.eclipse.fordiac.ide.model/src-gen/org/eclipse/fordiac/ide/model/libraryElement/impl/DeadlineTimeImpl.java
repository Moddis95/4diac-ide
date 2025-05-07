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
package org.eclipse.fordiac.ide.model.libraryElement.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.fordiac.ide.model.libraryElement.DeadlineTime;
import org.eclipse.fordiac.ide.model.libraryElement.DeadlineType;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deadline Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.DeadlineTimeImpl#getDeadlineType <em>Deadline Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeadlineTimeImpl extends VarDeclarationImpl implements DeadlineTime {
	/**
	 * The default value of the '{@link #getDeadlineType() <em>Deadline Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadlineType()
	 * @generated
	 * @ordered
	 */
	protected static final DeadlineType DEADLINE_TYPE_EDEFAULT = DeadlineType.SOFT_DEADLINE;
	/**
	 * The cached value of the '{@link #getDeadlineType() <em>Deadline Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadlineType()
	 * @generated
	 * @ordered
	 */
	protected DeadlineType deadlineType = DEADLINE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeadlineTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryElementPackage.Literals.DEADLINE_TIME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeadlineType getDeadlineType() {
		return deadlineType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeadlineType(DeadlineType newDeadlineType) {
		DeadlineType oldDeadlineType = deadlineType;
		deadlineType = newDeadlineType == null ? DEADLINE_TYPE_EDEFAULT : newDeadlineType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.DEADLINE_TIME__DEADLINE_TYPE, oldDeadlineType, deadlineType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryElementPackage.DEADLINE_TIME__DEADLINE_TYPE:
				return getDeadlineType();
			default:
				return super.eGet(featureID, resolve, coreType);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LibraryElementPackage.DEADLINE_TIME__DEADLINE_TYPE:
				setDeadlineType((DeadlineType)newValue);
				return;
			default:
				super.eSet(featureID, newValue);
				return;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case LibraryElementPackage.DEADLINE_TIME__DEADLINE_TYPE:
				setDeadlineType(DEADLINE_TYPE_EDEFAULT);
				return;
			default:
				super.eUnset(featureID);
				return;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LibraryElementPackage.DEADLINE_TIME__DEADLINE_TYPE:
				return deadlineType != DEADLINE_TYPE_EDEFAULT;
			default:
				return super.eIsSet(featureID);
		}
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
		result.append(" (deadlineType: "); //$NON-NLS-1$
		result.append(deadlineType);
		result.append(')');
		return result.toString();
	}

} //DeadlineTimeImpl
