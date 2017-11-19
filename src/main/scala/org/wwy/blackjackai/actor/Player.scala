package org.wwy.blackjackai.actor

import org.wwy.blackjackai.model.Hand

/**
  * Created by wayneyu on 11/18/17.
  */
class Player(val id: Int, var chips: Int) {

  var hand: Option[Hand] = None

  def addChips(amount: Int) = chips += amount

  def removeChips(amount: Int) = chips -= amount

  def win(amount: Int) = addChips(amount)

  def lose(amount: Int) = removeChips(amount)

  def setHand(hand: Hand) = this.hand = Some(hand)

  override def toString = s"${getClass.getSimpleName}(id: $id, chips: $chips)"

}
