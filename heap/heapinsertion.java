/*
Why we need heaps?
Reduced time complexity: Linear data structures such as linked lists or arrays can access the minimum or maximum element present in Big O (n) whereas heaps can access the minimum or maximum element present in Big O (1).
This is crucial while processing large data sets. n refers to the number of data sets.

Application of heaps
They have been used in operating systems for job scheduling on a priority basis.
They are used in Heap sort algorithms to implement priority queues.
Used in the Dijkstra’s algorithm to find the shortest paths.

Conclusion
With a reduced time complexity, min-heap and max-heap are efficient when processing data sets, each with its own use case and implementation.
In this article, we have covered, the min-heap, the max-heap, why we need heaps, and applications of heaps. */

//A Heap in which all nodes have a value smaller than all its children ,
import java.util.*;
class heapinsertion
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes 
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        heap.add(11);
        heap.add(2);
        heap.add(10);
        heap.add(7);
        heap.add(3);
        heap.add(8);

        System.out.println("size of heap : " + heap.size());
        System.out.println("min in heap : " +heap.peek());
        heap.poll();
         heap.remove(3);
        System.out.println("after deletion");

        boolean b = heap.contains(20);
        System.out.println("Priority queue contains 20 " + "or not?: " + b);
        System.out.println("size of heap : " + heap.size());
        System.out.println("min in heap : " +heap.peek());

        Object[] arr = heap.toArray();
        System.out.println("Value in array: ");
        for (int i = 0; i < arr.length; i++)
            System.out.println("Value: " + arr[i].toString());
    }
}