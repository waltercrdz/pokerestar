package com.waltercrdz.poker.domain.hand;

import com.waltercrdz.poker.domain.Card;

public class FourOfAKind extends RankedHand {

	private final Card card;
	
	public FourOfAKind(Card card) {
		super(Hand.FOUR_OF_A_KIND);
		this.card = card;
	}

	@Override
	protected int cardsStrength() {
		return this.card.strength();
	}
}
