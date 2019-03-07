package com.wiley.javainterviewsexposed.appendix

case class NameAgePair(name: String, age: Int)

object PatternMatching extends App {

  def matchInteger(i: Int): String = {
    i match {
      case 1 => "The value passed was 1"
      case 2 => "The value passed was 2"
      case x if x < 0 => s"The value passed was negative: $x"
      case _ => "The value passed was greater than 2"
    }
  }

  println(matchInteger(-2))
  println(matchInteger(-1))
  println(matchInteger(0))
  println(matchInteger(1))
  println(matchInteger(2))
  println(matchInteger(3))

  def matchNameAgePair(pair: NameAgePair): String = {
    pair match {
      case NameAgePair("Alan", 53) => "Alan is 53"
      case NameAgePair("Alan", _) => "Alan is not 53"
      case NameAgePair(name, 53) => s"Another person, $name, is 53"
      case NameAgePair(name, age) => s"This person, $name, is $age"
    }
  }
}

