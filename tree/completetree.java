// Checking if a binary tree is a complete binary tree in Java

// Node creation
class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

class completetree {
  Node root;

  int totalNodes(Node root)
  {
      if (root == null)
          return 0;
    //  System.out.println("leftdata"+root.left.data);
      int l = totalNodes(root.left);
      // System.out.println("l"+l);
      //  System.out.println("rightdata"+root.right.data);
      int r = totalNodes(root.right);
      // System.out.println("r"+r);
   
      return 1 + l + r;
  }

  // Check for complete binary tree
  boolean checkComplete(Node root, int index, int count) {//root//index//totalnode

   
    if (root == null) //If the current node under examination is NULL, then the tree is a complete binary tree. Return true.
      return true;
    
  //  System.out.println("root"+root.data);
      
    if (index >= count)//(i>= count), then the tree is not a complete binary. Return false.
      return false;
      // System.out.println("i"+index);
//  System.out.println("rootleft"+root.left.data);
//  System.out.println("rootright"+root.right.data);
    return (checkComplete(root.left, 2 * index + 1, count) && checkComplete(root.right, 2 * index + 2, count));
  }

  public static void main(String args[]) {
    completetree tree = new completetree();

    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.right = new Node(5);
    tree.root.left.left = new Node(4);
    tree.root.right.right = new Node(6);
   
  
    // tree.root.right.left.left = new Node(10);

    int node_count = tree.totalNodes(tree.root);
      System.out.println("total node"+node_count);
    int index = 0;

    if (tree.checkComplete(tree.root, index, node_count))
      System.out.println("The tree is a complete binary tree");
    else
      System.out.println("The tree is not a complete binary tree");
  }
}