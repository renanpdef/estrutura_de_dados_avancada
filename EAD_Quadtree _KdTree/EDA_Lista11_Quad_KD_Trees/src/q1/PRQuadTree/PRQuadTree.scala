package q1.PRQuadTree

class PRQuadTree(dim: Int) extends AbstractPRQuadTree {
  
  var root: Node = _
  
  //ponto central do maior quadrante em que os nos serao inseridos.
  //Se o quandrante tiver limite superior de 100 para os pontos x e y
  //então o cp sera (50,50)
  var cPoint: Point = new Point(dim/2,dim/2)
  
  override def create(): Unit = {
    root = new Node()
    root.cPoint = cPoint
    root.dim = dim
  }
  
  override def insert(p: Point): Unit = {
    insertRecursive(root, p)
  }
  
  override def remove(p: Point): Unit = {
    var node = search(p)
    if(node != null){
      node.point = null
      node.color = 0
      if(node.parent != null){
        var nBlackChild = 0
        var nGrayChild = 0
        var blackNode: Node = null
        for(i<-0 to node.parent.child.size-1){
          if(node.parent.child(i).color == 1){
            nBlackChild += 1
            blackNode = node.parent.child(i)
          }
          if(node.parent.child(i).color == 2){
            nGrayChild += 1
          }
        }
        if(nBlackChild < 2 && nGrayChild < 1){
          blackNode.parent.point = blackNode.point
          blackNode.parent.color = 1
          for(j<-0 to blackNode.parent.child.size-1){
            blackNode.parent.child(j) = null
          }
        }
      }
    }
  }
  
  override def search(p:Point): Node = {
    if(root.color == 0){
      return null
    }
    else if(root.color == 1){
      if(root.point == p){
        return root
      }
      else{
        return null
      }
    }
    else{
      var node = chooseLeaf(root, p)
      if(node.point == p){
        return node
      }
      else{
        return null
      }
    }
  }
  
  def insertRecursive(node: Node, point: Point): Unit = {
    if(node.color == 1){
      split(node)
      var nextNode = chooseLeaf(node, point)
      insertRecursive(nextNode, point)
    }
    else if(node.color == 0){
      node.point = point
      node.color = 1
    }
    else{
      var nextNode = chooseLeaf(node, point)
      insertRecursive(nextNode, point)
    }
  }
  
  def split(node: Node): Unit = {
    for(i<-0 to node.child.size-1){
      var cp: Point = new Point(-1,-1)
      node.child(i) = new Node()
      node.child(i).parent = node
      if(i == 0){
        cp.x = node.cPoint.x - (node.dim) / 4
        cp.y = node.cPoint.y + (node.dim) / 4
      }
      if(i == 1){
        cp.x = node.cPoint.x + (node.dim) / 4
        cp.y = node.cPoint.y + (node.dim) / 4
      }
      if(i == 2){
        cp.x = node.cPoint.x - (node.dim) / 4
        cp.y = node.cPoint.y - (node.dim) / 4
      }
      if(i == 3){
        cp.x = node.cPoint.x + (node.dim) / 4
        cp.y = node.cPoint.y - (node.dim) / 4
      }
      node.child(i).cPoint = cp
      node.child(i).dim = node.dim / 2
    }
    var point = node.point
    node.point = null
    node.color = 2
    var leaf = chooseLeaf(node, point)
    leaf.point = point
    leaf.color = 1
  }
  
  def chooseLeaf(node: Node, point: Point): Node = {
    if(node.color == 2){
      if(point.x <= node.cPoint.x && point.y >= node.cPoint.y){
        chooseLeaf(node.child(0), point)
      }
      else if(point.x > node.cPoint.x && point.y >= node.cPoint.y){
        chooseLeaf(node.child(1), point)
      }
      else if(point.x <= node.cPoint.x && point.y < node.cPoint.y){
        chooseLeaf(node.child(2), point)
      }
      else{
        chooseLeaf(node.child(3), point)
      }
    }
    else{
      return node
    }
  }
}