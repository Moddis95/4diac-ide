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
import org.eclipse.fordiac.ide.model.libraryElement.ServiceTransaction;
import org.eclipse.gef.commands.Command;

public class DeleteTransactionDeadlineDurationCommand extends Command {
	private final ServiceTransaction transaction;
	private final DeadlineTime deadlineTime;
	private String oldValue;

	public DeleteTransactionDeadlineDurationCommand(final ServiceTransaction transaction) {
		this.transaction = transaction;
		this.deadlineTime = transaction.getDeadlineTime();
	}

	@Override
	public boolean canExecute() {
		return deadlineTime != null;
	}

	@Override
	public void execute() {
		if (deadlineTime != null) {
			oldValue = deadlineTime.getValue().getValue();
			transaction.setDeadlineTime(null);
		}
	}

	@Override
	public void undo() {
		if (oldValue != null) {
			final DeadlineTime newDeadlineTime = LibraryElementFactory.eINSTANCE.createDeadlineTime();
			newDeadlineTime.getValue().setValue(oldValue);
			transaction.setDeadlineTime(newDeadlineTime);
		}
	}

	@Override
	public void redo() {
		transaction.setDeadlineTime(null);
	}
}
