/*******************************************************************************
 * Copyright (c) 2021, 2025 Johannes Kepler University,
 * 					  		Carl von Ossietzky Universität Oldenburg
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Melanie Winter
 *     - initial API and implementation and/or initial documentation
 *   Mattis Harzmann - added DEADLINE_WIDTH
 *******************************************************************************/

package org.eclipse.fordiac.ide.fbtypeeditor.servicesequence;

import org.eclipse.swt.graphics.RGB;

public final class ServiceConstants {
	private static final int LIGHT_GRAY_RGB = 234;
	public static final RGB LIGHT_GRAY = new RGB(LIGHT_GRAY_RGB, LIGHT_GRAY_RGB, LIGHT_GRAY_RGB);

	private static final int LIGHTER_GRAY_RGB = 250;
	public static final RGB LIGHTER_GRAY = new RGB(LIGHTER_GRAY_RGB, LIGHTER_GRAY_RGB, LIGHTER_GRAY_RGB);

	private static final int GRAY_RGB = 75;
	public static final RGB GRAY = new RGB(GRAY_RGB, GRAY_RGB, GRAY_RGB);

	private static final int TEXT_BLUE_R = 0;
	private static final int TEXT_BLUE_G = 120;
	private static final int TEXT_BLUE_B = 215;
	public static final RGB TEXT_BLUE = new RGB(TEXT_BLUE_R, TEXT_BLUE_G, TEXT_BLUE_B);

	public static final int LINE_WIDTH = 1;

	private static final int WHOLE_WIDTH = 1120;
	private static final int MIDDLE_SECTION_PERCENT = 16;
	private static final int RIGHT_SECTION_PERCENT = 45;
	private static final int LEFT_SECTION_PERCENT = 35;

	private static final int LEFT_NAME_WIDTH_PERCENT = 17;
	private static final int LEFT_PARAMETER_WIDTH_PERCENT = 15;
	private static final int LEFT_ARROW_WIDTH_PERCENT = 10;

	private static final int RIGHT_NAME_WIDTH_PERCENT = 15;
	private static final int RIGHT_PARAMETER_WIDTH_PERCENT = 10;
	private static final int RIGHT_ARROW_WIDTH_PERCENT = 8;

	private static final int LEMPTY_SPACE_WIDTH_PERCENT = 25;
	private static final int REMPTY_SPACE_WIDTH_PERCENT = 32;
	private static final int DEADLINE_WIDTH_PERCENT = 10;

	public static int getMiddleSectionWidth() {
		return ((WHOLE_WIDTH * MIDDLE_SECTION_PERCENT) / 100);
	}

	public static int getRightSectionWidth() {
		return ((WHOLE_WIDTH * RIGHT_SECTION_PERCENT) / 100) - 2;
	}

	public static int getLeftSectionWidth() {
		return ((WHOLE_WIDTH * LEFT_SECTION_PERCENT) / 100) + 2;
	}

	public static int getLeftParameterLabelWidth() {
		return ((WHOLE_WIDTH * LEFT_PARAMETER_WIDTH_PERCENT) / 100);
	}

	public static int getLeftNameLabelWidth() {
		return ((WHOLE_WIDTH * LEFT_NAME_WIDTH_PERCENT) / 100) + 32;
	}

	public static int getLeftArrowWidth() {
		return ((WHOLE_WIDTH * LEFT_ARROW_WIDTH_PERCENT) / 100);
	}

	public static int getRightParameterLabelWidth() {
		return ((WHOLE_WIDTH * RIGHT_PARAMETER_WIDTH_PERCENT) / 100);
	}

	public static int getRightNameLabelWidth() {
		return ((WHOLE_WIDTH * RIGHT_NAME_WIDTH_PERCENT) / 100) + 32;
	}

	public static int getRightArrowWidth() {
		return ((WHOLE_WIDTH * RIGHT_ARROW_WIDTH_PERCENT) / 100);
	}

	public static int getLEmptyLabelWidth() {
		return ((WHOLE_WIDTH * LEMPTY_SPACE_WIDTH_PERCENT) / 100) + 27;
	}

	public static int getREmptyLabelWidth() {
		return ((WHOLE_WIDTH * REMPTY_SPACE_WIDTH_PERCENT) / 100) + 27;
	}

	public static int getDeadlineSectionWidth() {
		return ((WHOLE_WIDTH * DEADLINE_WIDTH_PERCENT) / 100);
	}

	private ServiceConstants() {
		throw new UnsupportedOperationException();
	}

}
