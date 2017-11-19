package org.wwy.blackjackai

import org.wwy.blackjackai.actor.{Dealer, Player}
import org.wwy.blackjackai.model.action.{DoubleDown, Hit, Split, Stay}
import org.wwy.blackjackai.model.{Deck, Hand}

import scala.collection.mutable.ListBuffer

/**
  * Created by wayneyu on 11/18/17.
  */
case class Game(nPlayer: Int, rounds: Int) {

  private val dealerInitialChips = 1000
  private val playerInitialChips = 100

  private val dealer = new Dealer(0, dealerInitialChips)
  private val players = (1 to nPlayer).map(i => new Player(i, playerInitialChips)) :+ dealer

  def play = (1 to rounds).foreach{i =>
    playRound
    println(s"Round: $i")
    reportResults
  }

  def playRound {
    val deck = Deck()
    deck.shuffle()
    dealer.setDeck(deck)

    players.foreach{ player =>
      val bet: Int = 1 + (Math.random * (player.chips * 0.1)).toInt

      // Bet
      player match {
        case p: Dealer =>
          p.addBet(p, 0)
        case p: Player if p.chips >= bet =>
          dealer.addBet(player, bet)
      }

      // Deal hand
      player.setHand(new Hand(dealer.deal, dealer.deal))
    }

    val playersToRemove = ListBuffer[Player]()
    dealer.currentBets.foreach { case (player, bet) =>
      // player act on hand
      player match {
        case p: Dealer =>

        case p: Player =>
          while(player.actHand(player.hand) == Hit)
            player.hand.addCard(dealer.deal)

          // player loses on bust or wins on blackjack
          val totals = p.hand.totals
          if (totals.head >= 21 || totals.contains(21)) {
            // player busts
            if (totals.contains(21)) payBet(p, dealer, bet)
            else payBet(dealer, p, bet)

            playersToRemove += p
            if (dealer.currentBets.size <= 2) playersToRemove += dealer
          }

      }
    }

    // dealer hits
    while(dealer.actHand(dealer.hand) == Hit)
      dealer.hand.addCard(dealer.deal)

    players.foreach{p => println(s"$p: ${p.hand}")}
    dealer.currentBets
      .filterNot{ case (k, v) => playersToRemove.contains(k) }
      .foreach{ case (player, bet) =>
        // player win/lose
        player match {
          case p: Dealer =>

          case p: Player =>
            println(p)
            val dealerHandTotal = dealer.hand.totals.head
            val playerHandTotal = player.hand.totals.head

            if (dealerHandTotal > 21 || dealerHandTotal < playerHandTotal) {
              payBet(player, dealer, bet)
            } else if (dealerHandTotal == 21 || dealerHandTotal > playerHandTotal) {
              payBet(dealer, player, bet)
            }
        }
      }

  }

  private def payBet(winner: Player, loser: Player, amount: Int) {
    loser.lose(amount)
    winner.win(amount)
  }

  def reportResults() {
    println(players.mkString("\n"))
    println("------------------------------------------------------")
  }

}

object Game {

  def main(args: Array[String]) {
    val game: Game = new Game(1, 50)
    game.play
  }
}