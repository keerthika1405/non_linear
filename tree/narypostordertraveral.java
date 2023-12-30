import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

 class Node {
        public int val;
        public List<Node> children = new ArrayList<Node>();//input type
     
        // Default constructor
        public Node() {

        }
        public Node(int _val)
        {
            val = _val;
        }
     
        public Node(int _val, List<Node> _children)
        {
            val = _val;
            children = _children;
        }
    }
public class narypostordertraveral {

    // Helper class to push node and it's index into the stack

    static class Pair {
         Node node;
        public int childrenIndex;
        public Pair(Node _node, int _childrenIndex)
        {
            node = _node;
            childrenIndex = _childrenIndex;
        }
    }
     
    // We will keep the start index as 0,
    // because first we always process the left most children
    int currentRootIndex = 0;
    Stack<Pair> stack = new Stack<Pair>();
    ArrayList<Integer> postorderTraversal =  new ArrayList<Integer>();
     
    // Function to perform iterative postorder traversa\

    public ArrayList<Integer> postorder(Node root)
    {
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                 
                // Push the root and it's index into the stack
                stack.push(new Pair(root, currentRootIndex));
                currentRootIndex = 0;
     
                // If root don't have any children's that
                // means we are already at the left most
                // node, so we will mark root as null
                if (root.children.size() >= 1) {
                    System.out.println("childroot"+root.children.size());
                    System.out.println("index "+currentRootIndex+" "+root.val);
                    root = root.children.get(0);
                    System.out.println("val "+root.val);
                }
                else {
                    root = null;
                }
                continue;
            }
     
            // We will pop the top of the stack and
            // add it to our answer
            Pair temp = stack.pop();
              System.out.println("temp "+temp.node.val);
            postorderTraversal.add(temp.node.val);
            System.out.println("postoder "+postorderTraversal);
            // Repeatedly we will the pop all the
            // elements from the stack till popped element is last children of top of the stack
            while (!stack.isEmpty() && temp.childrenIndex == stack.peek().node.children.size() - 1)
            {
                temp = stack.pop();
                postorderTraversal.add(temp.node.val);
            }
     
            // If stack is not empty, then simply assign the root to the next children of top of stack's node
            if (!stack.isEmpty()) {
                root = stack.peek().node.children.get(temp.childrenIndex + 1);
                currentRootIndex = temp.childrenIndex + 1;
            }
        }
     
        return postorderTraversal;
    }
     
   
    public static void main(String[] args)
    {
        narypostordertraveral solution = new narypostordertraveral();
        Node root = new Node(1);
     
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
     
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
     
        System.out.println(solution.postorder(root));
    }
}

