/**
 * *******************************************************************************
 * Copyright (c) 2008 - 2018 Profactor GmbH, TU Wien ACIN, fortiss GmbH
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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.fordiac.ide.model.data.DataType;
import org.eclipse.fordiac.ide.model.libraryElement.Connection;
import org.eclipse.fordiac.ide.model.libraryElement.ErrorMarkerInterface;
import org.eclipse.fordiac.ide.model.libraryElement.ErrorMarkerRef;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;

/** <!-- begin-user-doc --> An implementation of the model object '<em><b>Error Marker Interface</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#isIsInput <em>Is
 * Input</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getInputConnections <em>Input
 * Connections</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getOutputConnections <em>Output
 * Connections</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getTypeName <em>Type
 * Name</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getFileMarkerId <em>File Marker
 * Id</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getErrorMessage <em>Error
 * Message</em>}</li>
 * <li>{@link org.eclipse.fordiac.ide.model.libraryElement.impl.ErrorMarkerInterfaceImpl#getRepairedEndpoint
 * <em>Repaired Endpoint</em>}</li>
 * </ul>
 *
 * @generated */
public class ErrorMarkerInterfaceImpl extends ConfigurableObjectImpl implements ErrorMarkerInterface {
	/** The default value of the '{@link #isIsInput() <em>Is Input</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isIsInput()
	 * @generated
	 * @ordered */
	protected static final boolean IS_INPUT_EDEFAULT = false;

	/** The cached value of the '{@link #isIsInput() <em>Is Input</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isIsInput()
	 * @generated
	 * @ordered */
	protected boolean isInput = IS_INPUT_EDEFAULT;

	/** The cached value of the '{@link #getInputConnections() <em>Input Connections</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getInputConnections()
	 * @generated
	 * @ordered */
	protected EList<Connection> inputConnections;

	/** The cached value of the '{@link #getOutputConnections() <em>Output Connections</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getOutputConnections()
	 * @generated
	 * @ordered */
	protected EList<Connection> outputConnections;

	/** The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getType()
	 * @generated
	 * @ordered */
	protected DataType type;

	/** The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTypeName()
	 * @generated
	 * @ordered */
	protected static final String TYPE_NAME_EDEFAULT = null;

	/** The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTypeName()
	 * @generated
	 * @ordered */
	protected String typeName = TYPE_NAME_EDEFAULT;

	/** The default value of the '{@link #getFileMarkerId() <em>File Marker Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFileMarkerId()
	 * @generated
	 * @ordered */
	protected static final long FILE_MARKER_ID_EDEFAULT = 0L;

	/** The cached value of the '{@link #getFileMarkerId() <em>File Marker Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFileMarkerId()
	 * @generated
	 * @ordered */
	protected long fileMarkerId = FILE_MARKER_ID_EDEFAULT;

	/** The default value of the '{@link #getErrorMessage() <em>Error Message</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getErrorMessage()
	 * @generated
	 * @ordered */
	protected static final String ERROR_MESSAGE_EDEFAULT = null;

	/** The cached value of the '{@link #getErrorMessage() <em>Error Message</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getErrorMessage()
	 * @generated
	 * @ordered */
	protected String errorMessage = ERROR_MESSAGE_EDEFAULT;

