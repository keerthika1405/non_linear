
class Node {
        int key;
        Node left, right;
     
        // A utility function to create a new BST node
        Node(int item) {
            key = item;
            left = right = null;
        }
    }
public class deletioninBST {
  
        Node root;
     
        // A utility function to do inorder traversal of BST
        void inorder(Node root)
         {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.key + " ");
                inorder(root.right);
            }
        }
     
        Node insert(Node node, int key) {
          
            if (node == null)
                return new Node(key);
     
            if (key < node.key)
                node.left = insert(node.left, key);
            else if (key > node.key)
                node.right = insert(node.right, key);
    
            return node;
        }

        // Node deleteNode(Node root, int key)
        //  {
         
        //     if (root == null)
        //         return root;
     
        //     if (root.key > key)
        //      {
        //         root.left = deleteNode(root.left, key);
        //         return root;

        //     }
        //     else if (root.key < key) 
        //     {
        //         root.right = deleteNode(root.right, key);
        //         return root;
        //     }
     
        //     // We reach here when root is the node to be deleted.
     
        //     // If one of the children is empty
        //     if (root.left == null)
        //      {
               
        //         Node temp = root.right;
        //         return temp;
        //     } 
        //     else if (root.right == null)
        //      {
        //         Node temp = root.left;
        //         return temp;
        //     }
     
        //     else   // If both children exist
        //      {
        //         Node succParent = root;
     
        //         // Find successor
        //         Node succ = root.right;
        //         while (succ.left != null) {
        //             succParent = succ;
        //             succ = succ.left;
        //         }
     
        //         // Delete successor.  Since successor is always left child of its parent
        //         // we can safely make successor's right
        //         // right child as left of its parent.
        //         // If there is no succ, then assign
        //         // succ.right to succParent.right
        //         if (succParent != root)
        //             succParent.left = succ.right;
        //         else
        //             succParent.right = succ.right;
     
        //         // Copy Successor Data to root
        //         root.key = succ.key;
     
        //         // Delete Successor and return root
        //         return root;
        //     }
        // }
     
        public boolean delete(int data)
        {
            //   System.out.println("data:  "+data);
            return deleteop(root, data)!=null ? true: false;
        }
    
        private Node deleteop(Node root, int key)
        {
            //this is the termination condition for our recursion call
            if(root ==null){
                return root;
            }
              
            //we will keep traversing the left subtree until the element is less than node data.
            else if(root.key>key)
            {
                // System.out.println("root "+root.key);
                // System.out.println("l "+root.left.key);
                root.left = deleteop(root.left, key);
                 
            }
            //we will keep traversing the right subtree until the element is greater than node key.
            else if(root.key< key){
                root.right = deleteop(root.right, key);
               
            }

            else{
                /*we have found a potential match, mow we need to check
                the 3 different cases to see which one should be executed.*/
    
                // we are dealing with situation, where we have either one child or no child
                // System.out.println("elseleft "+root.left.key);
                //   System.out.println("elseright "+root.right.key);
                if(root.left ==null)
                {
                    return root.right;
                }
                else if(root.right == null)
                {
                    return root.left;
                }
    
                /*this is the complex use case where element contains both left and right sub-tree
                We will go with our algorithm to find the minimum element in the right sub-tree and
                replace it followed by deletion
                */
                //  System.out.println("findminright  "+root.right.key);
                root.key = findMin(root.right);
                // System.out.println("findmin "+root.key);
    
                root.right= deleteop(root.right, root.key);
            }
            return root;
        }
    
        private int findMin(Node node){
            //we are assuming that it's the minimum value
            int min = node.key;
    
            //remember left sub-tree will have the minimum value.You can also use the same logic to implement BST without recursion.
            while(node.left!=null){
                min = node.left.key;
                node = node.left;
            }
            return min;
        }
     
       
        public static void main(String[] args)
        {
            deletioninBST tree = new deletioninBST();
     
         
            tree.root = tree.insert(tree.root, 50);
            tree.insert(tree.root, 30);
            tree.insert(tree.root, 20);
            tree.insert(tree.root, 40);
            tree.insert(tree.root, 70);
            tree.insert(tree.root, 60);
     
            tree.inorder(tree.root);
     
            // System.out.println("\nDelete a Leaf Node: 20");
            // tree.root = tree.deleteNode(tree.root, 20);
            // tree.inorder(tree.root);
            //  System.out.println();

          
     
            // System.out.println("\n\nDelete Node with single child: 70");
            // tree.root = tree.deleteNode(tree.root, 70);
            // System.out.print("Modified BST tree after deleting single child Node:\n");
            // tree.inorder(tree.root);
     
            // System.out.println("\n\nDelete Node with both child: 50");
            // tree.root = tree.deleteNode(tree.root, 50);
            // System.out.print("Modified BST tree after deleting both child Node:\n");
            // tree.inorder(tree.root);

            tree.delete(30);
           
            System.out.println();
            tree.inorder(tree.root);
        }
        }
    
       /* Let us create following BST
                      50
                   /     \
                  30      70
                 /  \    /  \
               20   40  60   80 */