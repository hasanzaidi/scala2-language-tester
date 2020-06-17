package org.hasan.simpleclass

import org.hasan.simpleclass.MarginType._

// Primary constructor has three arguments
class SimpleClass(x: Int, y: Int, val z: Int = 10000) {
  def numer: Int = x
  def denom: Int = y

  // Method with package visibility (has to be part of current package name), e.g. "hasan1" would cause a compilation error
  private[hasan] def doSomething {}

  // no-args auxiliary constructor
  // Must include a call to this (although doesn't have to be primary)
  def this() {
    this(0, 0, 0)
  }

  // No return statement necessary, just whatever the last line is
  def twice(i: Int): Int = {
    var madeUpVariable = BOTTOM
    2 * i
  }

  // Can nest functions inside functions
  def triplePlusOne(i: Int): Int = {
    def plusOne(i: Int): Int = {
      i + 1
    }
    plusOne(3 * i)
  }

  // Scala methods are less strict on characters in method names
  def *(that: SimpleClass): SimpleClass = {
    new SimpleClass(numer * that.numer, denom * that.denom, 0)
  }

  override def toString = this.numer + ", " + this.denom

  def myPrint2: Int = {
    println("Executed myPrint2")
    2
  }

  val myPrint = {
    println("Executed myPrint")
    2
  }
}

// Can simulate static fields in Scala by using Companion objects
object SimpleClass {
  val STATIC_FIELD = "My static field"
}
