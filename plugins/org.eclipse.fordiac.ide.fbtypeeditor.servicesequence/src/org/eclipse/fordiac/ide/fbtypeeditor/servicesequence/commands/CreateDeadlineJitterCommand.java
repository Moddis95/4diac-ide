package org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.commands;

import org.eclipse.fordiac.ide.model.libraryElement.DeadlineJitter;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.libraryElement.Primitive;
import org.eclipse.fordiac.ide.model.libraryElement.ServiceTransaction;
import org.eclipse.fordiac.ide.model.libraryElement.Value;
import org.eclipse.gef.commands.Command;

public class CreateDeadlineJitterCommand extends Command {
	private final ServiceTransaction transaction;
	private final Primitive outputPrimitive;
	private final String value;
	private DeadlineJitter oldJitter;

	public CreateDeadlineJitterCommand(final ServiceTransaction transaction, final String value) {
		this.transaction = transaction;
		this.outputPrimitive = null;
		this.value = value;
	}

	public CreateDeadlineJitterCommand(final Primitive primitive, final String value) {
		this.transaction = null;
		this.outputPrimitive = primitive;
		this.value = value;
	}

	@Override
	public void execute() {
		oldJitter = getJitter();
		final DeadlineJitter newJitter = LibraryElementFactory.eINSTANCE.createDeadlineJitter();
		final Value val = LibraryElementFactory.eINSTANCE.createValue();
		newJitter.setValue(val);
		newJitter.getValue().setValue(value);
		setJitter(newJitter);
	}

	@Override
	public void undo() {
		setJitter(oldJitter);
	}

	@Override
	public void redo() {
		final DeadlineJitter newJitter = LibraryElementFactory.eINSTANCE.createDeadlineJitter();
		final Value val = LibraryElementFactory.eINSTANCE.createValue();
		newJitter.setValue(val);
		newJitter.getValue().setValue(value);
		setJitter(newJitter);
	}

	private DeadlineJitter getJitter() {
		if (transaction != null && transaction.getDeadlineTime() != null) {
			return transaction.getDeadlineTime().getDeadlineJitter();
		}
		if (outputPrimitive != null && outputPrimitive.getDeadlineTime() != null) {
			return outputPrimitive.getDeadlineTime().getDeadlineJitter();
		}
		return null;
	}

	private void setJitter(final DeadlineJitter jitter) {
		if (transaction != null && transaction.getDeadlineTime() != null) {
			transaction.getDeadlineTime().setDeadlineJitter(jitter);
		} else if (outputPrimitive != null && outputPrimitive.getDeadlineTime() != null) {
			outputPrimitive.getDeadlineTime().setDeadlineJitter(jitter);
		}
	}
}
