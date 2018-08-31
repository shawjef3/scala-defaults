package me.jeffshaw.default

import scala.collection.generic.CanBuildFrom

trait Default[A] {
  val value: A
}

object Default {
  @inline def apply[A](implicit d: Default[A]): A = d.value

  def apply[A](default: A): Default[A] =
    new Default[A] {
      override val value: A = default
    }

  def unapply[A](d: Default[A]): Option[A] = Some(d.value)

  implicit val anyRef: Default[AnyRef] = Default[AnyRef](null)

  def numeric[A: Numeric]: Default[A] = Default[A](implicitly[Numeric[A]].zero)

  implicit val char: Default[Char] = numeric[Char]

  implicit val byte: Default[Byte] = numeric[Byte]

  implicit val short: Default[Short] = numeric[Short]

  implicit val int: Default[Int] = numeric[Int]

  implicit val long: Default[Long] = numeric[Long]

  implicit val float: Default[Float] = numeric[Float]

  implicit val double: Default[Double] = numeric[Double]

  implicit val boxedChar: Default[java.lang.Character] = Default(java.lang.Character.valueOf(Default[Char]))

  implicit val boxedByte: Default[java.lang.Byte] = Default(java.lang.Byte.valueOf(Default[Byte]))

  implicit val boxedShort: Default[java.lang.Short] = Default(java.lang.Short.valueOf(Default[Short]))

  implicit val boxedInteger: Default[java.lang.Integer] = Default(java.lang.Integer.valueOf(Default[Int]))

  implicit val boxedLong: Default[java.lang.Long] = Default(java.lang.Long.valueOf(Default[Long]))

  implicit val boxedFloat: Default[java.lang.Float] = Default(java.lang.Float.valueOf(Default[Float]))

  implicit val boxedDouble: Default[java.lang.Double] = Default(java.lang.Double.valueOf(Default[Double]))

  implicit val optionInstance: Default[Option[Nothing]] = Default[Option[Nothing]](None)

  implicit def option[A]: Default[Option[A]] = optionInstance.asInstanceOf[Default[Option[A]]]

  implicit def collection[C[_], A](implicit cbf: CanBuildFrom[Nothing, A, C[A]]): Default[C[A]] = Default(cbf.apply().result())

}
