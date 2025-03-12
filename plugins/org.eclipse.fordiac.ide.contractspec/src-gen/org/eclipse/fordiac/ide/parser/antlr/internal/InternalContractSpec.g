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
 *     - initial implementation and/or documentation
 *******************************************************************************/
grammar InternalContractSpec;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.fordiac.ide.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.fordiac.ide.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.fordiac.ide.services.ContractSpecGrammarAccess;

}

@parser::members {

 	private ContractSpecGrammarAccess grammarAccess;

    public InternalContractSpecParser(TokenStream input, ContractSpecGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected ContractSpecGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getModelAccess().getTimeSpecTimeSpecParserRuleCall_0());
			}
			lv_timeSpec_0_0=ruleTimeSpec
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getModelRule());
				}
				add(
					$current,
					"timeSpec",
					lv_timeSpec_0_0,
					"org.eclipse.fordiac.ide.ContractSpec.TimeSpec");
				afterParserOrEnumRuleCall();
			}
		)
	)*
;

// Entry rule entryRuleTimeSpec
entryRuleTimeSpec returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTimeSpecRule()); }
	iv_ruleTimeSpec=ruleTimeSpec
	{ $current=$iv_ruleTimeSpec.current; }
	EOF;

// Rule TimeSpec
ruleTimeSpec returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTimeSpecAccess().getSingleEventParserRuleCall_0());
		}
		this_SingleEvent_0=ruleSingleEvent
		{
			$current = $this_SingleEvent_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTimeSpecAccess().getRepetitionParserRuleCall_1());
		}
		this_Repetition_1=ruleRepetition
		{
			$current = $this_Repetition_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTimeSpecAccess().getReactionParserRuleCall_2());
		}
		this_Reaction_2=ruleReaction
		{
			$current = $this_Reaction_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTimeSpecAccess().getAgeParserRuleCall_3());
		}
		this_Age_3=ruleAge
		{
			$current = $this_Age_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTimeSpecAccess().getCausalReactionParserRuleCall_4());
		}
		this_CausalReaction_4=ruleCausalReaction
		{
			$current = $this_CausalReaction_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTimeSpecAccess().getCausalAgeParserRuleCall_5());
		}
		this_CausalAge_5=ruleCausalAge
		{
			$current = $this_CausalAge_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTimeSpecAccess().getCausalFuncDeclParserRuleCall_6());
		}
		this_CausalFuncDecl_6=ruleCausalFuncDecl
		{
			$current = $this_CausalFuncDecl_6.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTimeSpecAccess().getClockDefinitionParserRuleCall_7());
		}
		this_ClockDefinition_7=ruleClockDefinition
		{
			$current = $this_ClockDefinition_7.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleSingleEvent
entryRuleSingleEvent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSingleEventRule()); }
	iv_ruleSingleEvent=ruleSingleEvent
	{ $current=$iv_ruleSingleEvent.current; }
	EOF;

// Rule SingleEvent
ruleSingleEvent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSingleEventAccess().getEventsEventListParserRuleCall_0_0());
				}
				lv_events_0_0=ruleEventList
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSingleEventRule());
					}
					set(
						$current,
						"events",
						lv_events_0_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventList");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='occurs'
		{
			newLeafNode(otherlv_1, grammarAccess.getSingleEventAccess().getOccursKeyword_1());
		}
		otherlv_2='within'
		{
			newLeafNode(otherlv_2, grammarAccess.getSingleEventAccess().getWithinKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSingleEventAccess().getIntervalIntervalParserRuleCall_3_0());
				}
				lv_interval_3_0=ruleInterval
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSingleEventRule());
					}
					set(
						$current,
						"interval",
						lv_interval_3_0,
						"org.eclipse.fordiac.ide.ContractSpec.Interval");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4='using'
			{
				newLeafNode(otherlv_4, grammarAccess.getSingleEventAccess().getUsingKeyword_4_0());
			}
			otherlv_5='clock'
			{
				newLeafNode(otherlv_5, grammarAccess.getSingleEventAccess().getClockKeyword_4_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSingleEventRule());
						}
					}
					otherlv_6=RULE_ID
					{
						newLeafNode(otherlv_6, grammarAccess.getSingleEventAccess().getClockClockDefinitionCrossReference_4_2_0());
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleRepetition
entryRuleRepetition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRepetitionRule()); }
	iv_ruleRepetition=ruleRepetition
	{ $current=$iv_ruleRepetition.current; }
	EOF;

