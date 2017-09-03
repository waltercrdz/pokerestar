package com.waltercrdz.poker.domain;

import java.util.List;

public class Dealer {
	
	private Deck deck;

	protected Dealer(Deck deck) {
		this.deck = deck;
	}
	
	public void shuffle() {
		this.deck.shuffle();
	}
	
	public Card deal() {
		return this.deck.deal();
	}
	
	public List<Card> deal(int times) {
		return this.deck.deal(times);
	}
	
	public void resetDeckIfNecessary() {
		if (this.deck.isComplete())
			this.deck.reset();
	}
	
	public static class Builder {
		
		private Deck deck;
		
		public Builder deck(Deck deck) {
			this.deck = deck;
			return this;
		}
		
		public Dealer build() {
			return new Dealer(this.deck);
		}
	}
}
