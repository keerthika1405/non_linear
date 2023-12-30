public class printallnodelessthankheap {

        // array of elements in heap
        int[] harr;
     
        // maximum possible size of min heap
        int capacity;
        int heap_size; // Current no. of elements.
        
         public printallnodelessthankheap(int cap)
        {
            heap_size = 0;
            capacity = cap;
            harr = new int[cap];
        }
     
        int parent(int i)
         {
         return (i - 1) / 2; 
        }
        int left(int i) 
        {
             return (2 * i + 1);
             }
        int right(int i) 
        { 
            return (2 * i + 2); 
        }
     
        // Function to print all elements smaller than k
        void printSmallerThan(int x, int pos)
        {
            // System.out.println( "x "+x +" pos " + pos);
            if (pos >= heap_size){
                //   System.out.println( "--");
                return; }
     
            if (harr[pos] <= x) {  //x=100 ,harr[pos] >= x -->minheap value
                //  System.out.println( "**");
                return;
            }
     
            System.out.print(harr[pos] + " ");

            // System.out.println("l "+pos);
            //  System.out.println( "left  "+left(pos));
            printSmallerThan(x, left(pos));

            //   System.out.println("r "+pos);
            //   System.out.println( "right  "+right(pos));
            printSmallerThan(x, right(pos));
        }
     
        // Constructor: Builds a heap of given size
       
     
       
        void insertKey(int k)
        {
            if (heap_size == capacity) {
                System.out.println("Overflow: Could not insertKey");
                return;
            }
     
            // First insert the new key at the end
            heap_size++;
            //    System.out.println("hs "+heap_size);
            int i = heap_size - 1;
            harr[i] = k;
            //   System.out.println("k "+k);
            //  System.out.println("i "+i);
            //    System.out.println("parent "+parent(i));
                //   System.out.println("harr[i] "+harr[i]);
            // Fix the max heap property if it is violated


            while (i != 0 && harr[parent(i)] < harr[i]) { //harr[parent(i)] > harr[i]-->min heap
                //  System.out.println("harr "+harr[i]);
                //  System.out.println("parent "+parent(i));
                swap(i,parent(i));
                i = parent(i);
                //   System.out.println("i "+i);
                
            }
           System.out.print(harr[i]+" ");
          
        }   
      
         
     
        // A utility function to swap two elements
        void swap(int x, int y)
        {
            // System.out.println("sw_ap");
            //  System.out.println(harr[x]+" before");

            int temp = harr[x];
            harr[x] = harr[y];
            harr[y] = temp;
            //  System.out.println(harr[x]+" after");
        }

      

 public static void main(String[] args)
        {
            printallnodelessthankheap h = new printallnodelessthankheap(15);
            h.insertKey(3);
            h.insertKey(2);
            h.insertKey(15);
            h.insertKey(5);
            h.insertKey(4);
            h.insertKey(45);
            h.insertKey(80);
            h.insertKey(6);
            h.insertKey(150);
            h.insertKey(77);
            h.insertKey(120);
            
        System.out.println();
            // Print all nodes smaller than 100.
            int x = 20;
            h.printSmallerThan(x, 0);


        }
    }

