package q4.CircularLinkedList

object MyAppCircularLinkedList extends App {
  
  val list = new CircularLinkedList()
  
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
  
  //buscando elementos (retorna a posição do elemento)
  print("Posição do elemento buscado: ")
  println(list.search(7))
  
  //Removendo elemento de 2 formas
  print("Removendo um elemento da lista: ")
  list.remove(3)
  list.printList()
  println()
  print("Removendo um elemento recursivamente da lista: ")
  list.removeRecursive(14, list.nodeHead)
  list.printList()
  println()
}