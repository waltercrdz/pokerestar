package com.waltercrdz.poker.domain;

public enum Rank {
	TWO(Values.TWO, 2),
	THREE(Values.THREE, 3),
	FOUR(Values.FOUR, 4),
	FIVE(Values.FIVE, 5),
	SIX(Values.SIX, 6),
	SEVEN(Values.SEVEN, 7),
	EIGHT(Values.EIGHT, 8),
	NINE(Values.NINE, 9),
	TEN(Values.TEN, 10),
	JACK(Values.JACK, 11),
	QUEEN(Values.QUEEN, 12),
	KING(Values.KING, 13),
	ACE(Values.ACE, 14);
	
	public String label;
	public int value;

	Rank(final String label, int value) {
        this.label = label;
        this.value = value;
    }

    public static class Values {
        public static final String TWO = "2";
        public static final String THREE = "3";
        public static final String FOUR = "4";
        public static final String FIVE = "5";
        public static final String SIX = "6";
        public static final String SEVEN = "7";
        public static final String EIGHT = "8";
        public static final String NINE = "9";
        public static final String TEN = "10";
        public static final String JACK = "J";
        public static final String QUEEN = "Q";
        public static final String KING = "K";
        public static final String ACE = "A";
    }
}
