

class DynamicHashTable(n: Int, size: Int) extends AbstractDynamicHashTable{
  
  var root: Node = _
  
  def hashFunction(k: Int): Int = {
    val h: Int = k % n
    return h
  }
  
  def structureTree(node: Node){
    if(node.bucket != null){
      var nodeLeft: Node = new Node()
      var nodeRight: Node = new Node()
      node.bucket.numReferencia += 1
      nodeLeft.bucket = node.bucket
      nodeRight.bucket = node.bucket
      node.bucket = null
      node.left = nodeLeft
      node.right = nodeRight
    }
    else{
      structureTree(node.left)
      structureTree(node.right)
    }
  }
  
  def splitBucket(hashK: String){
    var node: Node = root
    var newHk: String = hashK
    var prefix: String = ""
    while(node.bucket == null){
      if(newHk.last == '0'){
        node = node.left
      }
      else{
        node = node.right
      }
      prefix += newHk.last
      newHk = newHk.init
    }
    prefix = prefix.reverse  
    var newBucket = new Bucket(node.bucket.array.length)
    newBucket.numReferencia = 1
    var i: Int = 0
    while(i < newBucket.array.length){
      if(node.bucket.array(i) != null && node.bucket.array(i).contains(prefix)){
        newBucket.array(i) = node.bucket.array(i)
        node.bucket.array(i) = null
      }
      i += 1
    }
    var j:Int = 0
    while(j < newBucket.array.length && newBucket.array(j) != null){
      j += 1
    }
    if(j < newBucket.array.length){
      newBucket.array(j) = hashK
      node.bucket.numReferencia -= 1
      node.bucket = newBucket
    }
    else{
      var BucketOverflow = new Bucket(newBucket.array.length*2)
      var k: Int = 0
      while(k < newBucket.array.length){
        BucketOverflow.array(k) = newBucket.array(k)
        k += 1
      }
      BucketOverflow.array(k) = hashK
      node.bucket.numReferencia -= 1
      node.bucket = BucketOverflow
    }
  }
  
  override def create(): Unit = {
    var bucket: Bucket = new Bucket(size)
    bucket.numReferencia += 1
    root = new Node()
    root.bucket = bucket
    
  }
  
  override def insert(k: Int): Unit = {
    var hashK: String = hashFunction(k).toBinaryString
      var node: Node = root
      var newHk: String = hashK
      while(node.bucket == null){
        if(newHk.last == '0'){
          node = node.left
        }
        else{
          node = node.right
        }
        newHk = newHk.init
      }
      var i = 0
      while(i < node.bucket.array.length && node.bucket.array(i) != null){
        i += 1
      }
      if(i < node.bucket.array.length){
        node.bucket.array(i) = hashK
      }
      else{
        if(node.bucket.numReferencia > 1){
          splitBucket(hashK)
        }
        else{
          structureTree(root)
          insert(k)
        }
      }
  }
 
  override def search(k: Int): Unit = {
    var hashK: String = hashFunction(k).toBinaryString
    var storeCode: Array[Int] = new Array[Int](n)
    var pos: Int = 0
    var str: String = ""
    
    str = recursivePrintTable(root, storeCode, pos, str)
    if(str.contains(hashK)){
      var arrayStr: Array[String] = str.split(" | ")
      var posStr: Int = arrayStr.indexOf(hashK)
      var strHelp = "(" + arrayStr(posStr) + ")"
      arrayStr(posStr) = strHelp
      println(arrayStr.mkString)
    }
  }

  override def remove(k: Int): Unit = {
    var hashK: String = hashFunction(k).toBinaryString
    var node: Node = root
    var newHk: String = hashK
    while(node.bucket == null){
      if(newHk.last == '0'){
        node = node.left
      }
      else{
        node = node.right
      }
      newHk = newHk.init
    }
    var i: Int = 0
    while(i < node.bucket.array.length){
      if(node.bucket.array(i) == hashK){
        node.bucket.array(i) = null
      }
      i += 1
    }
    if(node.bucket.array.isEmpty){
      node.bucket = null
    }
  }
  
  override def release(): Unit = {
    root = null
  }
  
  def printTable(): Unit = {
    var storeCode: Array[Int] = new Array[Int](n)
    var pos: Int = 0
    var str: String = ""
    str = recursivePrintTable(root, storeCode, pos, str)
    println(str)
    
  }
  
  def recursivePrintTable(node: Node, storeCode: Array[Int], p: Int, s: String): String = {
    var pos: Int = p
    var str: String = s
    if(node.bucket != null){
      if(!storeCode.contains(node.bucket.hashCode())){
        storeCode(pos) = node.bucket.hashCode()
        //println(node.bucket.array.mkString(" | "))
        pos += 1
        str += node.bucket.array.mkString(" | ")
     } 
     str
    }
    else{
      recursivePrintTable(node.left, storeCode, pos, str) + " | \n" + recursivePrintTable(node.right, storeCode, pos, str)
    }
  }
   
}