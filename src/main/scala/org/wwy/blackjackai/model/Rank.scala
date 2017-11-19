package org.wwy.blackjackai.model

/**
  * Created by wayneyu on 11/18/17.
  */
sealed abstract case class Rank(value: Int, altValue: Int)

case object Ace extends Rank(1, 11)
case object Deuce extends Rank(2, 2)
case object Three extends Rank(3, 3)
case object Four extends Rank(4, 4)
case object Five extends Rank(5, 5)
case object Six extends Rank(6, 6)
case object Seven extends Rank(7, 7)
case object Eight extends Rank(8, 8)
case object Nine extends Rank(9, 9)
case object Ten extends Rank(10, 10)
case object Jack extends Rank(10, 10)
case object Queen extends Rank(10, 10)
case object King extends Rank(10, 10)

object Rank {
  val values = List(
    Ace,
    Deuce,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Ten,
    Jack,
    Queen,
    King)
}