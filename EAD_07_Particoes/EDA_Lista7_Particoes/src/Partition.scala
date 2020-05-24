import java.util.ArrayList


class Partition(n: Int) extends AbstractPartition {
  
  var sets: Array[Int] = _
  
  override def create(): Unit = {
    sets = new Array[Int](n+1)
  }
  
  override def makeSet(x: Int): Unit = {
    if(find(x) == 0){
      sets(x) = -1
    }
  }
  
  override def union(x: Int, y: Int): Unit = {
    var xP: Int = find(x)
    var yP: Int = find(y)
    if(numChildren(xP) >= numChildren(yP)){
      sets(yP) = xP
      var i = 1
      while(i < sets.length){
        if(sets(i) == yP){
          sets(i) == xP
        }
        i += 1
      }
    }
    else{
      sets(xP) = yP
      var i = 1
      while(i < sets.length){
        if(sets(i) == xP){
          sets(i) == yP
        }
        i += 1
      }
    }
  }
  
  override def find(x: Int): Int = {
    if(sets(x) != -1){
      return sets(x)
    }
    else{
      x
    }
  }
  
  override def isSameSet(x: Int, y: Int): Boolean = {
    if(find(x) == find(y)){
      return true
    }
    else{
      false
    }
  }
  
  override def release(): Unit = {
    sets = null
  }
  
  def numChildren(x: Int): Int = {
    var cont: Int = 0
    var i = 1
    while(i < sets.length){
      if(sets(i) == x){
        cont += 1
      }
      i += 1
    }
    cont
  }
  
  def printSets(): Unit = {
    var s: Array[Int] = null
    var sVisited: Array[Int] = new Array[Int](sets.length)
    var i = 1
    while(i < sets.length){
      var iP = find(i)
      if(!sVisited.contains(iP)){
        s = new Array[Int](numChildren(iP)+1)
        var j = 1
        var k = 0
        while(j < sets.length){
            if(iP == find(j)){
              s(k) = j
              k += 1
            }
          j += 1
        }
        print(s.mkString("[", ",", "]"))
        sVisited(i) = iP
      }
      i += 1
    }
    println()
  }
}