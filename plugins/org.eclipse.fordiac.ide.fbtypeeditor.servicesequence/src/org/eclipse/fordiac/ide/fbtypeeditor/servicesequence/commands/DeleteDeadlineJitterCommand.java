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
import org.eclipse.fordiac.ide.model.libraryElement.DeadlineTime;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.libraryElement.Primitive;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceTransaction;
import org.eclipse.gef.commands.Command;

public class DeleteDeadlineJitterCommand extends Command {
	private final ServiceTransaction transaction;
	private final Primitive outputPrimitive;
	private final DeadlineTime deadlineTime;
	private String oldValue;

	public DeleteDeadlineJitterCommand(final ServiceTransaction transaction) {
		this.transaction = transaction;
		this.outputPrimitive = null;
		this.deadlineTime = transaction.getDeadlineTime();
	}

	public DeleteDeadlineJitterCommand(final Primitive primitive) {
		this.transaction = null;
		this.outputPrimitive = primitive;
		this.deadlineTime = primitive.getDeadlineTime();
	}

	@Override
	public boolean canExecute() {
		return deadlineTime.getDeadlineJitter() != null;
	}

	@Override
	public void execute() {
		if (deadlineTime.getDeadlineJitter() != null) {
			oldValue = deadlineTime.getDeadlineJitter().getValue().getValue();
			clearDeadlineJitter();
		}
	}

	@Override
	public void undo() {
		if (oldValue != null) {
			final DeadlineJitter newDeadlineJitter = LibraryElementFactory.eINSTANCE.createDeadlineJitter();
			newDeadlineJitter.getValue().setValue(oldValue);
			setDeadlineJitter(newDeadlineJitter);
		}
	}

	@Override
	public void redo() {
		clearDeadlineJitter();
	}

	private void clearDeadlineJitter() {
		if (transaction != null && transaction.getDeadlineTime() != null) {
			transaction.getDeadlineTime().setDeadlineJitter(null);
		} else if (outputPrimitive != null) {
			outputPrimitive.getDeadlineTime().setDeadlineJitter(null);
		}
	}

	private void setDeadlineJitter(final DeadlineJitter jitter) {
		if (transaction != null && transaction.getDeadlineTime() != null) {
			transaction.getDeadlineTime().setDeadlineJitter(jitter);
		} else if (outputPrimitive != null) {
			outputPrimitive.getDeadlineTime().setDeadlineJitter(jitter);
		}
	}
}
