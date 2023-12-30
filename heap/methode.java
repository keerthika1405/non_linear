 class methode {

    private int[] Heap;
    private int size;
    private int maxsize;

     public methode(int maxsize)
    {
        // This keyword refers to current instance itself
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }

    public void insert(int element)  // Method 7 Inserts a new element to max heap
    {
        // System.out.println("s1 "+size);
        //  System.out.println("element "+element);
        Heap[size] = element;
 
        // Traverse up and fix violated property
        int current = size;
        // System.out.println("current"+current);
        //  System.out.println("parent(c) "+parent(current));
          System.out.println("heap "+Heap[current]);
        while (Heap[current] > Heap[parent(current)]) {
            // System.out.println("inside current"+current);
            // System.out.println("inside parent(c) "+parent(current));
            swap(current, parent(current));
            current = parent(current);
             System.out.println("heap1 "+Heap[current]);
        }
        size++;
    }
     private int parent(int pos)     // Method 1 Returning position of parent
    { 
        
         return (pos - 1) / 2; 
    }
 
    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity
   
 
   
    
    private int leftChild(int pos) // Method 2 Returning left children
    {
         return (2 * pos) + 1; 
    }

    private int rightChild(int pos)// Method 3 Returning right children
    {
        return (2 * pos) + 2;
    }


 
    private boolean isLeaf(int pos)  // Method 4 Returning true if given node is leaf
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
 
    // Method 5 Swapping nodes
    private void swap(int fpos, int spos)
    {
        
        int tmp;
        tmp = Heap[fpos];                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
        
    }
 
   
 
    // Method 9 Remove an element from max heap
    public int extractMax()
    {

        for(int i=0;i<size;i++){
            System.out.print(Heap[i]+" ");
        }
        int popped = Heap[0];
        Heap[0] = Heap[--size];
        maxHeapify(0);
        return popped;
    }
    /*
Store the value of the first node of our heap ( temp = heap[0] ).
Replace the root node with the farthest right node (last element).
Decrease the size by 1. (heap[0] = heap[size-1])
Perform heapify starting from the new root.
Return the stored value.(temp)
 */

     private void maxHeapify(int pos) // Method 6 Recursive function to max heapify given subtree
    {
        if (isLeaf(pos))
            return;
        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)])
         {
            if (Heap[leftChild(pos)]  > Heap[rightChild(pos)]) 
            {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }
 
    
 
    // Method 8 To display heap
    public void print()
    {
        System.out.println("s"+size);

        for (int i = 0; i < size / 2; i++) {
            System.out.println("Parent Node : " + Heap[i]);
 
            if (leftChild(i) < size) // if the child is out of the bound   // of the array
                System.out.println(" Left Child Node: "+ Heap[leftChild(i)]);
 
            if (rightChild(i) < size) // the right child index must not   // be out of the index of the array
                System.out.println(" Right Child Node: "  + Heap[rightChild(i)]);
 
            System.out.println(); // for new line
        }
    }
 
    // Method 10 main driver method
    public static void main(String[] arg)
    {
       
        methode maxHeap = new methode(15);
 
        // Insert() or add()
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
 
        // Calling maxHeap() as defined above
        maxHeap.print();
 
        // Print and display the maximum value in heap
        System.out.println("The max val is "  + maxHeap.extractMax());
    }
}
