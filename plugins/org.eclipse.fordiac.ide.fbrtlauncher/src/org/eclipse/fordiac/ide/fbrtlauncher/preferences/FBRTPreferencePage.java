/*******************************************************************************
 * Copyright (c) 2008, 2009, 2016 Profactor GmbH, fortiss GmbH
 * 				 2020			  Andrea Zoitl
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Martijn Rooker, Gerhard Ebenhofer, Thomas Strasser, Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *   Andrea Zoitl
 *     - externalized all translatable strings
 *******************************************************************************/
package org.eclipse.fordiac.ide.fbrtlauncher.preferences;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.fordiac.ide.fbrtlauncher.Messages;
import org.eclipse.fordiac.ide.ui.preferences.FixedScopedPreferenceStore;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class FBRTPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Instantiates a new fBRT preference page.
	 */
	public FBRTPreferencePage() {
		super(GRID);
		setPreferenceStore(new FixedScopedPreferenceStore(InstanceScope.INSTANCE,
				FbrtPreferenceConstants.FBRTLAUNCHER_PREFERENCES_ID));
		setDescription(Messages.FBRTPreferencePage_FBRTPreferencePage);
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common GUI
	 * blocks needed to manipulate various types of preferences. Each field editor
	 * knows how to save and restore itself.
	 */
	@Override
	public void createFieldEditors() {
		addField(new FileFieldEditor(FbrtPreferenceConstants.P_PATH, Messages.FBRTPreferencePage_FBRTLocation,
				getFieldEditorParent()));
		addField(new StringFieldEditor(FbrtPreferenceConstants.P_LIB, Messages.FBRTPreferencePage_FBRTLibrary,
				getFieldEditorParent()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	@Override
	public void init(final IWorkbench workbench) {
		// nothing to be done here
	}

}