package q2.OrderedLinkedList

class OrderedLinkedList extends AbstractOrderedLinkedList {
  
  var nodeHead: Node = _
  
  override def createEmptyList(): Unit = {
    nodeHead = null
  }
  
  override def insert(value: Int): Unit = {
    if(isEmpty()==0){
      if(value < nodeHead.value){
        var node = new Node(nodeHead.value, nodeHead.next)
        nodeHead.value = value
        nodeHead.next = node
      }
      else{
        var node = nodeHead
        while(node.next!=null && value>node.next.value){
          node = node.next 
        }
        var newNode = new Node(value, node.next)
        node.next = newNode
      }
    }
    else{
      nodeHead = new Node(value, null);
    }
  }
  
  override def printList(): Unit = {
    if(isEmpty()==0){
      print(nodeHead.value + " ")
      if(nodeHead.next != null){
        var node = new Node(nodeHead.value, nodeHead.next)
        while(node.next != null){
          print(node.next.value + " ")
          node = node.next
        }
      }
    }
  }
  
  override def printListRecursive(node: Node): Unit = {
    if(node != null){
      print(node.value + " ")
      printListRecursive(node.next)
    }
  }
  
  override def printListReverse(node: Node): Unit = {
    if(node.next != null){
      printListReverse(node.next)
    }
    print(node.value + " ")
  }
  
  override def isEmpty(): Int = {
    if(nodeHead == null){
      1
    }
    else{
      0
    }
  }
  
  override def search(value: Int): Int = {
    var pos: Int = 0
    if(isEmpty()==0){
      pos+=1
      if(nodeHead.value == value){
        return pos
      }
      if(nodeHead.next != null){
        var node = new Node(nodeHead.value, nodeHead.next)
        while(node.next != null){
          pos+=1
          if(node.next.value == value){
            return pos
          }
          node = node.next
        }
      }
    }
    0
  }
  
  override def remove(value: Int): Unit = {
    if(isEmpty()==0){
     if(value == nodeHead.value){
       nodeHead = nodeHead.next
     }
     else{
       var node = nodeHead
       while(node.next != null && node.next.value != value){
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
  
  override def removeRecursive(value: Int, node: Node): Unit = {
    if(node != null){
      if(value == nodeHead.value){
         nodeHead = nodeHead.next
       }
      else{
        if(node.next != null && value == node.next.value){
          var node2 = node.next
          node.next = node.next.next
          node2 = null
        }
        else{
          removeRecursive(value, node.next)
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