// Rule Repetition
ruleRepetition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getRepetitionAccess().getEventsEventListParserRuleCall_0_0());
				}
				lv_events_0_0=ruleEventList
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRepetitionRule());
					}
					set(
						$current,
						"events",
						lv_events_0_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventList");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='occurs'
		{
			newLeafNode(otherlv_1, grammarAccess.getRepetitionAccess().getOccursKeyword_1());
		}
		otherlv_2='every'
		{
			newLeafNode(otherlv_2, grammarAccess.getRepetitionAccess().getEveryKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRepetitionAccess().getIntervalIntervalParserRuleCall_3_0());
				}
				lv_interval_3_0=ruleInterval
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRepetitionRule());
					}
					set(
						$current,
						"interval",
						lv_interval_3_0,
						"org.eclipse.fordiac.ide.ContractSpec.Interval");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4='with'
			{
				newLeafNode(otherlv_4, grammarAccess.getRepetitionAccess().getWithKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getRepetitionAccess().getRepetitionOptionsRepetitionOptionsParserRuleCall_4_1_0());
					}
					lv_repetitionOptions_5_0=ruleRepetitionOptions
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRepetitionRule());
						}
						set(
							$current,
							"repetitionOptions",
							lv_repetitionOptions_5_0,
							"org.eclipse.fordiac.ide.ContractSpec.RepetitionOptions");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_6='using'
			{
				newLeafNode(otherlv_6, grammarAccess.getRepetitionAccess().getUsingKeyword_5_0());
			}
			otherlv_7='clock'
			{
				newLeafNode(otherlv_7, grammarAccess.getRepetitionAccess().getClockKeyword_5_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getRepetitionRule());
						}
					}
					otherlv_8=RULE_ID
					{
						newLeafNode(otherlv_8, grammarAccess.getRepetitionAccess().getClockClockDefinitionCrossReference_5_2_0());
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleRepetitionOptions
entryRuleRepetitionOptions returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRepetitionOptionsRule()); }
	iv_ruleRepetitionOptions=ruleRepetitionOptions
	{ $current=$iv_ruleRepetitionOptions.current; }
	EOF;

// Rule RepetitionOptions
ruleRepetitionOptions returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getRepetitionOptionsAccess().getJitterJitterParserRuleCall_0_0_0());
					}
					lv_jitter_0_0=ruleJitter
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRepetitionOptionsRule());
						}
						set(
							$current,
							"jitter",
							lv_jitter_0_0,
							"org.eclipse.fordiac.ide.ContractSpec.Jitter");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_1='and'
				{
					newLeafNode(otherlv_1, grammarAccess.getRepetitionOptionsAccess().getAndKeyword_0_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getRepetitionOptionsAccess().getOffsetOffsetParserRuleCall_0_1_1_0());
						}
						lv_offset_2_0=ruleOffset
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRepetitionOptionsRule());
							}
							set(
								$current,
								"offset",
								lv_offset_2_0,
								"org.eclipse.fordiac.ide.ContractSpec.Offset");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
		    |
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getRepetitionOptionsAccess().getOffsetOffsetParserRuleCall_1_0_0());
					}
					lv_offset_3_0=ruleOffset
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getRepetitionOptionsRule());
						}
						set(
							$current,
							"offset",
							lv_offset_3_0,
							"org.eclipse.fordiac.ide.ContractSpec.Offset");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_4='and'
				{
					newLeafNode(otherlv_4, grammarAccess.getRepetitionOptionsAccess().getAndKeyword_1_1_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getRepetitionOptionsAccess().getJitterJitterParserRuleCall_1_1_1_0());
						}
						lv_jitter_5_0=ruleJitter
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getRepetitionOptionsRule());
							}
							set(
								$current,
								"jitter",
								lv_jitter_5_0,
								"org.eclipse.fordiac.ide.ContractSpec.Jitter");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)?
		)
	)
;

// Entry rule entryRuleJitter
entryRuleJitter returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getJitterRule()); }
	iv_ruleJitter=ruleJitter
	{ $current=$iv_ruleJitter.current; }
	EOF;

// Rule Jitter
ruleJitter returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='jitter'
		{
			newLeafNode(otherlv_0, grammarAccess.getJitterAccess().getJitterKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getJitterAccess().getTimeTimeExprParserRuleCall_1_0());
				}
				lv_time_1_0=ruleTimeExpr
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getJitterRule());
					}
					set(
						$current,
						"time",
						lv_time_1_0,
						"org.eclipse.fordiac.ide.ContractSpec.TimeExpr");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleOffset
