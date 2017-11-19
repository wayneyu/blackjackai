package org.wwy.blackjackai.model

import scala.util.Random
/**
  * Created by wayneyu on 11/18/17.
  */
case class Deck(var cards: List[Card] = Deck.unShuffled) {

  var iterator = cards.iterator

  def shuffle() = {
    cards = Random.shuffle(cards)
    iterator = cards.iterator
  }

  def nextCard() = iterator.next()

}

object Deck {
  val unShuffled = for (r <- Rank.values; s <- Suit.values) yield Card(r, s)
}