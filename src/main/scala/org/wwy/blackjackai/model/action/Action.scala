package org.wwy.blackjackai.model.action

/**
  * Created by wayneyu on 11/18/17.
  */
sealed trait Action

case object Hit extends Action
case object Stay extends Action
case object DoubleDown extends Action
case object Split extends Action
