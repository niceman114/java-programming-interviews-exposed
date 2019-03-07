package com.wiley.javainterviewsexposed.appendix

object ListManipulations extends App {

  val list = List(-3, -2, -1, 0, 1, 2, 3, 4, 5)

  def absolute(value: Int): Int = {
    value match {
      case x if x < 0 => -value
      case _ => value
    }
  }

  def isPositive(value: Int): Boolean = {
    value >= 0
  }

  println(list.map(absolute))
  println(list.filter(isPositive))
}
