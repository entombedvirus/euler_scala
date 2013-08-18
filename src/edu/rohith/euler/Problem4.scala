package edu.rohith.euler

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/17/13
 * Time: 7:18 PM
 */
object Problem4 extends App {
  def nextPalindrome(n: Int): Int = {
    val prefix = (n / 1000) - 1
    prefix * 1000 + prefix.toString.reverse.toInt
  }

  val palindromes: Stream[Int] = Stream.iterate(999999)(nextPalindrome).takeWhile(_ > 100000)

  palindromes.find {p =>
    val divisorRange = Range(900, 999)
    val factor = divisorRange.find(p % _ == 0)
    factor match {
      case Some(divisor) => {
        val quotient = p / divisor
        if (quotient >= 100 && quotient <= 999) {
          println(s"$p = $divisor * $quotient")
          true
        } else {
          false
        }
      }

      case None => false
    }
  }
}
