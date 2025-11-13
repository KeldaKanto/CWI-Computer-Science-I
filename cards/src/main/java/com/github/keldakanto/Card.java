package com.github.keldakanto;

//*********************************************************************
//  PP 5.13      Java Foundations
//
//  Design and implement a class called Card that represents a stan-
//  dard playing card. Each card has a suit and a face value. Create a
//  program that deals five random cards.
//*********************************************************************

public class Card {
    private Suit suit;
    private Rank rank;

    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES;
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
    }

    public Card() {
        switch ((int)Math.random() * Suit.values().length) {
            case 0:
                suit = Suit.CLUBS;
            case 1:
                suit = Suit.DIAMONDS;
            case 2:
                suit = Suit.HEARTS;
            case 3:
                suit = Suit.SPADES;
        }

        switch (((int)Math.random() * Rank.values().length) + 2) {
            case 2:
                rank = Rank.TWO;
            case 3:
                rank = Rank.THREE;
            case 4:
                rank = Rank.FOUR;
            case 5:
                rank = Rank.FIVE;
            case 6:
                rank = Rank.SIX;
            case 7:
                rank = Rank.SEVEN;
            case 8:
                rank = Rank.EIGHT;
            case 9:
                rank = Rank.NINE;
            case 10:
                rank = Rank.TEN;
            case 11:
                rank = Rank.JACK;
            case 12:
                rank = Rank.QUEEN;
            case 13:
                rank = Rank.KING;
            case 14:
                rank = Rank.ACE;
        }
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        String suitName;
        suitName = suit.toString().charAt(0) + suit.toString().substring(1).toLowerCase();

        String rankName;
        switch (rank) {
            case JACK:
                rankName = "Jack";
            case QUEEN:
                rankName = "Queen";
            case KING:
                rankName = "King";
            case ACE:
                rankName = "Ace";
            default:
                rankName = String.valueOf(rank.ordinal() + 2);
        }
        return rankName + " of " + suitName;
    }
}