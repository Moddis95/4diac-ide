/********************************************************************************
 * Copyright (c) 2008, 2010, 2012 - 2017 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Gerhard Ebenhofer, Alois Zoitl, Monika Wenger, Martin Jobst
 *    - initial API and implementation and/or initial documentation
 ********************************************************************************/
package org.eclipse.fordiac.ide.model.data;

/** <!-- begin-user-doc --> A representation of the model object '<em><b>Derived Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.fordiac.ide.model.data.DerivedType#getBaseType <em>Base Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.fordiac.ide.model.data.DataPackage#getDerivedType()
 * @model
 * @generated */
public interface DerivedType extends ValueType {
	/** Returns the value of the '<em><b>Base Type</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Base Type</em>' reference.
	 * @see #setBaseType(ElementaryType)
	 * @see org.eclipse.fordiac.ide.model.data.DataPackage#getDerivedType_BaseType()
	 * @model required="true"
	 * @generated */
	ElementaryType getBaseType();

	/** Sets the value of the '{@link org.eclipse.fordiac.ide.model.data.DerivedType#getBaseType <em>Base Type</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value the new value of the '<em>Base Type</em>' reference.
	 * @see #getBaseType()
	 * @generated */
	void setBaseType(ElementaryType value);

} // DerivedType
