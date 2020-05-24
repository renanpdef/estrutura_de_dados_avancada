package q2.PRKDTree

class PRKDTree(dim: Int) extends AbstractPRKDTree{
  
  var root: Node = _
  
  //ponto central do maior quadrante em que os nos serao inseridos.
  //Se o quandrante tiver limite superior de 100 para os pontos x e y
  //então o cp sera (50,50)
  var cPoint: Point = new Point(dim/2,dim/2)
  
  override def create(): Unit = {
     root = new Node(-1,dim,null)
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
    }
  }
    
  override def search(p: Point): Node = {
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
    if(node.parent != null){
      if(node.parent.xORy == 0){
        node.xORy = 1
        var point = node.point
        node.point = null
        node.color = 2
        node.left = new Node(0, node.dim/2, node)
        node.right = new Node(1, node.dim/2, node)
        if(node.lORr == 0){
          node.left.cPoint = new Point(node.cPoint.x - node.dim/4, node.cPoint.y - node.dim/4)
          node.right.cPoint = new Point(node.cPoint.x - node.dim/4, node.cPoint.y + node.dim/4)
        }
        else{
          node.left.cPoint = new Point(node.cPoint.x + node.dim/4, node.cPoint.y - node.dim/4)
          node.right.cPoint = new Point(node.cPoint.x + node.dim/4, node.cPoint.y + node.dim/4)
        }
        var leaf = chooseLeaf(node, point)
        leaf.point = point
        leaf.color = 1
      }
      else{
        node.xORy = 0
        var point = node.point
        node.point = null
        node.color = 2
        node.left = new Node(0, node.dim, node)
        node.left.cPoint = node.cPoint
        node.right = new Node(1, node.dim, node)
        node.right.cPoint = node.cPoint
        var leaf = chooseLeaf(node, point)
        leaf.point = point
        leaf.color = 1
      }
    }
    else{
      node.xORy = 0
      var point = node.point
      node.point = null
      node.color = 2
      node.left = new Node(0, node.dim, node)
      node.left.cPoint = node.cPoint
      node.right = new Node(1, node.dim, node)
      node.right.cPoint = node.cPoint
      var leaf = chooseLeaf(node, point)
      leaf.point = point
      leaf.color = 1
    }
  }
  
  def chooseLeaf(node: Node, point: Point): Node = {
    if(node.color == 2){
      if(node.xORy == 0){
        if(point.x <= node.cPoint.x){
          chooseLeaf(node.left, point)
        }
        else{
          chooseLeaf(node.right, point)
        }
      }
      else{
        if(point.y <= node.cPoint.y){
          chooseLeaf(node.left, point)
        }
        else{
          chooseLeaf(node.right, point)
        }
      }
    }
    else{
      return node
    }
  }
  
  def printTree(): Unit = {
    print("pre-ordem: ")
    preOrdem(root)
    println()
    print("in-ordem:  ")
    inOrdem(root)
    println()
  }
  
  def preOrdem(node: Node): Unit = {
    if(node != null){
      if(node.color == 2){
        print("gray ")
      }
      else if(node.color == 0){
        print("white ")
      }
      else{
        print("(" + node.point.x + ", " + node.point.y + ")" )
      }
      preOrdem(node.left)
      preOrdem(node.right)
    }
  }
  
  def inOrdem(node: Node): Unit = {
    if(node != null){
      inOrdem(node.left)
      if(node.color == 2){
        print("gray ")
      }
      else if(node.color == 0){
        print("white ")
      }
      else{
        print("(" + node.point.x + ", " + node.point.y + ") " )
      }
      inOrdem(node.right)
    }
  }
}