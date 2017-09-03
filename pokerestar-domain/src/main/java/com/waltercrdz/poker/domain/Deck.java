package com.waltercrdz.poker.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.waltercrdz.poker.domain.exception.EmptyDeckException;

public class Deck {

	public final static int MAX_COUNT_OF_DECK = 52;
	
	private List<Card> cards;
	
	public Deck() {
		this(createCards());
	}

	protected Deck(List<Card> cards) {
		Preconditions.checkArgument(Objects.nonNull(cards), "Cards can't be null.");
		Preconditions.checkArgument(!cards.isEmpty(), "Cards can't be empty.");
		this.cards = cards;
	}

	public int count() {
		return this.cards.size();
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	public List<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		return "Deck [cards=" + cards + "]";
	}

	public Card deal() {
		Card first = this.cards.stream().findFirst().orElseThrow(() -> new EmptyDeckException());
		this.cards.remove(first);
		return first;
	}
	
	public List<Card> deal(int times) {
		Preconditions.checkArgument(times > 0, "Times must be bigger than 0");
		List<Card> cards = Lists.newLinkedList();
		
		for(int i = 0; i < times; i++)
			cards.add(this.deal());
		
		return cards;
	}
	
	public boolean isComplete() {
		return this.cards.size() == MAX_COUNT_OF_DECK;
	}
	
	public void reset() {
		this.cards.clear();
		this.cards.addAll(createCards());
	}
	
	private static List<Card> createCards() {
		List<Card> cards = new LinkedList<Card>();
		for(Suit suit : Suit.values())
			for(Rank rank : Rank.values())
				cards.add(new Card.Builder().suit(suit).rank(rank).build());
		
		return cards;
	}
}
