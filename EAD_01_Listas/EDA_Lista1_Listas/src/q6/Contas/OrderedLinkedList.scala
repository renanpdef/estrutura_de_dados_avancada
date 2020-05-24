package q6.Contas

class OrderedLinkedList extends AbstractOrderedLinkedList{
  
  var nodeHead: Node = _
  
  override def createEmptyList(): Unit = {
    nodeHead = null
  }
  
  override def insert(conta: Conta): Unit = {
    if(isEmpty()==0){
      if(conta.numero < nodeHead.value){
        var node = new Node(nodeHead.conta, nodeHead.next)
        nodeHead.value = conta.numero
        nodeHead.conta = conta
        nodeHead.next = node
      }
      else{
        var node = nodeHead
        while(node.next!=null && conta.numero>node.next.value){
          node = node.next 
        }
        var newNode = new Node(conta, node.next)
        node.next = newNode
      }
    }
    else{
      nodeHead = new Node(conta, null);
    }
  }
  
  override def printList(): Unit = {
    if(isEmpty()==0){
      println("Conta: "+nodeHead.value +" Saldo: R$"+ nodeHead.conta.saldo + " ")
      if(nodeHead.next != null){
        var node = new Node(nodeHead.conta, nodeHead.next)
        while(node.next != null){
          println("Conta: "+node.next.value +" Saldo: R$"+ node.next.conta.saldo + " ")
          node = node.next
        }
      }
    }
  }
  
  override def printListRecursive(node: Node): Unit = {
    if(node != null){
      println("Conta: "+node.value +" Saldo: R$"+ node.conta.saldo + " ")
      printListRecursive(node.next)
    }
  }
  
  override def printListReverse(node: Node): Unit = {
    if(node.next != null){
      printListReverse(node.next)
    }
    println("Conta: "+node.value +" Saldo: R$"+ node.conta.saldo + " ")
  }
  
  override def isEmpty(): Int = {
    if(nodeHead == null){
      1
    }
    else{
      0
    }
  }
  
  override def search(num: Int): Conta = {
    var pos: Int = 0
    if(isEmpty()==0){
      pos+=1
      if(nodeHead.value == num){
        return nodeHead.conta
      }
      if(nodeHead.next != null){
        var node = new Node(nodeHead.conta, nodeHead.next)
        while(node.next != null){
          pos+=1
          if(node.next.value == num){
            return node.next.conta
          }
          node = node.next
        }
      }
    }
    null
  }
  
  override def remove(conta: Conta): Unit = {
    if(isEmpty()==0){
     if(conta.numero == nodeHead.value){
       nodeHead = nodeHead.next
     }
     else{
       var node = nodeHead
       while(node.next != null && node.next.value != conta.numero){
         node = node.next
       }
       if(node.next != null){
         var node2 = node.next
         node.next = node.next.next
         node2 = null
       }
      }
    }
  }
  
  override def removeRecursive(conta: Conta, node: Node): Unit = {
    if(node != null){
      if(conta.numero == nodeHead.value){
         nodeHead = nodeHead.next
       }
      else{
        if(node.next != null && conta.numero == node.next.value){
          var node2 = node.next
          node.next = node.next.next
          node2 = null
        }
        else{
          removeRecursive(conta, node.next)
        }
      }
    }
  }
  
  override def compareLists(list1: OrderedLinkedList, list2: OrderedLinkedList): Boolean = {
    var node1 = list1.nodeHead
    var node2 = list2.nodeHead
    while(node1 != null || node2 != null){
      if(node1.value != node2.value){
        return false
      }
      node1 = node1.next
      node2 = node2.next
    }
    true
  }
}