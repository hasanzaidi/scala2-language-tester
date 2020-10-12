package org.hasan

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class FunctionalProgrammingSuite extends AnyFunSuite with Matchers {
  test("Anonymous functions in Scala") {
    val x = List.range(1, 10)
    val evens = x.filter((i: Int) => i % 2 == 0)
    evens should equal(List(2, 4, 6, 8))
  }

  test("Treating functions as objects") {
    val plusThree = (i: Int) => {
      i + 3
    }
    plusThree(2) should equal(5)

    val list = List.range(1, 5)
    list.map(plusThree) should equal(List(4, 5, 6, 7))
  }

  test("Partial function application") {
    def add(a: Int, b: Int): Int = {
      a + b
    }
    def add4 = add(4, _: Int)

    add4(1) should equal(5)
  }

  test("Curried function") {
    def curriedAdd(a: Int) =
      (b: Int) => {
        a + b
      }

    // Can call using multiple function calls
    curriedAdd(3)(1) should equal(4)

    // Or create new functions
    val add3 = curriedAdd(3)
    add3(1) should equal(4)
  }

  test("Building functions using functions using andThen or compose") {
    // Given:
    val add1 = (i: Int) => i + 1
    val double = (i: Int) => i * 2

    // When:
    val addThenDouble = add1 andThen double
    val addThenDoubleWithCompose = double compose add1

    // Then:
    Seq(1, 2, 3).map(addThenDouble) should equal(Seq(4, 6, 8))
    Seq(1, 2, 3).map(addThenDoubleWithCompose) should equal(Seq(4, 6, 8))
  }

  test("Flatten function on Option") {
    val options = List(Some(1), Some(2), None, Some(3), None)
    val optionsWithoutNones = options.flatten
    optionsWithoutNones should equal(List(1, 2, 3))
  }

  test("Flatten function on list of list") {
    val listOfLists = List(List(1, 2), List(3))
    val flattenedList = listOfLists.flatten
    flattenedList should equal(List(1, 2, 3))
  }

  test("Flatten function on list of Strings") {
    val listOfStrings = List("Hel", "lo")
    val flattenedString = listOfStrings.flatten
    flattenedString should equal(List('H', 'e', 'l', 'l', 'o'))
  }

  test("Partition a list") {
    val list = List(15, 10, 5, 8, 20, 12)
    val (greater, smaller) = list.partition(_ >= 10)
    greater should equal(List(15, 10, 20, 12))
    smaller should equal(List(5, 8))
  }
}
