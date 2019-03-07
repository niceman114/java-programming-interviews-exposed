package com.wiley.javainterviewsexposed.appendix

object HelloWorld {

  def main(args: Array[String]) = {
    println("Hello world!")
    println("The parameters passed were: " + args.mkString(","))
  }
}