entryRuleOffset returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOffsetRule()); }
	iv_ruleOffset=ruleOffset
	{ $current=$iv_ruleOffset.current; }
	EOF;

// Rule Offset
ruleOffset returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='offset'
		{
			newLeafNode(otherlv_0, grammarAccess.getOffsetAccess().getOffsetKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getOffsetAccess().getTimeTimeExprParserRuleCall_1_0());
				}
				lv_time_1_0=ruleTimeExpr
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOffsetRule());
					}
					set(
						$current,
						"time",
						lv_time_1_0,
						"org.eclipse.fordiac.ide.ContractSpec.TimeExpr");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleReaction
entryRuleReaction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReactionRule()); }
	iv_ruleReaction=ruleReaction
	{ $current=$iv_ruleReaction.current; }
	EOF;

// Rule Reaction
ruleReaction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='whenever'
		{
			newLeafNode(otherlv_0, grammarAccess.getReactionAccess().getWheneverKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getReactionAccess().getTriggerEventExprParserRuleCall_1_0());
				}
				lv_trigger_1_0=ruleEventExpr
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReactionRule());
					}
					set(
						$current,
						"trigger",
						lv_trigger_1_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventExpr");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='occurs'
		{
			newLeafNode(otherlv_2, grammarAccess.getReactionAccess().getOccursKeyword_2());
		}
		otherlv_3='then'
		{
			newLeafNode(otherlv_3, grammarAccess.getReactionAccess().getThenKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getReactionAccess().getReactionEventExprParserRuleCall_4_0());
				}
				lv_reaction_4_0=ruleEventExpr
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReactionRule());
					}
					set(
						$current,
						"reaction",
						lv_reaction_4_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventExpr");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='occurs'
		{
			newLeafNode(otherlv_5, grammarAccess.getReactionAccess().getOccursKeyword_5());
		}
		otherlv_6='within'
		{
			newLeafNode(otherlv_6, grammarAccess.getReactionAccess().getWithinKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getReactionAccess().getIntervalIntervalParserRuleCall_7_0());
				}
				lv_interval_7_0=ruleInterval
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReactionRule());
					}
					set(
						$current,
						"interval",
						lv_interval_7_0,
						"org.eclipse.fordiac.ide.ContractSpec.Interval");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_8='once'
			{
				newLeafNode(otherlv_8, grammarAccess.getReactionAccess().getOnceKeyword_8());
			}
		)?
		(
			(
				(
					lv_n_9_0=RULE_INT
					{
						newLeafNode(lv_n_9_0, grammarAccess.getReactionAccess().getNINTTerminalRuleCall_9_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getReactionRule());
						}
						setWithLastConsumed(
							$current,
							"n",
							lv_n_9_0,
							"org.eclipse.xtext.common.Terminals.INT");
					}
				)
			)
			otherlv_10='out'
			{
				newLeafNode(otherlv_10, grammarAccess.getReactionAccess().getOutKeyword_9_1());
			}
			otherlv_11='of'
			{
				newLeafNode(otherlv_11, grammarAccess.getReactionAccess().getOfKeyword_9_2());
			}
			(
				(
					lv_outOf_12_0=RULE_INT
					{
						newLeafNode(lv_outOf_12_0, grammarAccess.getReactionAccess().getOutOfINTTerminalRuleCall_9_3_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getReactionRule());
						}
						setWithLastConsumed(
							$current,
							"outOf",
							lv_outOf_12_0,
							"org.eclipse.xtext.common.Terminals.INT");
					}
				)
			)
			otherlv_13='times'
			{
				newLeafNode(otherlv_13, grammarAccess.getReactionAccess().getTimesKeyword_9_4());
			}
		)?
		(
			otherlv_14='using'
			{
				newLeafNode(otherlv_14, grammarAccess.getReactionAccess().getUsingKeyword_10_0());
			}
			otherlv_15='clock'
			{
				newLeafNode(otherlv_15, grammarAccess.getReactionAccess().getClockKeyword_10_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getReactionRule());
						}
					}
					otherlv_16=RULE_ID
					{
						newLeafNode(otherlv_16, grammarAccess.getReactionAccess().getClockClockDefinitionCrossReference_10_2_0());
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleAge
entryRuleAge returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAgeRule()); }
	iv_ruleAge=ruleAge
	{ $current=$iv_ruleAge.current; }
	EOF;

