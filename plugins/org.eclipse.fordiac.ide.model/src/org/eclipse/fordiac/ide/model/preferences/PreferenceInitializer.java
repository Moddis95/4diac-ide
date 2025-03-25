/*******************************************************************************
 * Copyright (c) 2020 Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Ernst Blecha
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		final IEclipsePreferences preferences = DefaultScope.INSTANCE
				.getNode(ModelPreferenceConstants.MODEL_PREFERENCES_ID);

		preferences.putInt(ModelPreferenceConstants.P_ALLOCATION_SIZE,
				ModelPreferenceConstants.P_ALLOCATION_SIZE_DEFAULT_VALUE);
		preferences.putInt(ModelPreferenceConstants.P_ALLOCATION_SIZE,
				ModelPreferenceConstants.P_ALLOCATION_SIZE_DEFAULT_VALUE);
		preferences.putInt(ModelPreferenceConstants.MARGIN_TOP_BOTTOM,
				ModelPreferenceConstants.MARGIN_TOP_BOTTOM_DEFAULT_VALUE);
		preferences.putInt(ModelPreferenceConstants.MARGIN_LEFT_RIGHT,
				ModelPreferenceConstants.MARGIN_LEFT_RIGHT_DEFAULT_VALUE);
	}
}
