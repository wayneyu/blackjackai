package org.wwy.blackjackai.model

/**
  * Created by wayneyu on 11/18/17.
  */
sealed abstract case class Rank(value: Int, altValue: Int)

object Ace extends Rank(1, 11)
object Deuce extends Rank(2, 2)
object Three extends Rank(3, 3)
object Four extends Rank(4, 4)
object Five extends Rank(5, 5)
object Six extends Rank(6, 6)
object Seven extends Rank(7, 7)
object Eight extends Rank(8, 8)
object Nine extends Rank(9, 9)
object Ten extends Rank(10, 10)
object Jack extends Rank(10, 10)
object Queen extends Rank(10, 10)
object King extends Rank(10, 10)

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