// Rule Age
ruleAge returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='whenever'
		{
			newLeafNode(otherlv_0, grammarAccess.getAgeAccess().getWheneverKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAgeAccess().getTriggerEventExprParserRuleCall_1_0());
				}
				lv_trigger_1_0=ruleEventExpr
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAgeRule());
					}
					set(
						$current,
						"trigger",
						lv_trigger_1_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventExpr");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2='occurs'
		{
			newLeafNode(otherlv_2, grammarAccess.getAgeAccess().getOccursKeyword_2());
		}
		otherlv_3='then'
		{
			newLeafNode(otherlv_3, grammarAccess.getAgeAccess().getThenKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAgeAccess().getReactionEventExprParserRuleCall_4_0());
				}
				lv_reaction_4_0=ruleEventExpr
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAgeRule());
					}
					set(
						$current,
						"reaction",
						lv_reaction_4_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventExpr");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='has'
		{
			newLeafNode(otherlv_5, grammarAccess.getAgeAccess().getHasKeyword_5());
		}
		otherlv_6='occurred'
		{
			newLeafNode(otherlv_6, grammarAccess.getAgeAccess().getOccurredKeyword_6());
		}
		otherlv_7='within'
		{
			newLeafNode(otherlv_7, grammarAccess.getAgeAccess().getWithinKeyword_7());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAgeAccess().getIntervalIntervalParserRuleCall_8_0());
				}
				lv_interval_8_0=ruleInterval
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAgeRule());
					}
					set(
						$current,
						"interval",
						lv_interval_8_0,
						"org.eclipse.fordiac.ide.ContractSpec.Interval");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_9='once'
			{
				newLeafNode(otherlv_9, grammarAccess.getAgeAccess().getOnceKeyword_9());
			}
		)?
		(
			(
				(
					lv_n_10_0=RULE_INT
					{
						newLeafNode(lv_n_10_0, grammarAccess.getAgeAccess().getNINTTerminalRuleCall_10_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAgeRule());
						}
						setWithLastConsumed(
							$current,
							"n",
							lv_n_10_0,
							"org.eclipse.xtext.common.Terminals.INT");
					}
				)
			)
			otherlv_11='out'
			{
				newLeafNode(otherlv_11, grammarAccess.getAgeAccess().getOutKeyword_10_1());
			}
			otherlv_12='of'
			{
				newLeafNode(otherlv_12, grammarAccess.getAgeAccess().getOfKeyword_10_2());
			}
			(
				(
					lv_outOf_13_0=RULE_INT
					{
						newLeafNode(lv_outOf_13_0, grammarAccess.getAgeAccess().getOutOfINTTerminalRuleCall_10_3_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAgeRule());
						}
						setWithLastConsumed(
							$current,
							"outOf",
							lv_outOf_13_0,
							"org.eclipse.xtext.common.Terminals.INT");
					}
				)
			)
			otherlv_14='times'
			{
				newLeafNode(otherlv_14, grammarAccess.getAgeAccess().getTimesKeyword_10_4());
			}
		)?
		(
			otherlv_15='using'
			{
				newLeafNode(otherlv_15, grammarAccess.getAgeAccess().getUsingKeyword_11_0());
			}
			otherlv_16='clock'
			{
				newLeafNode(otherlv_16, grammarAccess.getAgeAccess().getClockKeyword_11_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getAgeRule());
						}
					}
					otherlv_17=RULE_ID
					{
						newLeafNode(otherlv_17, grammarAccess.getAgeAccess().getClockClockDefinitionCrossReference_11_2_0());
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleCausalReaction
entryRuleCausalReaction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCausalReactionRule()); }
	iv_ruleCausalReaction=ruleCausalReaction
	{ $current=$iv_ruleCausalReaction.current; }
	EOF;

