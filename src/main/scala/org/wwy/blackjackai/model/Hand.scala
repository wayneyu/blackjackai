package org.wwy.blackjackai.model

import scala.collection.mutable.ListBuffer
/**
  * Created by wayneyu on 11/18/17.
  */
case class Hand(cards: ListBuffer[Card] = ListBuffer.empty) {

  def addCard(c: Card) = cards += c

  def total: List[Int] =
    List(cards.map(_.rank.value).sum, cards.map(_.rank.altValue).sum)

  def hasAce = cards.exists(_.rank == Ace)

  override def toString = s"Hand(total = $total, $cards)"
}
