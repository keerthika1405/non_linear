class Node
{
    int            value;
    Node Left;
    Node Right;
    Node(int k)
    {
        value = k;
    }
}
 
class checkifAVLtreeornot
{
    public static boolean isBST(Node node)
    {
        return (isBSTUtil(node, 0, 100));
    }
 
    public static boolean isBSTUtil(Node node, int min, int max)
    {
 
        if (node == null)
            return true;
 
        if (node.value < min || node.value > max)
            return false;
 
        return (isBSTUtil(node.Left, min, node.value - 1) && isBSTUtil(node.Right, node.value + 1, max));
    }
 
    public static boolean isBalanced(Node root)
    {
        int lh; /* for height of left subtree */
        int rh; /* for height of right subtree */
 
        if (root == null)
            return true;
 
        lh = height(root.Left);
        rh = height(root.Right);
 /*abs() method is the inbuilt method of the Math class that is present in java. lang package. The Math. abs() method takes one parameter that is of number type and returns its absolute value
  i.e positive value of the number, without using the negative sign. */

        if (Math.abs(lh - rh) <= 1   && isBalanced(root.Left)   && isBalanced(root.Right))
            return true;
 
        return false;
    }
 
    public static int max(int a, int b)
    {
        return (a >= b) ? a : b;
    }
 
    public static int height(Node node)
    {
        if (node == null)
            return 0;
 
        return 1 + max(height(node.Left), height(node.Right));
    }
 
    public static void main(String args[])
    {
        Node t1 = new Node(4);
         t1.Left = new Node(2);
        t1.Right = new Node(5);
        t1.Left.Left = new Node(1);
        t1.Left.Right = new Node(3);
        t1.Right.Left = new Node(5);
        t1.Right.Right = new Node(25);
 
        Node t2 = new Node(15);
        t2.Left = new Node(5);
        t2.Right = new Node(20);
        t2.Right.Left = new Node(18);
        t2.Right.Right = new Node(23);
        t2.Left.Left = new Node(4);
        t2.Left.Right = new Node(6);
 /* When a key is duplicated, we don't make a new node for the inserted node; instead, 
 we increase the repetition of an existing node. */
        if (isBST(t1)&&isBalanced(t1))
            System.out.println("Tree t1 is bst tree");
        else
            System.out.println("Tree t1 is not bst tree");
        

        // if ()
        //     System.out.println("Tree t1 is AVL tree");
        // else
        //     System.out.println("Tree t1 is not AVL tree");

            
        if (isBST(t2) && isBalanced(t2))
            System.out.println("Tree t1 is AVL tree");
        else
            System.out.println("Tree t1 is not AVL tree");
    }
}