// Rule CausalReaction
ruleCausalReaction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Reaction'
		{
			newLeafNode(otherlv_0, grammarAccess.getCausalReactionAccess().getReactionKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getCausalReactionAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCausalReactionAccess().getE1EventSpecParserRuleCall_2_0());
				}
				lv_e1_2_0=ruleEventSpec
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCausalReactionRule());
					}
					set(
						$current,
						"e1",
						lv_e1_2_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventSpec");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=','
		{
			newLeafNode(otherlv_3, grammarAccess.getCausalReactionAccess().getCommaKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCausalReactionAccess().getE2EventSpecParserRuleCall_4_0());
				}
				lv_e2_4_0=ruleEventSpec
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCausalReactionRule());
					}
					set(
						$current,
						"e2",
						lv_e2_4_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventSpec");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getCausalReactionAccess().getRightParenthesisKeyword_5());
		}
		otherlv_6='within'
		{
			newLeafNode(otherlv_6, grammarAccess.getCausalReactionAccess().getWithinKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCausalReactionAccess().getIntervalIntervalParserRuleCall_7_0());
				}
				lv_interval_7_0=ruleInterval
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCausalReactionRule());
					}
					set(
						$current,
						"interval",
						lv_interval_7_0,
						"org.eclipse.fordiac.ide.ContractSpec.Interval");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_8='using'
			{
				newLeafNode(otherlv_8, grammarAccess.getCausalReactionAccess().getUsingKeyword_8_0());
			}
			otherlv_9='clock'
			{
				newLeafNode(otherlv_9, grammarAccess.getCausalReactionAccess().getClockKeyword_8_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getCausalReactionRule());
						}
					}
					otherlv_10=RULE_ID
					{
						newLeafNode(otherlv_10, grammarAccess.getCausalReactionAccess().getClockClockDefinitionCrossReference_8_2_0());
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleCausalAge
entryRuleCausalAge returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCausalAgeRule()); }
	iv_ruleCausalAge=ruleCausalAge
	{ $current=$iv_ruleCausalAge.current; }
	EOF;

// Rule CausalAge
ruleCausalAge returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Age'
		{
			newLeafNode(otherlv_0, grammarAccess.getCausalAgeAccess().getAgeKeyword_0());
		}
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getCausalAgeAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCausalAgeAccess().getE1EventSpecParserRuleCall_2_0());
				}
				lv_e1_2_0=ruleEventSpec
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCausalAgeRule());
					}
					set(
						$current,
						"e1",
						lv_e1_2_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventSpec");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=','
		{
			newLeafNode(otherlv_3, grammarAccess.getCausalAgeAccess().getCommaKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCausalAgeAccess().getE2EventSpecParserRuleCall_4_0());
				}
				lv_e2_4_0=ruleEventSpec
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCausalAgeRule());
					}
					set(
						$current,
						"e2",
						lv_e2_4_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventSpec");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getCausalAgeAccess().getRightParenthesisKeyword_5());
		}
		otherlv_6='within'
		{
			newLeafNode(otherlv_6, grammarAccess.getCausalAgeAccess().getWithinKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCausalAgeAccess().getIntervalIntervalParserRuleCall_7_0());
				}
				lv_interval_7_0=ruleInterval
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCausalAgeRule());
					}
					set(
						$current,
						"interval",
						lv_interval_7_0,
						"org.eclipse.fordiac.ide.ContractSpec.Interval");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_8='using'
			{
				newLeafNode(otherlv_8, grammarAccess.getCausalAgeAccess().getUsingKeyword_8_0());
			}
			otherlv_9='clock'
			{
				newLeafNode(otherlv_9, grammarAccess.getCausalAgeAccess().getClockKeyword_8_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getCausalAgeRule());
						}
					}
					otherlv_10=RULE_ID
					{
						newLeafNode(otherlv_10, grammarAccess.getCausalAgeAccess().getClockClockDefinitionCrossReference_8_2_0());
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleEventExpr
entryRuleEventExpr returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEventExprRule()); }
	iv_ruleEventExpr=ruleEventExpr
	{ $current=$iv_ruleEventExpr.current; }
	EOF;

// Rule EventExpr
ruleEventExpr returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEventExprAccess().getEventEventSpecParserRuleCall_0_0());
				}
				lv_event_0_0=ruleEventSpec
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEventExprRule());
					}
					set(
						$current,
						"event",
						lv_event_0_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventSpec");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			otherlv_1='('
			{
				newLeafNode(otherlv_1, grammarAccess.getEventExprAccess().getLeftParenthesisKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEventExprAccess().getEventsEventListParserRuleCall_1_1_0());
					}
					lv_events_2_0=ruleEventList
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEventExprRule());
						}
						set(
							$current,
							"events",
							lv_events_2_0,
							"org.eclipse.fordiac.ide.ContractSpec.EventList");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3=')'
			{
				newLeafNode(otherlv_3, grammarAccess.getEventExprAccess().getRightParenthesisKeyword_1_2());
			}
		)
		    |
		(
			otherlv_4='{'
			{
				newLeafNode(otherlv_4, grammarAccess.getEventExprAccess().getLeftCurlyBracketKeyword_2_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEventExprAccess().getEventsEventListParserRuleCall_2_1_0());
					}
					lv_events_5_0=ruleEventList
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEventExprRule());
						}
						set(
							$current,
							"events",
							lv_events_5_0,
							"org.eclipse.fordiac.ide.ContractSpec.EventList");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_6='}'
			{
				newLeafNode(otherlv_6, grammarAccess.getEventExprAccess().getRightCurlyBracketKeyword_2_2());
			}
		)
	)
