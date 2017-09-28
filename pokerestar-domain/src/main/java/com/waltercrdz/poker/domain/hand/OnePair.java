package com.waltercrdz.poker.domain.hand;

import com.waltercrdz.poker.domain.Card;

public class OnePair extends RankedHand {
	
	private final Card card;
	
	public OnePair(Card card) {
		super(Hand.ONE_PAIR);
		this.card = card;
	}

	@Override
	protected int cardsStrength() {
		return this.card.strength();
	}
}
