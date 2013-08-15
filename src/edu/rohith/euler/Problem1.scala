package edu.rohith.euler

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/15/13
 * Time: 2:18 PM
 */
object Problem1 extends App {
  val inputRange = (3 until 1000).toStream
  val sum  = inputRange.
    filter(i => i % 3 == 0 || i % 5 == 0).
    sum

  println(s"Sum = $sum")
  // Sum = 233168
}
