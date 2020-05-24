

object MyAppDynamicHashTable extends App {
  
  var ht: DynamicHashTable = new DynamicHashTable(100, 3)
  
  ht.create()
  
  ht.insert(3)
  ht.insert(6)
  ht.insert(9)
  ht.insert(22)
  ht.insert(2)
  ht.insert(4)
  ht.insert(12)
  ht.insert(33)
  ht.insert(13)
  ht.insert(10)
  ht.insert(32)
  ht.insert(11)
  ht.insert(17)
  ht.insert(18)
  
  ht.printTable()
  println()
  
  ht.remove(11)
  ht.printTable()
  println()
  
  ht.search(32)
  
  
 /* println("Buscando valor 22: " + ht.search(22))
  
  ht.remove(33)
  
  ht.printTable(ht.root)
  
  ht.release()
  
  ht.printTable(ht.root)*/
}