;

// Entry rule entryRuleEventList
entryRuleEventList returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEventListRule()); }
	iv_ruleEventList=ruleEventList
	{ $current=$iv_ruleEventList.current; }
	EOF;

// Rule EventList
ruleEventList returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getEventListAccess().getEventsEventSpecParserRuleCall_0_0());
				}
				lv_events_0_0=ruleEventSpec
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getEventListRule());
					}
					add(
						$current,
						"events",
						lv_events_0_0,
						"org.eclipse.fordiac.ide.ContractSpec.EventSpec");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_1=','
			{
				newLeafNode(otherlv_1, grammarAccess.getEventListAccess().getCommaKeyword_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getEventListAccess().getEventsEventSpecParserRuleCall_1_1_0());
					}
					lv_events_2_0=ruleEventSpec
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getEventListRule());
						}
						add(
							$current,
							"events",
							lv_events_2_0,
							"org.eclipse.fordiac.ide.ContractSpec.EventSpec");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleEventSpec
entryRuleEventSpec returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEventSpecRule()); }
	iv_ruleEventSpec=ruleEventSpec
	{ $current=$iv_ruleEventSpec.current; }
	EOF;

// Rule EventSpec
ruleEventSpec returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEventSpecRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getEventSpecAccess().getPortPortCrossReference_0_0());
				}
			)
		)
		(
			otherlv_1='.'
			{
				newLeafNode(otherlv_1, grammarAccess.getEventSpecAccess().getFullStopKeyword_1_0());
			}
			(
				(
					lv_eventValue_2_0=RULE_ID
					{
						newLeafNode(lv_eventValue_2_0, grammarAccess.getEventSpecAccess().getEventValueIDTerminalRuleCall_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getEventSpecRule());
						}
						setWithLastConsumed(
							$current,
							"eventValue",
							lv_eventValue_2_0,
							"org.eclipse.xtext.common.Terminals.ID");
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleInterval
entryRuleInterval returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIntervalRule()); }
	iv_ruleInterval=ruleInterval
	{ $current=$iv_ruleInterval.current; }
	EOF;

// Rule Interval
ruleInterval returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getIntervalAccess().getTimeTimeExprParserRuleCall_0_0());
				}
				lv_time_0_0=ruleTimeExpr
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntervalRule());
					}
					set(
						$current,
						"time",
						lv_time_0_0,
						"org.eclipse.fordiac.ide.ContractSpec.TimeExpr");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getIntervalAccess().getB1BoundaryParserRuleCall_1_0_0());
					}
					lv_b1_1_0=ruleBoundary
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIntervalRule());
						}
						set(
							$current,
							"b1",
							lv_b1_1_0,
							"org.eclipse.fordiac.ide.ContractSpec.Boundary");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getIntervalAccess().getV1ValueParserRuleCall_1_1_0());
					}
					lv_v1_2_0=ruleValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIntervalRule());
						}
						set(
							$current,
							"v1",
							lv_v1_2_0,
							"org.eclipse.fordiac.ide.ContractSpec.Value");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3=','
			{
				newLeafNode(otherlv_3, grammarAccess.getIntervalAccess().getCommaKeyword_1_2());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getIntervalAccess().getV2ValueParserRuleCall_1_3_0());
					}
					lv_v2_4_0=ruleValue
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIntervalRule());
						}
						set(
							$current,
							"v2",
							lv_v2_4_0,
							"org.eclipse.fordiac.ide.ContractSpec.Value");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getIntervalAccess().getB2BoundaryParserRuleCall_1_4_0());
					}
					lv_b2_5_0=ruleBoundary
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIntervalRule());
						}
						set(
							$current,
							"b2",
							lv_b2_5_0,
							"org.eclipse.fordiac.ide.ContractSpec.Boundary");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getIntervalAccess().getUnitUnitParserRuleCall_1_5_0());
					}
					lv_unit_6_0=ruleUnit
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getIntervalRule());
						}
						set(
							$current,
							"unit",
							lv_unit_6_0,
							"org.eclipse.fordiac.ide.ContractSpec.Unit");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
	)
