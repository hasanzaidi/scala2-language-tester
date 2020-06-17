package org.hasan

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import scala.collection.mutable.ArrayBuffer
import collection.mutable._
import scala.jdk.CollectionConverters._

class CollectionsSuite extends AnyFunSpec with Matchers {
  describe("Map tests") {
    it("How to create a map in Scala (and get a value)") {
      // Can create without new keyword because it has apply method on companion object so equivalent to:
      // val scores = Map[String, Integer].apply("Apple" -> 100, "Mango" -> 87, "Banana" -> 42)
      val scores =
        Map[String, Integer]("Apple" -> 100, "Mango" -> 87, "Banana" -> 42)
      val appleVal = scores("Apple")
      appleVal should equal(100)

      // Get returns an optional so can use to check if something exists
      val appleExists = scores.get("Apple")
      appleExists.isDefined shouldBe true

      val orangeExists = scores.get("Orange")
      orangeExists.isDefined shouldBe false
    }

    it(
      "By default maps are immutable so create a mutable one by using mutable.map"
    ) {
      val mutableScores = scala.collection.mutable
        .Map[String, Integer]("Apple" -> 100, "Mango" -> 87)
      mutableScores("Apple") = 99
      val appleVal = mutableScores("Apple")
      appleVal should equal(99)
    }

    it("Converting a list to a map") {
      val listOfNums = Seq(Array("A", "B"), Array("C", "D"))
      val convertedMap = listOfNums.map(i => i(0) -> i(1)).toMap
      convertedMap should equal(Map("A" -> "B", "C" -> "D"))
    }
  }

  // A Scala List is equivalent to a LinkedList in Java
  describe("List tests") {
    val fruits = List("Apple", "Mango", "Banana")

    it("Getting the first element from a List") {
      val first = fruits(0)
      first should equal("Apple")
    }

    it("Can append to a list using ::, instead of += because List is immutable") {
      val newFruits = "Strawberry" :: fruits
      newFruits should equal(Seq("Strawberry", "Apple", "Mango", "Banana"))
    }
  }

  // Seq() uses List as the implementation
  describe("Seq tests") {
    val fruits = Seq("Apple", "Mango", "Banana")

    it("Adding an element to a Seq") {
      val newFruits = fruits :+ "Orange"
      newFruits should equal(Seq("Apple", "Mango", "Banana", "Orange"))
    }

    it("Adding an option to a Seq will flatten it") {
      val orangeOpt = Some("Orange")
      val newFruits = fruits ++ orangeOpt
      newFruits should equal(Seq("Apple", "Mango", "Banana", "Orange"))
    }
  }

  // A Scala Array is equivalent to an Array in Java (can't resize but mutable)
  describe("Array tests") {
    val fruits = Array("Apple", "Mango", "Banana")

    it("Getting the first element from an Array") {
      val first = fruits(0)
      first should equal("Apple")
    }
  }

  // A Scala Vector is equivalent to an ArrayList in Java so is recommended for general purpose immutable collections
  describe("Vector tests") {
    val fruits = Vector("Apple", "Mango", "Banana")

    it("Getting the first element from a Vector") {
      val first = fruits(0)
      first should equal("Apple")
    }
  }

  // A Scala ArrayBuffer is equivalent to an ArrayList in Java so is recommended for general purpose mutable collections
  describe("ArrayBuffer tests") {
    val fruits = ArrayBuffer("Apple", "Mango", "Banana")

    it("Getting the first element from an ArrayBuffer") {
      val first = fruits(0)
      first should equal("Apple")
    }

    it("Adding an element to an ArrayBuffer") {
      fruits += "Orange"
      fruits should equal(ArrayBuffer("Apple", "Mango", "Banana", "Orange"))
    }
  }

  // How to create a set in Scala
  describe("Set tests") {
    it("Adding an element to a set") {
      var fruits = Set("Strawberry", "Mango", "Banana")
      fruits += "Orange"
      fruits("Orange") shouldBe true
    }
  }

  // A range is a sequence holding evenly spaced integers
  describe("Range tests") {
    it("Create range") {
      val r: Range = 1 to 10 by 3
      r should have size (4)
      r(0) should equal(1)
      r(1) should equal(4)
      r(2) should equal(7)
      r(3) should equal(10)
    }
  }

  describe("Converting between Java and Scala") {
    it("Java to Scala") {
      val myJavaList = java.util.Arrays.asList(1, 2)
      val scalaList: Seq[Int] = myJavaList.asScala
      scalaList should equal(Buffer(1, 2))
    }
  }
}
