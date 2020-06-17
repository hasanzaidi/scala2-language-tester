package org.hasan.multipleinheritance

class BasicIntQueue {
  def put(x: Int): Int = { x }
}

trait Incrementing extends BasicIntQueue {
  override def put(x: Int) = {
    super.put(x + 1)
  }
}

trait Doubling extends BasicIntQueue {
  override def put(x: Int) = {
    super.put(2 * x)
  }
}
