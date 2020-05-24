package q1.PRQuadTree

class Node() {
  
  var point: Point = _
  var cPoint: Point = _
  var dim: Int = 0
  var color: Int = 0 //0 = white, 1 = black, 2 = gray
  var child: Array[Node] = new Array[Node](4) // child(0) = nw, child(1) = ne, child(2) = sw, child(3) = se  
  var parent: Node = _
}