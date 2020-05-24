package q3.DoublyLinkedList

trait AbstractDoublyLinkedList {
  
  def createEmptyList(): Unit
  
  def insert(value: Int): Unit
  
  def printList(): Unit
  
  def printListRecursive(node: Node): Unit
  
  def printListReverse(node: Node): Unit
  
  def isEmpty(): Int
  
  def search(value: Int): Int
  
  def remove(value: Int): Unit
  
  def removeRecursive(value: Int, node: Node): Unit
  
  def compareLists(list1: DoublyLinkedList, list2: DoublyLinkedList): Boolean
}