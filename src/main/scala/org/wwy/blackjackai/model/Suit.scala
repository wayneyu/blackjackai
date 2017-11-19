package org.wwy.blackjackai.model

/**
  * Created by wayneyu on 11/18/17.
  */
sealed abstract class Suit(value: Int)

case object Diamond extends Suit(1)
case object Club extends Suit(2)
case object Heart extends Suit(3)
case object Spade extends Suit(4)

object Suit {
  val values = List(Diamond, Club, Heart, Spade)
}