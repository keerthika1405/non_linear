import java.util.ArrayDeque;
import java.util.Queue;
 
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int data) {
        this.key = data;
    }
}
 
class BFSorlotheightoftree
{
    public static int height(Node root)
    {
        if (root == null) {
            return 0;
        }
 
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
    
       
 
        Node front = null;
        int height = 0;
 
        while (!queue.isEmpty())
        {
            int size = queue.size();
          // System.out.println(size);
 
            while (size --> 0)
            {
                front = queue.poll();//return and remove
                // System.out.println("front"+front.key);
 
                if (front.left != null) {
                  // System.out.println("frontleft"+front.left.key);
                    queue.add(front.left);
                }
 
                if (front.right != null) {
                  //  System.out.println("frontright"+front.right.key);
                    queue.add(front.right);
                }
            }
            //  System.out.println("height"+height);
            height++;
        }
  //  System.out.println("heightfinal"+height);
        return height-1;
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        root.right.right.right= new Node(50);  
        root.right.right.left= new Node(90);

      
        System.out.println("The height of the binary tree is " + height(root));
    }
}