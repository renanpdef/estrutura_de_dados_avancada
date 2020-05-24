package q5.CircularDoublyLinkedList

class Node(int: Int, nodeNext: Node, nodePrev: Node) {
  
  var value:Int = int
  var next: Node = nodeNext    
  var prev: Node = nodePrev
}