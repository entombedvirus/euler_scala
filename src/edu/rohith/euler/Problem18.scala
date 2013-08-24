package edu.rohith.euler

import scala.annotation.tailrec

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/22/13
 * Time: 9:56 AM
 */
object Problem18 extends App {
  val rawData =             """75
                             |95 64
                           |17 47 82
                         |18 35 87 10
                       |20 04 82 47 65
                     |19 01 23 75 03 34
                   |88 02 77 73 07 63 67
                 |99 65 04 28 06 16 70 92
               |41 41 26 56 83 40 80 70 33
             |41 48 72 33 47 32 37 16 94 29
           |53 71 44 65 25 43 91 52 97 51 14
         |70 11 33 28 77 73 17 78 39 68 17 57
       |91 71 52 38 17 14 91 43 58 50 27 29 48
      |63 66 04 68 89 53 67 30 73 16 69 87 40 31
    |04 62 98 27 23 09 70 98 73 93 38 53 60 04 23""".stripMargin

  val triangle = rawData.lines.map(_.split(' ').map(_.toInt)).toList
//  println(triangle(14)(14))

  def maxPathSum(triangle: List[Array[Int]], apex: (Int, Int) = (0, 0)): Int = {
    if (apex._1 == triangle.length - 1) {
      return triangle(apex._1)(apex._2)
    }

    triangle(apex._1)(apex._2) + Math.max(
      maxPathSum(triangle, (apex._1 + 1, apex._2)), maxPathSum(triangle, (apex._1 + 1, apex._2 + 1))
    )
  }

  println(s"Max Path Sum: ${maxPathSum(triangle)}")
}
