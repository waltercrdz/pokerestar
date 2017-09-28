package com.waltercrdz.poker.domain.hand;

public enum Hand {
	HIGH_CARD(Values.HIGH_CARD, 1),
	ONE_PAIR(Values.ONE_PAIR, 2),
	TWO_PAIR(Values.TWO_PAIR, 3),
	THREE_OF_A_KIND(Values.THREE_OF_A_KIND, 4),
	STRAIGHT(Values.STRAIGHT, 5),
	FLUSH(Values.FLUSH, 6),
	FULL_HOUSE(Values.FULL_HOUSE, 7),
	FOUR_OF_A_KIND(Values.FOUR_OF_A_KIND, 8),
	STRAIGHT_FLUSH(Values.STRAIGHT_FLUSH, 9),
	ROYAL_FLUSH(Values.ROYAL_FLUSH, 10);
	
	public String label;
	public int value;

	Hand(final String label, int value) {
        this.label = label;
        this.value = value;
    }

    public static class Values {
        public static final String HIGH_CARD = "High Card";
        public static final String ONE_PAIR = "One Pair";
        public static final String TWO_PAIR = "Two Pair";
        public static final String THREE_OF_A_KIND = "Three of a Kind";
        public static final String STRAIGHT = "Straight";
        public static final String FLUSH = "Flush";
        public static final String FULL_HOUSE = "Full House";
        public static final String FOUR_OF_A_KIND = "Four of a Kind";
        public static final String STRAIGHT_FLUSH = "Straight Flush";
        public static final String ROYAL_FLUSH = "Royal Flush";
    }
}
