package com.wiley.javainterviewsexposed.appendix

class ScalaIntro {

  val value: String = "This is a String"
  var variable: Int = -100

  def stringLength(s: String): Int = s.length

  def writeOutput = {
    println(s"variable is set to: $variable")
    variable = 25
    println(s"variable is now set to: $variable")

    println(s"value is set to: $value")

    println(s"The length of the string $value is: " + stringLength(value))
  }
}
