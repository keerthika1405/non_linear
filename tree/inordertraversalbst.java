public class inordertraversalbst {
   
 
        // Class containing left
        // and right child of current node
        // and key value
        class Node {
            int key;
            Node left, right;
     
            public Node(int item)
            {
                key = item;
                left = right = null;
            }
        }
     
        // Root of BST
        Node root;
     
        // Constructor
        inordertraversalbst()
        { 
            root = null; 
        }
     
        inordertraversalbst(int value)
        {
             root = new Node(value);
        }
     
      
        void insert(int key)   // This method mainly calls insertRec()
        { 
            root = insertRec(root, key);
         }
     
        Node insertRec(Node root, int key)   // A recursive function to insert a new key in BST
        {
           
            if (root == null) 
            {
                root = new Node(key);
                return root;
            }
     
            // Otherwise, recur down the tree
            else if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);
     
            // Return the (unchanged) node pointer
            return root;
        }
     
       
        void inorder() 
        {
            inorderRec(root);
        }
     
        void inorderRec(Node root)
        {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }
        
        void preorder() 
        {
            preorderRec(root);
        }
     
        void preorderRec(Node root)
        {
            if (root != null) {
                System.out.print(root.key + " ");
                preorderRec(root.left);
                preorderRec(root.right);
            }
        }

         void postorder() 
        {
            postorderRec(root);
        }
     
        void postorderRec(Node root)
        {
            if (root != null) {
                postorderRec(root.left);
                postorderRec(root.right);
                System.out.print(root.key + " ");
            }
        }
        
     
        // Driver Code
        public static void main(String[] args)
        {
            inordertraversalbst tree = new inordertraversalbst();
            tree.insert(50);
            tree.insert(30);
            tree.insert(20);
            tree.insert(40);
            tree.insert(70);
            tree.insert(60);
            tree.insert(80);

            tree.inorder();
            System.out.println();
            tree.preorder();
            System.out.println();
            tree.postorder();

             System.out.println();
            tree.insert(10);
            tree.inorder();
        }
    }

//   TreeNode root = new TreeNode(1);
//         root.left = new TreeNode(2);
//         root.right = new TreeNode(3);
//         root.left.left = new TreeNode(4);
//         root.left.right = new TreeNode(5);
