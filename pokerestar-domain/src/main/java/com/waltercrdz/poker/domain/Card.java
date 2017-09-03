package com.waltercrdz.poker.domain;

public class Card {
	
	private final Suit suit;
	private final Rank rank;
	
	private Card(Suit suit, Rank value) {
		this.suit = suit;
		this.rank = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return rank.label + "" + suit.value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (suit != other.suit)
			return false;
		if (rank != other.rank)
			return false;
		return true;
	}

	public static class Builder {
		private Suit suit;
		private Rank value;
		
		public Builder suit(Suit suit) {
			this.suit = suit;
			return this;
		}
		
		public Builder rank(Rank value) {
			this.value = value;
			return this;
		}
		
		public Card build() {
			return new Card(this.suit, this.value);
		}
	}
}
