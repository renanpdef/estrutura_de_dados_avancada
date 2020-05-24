

trait AbstractMinHeap {
  
  def create(): Unit
  
  def insert(k: Int): Unit
  
  def search(k: Int): Int
  
  def remove(k: Int): Unit
  
  def changeValue(oldK: Int, newK: Int ): Unit
  
  def release(): Unit
}