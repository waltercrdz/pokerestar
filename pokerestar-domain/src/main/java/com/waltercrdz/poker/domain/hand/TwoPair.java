package com.waltercrdz.poker.domain.hand;

import com.waltercrdz.poker.domain.Card;

public class TwoPair extends RankedHand {

	private final Card highest;
	private final Card lowest;
	
	public TwoPair(Card highest, Card lowest) {
		super(Hand.TWO_PAIR);
		this.highest = highest;
		this.lowest = lowest;
	}

	@Override
	protected int cardsStrength() {
		return this.highest.strength() + this.lowest.strength();
	}

}
