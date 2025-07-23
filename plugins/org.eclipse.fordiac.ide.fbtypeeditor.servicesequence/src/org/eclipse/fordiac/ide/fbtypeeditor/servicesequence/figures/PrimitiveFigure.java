/*******************************************************************************
 * Copyright (c) 2014, 2025 fortiss GmbH, Johannes Kepler University Linz,
 * 							Carl von Ossietzky Universität Oldenburg
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Monika Wenger
 *     - initial API and implementation and/or initial documentation
 *   Melanie Winter - added parameterLabel
 *   Mattis Harzmann - added DeadlineFigure
 *******************************************************************************/

package org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.fordiac.ide.fbtypeeditor.servicesequence.ServiceConstants;
import org.eclipse.fordiac.ide.model.libraryElement.DeadlineTime;
import org.eclipse.fordiac.ide.util.ColorManager;
import org.eclipse.swt.SWT;

public class PrimitiveFigure extends Layer {

	private final Label nameLabel;
	private final Label emptyLabel;
	private final Label parameterLabel;

	private final Figure centerFigure;
	private final Figure leftFigure;
	private final Figure rightFigure;
	private DeadlineFigure deadlineFigure;

	public PrimitiveFigure(final boolean isLeftInterface, final String name, final String parameter,
			final DeadlineTime deadlineTime) {

		final GridLayout mainLayout = new GridLayout(7, false);
		setLayoutManager(mainLayout);
		mainLayout.marginHeight = 0;
		mainLayout.marginWidth = 0;
		mainLayout.horizontalSpacing = 0;

		nameLabel = new Label();
		nameLabel.setForegroundColor(ColorConstants.black);
		final GridData nameLabelData = new GridData(SWT.FILL, SWT.CENTER, false, false);

		parameterLabel = new Label();
		parameterLabel.setForegroundColor(ColorManager.getColor(ServiceConstants.GRAY));
		final GridData parameterLabelData = new GridData(SWT.FILL, SWT.CENTER, false, false);

		emptyLabel = new Label();
		final GridData emptyLabelData = new GridData(SWT.FILL, SWT.CENTER, false, false);

		if (isLeftInterface) {
			nameLabelData.widthHint = ServiceConstants.getLeftNameLabelWidth();
			parameterLabelData.widthHint = ServiceConstants.getLeftParameterLabelWidth();
			emptyLabelData.widthHint = ServiceConstants.getLEmptyLabelWidth();

		} else if (!isLeftInterface) {
			nameLabelData.widthHint = ServiceConstants.getRightNameLabelWidth();
			parameterLabelData.widthHint = ServiceConstants.getRightParameterLabelWidth();
			emptyLabelData.widthHint = ServiceConstants.getREmptyLabelWidth();
		}

		final GridData arrowLeftData = new GridData(SWT.FILL, SWT.CENTER, false, false);
		arrowLeftData.widthHint = ServiceConstants.getLeftArrowWidth();
		leftFigure = new Figure();

		centerFigure = new Figure();
		final GridData spaceData = new GridData(SWT.FILL, SWT.CENTER, false, false);
		spaceData.widthHint = ServiceConstants.getMiddleSectionWidth();

		final GridData arrowRightData = new GridData(SWT.FILL, SWT.CENTER, false, false);
		arrowRightData.widthHint = ServiceConstants.getRightArrowWidth();
		rightFigure = new Figure();

		final GridData deadlineData = new GridData(SWT.FILL, SWT.CENTER, false, false);
		deadlineData.widthHint = ServiceConstants.getDeadlineSectionWidth();

		if (deadlineTime != null) {
			deadlineFigure = new DeadlineFigure(deadlineTime);
		} else {
			deadlineFigure = new DeadlineFigure();
		}

		setInterfaceDirection(isLeftInterface);

		setNameLabelText(name);
		setParameterLabelText(parameter);
		setConstraint(emptyLabel, emptyLabelData);
		setConstraint(leftFigure, arrowLeftData);
		setConstraint(centerFigure, spaceData);
		setConstraint(rightFigure, arrowRightData);
		setConstraint(nameLabel, nameLabelData);
		setConstraint(parameterLabel, parameterLabelData);
		setConstraint(deadlineFigure, deadlineData);

	}

	public void setInterfaceDirection(final boolean interfaceDirection) {

		if (!this.getChildren().isEmpty()) {
			this.getChildren().clear();
		}
		if (interfaceDirection) {
			nameLabel.setLabelAlignment(PositionConstants.RIGHT);
			parameterLabel.setLabelAlignment(PositionConstants.LEFT);
			nameLabel.setBorder(new MarginBorder(0, 0, 0, 10));

			add(parameterLabel);
			add(nameLabel);
			add(leftFigure);
			add(centerFigure);
			add(rightFigure);
			add(emptyLabel);
			add(deadlineFigure);
			this.revalidate();
			this.repaint();

		} else {
			nameLabel.setLabelAlignment(PositionConstants.LEFT);
			parameterLabel.setLabelAlignment(PositionConstants.RIGHT);
			nameLabel.setBorder(new MarginBorder(0, 10, 0, 0));

			add(emptyLabel);
			add(leftFigure);
			add(centerFigure);
			add(rightFigure);
			add(nameLabel);
			add(parameterLabel);
			add(deadlineFigure);
			this.revalidate();
			this.repaint();

		}
	}

	public Label getNameLabel() {
		return nameLabel;
	}

	public void setNameLabelText(final String name) {
		this.nameLabel.setText(null != name ? name : ""); //$NON-NLS-1$
	}

	public Figure getCenterFigure() {
		return centerFigure;
	}

	public Label getParameterLabel() {
		return parameterLabel;
	}

	public void setParameterLabelText(final String parameter) {
		if ((parameter != null) && !parameter.isEmpty()) {
			this.parameterLabel.setText("(" + parameter + ")"); //$NON-NLS-1$ //$NON-NLS-2$
			this.parameterLabel.setToolTip(new Label(parameter));
		} else {
			this.parameterLabel.setText(""); //$NON-NLS-1$
		}
	}

	public void setDeadlineTime(final DeadlineTime deadlineTime) {
		if (this.deadlineFigure != null) {
			this.getChildren().remove(this.deadlineFigure);
		}

		if (deadlineTime != null) {
			this.deadlineFigure = new DeadlineFigure(deadlineTime);
			this.add(deadlineFigure);
		} else {
			this.deadlineFigure = new DeadlineFigure();
			this.add(deadlineFigure);
		}
	}

}
