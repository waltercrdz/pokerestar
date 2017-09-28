package com.waltercrdz.poker.test.domain.evaluator;

import org.junit.Test;

import com.waltercrdz.poker.domain.Card;
import com.waltercrdz.poker.domain.Rank;
import com.waltercrdz.poker.domain.Suit;
import com.waltercrdz.poker.domain.hand.HighCard;
import com.waltercrdz.poker.domain.hand.OnePair;
import com.waltercrdz.poker.domain.hand.RankedHand;
import com.waltercrdz.poker.domain.hand.ThreeOfAKind;
import com.waltercrdz.poker.domain.hand.evaluator.HandEvaluator;

import junit.framework.Assert;

public class HandEvaluatorTest {

	@Test(expected = IllegalArgumentException.class)
	public void should_throwsException_when_aHandIsNull() {
		RankedHand aceHigh = this.buildHighCard(new Card.Builder().rank(Rank.ACE).suit(Suit.CLUB).build());
		HandEvaluator.evaluate(null, aceHigh);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_throwsException_when_anotherHandIsNull() {
		RankedHand aceHigh = this.buildHighCard(new Card.Builder().rank(Rank.ACE).suit(Suit.CLUB).build());
		HandEvaluator.evaluate(aceHigh, null);
	}
	
	@Test
	public void should_winsOnePair_when_evaluateAgainstHighCard() {
		RankedHand aceHigh = this.buildHighCard(new Card.Builder().rank(Rank.ACE).suit(Suit.CLUB).build());
		RankedHand pairOfTens = this.buildOnePair(new Card.Builder().rank(Rank.TEN).suit(Suit.CLUB).build());
		Assert.assertEquals(pairOfTens, HandEvaluator.evaluate(aceHigh, pairOfTens));
	}
	
	@Test
	public void should_winsThreeOfAKind_when_evaluateAgainstOnePair() {
		RankedHand onePair = this.buildOnePair(new Card.Builder().rank(Rank.ACE).suit(Suit.CLUB).build());
		RankedHand threeOfAKind = this.buildThreeOfAKind(new Card.Builder().rank(Rank.TEN).suit(Suit.CLUB).build());
		Assert.assertEquals(threeOfAKind, HandEvaluator.evaluate(threeOfAKind, onePair));
	}
	
	private RankedHand buildHighCard(Card aCard) {
		return new HighCard(aCard);
	}
	
	private RankedHand buildOnePair(Card aCard) {
		return new OnePair(aCard);
	}
	
	private RankedHand buildThreeOfAKind(Card aCard) {
		return new ThreeOfAKind(aCard);
	}
}
