package q4.CircularLinkedList

class CircularLinkedList extends AbstractCircularLinkedList{
  
  var nodeHead: Node = _
  var nodeTail: Node = _
  
  override def createEmptyList(): Unit = {
    nodeHead = null
  }
  
  override def insert(value: Int): Unit = {
    if(isEmpty()==0){
      if(nodeHead.next == nodeHead){
        var node = new Node(nodeHead.value, nodeHead.next)
        nodeHead.value = value
        nodeHead.next = node
        nodeTail = node
      }
      else{
        var node = new Node(nodeHead.value, nodeHead.next)
        nodeHead.value = value
        nodeHead.next = node
      }
    }
    else{
      nodeHead = new Node(value, null)
      nodeHead.next = nodeHead
      nodeTail = nodeHead

    }
  }
  
  override def printList(): Unit = {
    if(isEmpty()==0){
      print(nodeHead.value + " ")
      if(nodeHead.next != nodeHead){
        var node = new Node(nodeHead.value, nodeHead.next)
        while(node.next != nodeHead){
          print(node.next.value + " ")
          node = node.next
        }
      }
    }
  }
  
  override def printListRecursive(node: Node): Unit = {
    if(node.next != nodeHead ){
      print(node.value + " ")
      printListRecursive(node.next)
    }
    else{
      print(node.value + " ")
    }
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
      if(nodeHead.next != nodeHead){
        var node = new Node(nodeHead.value, nodeHead.next)
        while(node.next != nodeHead){
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
       nodeTail.next = nodeHead
     }
     else{
       var node = nodeHead
       while(node.next != nodeHead && node.next.value != value){
         node = node.next
       }
       if(node.next != nodeHead){
         if(node.next == nodeTail){
           var node2 = node.next
           node.next = node.next.next
           node2 = null
           nodeTail = node
         }
         else{
           var node2 = node.next
           node.next = node.next.next
           node2 = null
         }
       }
      }
    }
  }
  
  override def removeRecursive(value: Int, node: Node): Unit = {
    if(node != null){
      if(value == nodeHead.value){
         nodeHead = nodeHead.next
         nodeTail.next = nodeHead
       }
      else{
        if(node.next != nodeHead && value == node.next.value){
          if(node.next == nodeTail){
           var node2 = node.next
           node.next = node.next.next
           node2 = null
           nodeTail = node
         }
         else{
           var node2 = node.next
           node.next = node.next.next
           node2 = null
         }
        }
        else{
          removeRecursive(value, node.next)
        }
      }
    }
  }
}