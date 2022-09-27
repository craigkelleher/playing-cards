package com.tlglearning.cards.model;

public enum Suit {
  // need () due to our constructor having a req parameter (char symbol)
  // compiler expands these into constructor invocations in the bytecode
  CLUBS('\u2663', Color.BLACK),
  DIAMONDS('\u2662', Color.RED),
  HEARTS('\u2661', Color.RED),
  SPADES('\u2660',Color.BLACK );

  private final char symbol;
  private final Color color;
  // enum constructors must be private, as cannot create more at runtime, so already by default private
  // private Suit(char symbol){} is the same as below
  Suit(char symbol, Color color){
    //  symbol to represent a field in this instance
    this.symbol = symbol;
    this.color = color;
  }
  public char symbol(){
    return symbol;
  }

  public Color color(){
    return color;
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
  }
}

public enum Color{
  BLACK, RED
}
