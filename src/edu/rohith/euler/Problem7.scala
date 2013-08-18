package edu.rohith.euler

import scala.collection.mutable.ListBuffer

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/18/13
 * Time: 12:08 AM
 */
object Problem7 extends App {
  val primes: Stream[Int] = 2 #:: Stream.from(3).filter {i => primes.takeWhile(k => k * k <= i).forall(k => i % k != 0)}
  var nthPrime = primes(10000)
  println(s"Prime: $nthPrime")
}
