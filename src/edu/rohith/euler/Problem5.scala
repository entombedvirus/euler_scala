package edu.rohith.euler

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/17/13
 * Time: 10:25 PM
 */
object Problem5 extends App {
  val multiples20: Stream[Int] = Stream.iterate(20) {i => i + 20}
  val divisors = Set(
    20 , 19 , 18 , 17 , 16 , 15 ,
    14 , 13 , 12 , 11
  )

  multiples20.find(n => divisors.forall(n % _ == 0)) match {
    case Some(smallest) => println(s"Smallest number divisible by 1..20 is $smallest")
    case None => // will never hit
  }

}
