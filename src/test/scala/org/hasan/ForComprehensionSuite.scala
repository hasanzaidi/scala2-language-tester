package org.hasan

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ForComprehensionSuite extends AnyFunSuite with Matchers {
  test("Use yield with a for loop to build a new collection from the input") {
    // This is known as "for comprehension"
    // There is no val in the for statement because it is assumed they are val types. But they work because a new constant
    // is returned for next iteration.
    val fruits = Vector[String]("apple", "banana", "orange")
    val fruitsUpperCase1 = for (e <- fruits) yield e.toUpperCase
    fruitsUpperCase1 should equal(Vector[String]("APPLE", "BANANA", "ORANGE"))

    // For/yield works in the same way as map")
    val fruitsUpperCase2 = fruits.map(e => e.toUpperCase())
    fruitsUpperCase2 should equal(Vector[String]("APPLE", "BANANA", "ORANGE"))
  }

  test("An if statement in a for loop is called a guard") {
    // Given/When:
    var sum = 0
    for (i <- 1 to 10 if i < 4) sum = sum + i

    // Then:
    sum should equal(6)
  }

  test("A for loop which uses until instead of to") {
    // Given/When:
    // until is exclusive instead of inclusive
    var sum = 0
    for (i <- 1 until 4) sum = sum + i

    // Then:
    sum should equal(6)
  }

  test("yield returns an Option") {
    // Given/When:
    val product: Option[Int] = for {
      a <- Some(3)
      b <- Some(4)
      c <- Some(5)
    } yield a * b * c

    // Then
    product should equal(Some(60))
  }

  test("Equivalent code without for comprehension") {
    // Given/When:
    val product = Some(3).flatMap { num =>
      Some(4).flatMap { num2 =>
        Some(5).map { num3 =>
          num * num2 * num3
        }
      }
    }

    // Then:
    product should equal(Some(60))
  }
}
