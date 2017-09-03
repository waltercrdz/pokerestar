package com.waltercrdz.poker.test.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.waltercrdz.poker.domain.Card;
import com.waltercrdz.poker.domain.Dealer;
import com.waltercrdz.poker.domain.Deck;

public class DealerTest {
	
	@Test
	public void should_returnACard_when_deal() {
		Dealer dealer = this.createDealer();
		Card aCard = dealer.deal();
		Assert.assertNotNull(aCard);
	}
	
	@Test
	public void should_returnTwoCard_when_dealTwoTimes() {
		final int numberOfCards = 2;
		Dealer dealer = this.createDealer();
		List<Card> cards = dealer.deal(numberOfCards);
		Assert.assertEquals(numberOfCards, cards.size());
	}
	
	private Dealer createDealer() {
		return new Dealer.Builder().deck(new Deck()).build();
	}
}
