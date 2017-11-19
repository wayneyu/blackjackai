package org.wwy.blackjackai.model

import scala.util.Random
/**
  * Created by wayneyu on 11/18/17.
  */
case class Deck(var cards: List[Card] = Deck.unShuffledCards) {


  def shuffle() = cards = Random.shuffle(cards)

  def nextCard() = cards.iterator.next()

}

object Deck {
  val unShuffledCards = for (r <- Rank.values; s <- Suit.values) yield Card(r, s)
}