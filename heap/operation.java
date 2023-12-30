
public class operation {
  
    private int[] heapArray; // To store array of elements in heap
    private int capacity; // max size of the heap
    private int current_heap_size;  
    int key;  // Current number of elements in the heap
 
    // Constructor
    public operation(int n) {
        capacity = n;
        heapArray = new int[capacity];
        current_heap_size = 0;
    }
     
     
    private int parent(int key) {
        return (key - 1) / 2;
    }
    private int left(int key) {
        return 2 * key + 1;
    }
    private int right(int key) {
        return 2 * key + 2;
    }
     
     public void insertKey(int key) {    // Inserts a new key
        if (current_heap_size == capacity) {
            return ;
        }
        int i = current_heap_size;   // First insert the new key at the end
        heapArray[i] = key;
        current_heap_size++;
         
        while (i != 0 &&   heapArray[parent(i)] > heapArray[i]) {  // Fix the min heap property if it is violated
            swap(heapArray, i, parent(i));
            i = parent(i);
        }
        System.out.print(heapArray[i]+" ");
    }
     
 
   
    
            

   public void printheap(int x)
    {
         System.out.println( "current "+current_heap_size);
          System.out.println( "x "+x);
        if (x >= current_heap_size ){
             System.out.println( "--");
            return;//skip
         }
 
        System.out.println(heapArray[x] + " ");
       System.out.println( "left"+left(x));
        printheap(left(x));
         System.out.println( "right"+right(x));
        printheap(right(x));
    }
 
     
 
    // It is assumed that new_val is smaller
    // than heapArray[key].
       // Decreases value of given key to new_val.
    public void decreaseKey(int key, int new_val) {
        heapArray[key] = new_val;
         System.out.println("key "+ key );
         System.out.println("heaparray "+ heapArray[key] );
          System.out.println( "heaparrayparent  "+heapArray[parent(key)] );

        while (key != 0 && heapArray[key] < heapArray[parent(key)]) {
            swap(heapArray, key, parent(key));
             System.out.println( "heapkey1  "+key );
            key = parent(key);
        }
    }
     
    public int getMin() {
        return heapArray[0];
    }

     public void increaseKey(int key, int new_val) {
        heapArray[key] = new_val;
        MinHeapify(key);
    }
     
     public void deleteKey(int key)
     {
        decreaseKey(key, Integer.MIN_VALUE);
        extractMin();
    }

      // Changes value on a key
    public void changeValueOnAKey(int key, int new_val) {
        if (heapArray[key] == new_val) 
        {
            return;//base case
        }
        if (heapArray[key] < new_val) 
        {
            System.out.println("---");
            increaseKey(key, new_val);
        } else
        {
            System.out.println("===");
            decreaseKey(key, new_val);
        }
    }
     
    // Method to remove minimum element
    // (or root) from min heap
    public int extractMin() {
        if (current_heap_size <= 0) 
        {
            System.out.println("---");
            return Integer.MAX_VALUE;
        }
        if (current_heap_size == 1) {
              System.out.println(")))");
            current_heap_size--;
            return heapArray[0];
        } 
        System.out.println("size "+current_heap_size);
        int root = heapArray[0];    // Store the minimum value, and remove it from heap
         System.out.println("heaparray "+heapArray[0]);
        heapArray[0] = heapArray[current_heap_size - 1];
        System.out.println("heaparray1 "+heapArray[0]);
        current_heap_size--;
        MinHeapify(0);
        return root;
    }

    private void MinHeapify(int key) {

        int l = left(key);
          System.out.println("l "+l);
        int r = right(key);
             System.out.println("r "+r);
               System.out.println("key "+key);
                System.out.println("equalto  "+heapArray[key]);
                   System.out.println("current "+current_heap_size);
        int smallest = key;

        if (l < current_heap_size && heapArray[l] < heapArray[smallest]) {
             System.out.println("heaparrayleft "+heapArray[l]);
            System.out.println("l "+l);
            smallest = l;
        }
        if (r < current_heap_size && heapArray[r] < heapArray[smallest]) {
             System.out.println("heaparrayright  "+heapArray[r]);
               System.out.println("r1 "+r);
            smallest = r;
        }
        if (smallest != key) {
            System.out.println("notequal  "+heapArray[key]);
            System.out.println("key11 "+key);
            swap(heapArray, key, smallest);
            MinHeapify(smallest);
        }
    }

     private void swap(int[] arr, int a, int b) {
        System.out.println("a "+a);
        System.out.println("b "+b);
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
         

    public static void main(String[] args) {
        operation h = new operation(11);
        h.insertKey(3);
        h.insertKey(1);
        // h.deleteKey(1);
        h.insertKey(15);
        h.insertKey(5);
        h.insertKey(4);
        h.insertKey(45);
        System.out.println();

        h.printheap(0);
        System.out.println(h.extractMin() + ". ");

        System.out.println(h.getMin() + " ");
         
        h.decreaseKey(2, 1);
        System.out.println(h.getMin());

          h.decreaseKey(4, 2);
        System.out.println(h.getMin());

            System.out.println("increase ");
         h.increaseKey(1, 10);
        System.out.println(h.getMin());

         System.out.println("delete ");
         h.deleteKey(0);
        System.out.println(h.getMin());

        System.out.println("change value on key");
        h.changeValueOnAKey(1,9);
          System.out.println(h.getMin());
    }

} 
/*
 1.getMin()------>O(N)
 2.extractMin()---->O(logN)
 3.decreaseKey()--->O(logN)
 4.insert()----->O(logN)
 5.delete()----->O(logN)
 */

/*
applications:

Heap Sort:
Priority Queue:
Dijkstra’s Shortest Path 
Prim’s Minimum Spanning Tree.
a) K’th Largest Element in an array. 
b) Sort an almost sorted array/ 
c) Merge K Sorted Arrays.*/ 