package org.hasan

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class TypedClassSuite extends AnyFunSuite with Matchers {
  test("Getting type from Int type") {
    val int1 = new TypedClass[Int]
    int1.printType() should equal("Int")
  }

  test("Getting type from String type") {
    val str1 = new TypedClass[String]
    str1.printType() should equal("String")
  }
}
