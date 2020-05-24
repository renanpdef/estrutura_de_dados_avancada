

class HashTable(n: Int) extends AbstractHashTable{
  
  val size = n/2
  var table: Array[Node] = new Array[Node](size)
  
  def hashFunction(k: Int): Int = {
    val h: Int = k % size
    return h
  }
  
  override def insert(k: Int): Unit = {
    var node: Node = new Node(k)
    if(table(hashFunction(k)) == null){
      table(hashFunction(k)) = node
    }
    else{
      node.next = table(hashFunction(k))
      table(hashFunction(k)) = node
    }
  }
 
  override def search(k: Int): Int = {
    if(table(hashFunction(k)) == null)  {
      return 0
    }
    else if(table(hashFunction(k)).value == k){
      return hashFunction(k)
    }
    else{
      var node = table(hashFunction(k))
      while(node.next != null){
        node = node.next
        if(node.value == k){
          return hashFunction(k)
        }
      }
      return 0
    }
  }

  override def remove(k: Int): Unit = {
    if(table(hashFunction(k)) != null){
      if(table(hashFunction(k)).value == k){
        table(hashFunction(k)) = table(hashFunction(k)).next
      }
      else{
        var node = table(hashFunction(k))
        var flagRemove: Int = 0
        while(node.next != null && flagRemove == 0){
          if(node.next.value == k){
            node.next = node.next.next
            flagRemove = 1
          }
          if(node.next != null){
            node = node.next
          }
        }
      }
    }
  }
  
  override def release(): Unit = {
    var i: Int = 0
    while(i < size){
      table(i) = null
      i += 1
    }
  }
  
  def printTable(): Unit = {
    var i: Int = 0
    while(i < size){
      var node = table(i)
      while(node != null){
        print(node.value + " ")
        node = node.next
      }
      println()
      i += 1
    }
  }
}