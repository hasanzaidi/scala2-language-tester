package org.hasan

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class HighOrderFunctionSuite extends AnyFunSuite with Matchers {
  test("Using map HOF") {
    def squareList(xs: List[Int]): List[Int] = xs map (x => x * x)
    squareList(List(1, 2, 3)) should equal(List(1, 4, 9))
  }

  test("Using filter HOF") {
    def posElems(xs: List[Int]): List[Int] = xs filter (x => x > 0)
    posElems(List(1, -2, 31)) should equal(List(1, 31))
  }

  test("Applying function to String, treating as list of chars") {
    val s = "Hello World"
    s filter (c => c.isUpper) should equal("HW")
  }

  test("Subtracting a list of numbers using reduce") {
    def minus(total: Int, cur: Int): Int = {
      total - cur
    }
    // Equivalent to minus(minus(10, 5), 3)
    List(10, 5, 3).reduce(minus) should equal(2)

    // Equivalent to the reduce example above
    List(5, 3).foldLeft(10)(minus) should equal(2)

    // Equivalent to minus(5, minus(3, 10))
    List(5, 3).foldRight(10)(minus) should equal(12)
  }

  // Pack will combine all consecutive characters which are the same into separate lists.
  test("Packing example") {
    def pack[T](xs: List[T]): List[List[T]] = xs match {
      case Nil => Nil
      case x :: xs1 =>
        val (first, rest) = xs span (y => y == x)
        first :: pack(rest)
    }

    val expected =
      List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
    pack(List("a", "a", "a", "b", "c", "c", "a")) should equal(expected)
  }
}
