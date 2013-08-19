package edu.rohith.euler

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/18/13
 * Time: 1:06 PM
 */
object Problem10 extends App {
  val primes: Stream[Int] = 2 #:: Stream.from(3).filter {i => primes.takeWhile(k => k * k <= i).forall(k => i % k != 0)}

  val primesBelow = primes.takeWhile(_ < 2000000)

//  primesBelow.reverse take 10 foreach println

  val sumOfPrimes = (BigInt(0) /: primesBelow) {(sum, p) => sum + p}

  println(s"Sum of primes: $sumOfPrimes")

}
