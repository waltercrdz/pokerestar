package com.waltercrdz.poker.test.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.waltercrdz.poker.domain.Card;
import com.waltercrdz.poker.domain.Deck;
import com.waltercrdz.poker.domain.exception.EmptyDeckException;

public class DeckTest {

	private final static int MAX_COUNT_OF_DECK = 52;
	
	@Test
	public void should_count52Cards_When_count() {
		Deck deck = this.createDeck();
		Assert.assertEquals(MAX_COUNT_OF_DECK, deck.count());
	}
	
	@Test
	public void should_count52Cards_when_shuffle() {
		Deck deck = this.createDeck();
		deck.shuffle();
		Assert.assertEquals(MAX_COUNT_OF_DECK, deck.count());
	}
	
	@Test
	public void should_count51Cards_when_deal() {
		Deck deck = this.createDeck();
		Card aCard = deck.deal();
		Assert.assertNotNull(aCard);
		Assert.assertEquals(MAX_COUNT_OF_DECK - 1, deck.count());
	}
	
	@Test(expected = EmptyDeckException.class)
	public void should_throwsException_when_deal53times() {
		Deck deck = this.createDeck();
		for(int i = 0; i < MAX_COUNT_OF_DECK + 1; i++)
			deck.deal();
	}
	
	@Test
	public void should_count49Cards_when_deal2times() {
		Deck deck = this.createDeck();
		List<Card> cards = deck.deal(2);
		Assert.assertEquals(2, cards.size());
		Assert.assertEquals(MAX_COUNT_OF_DECK - 2, deck.count());
	}
	
	@Test(expected = EmptyDeckException.class)
	public void should_throwsException_when_dealMoreThan52times() {
		Deck deck = this.createDeck();
		deck.deal(100);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_throwsException_when_tryDealNegativeTimes() {
		Deck deck = this.createDeck();
		deck.deal(-2);
	}
	
	private Deck createDeck() {
		return new Deck();
	}
}
