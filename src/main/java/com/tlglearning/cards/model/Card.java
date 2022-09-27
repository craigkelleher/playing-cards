package com.tlglearning.cards.model;

import java.util.Objects;

public class Card implements Comparable<Card> {

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
  public int hashCode() {
    //return super.hashCode();
    //TODO move to initialization
    return Objects.hash(rank, suit); //Multiplication via specific prime number, then adds up
  }

  @Override
  public boolean equals(Object obj) {
    //return super.equals(obj);
    boolean result;
    if (this == obj) {
      result = true;
    } else if (obj instanceof Card) {
      //if obj doesnt point to an instance of cart, then not much point in comparing them 2.
      Card other = (Card) obj; // card has a is a relationship with obj, but obj doesnt with card.
      result = (this.rank == other.rank && this.suit == other.suit);
    } else {
      result = false;
    }
    return result;
  }

  @Override
  public String toString() {
    //since symbol returns string, compiler does string concatenation
    //if char, it would add their unicode together
    return rank.symbol() + suit.symbol();
  }

  @Override
  public int compareTo(Card other) {
    int comparison = suit.compareTo(other.suit);
    if (comparison == 0){
      comparison = rank.compareTo(other.rank);
    }
    return comparison; // TODO Replace with comparison based on suit and rank.

  }
}

//superclass of this, is Object