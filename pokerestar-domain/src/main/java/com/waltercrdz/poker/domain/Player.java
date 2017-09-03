package com.waltercrdz.poker.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Preconditions;

public class Player {
	
	private String username;
	private List<Card> holeCards;
	private Integer stack;
	
	protected Player(String username, Integer stack) {
		this.holeCards = new ArrayList<>(2);
		this.username = username;
		this.stack = stack;
	}
	
	public void addCard(Card card) {
		// TODO move this check precondition?
		Preconditions.checkState(this.holeCards.size() < 2, "Player cannot have more than 2 cards.");
		this.holeCards.add(card);
	}

	public List<Card> getHoleCards() {
		return Collections.unmodifiableList(this.holeCards);
	}

	public Integer getStack() {
		return new Integer(stack);
	}
	
//	// TODO How can I to model call, bet, fold?
//	public Integer bet(Integer value) {
//		Preconditions.checkArgument(stack.compareTo(value) >= 0, "Player cannot bet a value bigger than his stack.");
//		this.stack -= value;
//		return value;
//	}
	
	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "Player [username=" + username + "]";
	}

	public static class Builder {

		private String username;
		private Integer stack;
		
		public Builder username(String username) {
			this.username = username;
			return this;
		}
		
		public Builder stack(Integer stack) {
			this.stack = stack;
			return this;
		}
		
		public Player build() {
			return new Player(this.username, this.stack);
		}
	}
}