;

// Entry rule entryRuleTimeExpr
entryRuleTimeExpr returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTimeExprRule()); }
	iv_ruleTimeExpr=ruleTimeExpr
	{ $current=$iv_ruleTimeExpr.current; }
	EOF;

// Rule TimeExpr
ruleTimeExpr returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getTimeExprAccess().getValueValueParserRuleCall_0_0());
				}
				lv_value_0_0=ruleValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTimeExprRule());
					}
					set(
						$current,
						"value",
						lv_value_0_0,
						"org.eclipse.fordiac.ide.ContractSpec.Value");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getTimeExprAccess().getUnitUnitParserRuleCall_1_0());
				}
				lv_unit_1_0=ruleUnit
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTimeExprRule());
					}
					set(
						$current,
						"unit",
						lv_unit_1_0,
						"org.eclipse.fordiac.ide.ContractSpec.Unit");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleBoundary
entryRuleBoundary returns [String current=null]:
	{ newCompositeNode(grammarAccess.getBoundaryRule()); }
	iv_ruleBoundary=ruleBoundary
	{ $current=$iv_ruleBoundary.current.getText(); }
	EOF;

// Rule Boundary
ruleBoundary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='['
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBoundaryAccess().getLeftSquareBracketKeyword_0());
		}
		    |
		kw=']'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBoundaryAccess().getRightSquareBracketKeyword_1());
		}
	)
;

// Entry rule entryRuleValue
entryRuleValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getValueRule()); }
	iv_ruleValue=ruleValue
	{ $current=$iv_ruleValue.current; }
	EOF;

// Rule Value
ruleValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_integer_0_0=RULE_INT
				{
					newLeafNode(lv_integer_0_0, grammarAccess.getValueAccess().getIntegerINTTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getValueRule());
					}
					setWithLastConsumed(
						$current,
						"integer",
						lv_integer_0_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		(
			otherlv_1='.'
			{
				newLeafNode(otherlv_1, grammarAccess.getValueAccess().getFullStopKeyword_1_0());
			}
			(
				(
					lv_fraction_2_0=RULE_INT
					{
						newLeafNode(lv_fraction_2_0, grammarAccess.getValueAccess().getFractionINTTerminalRuleCall_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getValueRule());
						}
						setWithLastConsumed(
							$current,
							"fraction",
							lv_fraction_2_0,
							"org.eclipse.xtext.common.Terminals.INT");
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleUnit
entryRuleUnit returns [String current=null]:
	{ newCompositeNode(grammarAccess.getUnitRule()); }
	iv_ruleUnit=ruleUnit
	{ $current=$iv_ruleUnit.current.getText(); }
	EOF;

// Rule Unit
ruleUnit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='s'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getUnitAccess().getSKeyword_0());
		}
		    |
		kw='ms'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getUnitAccess().getMsKeyword_1());
		}
		    |
		kw='us'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getUnitAccess().getUsKeyword_2());
		}
		    |
		kw='ns'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getUnitAccess().getNsKeyword_3());
		}
	)
;

// Entry rule entryRuleCausalFuncDecl
entryRuleCausalFuncDecl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getCausalFuncDeclRule()); }
	iv_ruleCausalFuncDecl=ruleCausalFuncDecl
	{ $current=$iv_ruleCausalFuncDecl.current; }
	EOF;

// Rule CausalFuncDecl
ruleCausalFuncDecl returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getCausalFuncDeclAccess().getFuncNameCausalFuncNameParserRuleCall_0_0());
				}
				lv_funcName_0_0=ruleCausalFuncName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCausalFuncDeclRule());
					}
					set(
						$current,
						"funcName",
						lv_funcName_0_0,
						"org.eclipse.fordiac.ide.ContractSpec.CausalFuncName");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getCausalFuncDeclAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCausalFuncDeclRule());
					}
				}
				otherlv_2=RULE_ID
				{
					newLeafNode(otherlv_2, grammarAccess.getCausalFuncDeclAccess().getP1PortCrossReference_2_0());
				}
			)
		)
		otherlv_3=','
		{
			newLeafNode(otherlv_3, grammarAccess.getCausalFuncDeclAccess().getCommaKeyword_3());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getCausalFuncDeclRule());
					}
				}
				otherlv_4=RULE_ID
				{
					newLeafNode(otherlv_4, grammarAccess.getCausalFuncDeclAccess().getP2PortCrossReference_4_0());
				}
			)
		)
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getCausalFuncDeclAccess().getRightParenthesisKeyword_5());
		}
		otherlv_6=':='
		{
			newLeafNode(otherlv_6, grammarAccess.getCausalFuncDeclAccess().getColonEqualsSignKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getCausalFuncDeclAccess().getRelationCausalRelationParserRuleCall_7_0());
				}
				lv_relation_7_0=ruleCausalRelation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getCausalFuncDeclRule());
					}
					set(
						$current,
						"relation",
						lv_relation_7_0,
						"org.eclipse.fordiac.ide.ContractSpec.CausalRelation");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleCausalFuncName
