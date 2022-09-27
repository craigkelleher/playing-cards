package com.tlglearning.cards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck implements Iterable<Card>{

  //need final for list, we have a list of cards and it itself is iterable. (internal detail)
  private final List<Card> cards;

  public Deck() {
    cards = new ArrayList<>();
    //enchanced for loop, returns an array of our enumerated values
    for(Suit suit : Suit.values()){
      for(Rank rank: Rank.values()){
        Card card = new Card(rank, suit);
        cards.add(card);
      }
    }
  }

  //decorator collection around list of cards
  @Override
  public Iterator<Card> iterator() {
    //return cards.iterator(); //example of composition. a desk is composed a list of cards, but outside world sees desk.
    //to iterate, we just deletate to cards.
    //for each loop gets compiled to iterator.
    return Collections.unmodifiableList(cards).iterator();
  }

  // is a: (secure random) inherit by extending class or implementing interface
  // has a composition
  // uses, short term relationship between 1 object and another.
  //   lasts for a method or a few. Deck & Random: uses relationship
  public void shuffle(Random rng){
    Collections.shuffle(cards,rng);
  }

  public void shuffle(){
    //use default source of randomness
    Collections.shuffle(cards);
  }

  public void sort() {
    sort(null);
  }
    //override hashcode, to string (should be string representatin of string of cards representing deck),

  @Override
  public int hashCode() {
    return cards.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    boolean result;
    if (this == obj) {
      result = true;
    } else if (obj instanceof Deck) {
      result = cards.equals(((Deck) obj).cards);
    } else {
      result = false;
    }
    return result;
  }

  @Override
  public String toString() {
    return cards.toString();
  }

}
