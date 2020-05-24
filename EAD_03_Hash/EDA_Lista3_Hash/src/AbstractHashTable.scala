

trait AbstractHashTable {
  
   def insert(k: Int): Unit
   
   def search(k: Int): Int
   
   def remove(k: Int): Unit
   
   def release(): Unit
}