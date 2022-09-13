package com.tlglearning.cards.model;

public class Card {
  //Field declaration
  private final Rank rank;
  // private final are the modifiers
  private final Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  //write accessors for rank and suit. write getters with rank
  public Rank rank() {
    return rank;
  }
  public Suit suit() {
    return suit;
  }

  @Override
  public String toString() {
    //since symbol returns string, compiler does string concatenation
    //if char, it would add their unicode together
    return rank.symbol()+suit.symbol();
  }

  //TODO: override equals method
  //TODO: override hashcode method
}

//superclass of this, is Object