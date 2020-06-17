package org.hasan

import org.hasan.multipleinheritance.BasicIntQueue
import org.hasan.multipleinheritance.Doubling
import org.hasan.multipleinheritance.Incrementing
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class BasicIntQueueSuite extends AnyFunSuite with Matchers {
  test("Example of traits") {
    val incrementingThenDoubling = new BasicIntQueue with Incrementing
    with Doubling
    incrementingThenDoubling.put(2) should equal(5)

    val doublingThenIncrementing = new BasicIntQueue with Doubling
    with Incrementing
    doublingThenIncrementing.put(2) should equal(6)
  }
}
