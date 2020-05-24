

object MyAppPartition extends App {
  
  //Instanciando a particao com o maior valor que podera ser inserido no conjunto
  var p: Partition = new Partition(100)
  
  //criando a estrutura de dados
  p.create()
  
  //criando os conjuntos
  p.makeSet(2)
  p.makeSet(7)
  p.makeSet(4)
  p.makeSet(9)
  p.makeSet(3)
  p.makeSet(6)
  p.makeSet(5)
  
  p.printSets()
  
  
  p.union(2, 4)
  
  p.printSets()
  
  p.union(4, 6)
  p.union(5, 9)
  
  p.printSets()
  
  println("Encontando o 6: "+p.find(6))
  
  println("O 9 e o 3 estao no mesmo conjunto? "+p.isSameSet(9, 3))
  println("O 6 e o 2 estao no mesmo conjunto? "+p.isSameSet(6, 2))
  
  
}