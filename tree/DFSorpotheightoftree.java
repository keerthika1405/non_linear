class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}
public class DFSorpotheightoftree {
    Node root;
    

    int height(Node node)
    {
     

        if (node == null||node.left==null && node.right==null){
            return 0;
          }
        else {
        // System.out.println("*"+node.data);
        //  System.out.println("nodeleft"+node.left.data);
            int lHeight = height(node.left);
              // System.out.println("L "+lHeight);

              // System.out.println("noderight"+node.right.data);
            int rHeight = height(node.right);
              // System.out.println("R "+rHeight);

            return (lHeight > rHeight) ? (lHeight + 1): (rHeight + 1);
          
        }
    }
    public static void main(String args[])
        {
            DFSorpotheightoftree tree = new DFSorpotheightoftree();
            // tree.root = new Node(1);
            // tree.root.left = new Node(2);
            //   tree.root.left.left = new Node(10);
            // tree.root.right = new Node(3);
            // // tree.root.left.left = new Node(4);
            // tree.root.left.right = new Node(5);
            //  tree.root.left.right.left = new Node(9);
            // tree.root.right.right = new Node(8);
            //  tree.root.right.left = new Node(7);
            // tree.root.right.left.left = new Node(6);
            // tree.root.right.left.left.left = new Node(11);
            tree.root = new Node(15);
            tree.root.left = new Node(10);
            tree.root.right = new Node(20);
            tree.root.left.left = new Node(8);
            tree.root.left.right = new Node(12);
            tree.root.right.left = new Node(16);
            tree.root.right.right = new Node(25);
            // tree.root.right.right.right = new Node(7);
            System.out.println("height" + tree.height(tree.root));
        }
    
}
