public class root { 
  public static void main(String[] args){    // construct the binary tree given in question
    BinaryTree bt = BinaryTree.create();    
    // traversing binary tree using InOrder traversal using recursion
    System.out.println("printing nodes of binary tree on InOrder using recursion");    
    bt.in_order();

    System.out.println();
    System.out.println("printing nodes of binary tree on preorder using recursion");    
    bt.preorder();

    System.out.println();
    System.out.println("printing nodes of binary tree on postorder using recursion");    
    bt.postorder();

    System.out.println();
    System.out.println("leafnode:");
    bt.leafNode();

   
  }
}
  
class BinaryTree {
  static class TreeNode {
    String data;
    TreeNode left, right;    
    TreeNode(String value) {
      this.data = value;
      left = right = null;
    }   
  }  
  // root of binary tree
  TreeNode root;  

 //in-order 
  public void in_order() {
    in_order(root);
  }  
  private void in_order(TreeNode node) {
    if (node == null) {
      return;
    }   
    in_order(node.left);
    System.out.printf("%s ", node.data);
    in_order(node.right);
  }  

  //preorder
  public void preorder() {
    preorder(root);
  }  
   private void preorder(TreeNode node) {
    if (node == null) {
      return;
    }   
    System.out.printf("%s ", node.data);
    preorder(node.left);
    preorder(node.right);
}  

  //postorder
   public void postorder() {
    postorder(root);
  }  
   private void postorder(TreeNode node) {
    if (node == null) {
      return;
    }   
    postorder(node.left);
    postorder(node.right);
    System.out.printf("%s ", node.data);
  }  
  //if any parent node has 2 child node then print
   public void leafNode() {
    leafNode(root);
  }  
  private void leafNode(TreeNode node) {
    if (node == null) {
      return;
    }
        leafNode(node.left);
        if (node.left != null && node.right != null)
            System.out.print(node.data+" ");
        leafNode(node.right);   
    }
    //size of tree
 
  
  

  /**
   * Java method to create binary tree with test data
   *
   * @return a sample binary tree for testing
   */
  public static BinaryTree create() {// The Object.create() static method creates a new object, using an existing object as the prototype of the newly created object
    BinaryTree tree = new BinaryTree();
    TreeNode root = new TreeNode("40");
    tree.root = root;
    tree.root.left = new TreeNode("20");
    tree.root.left.left = new TreeNode("10");
    tree.root.left.left.left = new TreeNode("5");   
    tree.root.left.right = new TreeNode("30");
    tree.root.right = new TreeNode("50");
    tree.root.right.right = new TreeNode("60");
    tree.root.left.right.left = new TreeNode("67");
    tree.root.left.right.right = new TreeNode("78");    
    return tree;
  }
}