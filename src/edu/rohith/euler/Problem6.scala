package edu.rohith.euler

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/17/13
 * Time: 11:41 PM
 */
object Problem6 extends App {
  val squareOfSum = Math.pow((100 * 101) / 2, 2)
  val sumOfSquares = Stream.range(1, 101).map(i => i * i).sum

  val diff = squareOfSum - sumOfSquares
  println(s"Difference = $diff")
}