	/** The cached value of the '{@link #getRepairedEndpoint() <em>Repaired Endpoint</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getRepairedEndpoint()
	 * @generated
	 * @ordered */
	protected IInterfaceElement repairedEndpoint;

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	protected ErrorMarkerInterfaceImpl() {
		super();
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	protected EClass eStaticClass() {
		return LibraryElementPackage.Literals.ERROR_MARKER_INTERFACE;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public boolean isIsInput() {
		return isInput;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public void setIsInput(boolean newIsInput) {
		boolean oldIsInput = isInput;
		isInput = newIsInput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__IS_INPUT, oldIsInput, isInput));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public EList<Connection> getInputConnections() {
		if (inputConnections == null) {
			inputConnections = new EObjectWithInverseResolvingEList<>(Connection.class, this,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS,
					LibraryElementPackage.CONNECTION__DESTINATION);
		}
		return inputConnections;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public EList<Connection> getOutputConnections() {
		if (outputConnections == null) {
			outputConnections = new EObjectWithInverseResolvingEList<>(Connection.class, this,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS,
					LibraryElementPackage.CONNECTION__SOURCE);
		}
		return outputConnections;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public DataType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (DataType) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	public DataType basicGetType() {
		return type;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public void setType(DataType newType) {
		DataType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE,
					oldType, type));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public String getTypeName() {
		return typeName;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public void setTypeName(String newTypeName) {
		String oldTypeName = typeName;
		typeName = newTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE_NAME, oldTypeName, typeName));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public long getFileMarkerId() {
		return fileMarkerId;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public void setFileMarkerId(long newFileMarkerId) {
		long oldFileMarkerId = fileMarkerId;
		fileMarkerId = newFileMarkerId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__FILE_MARKER_ID, oldFileMarkerId, fileMarkerId));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public void setErrorMessage(String newErrorMessage) {
		String oldErrorMessage = errorMessage;
		errorMessage = newErrorMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__ERROR_MESSAGE, oldErrorMessage, errorMessage));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public IInterfaceElement getRepairedEndpoint() {
		if (repairedEndpoint != null && repairedEndpoint.eIsProxy()) {
			InternalEObject oldRepairedEndpoint = (InternalEObject) repairedEndpoint;
			repairedEndpoint = (IInterfaceElement) eResolveProxy(oldRepairedEndpoint);
			if (repairedEndpoint != oldRepairedEndpoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT, oldRepairedEndpoint,
							repairedEndpoint));
			}
		}
		return repairedEndpoint;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	public IInterfaceElement basicGetRepairedEndpoint() {
		return repairedEndpoint;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public void setRepairedEndpoint(IInterfaceElement newRepairedEndpoint) {
		IInterfaceElement oldRepairedEndpoint = repairedEndpoint;
		repairedEndpoint = newRepairedEndpoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT, oldRepairedEndpoint,
					repairedEndpoint));
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public boolean hasError() {
		return getFileMarkerId() != 0;
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public FBNetworkElement getFBNetworkElement() {
		return org.eclipse.fordiac.ide.model.Annotations.getFBNetworkElement(this);
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInputConnections()).basicAdd(otherEnd, msgs);
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOutputConnections()).basicAdd(otherEnd,
					msgs);
		default:
			return super.eInverseAdd(otherEnd, featureID, msgs);
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			return ((InternalEList<?>) getInputConnections()).basicRemove(otherEnd, msgs);
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			return ((InternalEList<?>) getOutputConnections()).basicRemove(otherEnd, msgs);
		default:
			return super.eInverseRemove(otherEnd, featureID, msgs);
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__IS_INPUT:
			return isIsInput();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			return getInputConnections();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			return getOutputConnections();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE_NAME:
			return getTypeName();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__FILE_MARKER_ID:
			return getFileMarkerId();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__ERROR_MESSAGE:
			return getErrorMessage();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT:
			if (resolve)
				return getRepairedEndpoint();
			return basicGetRepairedEndpoint();
		default:
			return super.eGet(featureID, resolve, coreType);
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__IS_INPUT:
			setIsInput((Boolean) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			getInputConnections().clear();
			getInputConnections().addAll((Collection<? extends Connection>) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			getOutputConnections().clear();
			getOutputConnections().addAll((Collection<? extends Connection>) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE:
			setType((DataType) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE_NAME:
			setTypeName((String) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__FILE_MARKER_ID:
			setFileMarkerId((Long) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__ERROR_MESSAGE:
			setErrorMessage((String) newValue);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT:
			setRepairedEndpoint((IInterfaceElement) newValue);
			return;
		default:
			super.eSet(featureID, newValue);
			return;
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__IS_INPUT:
			setIsInput(IS_INPUT_EDEFAULT);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			getInputConnections().clear();
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			getOutputConnections().clear();
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE:
			setType((DataType) null);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE_NAME:
			setTypeName(TYPE_NAME_EDEFAULT);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__FILE_MARKER_ID:
			setFileMarkerId(FILE_MARKER_ID_EDEFAULT);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__ERROR_MESSAGE:
			setErrorMessage(ERROR_MESSAGE_EDEFAULT);
			return;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT:
			setRepairedEndpoint((IInterfaceElement) null);
			return;
		default:
			super.eUnset(featureID);
			return;
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__IS_INPUT:
			return isInput != IS_INPUT_EDEFAULT;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__INPUT_CONNECTIONS:
			return inputConnections != null && !inputConnections.isEmpty();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__OUTPUT_CONNECTIONS:
			return outputConnections != null && !outputConnections.isEmpty();
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE:
			return type != null;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__TYPE_NAME:
			return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__FILE_MARKER_ID:
			return fileMarkerId != FILE_MARKER_ID_EDEFAULT;
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__ERROR_MESSAGE:
			return ERROR_MESSAGE_EDEFAULT == null ? errorMessage != null : !ERROR_MESSAGE_EDEFAULT.equals(errorMessage);
		case LibraryElementPackage.ERROR_MARKER_INTERFACE__REPAIRED_ENDPOINT:
			return repairedEndpoint != null;
		default:
			return super.eIsSet(featureID);
		}
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ErrorMarkerRef.class) {
			switch (derivedFeatureID) {
			case LibraryElementPackage.ERROR_MARKER_INTERFACE__FILE_MARKER_ID:
				return LibraryElementPackage.ERROR_MARKER_REF__FILE_MARKER_ID;
			case LibraryElementPackage.ERROR_MARKER_INTERFACE__ERROR_MESSAGE:
				return LibraryElementPackage.ERROR_MARKER_REF__ERROR_MESSAGE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ErrorMarkerRef.class) {
			switch (baseFeatureID) {
			case LibraryElementPackage.ERROR_MARKER_REF__FILE_MARKER_ID:
				return LibraryElementPackage.ERROR_MARKER_INTERFACE__FILE_MARKER_ID;
			case LibraryElementPackage.ERROR_MARKER_REF__ERROR_MESSAGE:
				return LibraryElementPackage.ERROR_MARKER_INTERFACE__ERROR_MESSAGE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/** <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (isInput: "); //$NON-NLS-1$
		result.append(isInput);
		result.append(", typeName: "); //$NON-NLS-1$
		result.append(typeName);
		result.append(", fileMarkerId: "); //$NON-NLS-1$
		result.append(fileMarkerId);
		result.append(", errorMessage: "); //$NON-NLS-1$
		result.append(errorMessage);
		result.append(')');
		return result.toString();
	}

} // ErrorMarkerInterfaceImpl
