/**
 * *******************************************************************************
 * Copyright (c) 2008 - 2018 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 *               2022 Martin Erich Jobst
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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.fordiac.ide.model.libraryElement.DeadlineTime;
import org.eclipse.fordiac.ide.model.libraryElement.InputPrimitive;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.libraryElement.OutputPrimitive;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceSequence;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceTransaction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ServiceTransactionImpl#getInputPrimitive <em>Input Primitive</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ServiceTransactionImpl#getOutputPrimitive <em>Output Primitive</em>}</li>
 *   <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ServiceTransactionImpl#getDeadlineTime <em>Deadline Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceTransactionImpl extends EObjectImpl implements ServiceTransaction {
	/**
	 * The cached value of the '{@link #getInputPrimitive() <em>Input Primitive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputPrimitive()
	 * @generated
	 * @ordered
	 */
	protected InputPrimitive inputPrimitive;

	/**
	 * The cached value of the '{@link #getOutputPrimitive() <em>Output Primitive</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputPrimitive()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputPrimitive> outputPrimitive;

	/**
	 * The cached value of the '{@link #getDeadlineTime() <em>Deadline Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeadlineTime()
	 * @generated
	 * @ordered
	 */
	protected DeadlineTime deadlineTime;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceTransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryElementPackage.Literals.SERVICE_TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InputPrimitive getInputPrimitive() {
		return inputPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInputPrimitive(InputPrimitive newInputPrimitive, NotificationChain msgs) {
		InputPrimitive oldInputPrimitive = inputPrimitive;
		inputPrimitive = newInputPrimitive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryElementPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE, oldInputPrimitive, newInputPrimitive);
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
	public void setInputPrimitive(InputPrimitive newInputPrimitive) {
		if (newInputPrimitive != inputPrimitive) {
			NotificationChain msgs = null;
			if (inputPrimitive != null)
				msgs = ((InternalEObject)inputPrimitive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryElementPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE, null, msgs);
			if (newInputPrimitive != null)
				msgs = ((InternalEObject)newInputPrimitive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryElementPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE, null, msgs);
			msgs = basicSetInputPrimitive(newInputPrimitive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE, newInputPrimitive, newInputPrimitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OutputPrimitive> getOutputPrimitive() {
		if (outputPrimitive == null) {
			outputPrimitive = new EObjectContainmentEList<OutputPrimitive>(OutputPrimitive.class, this, LibraryElementPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE);
		}
		return outputPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeadlineTime getDeadlineTime() {
		if (deadlineTime != null && deadlineTime.eIsProxy()) {
			InternalEObject oldDeadlineTime = (InternalEObject)deadlineTime;
			deadlineTime = (DeadlineTime)eResolveProxy(oldDeadlineTime);
			if (deadlineTime != oldDeadlineTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryElementPackage.SERVICE_TRANSACTION__DEADLINE_TIME, oldDeadlineTime, deadlineTime));
			}
		}
		return deadlineTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeadlineTime basicGetDeadlineTime() {
		return deadlineTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDeadlineTime(DeadlineTime newDeadlineTime) {
		DeadlineTime oldDeadlineTime = deadlineTime;
		deadlineTime = newDeadlineTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.SERVICE_TRANSACTION__DEADLINE_TIME, oldDeadlineTime, deadlineTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceSequence getServiceSequence() {
		return (ServiceSequence) this.eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryElementPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				return basicSetInputPrimitive(null, msgs);
			case LibraryElementPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				return ((InternalEList<?>)getOutputPrimitive()).basicRemove(otherEnd, msgs);
			default:
				return super.eInverseRemove(otherEnd, featureID, msgs);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryElementPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				return getInputPrimitive();
			case LibraryElementPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				return getOutputPrimitive();
			case LibraryElementPackage.SERVICE_TRANSACTION__DEADLINE_TIME:
				if (resolve) return getDeadlineTime();
				return basicGetDeadlineTime();
			default:
				return super.eGet(featureID, resolve, coreType);
		}
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
			case LibraryElementPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				setInputPrimitive((InputPrimitive)newValue);
				return;
			case LibraryElementPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				getOutputPrimitive().clear();
				getOutputPrimitive().addAll((Collection<? extends OutputPrimitive>)newValue);
				return;
			case LibraryElementPackage.SERVICE_TRANSACTION__DEADLINE_TIME:
				setDeadlineTime((DeadlineTime)newValue);
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
			case LibraryElementPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				setInputPrimitive((InputPrimitive)null);
				return;
			case LibraryElementPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				getOutputPrimitive().clear();
				return;
			case LibraryElementPackage.SERVICE_TRANSACTION__DEADLINE_TIME:
				setDeadlineTime((DeadlineTime)null);
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
			case LibraryElementPackage.SERVICE_TRANSACTION__INPUT_PRIMITIVE:
				return inputPrimitive != null;
			case LibraryElementPackage.SERVICE_TRANSACTION__OUTPUT_PRIMITIVE:
				return outputPrimitive != null && !outputPrimitive.isEmpty();
			case LibraryElementPackage.SERVICE_TRANSACTION__DEADLINE_TIME:
				return deadlineTime != null;
			default:
				return super.eIsSet(featureID);
		}
	}

} //ServiceTransactionImpl
