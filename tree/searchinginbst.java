

 class Node {
    int key;
    Node left, right;
 
    public Node(int item) {
        key = item;
        left = right = null;
    }
}
public class searchinginbst {
   
    Node root;
    searchinginbst() {  // Constructor
        root = null;
    }
 
    Node insert(Node node, int key)
     {
      
        if (node == null)   // If the tree is empty, return a new node
        {
            node = new Node(key);
            return node;
        }
        if (key < node.key){   // Otherwise, recur down the tree
         System.out.println("key1 "+key);
          System.out.println("node.key1 "+node.key);
        //    System.out.println("before left "+node.left.key);
            node.left = insert(node.left, key);
            System.out.println("after left "+node.left.key);

        }

        else if (key > node.key){
          System.out.println("nkey "+key);
          System.out.println("node.key "+node.key);
        // System.out.println("before right "+node.right.key);
            node.right = insert(node.right, key);
            System.out.println("after right "+node.right.key);
        }
        System.out.println("node  "+node.key);
          System.out.println();
        return node;
         
    }

 
  
    Node search(Node root, int key) 
    {
        
        if (root == null || root.key == key)
            return root;
 
        if (root.key < key) // Key is greater than root's key
            return search(root.right, key);
 
        return search(root.left, key);// Key is smaller than root's key
    }
 
 
    public static void main(String[] args)
     {
        searchinginbst tree = new searchinginbst();
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

 
       
        int key = 60;
 
        if (tree.search(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");
 
    }
}
/*Time complexity: O(h), where h is the height of the BST.
Auxiliary Space: O(h), where h is the height of the BST. This is because the maximum amount of space needed to store the recursion stack would be h.\


greater --->right
lesser--->left
*/