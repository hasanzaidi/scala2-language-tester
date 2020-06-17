package org.hasan

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import scala.util.Failure
import scala.util.Success
import scala.util.Try

class TrySuite extends AnyFunSuite with Matchers {
  test("Valid Try for sum") {
    val numTry: Try[Int] = Try(Integer.parseInt("1"))
    numTry should equal(Success(1))
  }

  test("Invalid Try for sum") {
    val numTry: Try[Int] = Try(Integer.parseInt("one"))
    numTry.isFailure shouldBe true
  }

  test("Can use pattern matching to access value inside") {
    // Given/When:
    val numTry = Try(Integer.parseInt("2"))
    val num = numTry match {
      case Success(s) => {
        s
      }
      case Failure(thrown) => {
        thrown
      }
    }

    // Then:
    num should equal(2)
  }

  test("Try which recovers if there is an error") {
    // Given/When:
    val sumTry = for {
      int1 <- Try(Integer.parseInt("one")).recover {
        case e: NumberFormatException => 1
      }
      int2 <- Try(Integer.parseInt("2"))
    } yield {
      int1 + int2
    }

    // Then:
    sumTry should equal(Success(3))
  }

  test("Try which can change the Failure if there is one") {
    // Given/When:
    val sumTry = for {
      int1 <- Try(Integer.parseInt("one")).recoverWith {
        case e: NumberFormatException =>
          Failure(new IllegalArgumentException("Try 1 next time"))
      }
      int2 <- Try(Integer.parseInt("2"))
    } yield {
      int1 + int2
    }

    // Then:
    // Hard to assert on this
  }

  test("Multiple Tries for sum") {
    val sumTry: Try[Int] = for {
      int1 <- Try(Integer.parseInt("1"))
      int2 <- Try(Integer.parseInt("2"))
    } yield {
      int1 + int2
    }

    sumTry should equal(Success(3))
  }
}
