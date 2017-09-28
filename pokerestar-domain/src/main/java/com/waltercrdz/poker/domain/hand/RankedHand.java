package com.waltercrdz.poker.domain.hand;

public abstract class RankedHand {
	
	private final Hand hand;
	
	public RankedHand(Hand hand) {
		this.hand = hand;
	}

	public int strength() {
		return this.handStrength();
	}
	
	private int handStrength() {
		return this.hand.value;
	}
	
	protected abstract int cardsStrength();
}
