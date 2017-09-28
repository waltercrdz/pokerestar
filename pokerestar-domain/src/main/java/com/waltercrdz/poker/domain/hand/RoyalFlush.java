package com.waltercrdz.poker.domain.hand;

import com.waltercrdz.poker.domain.Card;

public class RoyalFlush extends RankedHand {

	private final Card highest;
	private final Card lowest;
	
	public RoyalFlush(Card highest, Card lowest) {
		super(Hand.ROYAL_FLUSH);
		this.highest = highest;
		this.lowest = lowest;
	}
	
	@Override
	protected int cardsStrength() {
		return this.highest.strength() + this.lowest.strength();
	}

}
