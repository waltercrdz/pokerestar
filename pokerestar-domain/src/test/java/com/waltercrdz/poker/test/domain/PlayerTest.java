package com.waltercrdz.poker.test.domain;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.waltercrdz.poker.domain.Card;
import com.waltercrdz.poker.domain.Dealer;
import com.waltercrdz.poker.domain.Player;
import com.waltercrdz.poker.domain.Rank;
import com.waltercrdz.poker.domain.Suit;

public class PlayerTest {

	private static final int INITIAL_STACK = 2000;
	
	@Mock
	private Dealer dealer;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(this.dealer.deal())
		.thenReturn(new Card.Builder().suit(Suit.HEART).rank(Rank.ACE).build())
		.thenReturn(new Card.Builder().suit(Suit.SPADE).rank(Rank.ACE).build());
	}

	@Test
	public void should_noHasCards_when_isNewPlayer() {
		Player aPlayer = new Player.Builder().stack(INITIAL_STACK).build();
		Assert.assertTrue(aPlayer.getHoleCards().isEmpty());
	}
	
	@Test
	public void should_hasOneCard_when_dealerDealACard() {
		Player aPlayer = new Player.Builder().stack(INITIAL_STACK).build();
		aPlayer.addCard(this.dealer.deal());
		Assert.assertEquals(1, aPlayer.getHoleCards().size());
	}
	
	@Test
	public void should_hasTwoCards_when_dealerDealTwoCards() {
		Player aPlayer = new Player.Builder().stack(INITIAL_STACK).build();
		aPlayer.addCard(this.dealer.deal());
		aPlayer.addCard(this.dealer.deal());
		Assert.assertEquals(2, aPlayer.getHoleCards().size());
	}
	
	@Test(expected = IllegalStateException.class)
	public void should_throwsException_when_dealerTryToDealthreeCards() {
		Player aPlayer = new Player.Builder().stack(INITIAL_STACK).build();
		aPlayer.addCard(this.dealer.deal());
		aPlayer.addCard(this.dealer.deal());
		aPlayer.addCard(this.dealer.deal());
	}

}
