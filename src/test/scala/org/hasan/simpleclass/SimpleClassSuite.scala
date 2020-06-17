package org.hasan.simpleclass

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SimpleClassSuite extends AnyFunSuite with Matchers {
  test("Accessing getters") {
    val sc = new SimpleClass(1, 2)
    sc.numer should equal(1)
    sc.denom should equal(2)
    sc.z should equal(10000)
  }

  test("Calling method on class") {
    val sc = new SimpleClass(1, 2)
    val numTimesTwo: Int = sc.twice(3)
    numTimesTwo should equal(6)

    // A method which takes an argument and returns a value can use this simplified syntax
    val numTimesTwo2: Int = sc twice 3
    numTimesTwo2 should equal(6)
  }

  test("Making use of alternative constructor") {
    val sc = new SimpleClass()
    sc.numer should equal(0)
    sc.denom should equal(0)
    sc.z should equal(0)
  }

  test("Calling triplePlusOne method on sc") {
    val sc = new SimpleClass()
    val tripleNumPlusOne: Int = sc.triplePlusOne(5)
    tripleNumPlusOne should equal(16)
  }

  test("Static field in Scala") {
    SimpleClass.STATIC_FIELD should equal("My static field")
  }

  test("Multiplying two instances of a class") {
    val sc = new SimpleClass(1, 2)
    val result = sc * new SimpleClass(5, 6, 7)
    result.numer should equal(5)
    result.denom should equal(12)
  }

  test("assigning values to val/def") {
    val sc = new SimpleClass(1, 2)
    // myPrint2 not executed when defined but when called
    sc.myPrint2
    sc.myPrint2

    // myPrint only executed above and repeated references will just use the cached value
    sc.myPrint
    sc.myPrint
  }
}
