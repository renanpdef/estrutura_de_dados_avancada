package q1.PRQuadTree

object MyAppPRQuadTree extends App {
  
  //Setando o objeto com o tamanho da dimensao (limite maximo de x e y)
  //Sendo 100, temos que o ponto central da area sera (50,50)
  var t: PRQuadTree = new PRQuadTree(100)
  
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
  
  //buscando o no pA
  var nodePA = t.search(pA)
  
  //imprimindo o no pA e todos os seus 4 irmaos
  //NOTA: A ORDEM DE IMPRESSAO E NW, NE, SW, SE
  print("pA e seus irmaos: ")
  for(i<-0 to 3){
    if(nodePA.parent.child(i).point != null){
      print("(" + nodePA.parent.child(i).point.x + ", " + nodePA.parent.child(i).point.y + ") ")
    }
    else{
      if(nodePA.parent.child(i).color == 0){
        print("white ")
      }else{
        print("gray ")
      }
    }
  }
  println()
  
  //buscando no pD
  print("pD e seus irmaos: ")
  var nodePD = t.search(pD)
  for(i<-0 to 3){
    if(nodePD.parent.child(i).point != null){
      print("(" + nodePD.parent.child(i).point.x + ", " + nodePD.parent.child(i).point.y + ") ")
    }
    else{
      if(nodePD.parent.child(i).color == 0){
        print("white ")
      }else{
        print("gray ")
      }
    }
  }
  println()
  
  //removendo o pB
  t.remove(pB)
  
  //buscando pD novamente e imprimindo ele e seus irmaos
  print("pA e seus irmaos depois da remocao do pB: ")
  var nodePD2 = t.search(pD)
  for(i<-0 to 3){
    if(nodePD2.parent.child(i).point != null){
      print("(" + nodePD2.parent.child(i).point.x + ", " + nodePD2.parent.child(i).point.y + ") ")
    }
    else{
      if(nodePD2.parent.child(i).color == 0){
        print("white ")
      }else{
        print("gray ")
      }
    }
  }
}