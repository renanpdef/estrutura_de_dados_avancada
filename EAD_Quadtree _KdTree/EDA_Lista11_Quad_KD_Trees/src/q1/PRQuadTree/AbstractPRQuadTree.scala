package q1.PRQuadTree

trait AbstractPRQuadTree {
  
  def create(): Unit
  
  def insert(p: Point): Unit
  
  def remove(p: Point): Unit
  
  def search(p: Point): Node
  
}