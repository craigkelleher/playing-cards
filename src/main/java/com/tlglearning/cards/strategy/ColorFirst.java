package com.tlglearning.cards.strategy;

import com.tlglearning.cards.model.Card;
import java.util.Comparator;

public class ColorFirst implements Comparator<Card> {

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
