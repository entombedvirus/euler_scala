package edu.rohith.euler

import scala.collection.mutable
import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/19/13
 * Time: 12:48 PM
 */
object Problem14 extends App {
  def collatzSeries(start: Long): Stream[Long] = {

    val series = Stream.iterate(start) {
      case n if n % 2 == 0 => n / 2
      case n => 3 * n + 1
    }

    series.takeWhile(_ != 1) #::: Stream(1L)
  }

//  collatzSeries(13) foreach println

  def perfectPowerOfTwo(n: Long) = (n != 0 && (n & (n - 1)) == 0)

  val cache = new mutable.HashMap[Long, Int]

  def numTermsInSeries(s: Stream[Long]): Int = {
    if (s.isEmpty)
      0
    else
      cache.getOrElseUpdate(s.head, numTermsInSeries(s.tail) + 1)
  }

  val longestChainStart = (1 to 999999).maxBy {i =>
    val numTerms = numTermsInSeries(collatzSeries(i))
//    println(s"$i = $numTerms");
    numTerms
  }

  println(s"Longest chain is produced by $longestChainStart")
//  (2 to 40) foreach {i => println(collatzSeries(i) mkString " -> ")}
//  println(collatzSeries(837799) find perfectPowerOfTwo)
}
