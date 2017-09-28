package com.waltercrdz.poker.domain.hand.evaluator;

import java.util.Objects;

import com.google.common.base.Preconditions;
import com.waltercrdz.poker.domain.hand.RankedHand;

public class HandEvaluator {

	public static RankedHand evaluate(RankedHand aHand, RankedHand anotherHand) {
		Preconditions.checkArgument(Objects.nonNull(aHand) && Objects.nonNull(anotherHand), "Hand to evaluate cannot be null.");
		// TODO what happens in case of a tie?
		return aHand.strength() > anotherHand.strength() ? aHand : anotherHand;
	}
}
