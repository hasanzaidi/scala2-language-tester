package org.hasan

import org.hasan.simpleclass.SimpleClass
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class BasicLanguageSuite extends AnyFunSuite with Matchers {
  test("Example of tuples") {
    val myTuple = ("answer", 42, false)
    val (stringVal, intVal, boolVal) = myTuple
    stringVal should equal("answer")
    intVal should equal(42)
    boolVal should equal(false)

    // Can also get value from tuple with (not zero indexed) accessor (although not recommended)
    myTuple._1 should equal("answer")
  }

  test("Test regular expressions") {
    val numPattern = "[0-9]+".r
    val address = "123 Main Street Suite 101"
    val match1 = numPattern.findFirstIn(address)
    match1.get should equal("123")
  }

  test("Comparing two Strings with ==") {
    val myString1 = "hello"
    val myString2 = "hello"
    myString1 == myString2 shouldBe true
  }

  test("Formatting Strings") {
    val simple = new SimpleClass(1, 2)
    val str = s"numer ${simple.numer} and denom ${simple.denom}"
    str should equal("numer 1 and denom 2")
  }

  test("Formatting Strings using printf style") {
    val name = "Hasan"
    val age = 30
    val str =
      f"Hello, $name! In six months, you'll be ${age + 0.5}%4.2f years old."
    str should equal("Hello, Hasan! In six months, you'll be 30.50 years old.")
  }

  test("Can get a char from a String by treating it as an array") {
    "hello" (1) should equal('e')
  }

  test("Symbolic literals:") {
    // Scala has symbolic literal which allows you to compare Strings using identity instead of equality, which is quicker as
    // it is O(1) instead of O(n)
    val s1 = Symbol("mystring")
    val s2 = Symbol("mystring")
    s1 == s2 shouldBe true
  }

  test("Convert an array to a String using mkstring") {
    val fruits = Array("Apple", "Mango", "Banana")
    fruits.mkString(",") should equal("Apple,Mango,Banana")
  }

  test("Varargs") {
    def printAll(strings: String*): String = {
      strings.mkString(",")
    }
    printAll("Apple", "Mango", "Banana") should equal("Apple,Mango,Banana")
  }

  test(
    "Including quotes in string literal (as you can't insert quotes when using `s`)"
  ) {
    val myString = "\"abc\""
    val newString = s"$myString"
    newString should equal("\"abc\"")
  }

  test(
    "Creating Option"
  ) {
    val some: Option[Int] = Some(5)
    val none: Option[Int] = None

    val x = some.getOrElse(100)
    val y = none.getOrElse(100)

    x should equal(5)
    y should equal(100)
  }
}
