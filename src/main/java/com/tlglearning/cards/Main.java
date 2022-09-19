package com.tlglearning.cards;

import com.tlglearning.cards.model.Deck;
import java.security.SecureRandom;
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
  }

}
