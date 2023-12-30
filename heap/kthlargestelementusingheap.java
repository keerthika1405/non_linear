
   
import java.util.Collections;
import java.util.PriorityQueue;
 class kthlargestelementusingheap {


  public static int kthLargestElementInGivenArrayMinHeap(int[] arr, int k) {
    if(arr.length < k) {
      System.out.println("Invalid Case");
      return -1;
    }
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for(int i = 0; i < k; i++) {
      minHeap.add(arr[i]);
    }
    
    for(int i = k; i < arr.length; i++) {
      if(arr[i] > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(arr[i]);
      }  
    }
    
    return minHeap.peek();
  }
  
  public static int kthLargestElementInGivenArrayMaxHeap(int[] arr, int k) {
    if(arr.length < k) {
      System.out.println("Invalid Case");
      return -1;
    }
    
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    for(int i = 0; i < arr.length; i++) {
      maxHeap.add(arr[i]);
   
    }
    /*  By default, elements are sorted in increasing order and the head contains the smallest elements. You can retrieve the head of the priority queue
     without removing it by using the peek() method*/
    for(int i = 0; i < k - 1; i++) {
      maxHeap.poll();  
    }
    // poll() method is used to remove the element present at the head of the PriorityQueue .
    return maxHeap.peek();
  }
  
  public static void main(String[] args) {
    
    int[] arr = {10, 7, 11, 30, 20, 38, 2, 45};
    int k = 3;
    
    System.out.println(kthlargestelementusingheap.kthLargestElementInGivenArrayMinHeap(arr, k));
    System.out.println(kthlargestelementusingheap.kthLargestElementInGivenArrayMaxHeap(arr, k));
    

  }

}

