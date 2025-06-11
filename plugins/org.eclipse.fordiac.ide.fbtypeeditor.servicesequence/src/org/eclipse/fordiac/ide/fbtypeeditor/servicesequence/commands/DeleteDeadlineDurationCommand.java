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
import org.eclipse.fordiac.ide.model.libraryElement.Primitive;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceTransaction;
import org.eclipse.gef.commands.Command;

public class DeleteDeadlineDurationCommand extends Command {
	private final ServiceTransaction transaction;
	private final Primitive outputPrimitive;
	private final DeadlineTime deadlineTime;
	private String oldValue;

	public DeleteDeadlineDurationCommand(final ServiceTransaction transaction) {
		this.transaction = transaction;
		this.outputPrimitive = null;
		this.deadlineTime = transaction.getDeadlineTime();
	}

	public DeleteDeadlineDurationCommand(final Primitive primitive) {
		this.transaction = null;
		this.outputPrimitive = primitive;
		this.deadlineTime = primitive.getDeadlineTime();
	}

	@Override
	public boolean canExecute() {
		return deadlineTime != null;
	}

	@Override
	public void execute() {
		if (deadlineTime != null) {
			oldValue = deadlineTime.getValue().getValue();
			clearDeadline();
		}
	}

	@Override
	public void undo() {
		if (oldValue != null) {
			final DeadlineTime newDeadlineTime = LibraryElementFactory.eINSTANCE.createDeadlineTime();
			newDeadlineTime.getValue().setValue(oldValue);
			setDeadline(newDeadlineTime);
		}
	}

	@Override
	public void redo() {
		clearDeadline();
	}

	private void clearDeadline() {
		if (transaction != null) {
			transaction.setDeadlineTime(null);
		} else if (outputPrimitive != null) {
			outputPrimitive.setDeadlineTime(null);
		}
	}

	private void setDeadline(final DeadlineTime deadline) {
		if (transaction != null) {
			transaction.setDeadlineTime(deadline);
		} else if (outputPrimitive != null) {
			outputPrimitive.setDeadlineTime(deadline);
		}
	}
}