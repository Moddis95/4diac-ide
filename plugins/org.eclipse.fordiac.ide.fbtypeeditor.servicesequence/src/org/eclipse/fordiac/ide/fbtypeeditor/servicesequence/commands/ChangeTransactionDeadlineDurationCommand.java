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
import org.eclipse.gef.commands.Command;

public class ChangeTransactionDeadlineDurationCommand extends Command {
	private final DeadlineTime deadlineTime;
	private final String newValue;
	private String oldValue;

	public ChangeTransactionDeadlineDurationCommand(final DeadlineTime deadlineTime, final String newValue) {
		this.deadlineTime = deadlineTime;
		this.newValue = newValue;
	}

	@Override
	public void execute() {
		oldValue = deadlineTime.getValue().getValue();
		deadlineTime.getValue().setValue(newValue);
	}

	@Override
	public void undo() {
		deadlineTime.getValue().setValue(oldValue);
	}

	@Override
	public void redo() {
		deadlineTime.getValue().setValue(newValue);
	}
}