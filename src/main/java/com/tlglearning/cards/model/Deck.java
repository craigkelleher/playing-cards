package com.tlglearning.cards.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

  @Override
  public Iterator<Card> iterator() {
    return cards.iterator(); //example of composition. a desk is composed a list of cards, but outside world sees desk.
    //to iterate, we just deletate to cards.
    //for each loop gets compiled to iterator.
  }
}
