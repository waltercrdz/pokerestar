package com.waltercrdz.poker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.waltercrdz.poker.domain.Board;
import com.waltercrdz.poker.domain.Dealer;
import com.waltercrdz.poker.domain.Deck;
import com.waltercrdz.poker.domain.Player;

public class App {
	
	final static Logger LOG = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		Dealer dealer = new Dealer.Builder().deck(new Deck()).build();
		Board table = new Board.Builder().dealer(dealer).build();
		table.addPlayer(new Player.Builder().username("Pepe").stack(1000).build());
		table.addPlayer(new Player.Builder().username("Pirulo").stack(1000).build());
		table.addPlayer(new Player.Builder().username("Walter").stack(1000).build());
		
		table.startHand();
	}
}
