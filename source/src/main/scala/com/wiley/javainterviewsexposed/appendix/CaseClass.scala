package com.wiley.javainterviewsexposed.appendix

case class Person(name: String, age: Int, salary: Int)

object CaseClassExample extends App {
  val firstPerson = Person("Alice", 24, 3000)
  val secondPerson = Person("Bob", 25, 2500)
  val thirdPerson = Person("Charlie", 30, 1000)

  println(s"The first person is: $firstPerson")
  println("Second person and third person are equal: " + secondPerson == thirdPerson)
}
