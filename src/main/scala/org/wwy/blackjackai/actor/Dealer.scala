package org.wwy.blackjackai.actor

import org.wwy.blackjackai.model.Deck

import scala.collection.mutable

/**
  * Created by wayneyu on 11/18/17.
  */
class Dealer(id: Int, chips: Int) extends Player(id, chips) {

  var deck = Deck()

  val currentBets: mutable.Map[Player, Integer] = mutable.ListMap.empty()

  def setDeck(deck: Deck) = this.deck = deck

  def deal = deck.nextCard()

  def hasMoreCards: Boolean = this.deck.cards.nonEmpty

  def addBet(player: Player, amount: Int) = currentBets.put(player, amount)

  def removePlayer(player: Player) = currentBets -= player

}