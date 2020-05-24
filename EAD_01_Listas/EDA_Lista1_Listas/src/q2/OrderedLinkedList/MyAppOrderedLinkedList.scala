package q2.OrderedLinkedList

object MyAppOrderedLinkedList extends App {
  
  val list = new OrderedLinkedList()
  
  //inserindo na lista
  list.insert(3)
  list.insert(5)
  list.insert(2)
  list.insert(7)
  list.insert(9)
  list.insert(14)
  
  //imprimindo lista de 3 formas
  print("Imprimindo a lista: ")
  list.printList()
  println()
  print("Imprimindo Recursivamente a lista: ")
  list.printListRecursive(list.nodeHead)
  println()
  print("Imprimindo lista Reversa: ")
  list.printListReverse(list.nodeHead)
  println()
  
  //buscando elementos (retorna a posição do elemento)
  print("Posição do elemento buscado: ")
  println(list.search(7))
  
  //Removendo elemento de 2 formas
  print("Removendo um elemento da lista: ")
  list.remove(5)
  list.printList()
  println()
  print("Removendo um elemento recursivamente da lista: ")
  list.removeRecursive(7, list.nodeHead)
  list.printList()
  println()
  
  val list2 = new OrderedLinkedList()
  list2.insert(3)
  list2.insert(2)
  list2.insert(9)
  list2.insert(14)
  print("Imprimindo Lista 2: ")
  list2.printList()
  
  println()
  print("Listas são iguai? ")
  println(list.compareLists(list, list2))
}