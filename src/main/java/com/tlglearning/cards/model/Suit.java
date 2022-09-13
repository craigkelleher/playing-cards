package com.tlglearning.cards.model;

public enum Suit {
  // need () due to our constructor having a req parameter (char symbol)
  // compiler expands these into constructor invocations in the bytecode
  CLUBS('\u2663'),      // Black club suit
  DIAMONDS('\u2662'),   // White diamond suit
  HEARTS('\u2661'),     // White heart suit
  SPADES('\u2660');     // Black spade suit

  private final char symbol;
  // enum constructors must be private, as cannot create more at runtime, so already by default private
  // private Suit(char symbol){} is the same as below
  Suit(char symbol){
    //  symbol to represent a field in this instance
    this.symbol = symbol;
  }
  public char symbol(){
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
  }
  //override a method

}
