package org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands;

import org.eclipse.fordiac.ide.model.libraryElement.DeadlineJitter;
import org.eclipse.gef.commands.Command;

public class ChangeDeadlineJitterCommand extends Command {

	private final DeadlineJitter deadlineJitter;
	private final String newValue;
	private String oldValue;

	public ChangeDeadlineJitterCommand(final DeadlineJitter deadlineJitter, final String newValue) {
		this.deadlineJitter = deadlineJitter;
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