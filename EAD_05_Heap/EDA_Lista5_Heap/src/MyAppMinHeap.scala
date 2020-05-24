

object MyAppMinHeap extends App {
  
  var heap: MinHeap = new MinHeap(100)
  
  heap.create()
  
  heap.insert(7)
  heap.insert(9)
  heap.insert(12)
  heap.insert(8)
  heap.insert(4)
  heap.insert(56)
  heap.insert(43)
  heap.insert(99)
  heap.insert(2)
  heap.insert(15)
  
  heap.printTree()
  
  println(heap.search(43))
  
  heap.remove(8)
  
  heap.printTree()
  
  heap.changeValue(99, 1)
  
  heap.printTree()
  
  heap.changeValue(12, 84)
  
  heap.printTree()
  
  heap.release()
  
  heap.printTree()
  
  heap.insert(11)
  heap.insert(33)
  heap.insert(79)
  heap.insert(6)
  heap.insert(16)  
  
  heap.printTree()
}
