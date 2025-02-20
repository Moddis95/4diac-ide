/*******************************************************************************
 * Copyright (c) 2024 Felix Schmid
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Felix Schmid
 *     - initial commit of contract specification editor
 *******************************************************************************/
package org.eclipse.fordiac.ide.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.fordiac.ide.contractSpec.Age;
import org.eclipse.fordiac.ide.contractSpec.CausalAge;
import org.eclipse.fordiac.ide.contractSpec.CausalFuncDecl;
import org.eclipse.fordiac.ide.contractSpec.CausalReaction;
import org.eclipse.fordiac.ide.contractSpec.ContractSpecPackage;
import org.eclipse.fordiac.ide.contractSpec.EventExpr;
import org.eclipse.fordiac.ide.contractSpec.EventSpec;
import org.eclipse.fordiac.ide.contractSpec.Interval;
import org.eclipse.fordiac.ide.contractSpec.Port;
import org.eclipse.fordiac.ide.contractSpec.Reaction;
import org.eclipse.fordiac.ide.contractSpec.Value;
import org.eclipse.xtext.validation.Check;

/**
 * This class contains custom validation rules.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class ContractSpecValidator extends AbstractContractSpecValidator {
	private static final int INPUT = 1;
	private static final int OUTPUT = 0;

	public static final String EMPTY_INTERVAL = "emptyInterval"; //$NON-NLS-1$
	public static final String PORT_NOT_INPUT = "portNotInput"; //$NON-NLS-1$
	public static final String PORT_NOT_OUTPUT = "portNotOutput"; //$NON-NLS-1$

	@Check
	public void checkInterval(final Interval interval) {
		if (interval.getTime() != null) {
			return; // was a single value -> no check needed
		}
		final double begin = value2Double(interval.getV1());
		final double end = value2Double(interval.getV2());

		if (end < begin) {
			warning("Interval is empty. The first number should be smaller than the second.",
					ContractSpecPackage.Literals.INTERVAL__V1, EMPTY_INTERVAL);
		}
	}

	// TODO: SingleEvent, Repetition still unclear regarding input/output ports...

	@Check
	public void checkReaction(final Reaction reaction) {
		checkPortsOfType(reaction.getTrigger(), INPUT, ContractSpecPackage.Literals.REACTION__TRIGGER);
		checkPortsOfType(reaction.getReaction(), OUTPUT, ContractSpecPackage.Literals.REACTION__REACTION);
	}

	@Check
	public void checkCausalReaction(final CausalReaction causalReaction) {
		checkPortsOfType(causalReaction.getE1(), INPUT, ContractSpecPackage.Literals.CAUSAL_REACTION__E1);
		checkPortsOfType(causalReaction.getE2(), OUTPUT, ContractSpecPackage.Literals.CAUSAL_REACTION__E2);
	}

	@Check
	public void checkAge(final Age age) {
		checkPortsOfType(age.getTrigger(), OUTPUT, ContractSpecPackage.Literals.AGE__TRIGGER);
		checkPortsOfType(age.getReaction(), INPUT, ContractSpecPackage.Literals.AGE__REACTION);
	}

	@Check
	public void checkCausalAge(final CausalAge causalAge) {
		checkPortsOfType(causalAge.getE1(), OUTPUT, ContractSpecPackage.Literals.CAUSAL_AGE__E1);
		checkPortsOfType(causalAge.getE2(), INPUT, ContractSpecPackage.Literals.CAUSAL_AGE__E2);
	}

	@Check
	public void checkCausalFuncDecl(final CausalFuncDecl causalFuncDecl) {
		checkPortOfType(causalFuncDecl.getP1(), INPUT, ContractSpecPackage.Literals.CAUSAL_FUNC_DECL__P1);
		checkPortOfType(causalFuncDecl.getP2(), OUTPUT, ContractSpecPackage.Literals.CAUSAL_FUNC_DECL__P2);
	}

	private void checkPortsOfType(final EventExpr expr, final int type, final EStructuralFeature feature) {
		if (expr.getEvent() != null) {
			checkPortOfType(expr.getEvent().getPort(), type, feature);
		} else if (expr.getEvents() != null) {
			checkPortsOfType(expr.getEvents().getEvents(), type, feature);
		}
	}

	private void checkPortsOfType(final EList<EventSpec> list, final int type, final EStructuralFeature feature) {
		if (list == null) {
			return; // nothing to check
		}

		for (final EventSpec es : list) {
			checkPortOfType(es.getPort(), type, feature);
		}
	}

	private void checkPortsOfType(final EventSpec es, final int type, final EStructuralFeature feature) {
		if (es == null) {
			return; // nothing to check
		}
		checkPortOfType(es.getPort(), type, feature);
	}

	private void checkPortOfType(final Port port, final int type, final EStructuralFeature feature) {
		if (port != null && port.getIsInput() != type) {
			if (type == INPUT) {
				final String s = String.format("Expected input ports, but %s is an output port.", port.getName());
				error(s, feature, PORT_NOT_INPUT);
			} else {
				final String s = String.format("Expected output ports, but %s is an input port.", port.getName());
				error(s, feature, PORT_NOT_OUTPUT);
			}
		}
	}

	private static double value2Double(final Value value) {
		final double i = value.getInteger();
		double f = value.getFraction();

		while (f >= 1) {
			f /= 10.0;
		}
		return i + f;
	}
}
