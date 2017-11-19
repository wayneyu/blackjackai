package org.wwy.blackjackai.model

import scala.collection.mutable.ListBuffer
/**
  * Created by wayneyu on 11/18/17.
  */
case class Hand(var cards: ListBuffer[Card] = ListBuffer.empty) {

  def this(cards: Card*) = this(cards.to[ListBuffer])

  def addCard(c: Card) = cards += c

  def totals: List[Int] =
    List(cards.map(_.rank.value).sum, cards.map(_.rank.altValue).sum)

  def hasAce = cards.exists(_.rank == Ace)

  override def toString = s"Hand(total = $totals, $cards)"
}
