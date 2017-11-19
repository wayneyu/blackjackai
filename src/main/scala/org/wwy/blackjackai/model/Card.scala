package org.wwy.blackjackai.model

/**
  * Created by wayneyu on 11/18/17.
  */
case class Card(rank: Rank, suit: Suit) {

  override def toString = s"Card(${rank.getClass.getSimpleName},$suit)"
}
