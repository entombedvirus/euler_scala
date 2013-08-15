package edu.rohith.euler

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/15/13
 * Time: 2:34 PM
 */

object Problem2 extends App {
  val MAX_TERM = 4000000
  def fibonacciStream(first: Int, second: Int): Stream[Int] = {
    if (first > MAX_TERM)
      Stream.empty
    else
      first #:: fibonacciStream(second, first + second)
  }

//  fibonacciStream(1, 2) take 10 foreach println
  var sum = fibonacciStream(1, 2).filter(_ % 2 == 0).sum
  println(s"Sum is $sum")
}
