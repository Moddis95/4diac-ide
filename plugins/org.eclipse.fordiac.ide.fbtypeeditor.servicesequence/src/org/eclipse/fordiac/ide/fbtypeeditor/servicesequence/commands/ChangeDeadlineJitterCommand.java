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

import org.eclipse.fordiac.ide.model.libraryElement.DeadlineJitter;
import org.eclipse.fordiac.ide.model.libraryElement.Primitive;
import org.eclipse.gef.commands.Command;

public class ChangeDeadlineJitterCommand extends Command {

	private final DeadlineJitter deadlineJitter;
	private final String newValue;
	private String oldValue;

	public ChangeDeadlineJitterCommand(final DeadlineJitter deadlineJitter, final String newValue) {
		this.deadlineJitter = deadlineJitter;
		this.newValue = newValue;
	}

	public ChangeDeadlineJitterCommand(final Primitive primitive, final String newValue) {
		this.deadlineJitter = primitive.getDeadlineTime().getDeadlineJitter();
		this.newValue = newValue;
	}

	@Override
	public void execute() {
		oldValue = deadlineJitter.getValue().getValue();
		deadlineJitter.getValue().setValue(newValue);
	}

	@Override
	public void undo() {
		deadlineJitter.getValue().setValue(oldValue);
	}

	@Override
	public void redo() {
		deadlineJitter.getValue().setValue(newValue);
	}
}