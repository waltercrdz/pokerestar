package com.waltercrdz.poker.domain.hand;

import com.waltercrdz.poker.domain.Card;

public class HighCard extends RankedHand {

	private final Card card;
	
	public HighCard(Card card) {
		super(Hand.HIGH_CARD);
		this.card = card;
	}

	@Override
	protected int cardsStrength() {
		return this.card.strength();
	}
}
