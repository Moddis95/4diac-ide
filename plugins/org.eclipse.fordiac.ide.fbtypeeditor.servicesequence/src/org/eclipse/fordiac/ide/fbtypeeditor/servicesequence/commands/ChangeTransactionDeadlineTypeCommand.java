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
import org.eclipse.fordiac.ide.model.libraryElement.DeadlineType;
import org.eclipse.gef.commands.Command;

public class ChangeTransactionDeadlineTypeCommand extends Command {
	private final DeadlineTime deadlineTime;
	private final DeadlineType newDeadlineType;
	private DeadlineType oldDeadlineType;

	public ChangeTransactionDeadlineTypeCommand(final DeadlineTime deadlineTime, final DeadlineType newDeadline) {
		this.deadlineTime = deadlineTime;
		this.newDeadlineType = newDeadline;
	}

	@Override
	public void execute() {
		oldDeadlineType = deadlineTime.getDeadlineType();
		deadlineTime.setDeadlineType(newDeadlineType);
	}

	@Override
	public void undo() {
		deadlineTime.setDeadlineType(oldDeadlineType);
	}

	@Override
	public void redo() {
		deadlineTime.setDeadlineType(newDeadlineType);
	}
}