package q2.PRKDTree

object MyAppPRKDTree extends App {
  
  //Setando o objeto com o tamanho da dimensao (limite maximo de x e y)
  //Sendo 100, temos que o ponto central da area sera (50,50)
  var t: PRKDTree = new PRKDTree(100)
  
  //criando a arvore vazia
  t.create()
  
  //criando os pontos
  var pA: Point = new Point(35, 42)
  var pB: Point = new Point(62, 77)
  var pC: Point = new Point(52, 10)
  var pD: Point = new Point(82, 65)
  var pE: Point = new Point(5, 45)
  
  //inserindo os pontos
  t.insert(pA)
  t.insert(pB)
  t.insert(pC)
  t.insert(pD)
  t.insert(pE)
  
  //buscando o no pD
  println("Buscando o no (82,65) e apreentando seu irmao")
  var nodePD = t.search(pD)
  println("ponto do PD: (" + nodePD.point.x + ", " + nodePD.point.y + ")" )
  println("Irmao do PD: (" + nodePD.parent.left.point.x + ", " + nodePD.parent.left.point.y + ")")
  
  println()
  t.printTree()
  
  println()
  t.remove(pE)
  
  println("Apos a remocao do (5,45) ")
  t.printTree()
}