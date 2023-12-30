class degenerateBT
{
 static class Node {
    int key;
     Node left, right;
}
 
// Utility function to create a new node
static Node newNode(int key)
{
    Node temp = new Node();
    temp.key = key;
    temp.left = temp.right = null;
    return (temp);
}
 
static boolean isSkewedBT(Node root)
{
  
    if (root == null || (root.left == null &&  root.right == null))
        return true;
 
    // check if node has two children if yes, return false
    if (root.left!=null && root.right!=null)
        return false;

        
    if (root.left!=null)
        return isSkewedBT(root.left);
    return isSkewedBT(root.right);
    
}
 
public static void main(String args[])
{
  
    Node root = newNode(10);
    root.left = newNode(12);
    root.left.right = newNode(15);
    System.out.println( isSkewedBT(root)?1:0 );
 
    root = newNode(5);
    root.right = newNode(4);
    root.right.left = newNode(3);
    root.right.left.right = newNode(2);
    System.out.println( isSkewedBT(root)?1:0 );
 
    root = newNode(5);
    root.left = newNode(4);
    root.left.right = newNode(3);
    root.left.right.left = newNode(2);
    root.left.right.right = newNode(4);
    System.out.println(  isSkewedBT(root)?1:0 );
}
} 
  /* 10
    /     \
    12     13
        /     \
        14     15    
        / \     / \
     21     22 23 24     */  
