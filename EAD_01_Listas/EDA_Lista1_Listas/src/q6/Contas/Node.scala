package q6.Contas

class Node(cont: Conta , node: Node) {
  
  var value:Int = cont.numero
  var conta = cont
  var next: Node = node
}