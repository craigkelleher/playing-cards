package com.tlglearning.cards.model;

public enum Rank {
  ACE("A"),
  TWO("2"),
  THREE("3"),
  FOUR("4"),
  FIVE("5"),
  SIX("6"),
  SEVEN("7"),
  EIGHT("8"),
  NINE("9"),
  TEN("10"),
  JACK("J"),
  QUEEN("Q"),
  KING("K");

  private final String symbol;

  //constructor
  Rank(String symbol) {
    this.symbol = symbol;
  }

  // could be called getSymbol, if not needing a set due to this case.
  public String symbol(){
    return symbol;
  }

  @Override
  public String toString() {
    // invoking a method as it is defined in the superclass (intellij did this)
    // invoke a method on string class to get a portion of the string
    String name = name();       // name is one of the methods we inherit from enum
    // get char at name. invoke substring method, take everything that starts at 1
    // get same string but lower case.
    return name.charAt(0) + name.substring(1).toLowerCase();
    //return super.toString();

    //however if toString on 10, it will return the same thing. this computation could be once,
    //storedin a final thing, and then return that. if it is immutable, why not store it,
    // rather than recompute the same value every time. Same thing wish hashcodes.
  }
}
