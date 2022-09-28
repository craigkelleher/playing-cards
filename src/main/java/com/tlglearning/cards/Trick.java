package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import com.tlglearning.cards.model.Suit;
import com.tlglearning.cards.model.Suit.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Trick {

  private final Random rng;
  private final List<Card> blackPile;
  private final List<Card> redPile;

  //Constructor
/*  public Trick(List<Card> blackPile, List<Card> redPile) {
    this.blackPile = blackPile;
    this.redPile = redPile;
  }*/

  public Trick (Random rng){
    this.rng = rng; //take this rng that came in as a parameter, which came as a pointer to rng
    // and put it in the field initializing rng.

    //random source as it will shuffle deck of cards
    //iterate across it to populate red and black pile
    Deck deck = new Deck(); //constructor of deck fills with 52 cards, from deck class.
    deck.shuffle(rng);
    blackPile = new ArrayList<>();
    redPile = new ArrayList<>();
    // divide code in this constructor into 2 piles
    // iterate over the deck, draw 2 cards at a time, 1 being selector
    divideIntoPiles(deck);

  }

  private void divideIntoPiles(Deck deck) {
    for (Iterator<Card> iterator = deck.iterator(); iterator.hasNext(); ){
      Card indicator = iterator.next();
      Card next = iterator.next();
      if(indicator.suit().color() == Suit.Color.BLACK) {
        blackPile.add(next); //putting next card after indicator in pile
      }
      else {
        redPile.add(next);
      }
    }
  }

  public static void main(String[] args) {
    // Create and shuffle a deck of cards
    Trick trick = new Trick(new SecureRandom());
    trick.swapBetweenPiles();
    trick.displayPile(trick.blackPile, Color.BLACK);
    trick.displayPile(trick.redPile, Color.RED);

    // tally the results, cound red cards in red pile, black cards in black pile, compare for equality,
    //   also display the contents of the piles.

  }

  // Divide deck into 2 piles, red and black, discard indicator cards.
  // Swap a random number of cards (between 0 and the size of the smaller pile, inclusive)
  //   between red and black piles
  private void swapBetweenPiles(){
    int maxSwapCount = Math.max(blackPile.size(), redPile.size());
    int swapCount = rng.nextInt(maxSwapCount + 1);
    for(int i = 0; i <swapCount; i++){
      redPile.add(blackPile.remove(0));
      blackPile.add(redPile.remove(0));
    }
  }

  private void displayPile(List<Card> cards, Suit.Color color){
    cards.sort(Comparator
        .comparing((Card card) -> card.suit().color())
        .thenComparing(Card::suit)
        .thenComparing(Card::rank));
    int count = countColor(cards, color);
    System.out.printf("%s: %s: %d%n", color, cards, count);
  }

  private int countColor(Collection<Card> cards, Suit.Color color){
    return (int) cards
        .stream()
        .filter((card -> card.suit().color() == color))
        .count();
  }
}
