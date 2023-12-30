import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

 class Node {
        int key;
        ArrayList<Node> child;
        public Node(int key)
        {
            this.key = key;
            child = new ArrayList<>();
        }
    }
public class ncrwayfornary {
  

    
 
    // Utility function to create a new tree node
    static Node newNode(int key) 
    { 
         return new Node(key);
     }
 
    // Utility Function to find factorial of given number
    static int factorial(int n)
    {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
 
    // Function to calculate the number of ways of
    // traversing the n-ary starting from root. This
    // function is just a modified breadth-first search. We
    // can use a depth-first search too.
    static int calculateWays(Node root)
    {
        int ways = 1; // Initialize result
 
        // If the tree is empty there is no way of traversing the tree.
        if (root == null) {
            return 0;
        }
 
        // Create a queue and enqueue root to it.
        Queue<Node> q = new LinkedList<>();
        q.add(root);
 
        // Level order traversal.
        while (!q.isEmpty()) {
            // Dequeue an item from queue and print it
            Node p = q.poll();
 
            // The number of ways is the product of
            // factorials of number of children of each
            // node.
            ways = ways * (factorial(p.child.size()));
 
            // Enqueue all children of the dequeued item
            for (int i = 0; i < p.child.size(); i++) {
                q.add(p.child.get(i));
            }
        }
 
        return (ways);
    }
 
    public static void main(String[] args)
    {
        Node root = newNode(1);

        root.child.add(newNode(2));
        root.child.add(newNode(3));
        root.child.add(newNode(4));

        root.child.get(0).child.add(newNode(5));
        root.child.get(0).child.add(newNode(6));

        root.child.get(2).child.add(newNode(7));
        root.child.get(2).child.add(newNode(8));
        root.child.get(2).child.add(newNode(9));

        root.child.get(0).child.get(0).child.add( newNode(10));

        root.child.get(0).child.get(1).child.add( newNode(11));
        root.child.get(0).child.get(1).child.add( newNode(12));
        root.child.get(0).child.get(1).child.add( newNode(13));

        //3!*2!*1!*3!*3!*0!==432

        // Node root = newNode('A');
        // root.child.add(newNode('B'));
        // root.child.add(newNode('F'));
        // root.child.add(newNode('D'));
        // root.child.add(newNode('E'));
        // root.child.get(0).child.add(newNode('K'));
        // root.child.get(0).child.add(newNode('J'));
        // root.child.get(2).child.add(newNode('G'));
        // root.child.get(3).child.add(newNode('C'));
        // root.child.get(3).child.add(newNode('H'));
        // root.child.get(3).child.add(newNode('I'));
        // root.child.get(0).child.get(0).child.add( newNode('N'));
        // root.child.get(0).child.get(0).child.add( newNode('M'));
        // root.child.get(3).child.get(2).child.add( newNode('L'));
 
        System.out.println(calculateWays(root));
    }
}
    
 /*   Let us create below tree
         *           A
         *         / /  \  \
         *       B  F   D  E
         *      / \     |  /|\
         *     K  J    G  C H I
         *      /\            \
         *    N   M            L
         */
 

