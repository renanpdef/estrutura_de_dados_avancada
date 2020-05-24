

object MyAppSet extends App {
  
  //Informe o número de elementos e um vetor de strings com esses elementos
  var set: Set = new Set(4, Array("a","b","c","d"))
  
  set.create(Array("a"))
  set.create(Array("c"))
  set.create(Array("a", "b"))
  set.create(Array())
  
  set.printSets()
  
  println("Buscando Conjunto 3: "+set.search(3).mkString("[", ",", "]"))
  
  println("Inserindo d no Conjunto 4: "+set.insert("d", set.search(4)))
  
  println("Removando a do Conjunto 3: "+set.remove("a", set.search(3)))
  
  println("Uniao do Conjunto 2 com 3: "+set.union(set.search(2), set.search(3)))
  
  println("Intersecao do Conjunto 5 com 2: "+set.intersection(set.search(5), set.search(2)))
  
  println("Diferenca do Conjunto 5 com 2: "+set.difference(set.search(5), set.search(2)))
  
  println("O Conjunto 2 esta contido no 5? "+set.isSubSet(set.search(2), set.search(5)))
  
  println("Os Conjuntos 2 e 5 sao iguais? "+set.isEqual(set.search(2), set.search(5)))
  
  println("O Complemento do Conjunto 5: "+set.complement(set.search(5)))
  
  println("d Pertence ao Conjunto 4? : "+set.isMember("d", set.search(4)))
  
  set.printSets()
  
  println("Eliminando a estrutura de um determinado conjunto (Todas as ocorrencias serao eliminadas)")
  set.release(set.search(6))
  
  set.printSets()
  
}