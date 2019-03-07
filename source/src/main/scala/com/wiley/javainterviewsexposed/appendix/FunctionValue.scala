package com.wiley.javainterviewsexposed.appendix

object FunctionValue extends App {

  val square: (Int => Int) = x => x * x
  val threeSquared = square(3)
  println(s"The square of 3 is $threeSquared")

  def printNumber(string: String): (Int => String) =
                        number => string + " " + number.toString

  val numberPrinter = printNumber("The value passed to the function is:")
  println(numberPrinter(-100))
}
