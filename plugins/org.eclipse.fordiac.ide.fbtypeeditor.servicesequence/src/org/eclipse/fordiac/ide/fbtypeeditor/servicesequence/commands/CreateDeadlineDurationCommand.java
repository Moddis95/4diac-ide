/*******************************************************************************
 * Copyright (c)  2025		Carl von Ossietzky Universität Oldenburg
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * 	 Mattis Harzmann
 * 		- initial API and initial implementation and/or documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands;

import org.eclipse.fordiac.ide.model.libraryElement.DeadlineTime;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.libraryElement.OutputPrimitive;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceTransaction;
import org.eclipse.fordiac.ide.model.libraryElement.Value;
import org.eclipse.gef.commands.Command;

public class CreateDeadlineDurationCommand extends Command {

	private final ServiceTransaction transaction;
	private final OutputPrimitive outputPrimitive;
	private final String value;
	private DeadlineTime oldDeadline;

	public CreateDeadlineDurationCommand(final ServiceTransaction transaction, final String value) {
		this.transaction = transaction;
		this.outputPrimitive = null;
		this.value = value;
	}

	public CreateDeadlineDurationCommand(final OutputPrimitive primitive, final String value) {
		this.transaction = null;
		this.outputPrimitive = primitive;
		this.value = value;
	}

	@Override
	public void execute() {
		oldDeadline = getDeadline();
		final DeadlineTime newDeadline = LibraryElementFactory.eINSTANCE.createDeadlineTime();
		final Value val = LibraryElementFactory.eINSTANCE.createValue();
		newDeadline.setValue(val);
		newDeadline.getValue().setValue(value);
		setDeadline(newDeadline);
	}

	@Override
	public void undo() {
		setDeadline(oldDeadline);
	}

	@Override
	public void redo() {
		final DeadlineTime newDeadline = LibraryElementFactory.eINSTANCE.createDeadlineTime();
		final Value val = LibraryElementFactory.eINSTANCE.createValue();
		newDeadline.setValue(val);
		newDeadline.getValue().setValue(value);
		setDeadline(newDeadline);
	}

	private DeadlineTime getDeadline() {
		if (transaction != null) {
			return transaction.getDeadlineTime();
		}
		if (outputPrimitive != null) {
			return outputPrimitive.getDeadlineTime();
		}
		return null;
	}

	private void setDeadline(final DeadlineTime deadline) {
		if (transaction != null) {
			transaction.setDeadlineTime(deadline);
		} else if (outputPrimitive != null) {
			outputPrimitive.setDeadlineTime(deadline);
		}
	}
}