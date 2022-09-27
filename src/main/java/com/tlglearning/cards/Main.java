package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
    // Create instance of deck
    Deck deck = new Deck();
    // Print the string representation of the deck
    System.out.println(deck);
    // Create an acceptable source of randomness: Cryptographically secure random
    Random rng = new SecureRandom(); //hard to hack
    // shuffle the deck, using the created source of randomness
    deck.shuffle(rng); //points to an instance of a subclass of random (polymorphism)
    // due to secure random
    // Print the string representation of the deck after shuffling
    System.out.println(deck);
    deck.sort();
    System.out.println(deck);
    deck.sort(new ColorFirst()); //create an instance
    System.out.println(deck);
  }

  private static class ColorFirst implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
      int comparison = card1.suit().color().compareTo(card2.suit().color());
      if (comparison == 0){
        comparison = card1.suit().compareTo(card2.suit());
        if (comparison == 0){
          //computer all on right, and then turn into negative number, assigning to comparison.
          comparison = - card1.rank().compareTo(card2.rank()); //- reverses comparison
        }
      }
      return comparison;
    }
  }

}

