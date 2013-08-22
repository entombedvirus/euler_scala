package edu.rohith.euler

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/20/13
 * Time: 2:50 PM
 */
object Problem16 extends App {
  val num = BigInt(1) << 1000

  val sumOfDigits = num.toString.map(Character.digit(_, 10)).sum
  println(s"Sum of digits: $sumOfDigits")
}
