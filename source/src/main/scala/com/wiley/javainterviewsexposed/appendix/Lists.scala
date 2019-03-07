package com.wiley.javainterviewsexposed.appendix

import annotation.tailrec

object Lists extends App {

  val listOne = List(1, 2, 3, 4, 5)
  val listTwo = 0 :: listOne
  val listThree = -2 :: -1 :: listTwo

  println(listOne)
  println(listTwo)
  println(listThree)

  @tailrec
  def find(value: Int, list: List[Int]): Boolean = {
    list match {
      case Nil => false
      case x :: _ if x == value => true
      case _ :: xs => find(value, xs)
    }
  }
}
