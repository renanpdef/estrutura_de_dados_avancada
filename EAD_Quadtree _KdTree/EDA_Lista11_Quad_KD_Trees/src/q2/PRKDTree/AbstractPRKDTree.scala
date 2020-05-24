package q2.PRKDTree

trait AbstractPRKDTree {
  
  def create(): Unit
  
  def insert(p: Point): Unit
  
  def remove(p: Point): Unit
  
  def search(p: Point): Node
}