package com.waltercrdz.poker.domain.hand;

import com.waltercrdz.poker.domain.Card;

public class StraightFlush extends RankedHand {

	private final Card highest;
	private final Card lowest;
	
	public StraightFlush(Card highest, Card lowest) {
		super(Hand.STRAIGHT_FLUSH);
		this.highest = highest;
		this.lowest = lowest;
	}

	@Override
	protected int cardsStrength() {
		return this.highest.strength() + this.lowest.strength();
	}

}
