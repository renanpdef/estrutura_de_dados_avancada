

trait AbstractPartition {
  
  def create(): Unit
  
  def makeSet(x: Int): Unit
  
  def union(x: Int, y: Int): Unit
  
  def find(x: Int): Int
  
  def isSameSet(x: Int, y: Int): Boolean
  
  def release(): Unit
}