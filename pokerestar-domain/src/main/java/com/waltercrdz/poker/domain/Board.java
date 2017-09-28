package com.waltercrdz.poker.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.waltercrdz.poker.domain.hand.RankedHand;

public class Board {

	private static final Logger LOG = LoggerFactory.getLogger(Board.class);

	private Dealer dealer;
	private List<Player> players;
	private List<Card> communityCards;
	// private Integer pot;

	private Board(Dealer dealer) {
		// Empty pot
		this.players = Lists.newArrayList();
		this.communityCards = Lists.newArrayList();
		this.dealer = dealer;
	}

	// TODO remove this
	public void debugPrints() {
		LOG.debug("Flop: {}", this.communityCards.stream().limit(3).collect(Collectors.toList()));
		LOG.debug("Turn: {}", this.communityCards.stream().skip(3).limit(1).collect(Collectors.toList()));
		LOG.debug("River: {}", this.communityCards.stream().skip(4).limit(1).collect(Collectors.toList()));
		this.players.stream().forEach(p -> LOG.debug("{}'s cards: {}", p.getUsername(), p.getHoleCards()));
	}

	public void startHand() {
		this.dealPreFlopRound();
		this.dealFlopRound();
		this.dealTurnRound();
		this.dealRiverRound();

		this.evaluateHands();

		this.debugPrints();
	}

	public Map<Player, RankedHand> evaluateHands() {
		Map<Player, RankedHand> rankedHands = new HashMap<>();
//		this.players.stream().forEach(p -> rankedHands.put(p, HandEvaluator.evaluate(p, this.communityCards)));
		return rankedHands;
	}

	public void dealPreFlopRound() {
		this.checkPreconditions();
		LOG.info("Starting hand...");
		LOG.info("{} {} {} {}", '\u2660', '\u2666', '\u2663', '\u2764');

		this.dealer.resetDeckIfNecessary();
		this.dealer.shuffle();

		this.dealOneCardForEachPlayer();
		this.dealOneCardForEachPlayer();
	}

	public void dealFlopRound() {
		this.communityCards.addAll(this.dealer.deal(3));
	}

	public void dealTurnRound() {
		this.communityCards.add(this.dealer.deal());
	}

	public void dealRiverRound() {
		this.communityCards.add(this.dealer.deal());
	}

	private void dealOneCardForEachPlayer() {
		this.players.stream().forEach(p -> p.addCard(this.dealer.deal()));
	}

	public void addPlayer(Player player) {
		Preconditions.checkArgument(Objects.nonNull(player), "Player to add Cannot be null.");
		LOG.info("{} has entered in the game.", player);
		this.players.add(player);
	}

	private void checkPreconditions() {
		Preconditions.checkState(!this.players.isEmpty(), "The table should has any player at least.");
	}

	public static class Builder {

		private Dealer dealer;

		public Builder dealer(Dealer dealer) {
			this.dealer = dealer;
			return this;
		}

		public Board build() {
			return new Board(this.dealer);
		}
	}
}
