package edu.rohith.euler

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/18/13
 * Time: 8:22 PM
 */
object Problem12 extends App {
  val triangleNumbers: Stream[Int] = Stream.from(1).map {i => (i) * (i+1)/2}

//  triangleNumbers take 10 foreach println
  def numFactors(n: Int): Int = {
    Stream.range(2, Math.sqrt(n).toInt).filter(divisor => n % divisor == 0 && n / divisor > divisor).length * 2 + 2
  }

//  println(numFactors(21))

  triangleNumbers.find(numFactors(_) > 500) match {
    case Some(num) => println(s"$num is the first triangle number that has over 500 divisors")
    case None => throw new Exception("Unexpected exception")
  }
}
