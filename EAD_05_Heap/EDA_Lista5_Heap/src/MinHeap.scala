

class MinHeap(n: Int) extends AbstractMinHeap {
  
  var heapTree: Array[Int] = _
  var last: Int = 0
  
  override def create(): Unit = {
    heapTree = new Array[Int](n+1)
  }
  
  
  override def insert(k: Int): Unit = {
    var i: Int = last
    heapTree(i+1) = k
    last += 1
    bubbleUp(last)
  }
  
  override def search(k: Int): Int = {
    var pos: Int = 1
    recursiveSearch(k, pos)
  }
  
  override def remove(k: Int): Unit = {
    var pos: Int = search(k)
    heapTree(pos) = heapTree(last)
    heapTree(last) = 0
    last -= 1
    bubbleDown(pos)
  }
  
  override def changeValue(oldK: Int, newK: Int): Unit = {
    var pos: Int = search(oldK)
    heapTree.update(pos, newK)
    bubbleUp(pos)
    bubbleDown(pos)
  }
  
  override def release(): Unit = {
    var i: Int = 1
    while(i <= last){
      heapTree(i) = 0
      i += 1
    }
    last = 0
  }
  
  def bubbleUp(pos: Int): Unit = {
    var i: Int = pos
    while(heapTree(i) < heapTree(i/2)){
      var value: Int = heapTree(i/2)
      heapTree(i/2) = heapTree(i)
      heapTree(i) = value
      i = i/2
    }
  }
  
  def bubbleDown(pos: Int): Unit = {
    var i: Int = pos
    while(2*i <= last && (heapTree(i) > heapTree(2*i) || heapTree(i) > heapTree(2*i+1))){
      if(heapTree(2*i) <= heapTree(2*i+1)){
        var value: Int = heapTree(i)
        heapTree(i) = heapTree(2*i)
        heapTree(2*i) = value
        i = 2*i
      }
      else{
        var value: Int = heapTree(i)
        heapTree(i) = heapTree(2*i+1)
        heapTree(2*i+1) = value
        i = 2*i+1
      }
    }
  }
  
  def recursiveSearch(k: Int, pos: Int): Int = {
    if(pos <= last){
      if(heapTree(pos) == k){
        return pos
      }
      else if(heapTree(pos) < k){
        return recursiveSearch(k, pos*2) + recursiveSearch(k, pos*2+1)
      }
      else{
        0
      }
    }
    0
  }
  
  def printTree(): Unit = {
    var i: Int = 1
    while(i <= last){
      print(heapTree(i) + " ")
      i += 1
    }
    println()
  }
}