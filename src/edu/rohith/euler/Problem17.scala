package edu.rohith.euler

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/21/13
 * Time: 9:46 PM
 */
object Problem17 extends App {
  val prefixCountMap:Map[Int, String] = Map(
    1    -> "one",
    2    -> "two",
    3    -> "three",
    4    -> "four",
    5    -> "five",
    6    -> "six",
    7    -> "seven",
    8    -> "eight",
    9    -> "nine",
    10   -> "ten",
    11   -> "eleven",
    12   -> "twelve",
    13   -> "thirteen",
    14   -> "fourteen",
    15   -> "fifteen",
    16   -> "sixteen",
    17   -> "seventeen",
    18   -> "eighteen",
    19   -> "nineteen",
    20   -> "twenty",
    30   -> "thirty",
    40   -> "forty",
    50   -> "fifty",
    60   -> "sixty",
    70   -> "seventy",
    80   -> "eighty",
    90   -> "ninety",
    100  -> "hundred",
    1000 -> "thousand"
  )

  def numberInWords(n: Int): String = {
    n match {
      case i if i == 1000 => prefixCountMap(1) + prefixCountMap(1000)
      case i if 100 to 999 contains i => {
        // let's say i = 415
        val charCount = prefixCountMap(i / 100) + prefixCountMap(100) // four + hundred
        if (i % 100 == 0)
          charCount
        else
          charCount + "and" + numberInWords(i % 100)
      }
      case i: Int => prefixCountMap.get(i) match {
        case Some(nonComposite) => nonComposite
        case None => {
          prefixCountMap((i / 10) * 10) + prefixCountMap(i % 10) // in the case of 52, fifty + two
        }
      }
    }
  }

//  println(s"463 = ${letterCount(463)}")

//  val numbersInWords = (1 to 1000).map {i =>
//    (i, letterCount(i))
//  }
//  numbersInWords foreach println

  val numberLetterCount = (1 to 1000).map(numberInWords(_).length).sum
  println(s"Letter count: $numberLetterCount")
}
