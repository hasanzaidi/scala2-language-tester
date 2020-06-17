package org.hasan.simpleclass

// Example of an enum in Scala
object MarginType extends Enumeration {
  type Margin = Value
  val TOP, BOTTOM, LEFT, RIGHT = Value
}
