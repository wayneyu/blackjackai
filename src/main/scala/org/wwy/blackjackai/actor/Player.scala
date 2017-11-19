package org.wwy.blackjackai.actor

import org.wwy.blackjackai.model.Hand
import org.wwy.blackjackai.model.action.Action
import org.wwy.blackjackai.strategy.{DealerHitStrategy, HandStrategy}

/**
  * Created by wayneyu on 11/18/17.
  */
class Player(val id: Int, var chips: Int, hitStrategy: HandStrategy = DealerHitStrategy()) {

  var hand = Hand()

  def addChips(amount: Int) = chips += amount

  def removeChips(amount: Int) = chips -= amount

  def win(amount: Int) = addChips(amount)

  def lose(amount: Int) = removeChips(amount)

  def setHand(hand: Hand) = this.hand = hand

  def actHand(hand: Hand): Action = hitStrategy.actHand(hand)

  override def toString = s"${getClass.getSimpleName}(id: $id, chips: $chips)"

}
