package edu.rohith.euler

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * Created with IntelliJ IDEA.
 * User: rravi
 * Date: 8/19/13
 * Time: 6:14 PM
 */
object Problem15 extends App {
  class Node(val row: Int, val col: Int, var numPaths: Long = 0) {
    val children: ListBuffer[Node] = new ListBuffer[Node]
    override def hashCode(): Int = s"$row,$col".hashCode
    override def toString(): String = (row, col).toString()
    override def equals(other: Any): Boolean = {
      other.isInstanceOf[Node] &&
      row == other.asInstanceOf[Node].row && col == other.asInstanceOf[Node].col
    }
  }

  val GRID_SIZE = 20
  val ROOT = new Node(0, 0)

  def constructTree(root: Node, alreadyConstructedNodes: mutable.HashSet[Node] = new mutable.HashSet[Node]): Unit = {
    alreadyConstructedNodes.add(root)

    // RIGHT child
    if (root.col + 1 <= GRID_SIZE) {
      val c = new Node(root.row, root.col + 1)
      if (alreadyConstructedNodes(c) == false) {
        constructTree(c, alreadyConstructedNodes)
        root.children.append(c)
      } else {
        root.children.append(alreadyConstructedNodes.find(_ == c).get)
      }
    }

    // BOTTOM child
    if (root.row + 1 <= GRID_SIZE) {
      val c = new Node(root.row + 1, root.col)
      if (alreadyConstructedNodes(c) == false) {
        constructTree(c, alreadyConstructedNodes)
        root.children.append(c)
      } else {
        root.children.append(alreadyConstructedNodes.find(_ == c).get)
      }
    }
  }

  // Construct the tree, starting with root
  constructTree(ROOT)

  def printTree(s: Node, alreadyVisitedNodes: mutable.HashSet[Node] = new mutable.HashSet[Node]): Unit = {
    if (alreadyVisitedNodes(s) == false) {
      alreadyVisitedNodes.add(s)
      s.children.foreach(printTree(_, alreadyVisitedNodes))
      println(s"$s -> ${s.children.map(_.toString())}")
    }
  }
  printTree(ROOT)

  // depth first traversal of the tree
  def calculateNumPaths(start: Node, alreadyVisitedNodes: mutable.HashSet[Node] = new mutable.HashSet[Node]): Long = {
    if (alreadyVisitedNodes(start) == false) {
      alreadyVisitedNodes.add(start)
      if (start.children.isEmpty) // only the leaf node will have no children
        start.numPaths = 1L
      else
        start.numPaths = start.children.map {c => calculateNumPaths(c, alreadyVisitedNodes)}.reduce(_ + _)
    }

    start.numPaths
  }

  val totalNumPaths = calculateNumPaths(ROOT)
  println(s"Total paths: $totalNumPaths")
}
