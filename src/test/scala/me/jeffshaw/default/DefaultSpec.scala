package me.jeffshaw.default

import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer

class DefaultSpec extends FunSuite {

  test("integer") {
    assertCompiles(
      "Default[Int]"
    )
    assertResult(0)(Default[Int])
  }

  test("long") {
    assertCompiles(
      "Default[Long]"
    )
    assertResult(0L)(Default[Long])
  }

  test("boxed integer") {
    assertCompiles(
      "Default[java.lang.Integer]"
    )
    assertResult(0)(Default[java.lang.Integer])
  }

  test("boxed long") {
    assertCompiles(
      "Default[java.lang.Long]"
    )
    assertResult(0L)(Default[java.lang.Long])
  }

  test("Option") {
    assertCompiles("Default[Option[Int]]")
    assertResult(None)(Default[Option[Int]])
  }

  test("Vector") {
    assertCompiles("Default[Vector[Int]]")
    assertResult(Vector.empty)(Default[Vector[Int]])
  }

  test("ArrayBuffer") {
    assertCompiles("Default[ArrayBuffer[Vector[Int]]]")
    assert(Default[ArrayBuffer[Int]].isInstanceOf[ArrayBuffer[_]])
    assert(Default[ArrayBuffer[Int]].isEmpty)
  }

}
