package q6.Contas

trait AbstractOrderedLinkedList {
  
  def createEmptyList(): Unit
  
  def insert(conta: Conta): Unit
  
  def printList(): Unit
  
  def printListRecursive(node: Node): Unit
  
  def printListReverse(node: Node): Unit
  
  def isEmpty(): Int
  
  def search(num: Int): Conta
  
  def remove(conta: Conta): Unit
  
  def removeRecursive(conta: Conta, node: Node): Unit
  
  def compareLists(list1: OrderedLinkedList, list2: OrderedLinkedList): Boolean
}