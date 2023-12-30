import java.util.ArrayList;
import java.util.Stack;

class Node {
        int key;
 
        // All children are stored in a list
        ArrayList<Node> child;
 
        Node(int val)
        {
            key = val;
            child = new ArrayList<>();
        }
    }
public class narypreordertraversal {
    
    static void preorderTraversal(Node root)
    {
        Stack<Node> stack = new Stack<>();
 
        // 'Preorder'-> contains all the visited nodes
        ArrayList<Integer> Preorder = new ArrayList<>();
 
        stack.push(root);
          
 
        while (!stack.isEmpty()) {
            Node temp = stack.peek();
             System.out.println("temp"+temp.key);
            stack.pop();
            // store the key in preorder vector(visited list)
            Preorder.add(temp.key);
             System.out.println("preorder"+Preorder);
             
            // Push all of the child nodes of temp into the stack from right to left.
              System.out.println("size "+temp.child.size());
                

            for (int i = temp.child.size() - 1; i >= 0; i--) 
            {
                System.out.println("i "+i);
            
                stack.push(temp.child.get(i));
                
            }
        }
         System.out.println("-------");
        for (Integer i : Preorder) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.child.add(new Node(2));
        root.child.add(new Node(3));
        root.child.add(new Node(4));
        root.child.get(0).child.add(new Node(5));
        root.child.get(0).child.add(new Node(6));
        root.child.get(0).child.get(0).child.add(new Node(10));
        root.child.get(0).child.get(1).child.add( new Node(11));
        root.child.get(0).child.get(1).child.add(new Node(12));
        root.child.get(0).child.get(1).child.add( new Node(13));
        root.child.get(2).child.add(new Node(7));
        root.child.get(2).child.add(new Node(8));
        root.child.get(2).child.add(new Node(9));
 
        preorderTraversal(root);
    }
}

 
        /*
                1
              /  |  \
            /   |   \
            2    3    4
          / \      / | \
         /  \    7  8  9
        5     6
        /    / | \
      10   11 12 13
        */