entryRuleCausalFuncName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getCausalFuncNameRule()); }
	iv_ruleCausalFuncName=ruleCausalFuncName
	{ $current=$iv_ruleCausalFuncName.current.getText(); }
	EOF;

// Rule CausalFuncName
ruleCausalFuncName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='|>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCausalFuncNameAccess().getVerticalLineGreaterThanSignKeyword_0());
		}
		    |
		kw='<|'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCausalFuncNameAccess().getLessThanSignVerticalLineKeyword_1());
		}
	)
;

// Entry rule entryRuleCausalRelation
entryRuleCausalRelation returns [String current=null]:
	{ newCompositeNode(grammarAccess.getCausalRelationRule()); }
	iv_ruleCausalRelation=ruleCausalRelation
	{ $current=$iv_ruleCausalRelation.current.getText(); }
	EOF;

// Rule CausalRelation
ruleCausalRelation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='FIFO'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCausalRelationAccess().getFIFOKeyword_0());
		}
		    |
		kw='LIFO'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCausalRelationAccess().getLIFOKeyword_1());
		}
		    |
		kw='ID'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getCausalRelationAccess().getIDKeyword_2());
		}
	)
;

// Entry rule entryRuleClockDefinition
entryRuleClockDefinition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getClockDefinitionRule()); }
	iv_ruleClockDefinition=ruleClockDefinition
	{ $current=$iv_ruleClockDefinition.current; }
	EOF;

// Rule ClockDefinition
ruleClockDefinition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Clock'
		{
			newLeafNode(otherlv_0, grammarAccess.getClockDefinitionAccess().getClockKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getClockDefinitionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getClockDefinitionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='has'
		{
			newLeafNode(otherlv_2, grammarAccess.getClockDefinitionAccess().getHasKeyword_2());
		}
		(
			otherlv_3='resolution'
			{
				newLeafNode(otherlv_3, grammarAccess.getClockDefinitionAccess().getResolutionKeyword_3_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getClockDefinitionAccess().getResolutionTimeExprParserRuleCall_3_1_0());
					}
					lv_resolution_4_0=ruleTimeExpr
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getClockDefinitionRule());
						}
						set(
							$current,
							"resolution",
							lv_resolution_4_0,
							"org.eclipse.fordiac.ide.ContractSpec.TimeExpr");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_5='skew'
			{
				newLeafNode(otherlv_5, grammarAccess.getClockDefinitionAccess().getSkewKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getClockDefinitionAccess().getSkewTimeExprParserRuleCall_4_1_0());
					}
					lv_skew_6_0=ruleTimeExpr
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getClockDefinitionRule());
						}
						set(
							$current,
							"skew",
							lv_skew_6_0,
							"org.eclipse.fordiac.ide.ContractSpec.TimeExpr");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_7='drift'
			{
				newLeafNode(otherlv_7, grammarAccess.getClockDefinitionAccess().getDriftKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getClockDefinitionAccess().getDriftIntervalParserRuleCall_5_1_0());
					}
					lv_drift_8_0=ruleInterval
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getClockDefinitionRule());
						}
						set(
							$current,
							"drift",
							lv_drift_8_0,
							"org.eclipse.fordiac.ide.ContractSpec.Interval");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_9='maxdiff'
			{
				newLeafNode(otherlv_9, grammarAccess.getClockDefinitionAccess().getMaxdiffKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getClockDefinitionAccess().getMaxdiffTimeExprParserRuleCall_6_1_0());
					}
					lv_maxdiff_10_0=ruleTimeExpr
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getClockDefinitionRule());
						}
						set(
							$current,
							"maxdiff",
							lv_maxdiff_10_0,
							"org.eclipse.fordiac.ide.ContractSpec.TimeExpr");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
