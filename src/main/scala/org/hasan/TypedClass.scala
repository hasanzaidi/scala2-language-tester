package org.hasan

import scala.reflect.runtime.universe._

class TypedClass[T](implicit tag: TypeTag[T]) {
  def printType(): String = {
    this.tag.tpe.toString
  }
}
