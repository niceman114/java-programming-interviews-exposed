package com.wiley.javainterviewsexposed.appendix

case class BankAccount(accountId: String, balance: Double)

object HigherOrder extends App {

  def alterAccount(account: BankAccount, alteration: (Double => Double)): BankAccount ={
    val newBalance = alteration(account.balance)
    BankAccount(account.accountId, newBalance)
  }

  def applyMinimalInterest(amount: Double) = amount * 1.01
  def applyBonusInterest(amount: Double) = amount * 1.09

  val accountOne = BankAccount("12345", 100.00)
  println(alterAccount(accountOne, applyMinimalInterest))

  val accountTwo = BankAccount("55555", 2000000.00)
  println(alterAccount(accountTwo, applyBonusInterest))
}
