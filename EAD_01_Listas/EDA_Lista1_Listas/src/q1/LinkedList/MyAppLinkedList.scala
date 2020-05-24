package q1.LinkedList

object MyAppList extends App {
  
  val list = new LinkedList()
  
  //inserindo na lista
  list.insertBeginning(3)
  list.insertBeginning(5)
  list.insertBeginning(2)
  list.insertBeginning(7)
  list.insertBeginning(9)
  list.insertBeginning(14)
  
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

}