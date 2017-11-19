package org.wwy.blackjackai.strategy

import org.wwy.blackjackai.model.Hand
import org.wwy.blackjackai.model.action.{Action, Hit, Stay}

/**
  * Created by wayneyu on 11/18/17.
  */
case class PlayerHitStrategy() extends HandStrategy {
  def actHand(hand: Hand): Action = {
    // hit on 17-
    hand.totals.head match {
      case x if x < 17 => Hit
      case _ => Stay
    }
  }
}
