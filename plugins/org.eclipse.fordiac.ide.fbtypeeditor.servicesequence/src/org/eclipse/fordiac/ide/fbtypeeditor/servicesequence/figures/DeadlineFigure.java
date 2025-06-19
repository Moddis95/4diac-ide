package org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.fordiac.ide.model.libraryElement.DeadlineTime;

public class DeadlineFigure extends Figure {

	private final Figure deadlineColorBox;
	private final Label deadlineNameLabel;

	public DeadlineFigure(final DeadlineTime deadlineTime) {
		setLayoutManager(new FlowLayout());

		this.deadlineColorBox = new Figure();

		final GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		this.deadlineColorBox.setLayoutManager(layout);

		setColorForDeadlineType(deadlineTime);
		this.deadlineColorBox.setPreferredSize(120, 20);
		this.deadlineColorBox.setOpaque(true);

		this.deadlineNameLabel = new Label();
		setDeadlineNameLabelText(deadlineTime);

		this.deadlineColorBox.add(deadlineNameLabel);
		add(deadlineColorBox);

		setPreferredSize(120, 20);
	}

	public DeadlineFigure() {
		setLayoutManager(new FlowLayout());

		this.deadlineColorBox = new Figure();

		final GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		this.deadlineColorBox.setLayoutManager(layout);

		setColorForDeadlineType(null);
		this.deadlineColorBox.setPreferredSize(120, 20);
		this.deadlineColorBox.setOpaque(true);

		this.deadlineNameLabel = new Label();
		setDeadlineNameLabelText(null);

		this.deadlineColorBox.add(deadlineNameLabel);
		add(deadlineColorBox);

		setPreferredSize(120, 20);
	}

	public void setColorForDeadlineType(final DeadlineTime deadlineTime) {
		if (deadlineTime != null) {
			switch (deadlineTime.getDeadlineType()) {
			case SOFT_DEADLINE -> this.deadlineColorBox.setBackgroundColor(ColorConstants.green);
			case HARD_DEADLINE -> this.deadlineColorBox.setBackgroundColor(ColorConstants.orange);
			case FIRM_DEADLINE -> this.deadlineColorBox.setBackgroundColor(ColorConstants.yellow);
			default ->
				throw new IllegalArgumentException("Unexpected DeadlineType value: " + deadlineTime.getDeadlineType());
			}
		} else {
			setVisible(false);
		}
	}

	public void setDeadlineNameLabelText(final DeadlineTime deadlineTime) {
		if (deadlineTime != null) {
			if (deadlineTime.getDeadlineJitter() != null) {
				final String labelText = deadlineTime.getValue().getValue() + "(+"
						+ deadlineTime.getDeadlineJitter().getValue().getValue() + ")";
				this.deadlineNameLabel.setText(labelText + "micro s"); //$NON-NLS-1$
				this.deadlineNameLabel.setToolTip(new Label(labelText + "micro s")); //$NON-NLS-1$
			} else {
				final String labelText = deadlineTime.getValue().getValue();
				this.deadlineNameLabel.setText(labelText + "micro s"); //$NON-NLS-1$
				this.deadlineNameLabel.setToolTip(new Label(labelText + "micro s")); //$NON-NLS-1$
			}
		} else {
			this.deadlineNameLabel.setText(" "); //$NON-NLS-1$
		}
	}

}