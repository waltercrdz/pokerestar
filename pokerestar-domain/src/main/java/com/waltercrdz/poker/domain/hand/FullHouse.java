package com.waltercrdz.poker.domain.hand;

import com.waltercrdz.poker.domain.Card;

public class FullHouse extends RankedHand {

	private final Card cardOfThree;
	private final Card cardOfTwo;
	
	public FullHouse(Card cardOfThree, Card cardOfTwo) {
		super(Hand.FULL_HOUSE);
		this.cardOfThree = cardOfThree;
		this.cardOfTwo = cardOfTwo;
	}
	
	@Override
	protected int cardsStrength() {
		return this.cardOfThree.strength();
	}

}
