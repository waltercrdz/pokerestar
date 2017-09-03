package com.waltercrdz.poker.domain;

public enum Suit {
	
	SPADE(Values.SPADE),
	DIAMOND(Values.DIAMOND),
	CLUB(Values.CLUB), 
	HEART(Values.HEART);
	
	public char value;

	Suit(final char aValue) {
        this.value = aValue;
    }

    public static class Values {
        public static final char SPADE = '\u2660';
        public static final char DIAMOND = '\u2666';
        public static final char CLUB = '\u2663';
        public static final char HEART = '\u2764';
    }
}
