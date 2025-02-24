/*******************************************************************************
 * Copyright (c) 2011, 2024 Profactor GmbH, TU Wien ACIN, fortiss GmbH,
 *                          Primetals Technologies Austria GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl, Monika Wenger
 *     - initial API and implementation and/or initial documentation
 *   Alois Zoitl - extracted and generalized from IFBTEditorPart
 *******************************************************************************/
package org.eclipse.fordiac.ide.typeeditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElement;
import org.eclipse.fordiac.ide.model.typelibrary.TypeEntry;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.MultiPageEditorSite;

public interface ITypeEditorPage extends ISelectionListener, IReusableEditor, IGotoMarker {

	/**
	 * Inform the FBTEditorPart that an element has been selected in the outline
	 * view. If the selected element is handled by the FBTEditorPart the
	 * FBTEditorPart has to perform measure to show the selected element. By
	 * returning true the FBTypeEditor can perform measure to activate the correct
	 * tab.
	 *
	 * @param selectedElement the element that has been selected in the FB outline
	 *                        view
	 * @return true if the selected element is handled in this editor part
	 */
	boolean outlineSelectionChanged(Object selectedElement);

	/**
	 * Check if the given marker references an element shown by this IFBTEditorPart
	 *
	 * @param marker the marker to be checked for
	 * @return true if the marker targets elements shown in this IFBTEditorPart
	 */
	boolean isMarkerTarget(IMarker marker);

	default String getEditorId() {
		return ""; //$NON-NLS-1$
	}

	void reloadType();

	void setCommonCommandStack(final CommandStack commandStack);

	default LibraryElement getType() {
		if (getEditorInput() instanceof final TypeEditorInput typeEI) {
			return typeEI.getContent();
		}
		return null;
	}

	default TypeEntry getTypeEntry() {
		if (getEditorInput() instanceof final TypeEditorInput typeEI) {
			return typeEI.getTypeEntry();
		}
		return null;
	}

	default IFile getFile() {
		if (getEditorInput() instanceof final IFileEditorInput fileEI) {
			return fileEI.getFile();
		}
		return null;
	}

	default void checkEditorInput(final IEditorInput input) {
		if (!(input instanceof final TypeEditorInput typeEI)) {
			throw new IllegalArgumentException("Type Editor Pages only accept TypeEditorInputs as valid inputs!"); //$NON-NLS-1$
		}
		final TypeEditorInput currentEditorInput = (TypeEditorInput) getEditorInput();
		if (currentEditorInput != null && currentEditorInput.getContent() != typeEI.getContent()) {
			throw new IllegalArgumentException(
					"Editor input with new content given to type editor. This is currently not supported!"); //$NON-NLS-1$
		}
	}

	default void revealEditor() {
		if (getEditorSite() instanceof final MultiPageEditorSite multiPageEditorSite) {
			final MultiPageEditorPart multiPageEditor = multiPageEditorSite.getMultiPageEditor();
			if (multiPageEditor.getSelectedPage() != this) {
				multiPageEditor.setActiveEditor(this);
			}
		}
	}

	Object getSelectableObject();

}
