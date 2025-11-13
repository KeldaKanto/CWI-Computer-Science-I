//*********************************************************************
//  PP 5.13      Java Foundations
//
//  Design and implement a class called Card that represents a stan-
//  dard playing card. Each card has a suit and a face value. Create a
//  program that deals five random cards.
//*********************************************************************

import Card.Rank;
import Card.Suit;

public class Deal {
    public static void main(String[] args) {
        final int CARD_TOTAL = 5;

        Card[] cards = new Card[CARD_TOTAL];

        System.out.printf("This program will deal %s cards.%n%n", CARD_TOTAL);
        System.out.printf("Your cards are : %n");

        for (int i = 0; i < CARD_TOTAL; i++) {
            cards[i] = new Card();
            System.out.printf("   %s%n", cards[i]);
        }

        cards[0].setRank(Rank.EIGHT);

        System.out.printf("%s, %s%n", cards[0].getRank(), cards[0].getSuit());
        System.out.printf("%s, %s%n", cards[1].getRank(), cards[1].getSuit());
    }
}