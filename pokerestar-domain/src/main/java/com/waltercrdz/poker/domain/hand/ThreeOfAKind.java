package com.waltercrdz.poker.domain.hand;

import com.waltercrdz.poker.domain.Card;

public class ThreeOfAKind extends RankedHand {

	private final Card card;
	
	public ThreeOfAKind(Card card) {
		super(Hand.THREE_OF_A_KIND);
		this.card = card;
	}

	@Override
	protected int cardsStrength() {
		return this.card.strength();
	}
}
