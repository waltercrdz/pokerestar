package com.waltercrdz.poker.test.domain.evaluator;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.waltercrdz.poker.domain.Card;
import com.waltercrdz.poker.domain.Rank;
import com.waltercrdz.poker.domain.Suit;
import com.waltercrdz.poker.domain.evaluator.HandEvaluator;

public class HandEvaluatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		// TODO to implements
		final HandEvaluator evaluator;
		List<Card> aHoleCards = this.createHoleCards();
		List<Card> communityCards = this.createCommunityCards();
		
	}

	private List<Card> createCommunityCards() {
		final List<Card> holeCards = Lists.newArrayList();
		holeCards.add(new Card.Builder().rank(Rank.ACE).suit(Suit.CLUB).build());
		holeCards.add(new Card.Builder().rank(Rank.ACE).suit(Suit.DIAMOND).build());
		return holeCards;
	}

	private List<Card> createHoleCards() {
		final List<Card> holeCards = Lists.newArrayList();
		holeCards.add(new Card.Builder().rank(Rank.ACE).suit(Suit.CLUB).build());
		holeCards.add(new Card.Builder().rank(Rank.ACE).suit(Suit.DIAMOND).build());
		return holeCards;
	}

}
