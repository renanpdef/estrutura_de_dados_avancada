package q4.CircularLinkedList

trait AbstractCircularLinkedList {
  
  def createEmptyList(): Unit
  
  def insert(value: Int): Unit
  
  def printList(): Unit
  
  def printListRecursive(node: Node): Unit
  
  def isEmpty(): Int
  
  def search(value: Int): Int
  
  def remove(value: Int): Unit
  
  def removeRecursive(value: Int, node: Node): Unit
}