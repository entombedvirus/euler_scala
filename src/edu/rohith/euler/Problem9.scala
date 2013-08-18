package edu.rohith.euler

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/18/13
 * Time: 9:21 AM
 */
object Problem9 extends App {
  val MAX_C_VALUE = 997 // highest value c can be to satisfy a^2 + b^2 = c^2 and a < b < c and a + b + c = 1000

//  val triplets = naturals.zip(naturals.tail).map {tuple =>
//    tuple match {
//      case (n, m) => val t = (m * m - n * n, 2 * m * n, m * m + n * n); println(s"m = $m, n = $n, $t"); t
//    }
//  }

  val naturalPairs: Stream[(Int, Int)] = Stream.iterate((1, 2)) {lastPair =>
    var newPair = (lastPair._1, lastPair._2 + 1)
    val c = newPair._1 * newPair._1 + newPair._2 * newPair._2
  
    if (c > MAX_C_VALUE) {
      newPair = (lastPair._1 + 1, lastPair._1 + 2)
    }

    newPair
  }

//  naturalPairs take 70 foreach println

  val potentialTriplets = naturalPairs.map(_ match {
    case (n, m) => (m * m - n * n, 2 * m * n, m * m + n * n) // Euclid's formula
  }).takeWhile(_._3 < MAX_C_VALUE)

//  potentialTriplets take 20 foreach println

  val chosenTriplet = potentialTriplets.filter(t => t._1 + t._2 + t._3 == 1000).head
  val product = chosenTriplet._1 * chosenTriplet._2 * chosenTriplet._3
  println(s"chosenTriplet = $chosenTriplet. Product = $product")
}
