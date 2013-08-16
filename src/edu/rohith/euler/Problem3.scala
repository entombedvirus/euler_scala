package edu.rohith.euler

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/15/13
 * Time: 3:22 PM
 */
object Problem3 extends App {
  val NUMBER = 600851475143L
//  val NUMBER = 13195L

  var start = NUMBER
  var divisor = 2
  while (start > 1) {
    if (start % divisor == 0) {
      start = start / divisor
      divisor -= 1
    }
    divisor += 1
  }

  println(s"Largest prime: $divisor")
}
