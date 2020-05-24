

trait AbstractDynamicHashTable {
  
  def create(): Unit  
  
  def insert(k: Int): Unit
   
  def search(k: Int): Unit
   
  def remove(k: Int): Unit
   
  def release(): Unit
}