

trait AbstractSet {
 
  def create(set: Array[String]): String
  
  def insert(e: String, set: Array[String]): String
  
  def remove(e: String, set: Array[String]): String
  
  def union(set: Array[String], set2: Array[String]): String
  
  def intersection(set: Array[String], set2: Array[String]): String
  
  def difference(set: Array[String], set2: Array[String]): String
  
  def isSubSet(set: Array[String], set2: Array[String]): Boolean
  
  def isEqual(set: Array[String], set2: Array[String]): Boolean
  
  def complement(set: Array[String]): String
  
  def isMember(e: String, set: Array[String]): Boolean
  
  def search(pos: Int): Array[String]
  
  def release(set: Array[String]): Unit
}