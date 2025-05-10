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

import org.eclipse.fordiac.ide.model.libraryElement.ServiceTransaction;
import org.eclipse.gef.commands.Command;

public class CreateTransactionDeadlineDurationCommand extends Command {
	private final ServiceTransaction transaction; // Use Transaction instead of DeadlineTime
	private final String value;

	public CreateTransactionDeadlineDurationCommand(final ServiceTransaction transaction, final String value) {
		this.transaction = transaction;
		this.value = value;
	}

	@Override
	public void execute() {
		transaction.getDeadlineTime().getValue().setValue(value); // Assuming you have a setValue method on Transaction
	}

	@Override
	public void undo() {
		transaction.getDeadlineTime().getValue().setValue(null); // Revert the change in case of undo
	}

	@Override
	public void redo() {
		transaction.getDeadlineTime().getValue().setValue(value); // Redo the change after undo
	}
}
