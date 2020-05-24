

class Set(n: Int, elements: Array[String]) extends AbstractSet{
  
  var sets: Array[String] = new Array[String](math.pow(2, n+1).toInt)
  var last: Int = 0
  
  //retorna uma string de binarios referente ao conjunto informado
  def binSet(set: Array[String]): String = {
    var array: Array[Int] = new Array[Int](n)
    var i = 0
    var j = 0
    if (!set.isEmpty){
      while(j < set.length){
        while(i < n){
          if(elements(i) == set(j)){
            array(i) = 1
          }
          i += 1
        }
        i = 0
        j += 1
      }
    }
    array.mkString
  }
  
  override def create(set: Array[String]): String = {
    sets(last) = binSet(set)
    last += 1
    sets(last-1)
  }
  
  override def insert(e: String, set: Array[String]): String = {
    if(set == null){
      return null
    }
    var newSet: Array[String] = new Array[String](set.length+1)
    var i = 0
    while(i < set.length){
      newSet(i) = set(i)
      i += 1
    }
    newSet(i) = e
    sets.update(sets.indexOf(binSet(set)), binSet(newSet))
    binSet(newSet)
  }
  
  override def remove(e: String, set: Array[String]): String = {
    if(set == null){
      return null
    }
    var newSet: Array[String] = new Array[String](set.length-1)
    var i = 0
    var j = 0
    while(i < newSet.length && j < set.length){
      if(set(j) != e){
        newSet(i) = set(j)
        i += 1
        j += 1
      }
      else{
        j += 1
      }
    }
    sets.update(sets.indexOf(binSet(set)), binSet(newSet))
    binSet(newSet)
  }
  
  override def union(set: Array[String], set2: Array[String]): String = {
    if(set == null || set2 == null){
      return null
    }
    var bSet: String = binSet(set)
    var bSet2: String = binSet(set2)
    var newBSet: String = ""
    var i = 0
    while(i < n){
      if(bSet(i) =='1' || bSet2(i) == '1'){
        newBSet += "1"
      }
      else{
        newBSet += "0"
      }
      i += 1
    }
    sets.update(last, newBSet)
    last += 1
    newBSet
  }
  
  override def intersection(set: Array[String], set2: Array[String]): String = {
    if(set == null || set2 == null){
      return null
    }
    var bSet: String = binSet(set)
    var bSet2: String = binSet(set2)
    var newBSet: String = ""
    var i = 0
    while(i < n){
      if(bSet(i) =='1' && bSet2(i) =='1'){
        newBSet += "1"
      }
      else{
        newBSet += "0"
      }
      i += 1
    }
    sets.update(last, newBSet)
    last += 1
    newBSet
  }
  
  override def difference(set: Array[String], set2: Array[String]): String = {
    if(set == null || set2 == null){
      return null
    }
    var bSet: String = binSet(set)
    var bSet2: String = binSet(set2)
    var newBSet: String = ""
    var i = 0
    while(i < n){
      if(bSet(i) == '1' && bSet2(i) == '0'){
        newBSet += "1"
      }
      else{
        newBSet += "0"
      }
      i += 1
    }
    sets.update(last, newBSet)
    last += 1
    newBSet
  }
  
  override def isSubSet(set: Array[String], set2: Array[String]): Boolean = {
    if(set == null || set2 == null){
      return true
    }
    var bSet: String = binSet(set)
    var bSet2: String = binSet(set2)
    var i = 0
    while(i < n){
      if(bSet(i) == '1' && bSet2(i) == '0'){
        return false
      }
      i += 1
    }
    true
  }
  
  override def isEqual(set: Array[String], set2: Array[String]): Boolean = {
    if(set == null || set2 == null){
      return true
    }
    var bSet: String = binSet(set)
    var bSet2: String = binSet(set2)
    var i = 0
    while(i < n){
      if(bSet(i) != bSet2(i)){
        return false
      }
      i += 1
    }
    true
  }
  
  override def complement(set: Array[String]): String = {
    if(set == null){
      return null
    }
    var bSet: String = binSet(set)
    var newBSet: String = ""
    var i = 0
    while(i < n){
      if(bSet(i) == '1'){
        newBSet += "0"
      }
      else{
        newBSet += "1"
      }
      i += 1
    }
    sets.update(last, newBSet)
    last += 1
    newBSet
  }
  
  override def isMember(e: String, set: Array[String]): Boolean = {
    if(set == null){
      return false
    }
    binSet(set)(elements.indexOf(e)) == '1'
  }
  
  override def search(pos: Int): Array[String] = {
    if(sets(pos-1) == null){
      return null
    }
    var binStr = sets(pos-1)
    var str = ""
    var i = 0
    while(i < n){
      if(binStr(i) == '1'){
        str += elements(i) + ":"
      }
      i += 1
    }
    var array: Array[String] = str.split(":")
    array
  }
  
  override def release(set: Array[String]): Unit = {
    while(sets.indexOf(binSet(set)) != -1){
      sets.update(sets.indexOf(binSet(set)), null)
    }
  }
  
  def printSets(): Unit = {
    var i = 0
    while(i < sets.length){
      if(sets(i) != null){
        print("[(" + (i+1) + ") "+sets(i)+"] ")
      }
      i += 1
    }
    println()
  }
}