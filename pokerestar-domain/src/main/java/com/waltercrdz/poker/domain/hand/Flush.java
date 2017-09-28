package com.waltercrdz.poker.domain.hand;

import com.waltercrdz.poker.domain.Card;

public class Flush extends RankedHand {

	private final Card highest;
	
	public Flush(Card highest) {
		super(Hand.FLUSH);
		this.highest = highest;
	}

	@Override
	protected int cardsStrength() {
		// TODO strength of all cards
		return this.highest.strength();
	}

}
