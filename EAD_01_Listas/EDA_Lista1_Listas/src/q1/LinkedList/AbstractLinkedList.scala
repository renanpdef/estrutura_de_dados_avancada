package q1.LinkedList

trait AbstractLinkedList {
  
  def createEmptyList(): Unit
  
  def insertBeginning(value: Int): Unit
  
  def printList(): Unit
  
  def printListRecursive(node: Node): Unit
  
  def printListReverse(node: Node): Unit
  
  def isEmpty(): Int
  
  def search(value: Int): Int
  
  def remove(value: Int): Unit
  
  def removeRecursive(value: Int, node: Node): Unit
}