package q2.PRKDTree

class Node(lr: Int, d: Int, p: Node) {
  
  var point: Point = _
  var cPoint: Point = _
  var xORy: Int = -1 // 0 para x e 1 para y (indica se o discriminante eh x ou y)
  var lORr: Int = lr // 0 para left e 1 para right (indica se o no eh filho a esquerda ou a direita do pai dele)
  var dim: Int = d  // (dimensao do quadrante)
  var color: Int = 0 //0 = white, 1 = black, 2 = gray
  var left: Node = _
  var right: Node = _
  var parent: Node = p
}