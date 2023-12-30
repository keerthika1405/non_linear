
    class Node {
        int key, height;
        Node left, right;
     
        Node(int d) {
            key = d;
            height = 1;
        }

    }
     
    class insertavltree {
     
        Node root;
        int height=0;
     

 int height(Node N) // A utility function to get the height of the tree
 {   
     if (N == null){
       System.out.println("null 0 ");
        return 0;}
         System.out.println("heighr key "+N.key);
     return N.height;
  }
     
       
int max(int a, int b)
  { // A utility function to get maximum of two integers
      System.out.println("a "+a+" "+"b "+b);
       return (a > b) ? a : b;
    }
     
        // A utility function to right rotate subtree rooted with y
        // See the diagram given above.
        Node rightRotate(Node y) {
            System.out.println("y "+y.key);
            Node x = y.left;
            Node T2 = x.right;
              System.out.println("x "+y.left.key);
            x.right = y;  // Perform rotation
            System.out.println("x "+x.right.key);
            y.left = T2;
            y.height = max(height(y.left), height(y.right)) + 1;  // Update heights
                System.out.println("y.height "+y.height); 
            x.height = max(height(x.left), height(x.right)) + 1;
                 System.out.println("x..height "+x.height);
            return x;    // Return new root
        }
     
        // A utility function to left rotate subtree rooted with x
        // See the diagram given above.
        Node leftRotate(Node x) {
             System.out.println("x "+x.key);
            Node y = x.right;
            Node T2 = y.left;
            System.out.println("y "+x.right.key);
            
            y.left = x;  // Perform rotation
            System.out.println("y "+y.left.key);
            x.right = T2;
            x.height = max(height(x.left), height(x.right)) + 1; 
                         System.out.println("x.height "+x.height);  //  Update heights
            y.height = max(height(y.left), height(y.right)) + 1;
                        System.out.println("y..height "+y.height); 
            return y;// Return new root
        }

 int getBalance(Node N) 
 {    // Get Balance factor of node N
     if (N == null){
       System.out.println("null 0 ");
         return 0;}
            // System.out.println("heighr left key "+N.left.key);
            // System.out.println("heighr right key "+N.right.key);
     return height(N.left) - height(N.right);
        }
     
 Node insert(Node node, int key)  //insertion
 {
   if (node == null)
       return (new Node(key));
     
   if (key < node.key){
    System.out.println("key  "+key);
   System.out.println("leftof node  "+node.key);
       node.left = insert(node.left, key);}
   else if (key > node.key){
    System.out.println("key  "+key);
     System.out.println("rightof node  "+node.key);
       node.right = insert(node.right, key);}
   else 
    
       return node; // Duplicate keys not allowed
     
    System.out.println("keyout  "+node.key);
  /* 2. Update height of this ancestor node */
     node.height = 1 + max(height(node.left),  height(node.right));
     System.out.println("height  "+node.height);


  /* 3. Get the balance factor of this ancestor node to check whether this node became unbalanced */
            int balance = getBalance(node);
            System.out.println("balance  "+balance);
            // If this node becomes unbalanced, then there // are 4 cases 
            if (balance > 1 && key < node.left.key){//Left Left Case
             System.out.println("case1");
                return rightRotate(node);}
     
            if (balance < -1 && key > node.right.key) {// Right Right Case
                  System.out.println("case2");
                return leftRotate(node);}
     
            if (balance > 1 && key > node.left.key) {// Left Right Case
                   System.out.println("case3");
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
     
            if (balance < -1 && key < node.right.key) {// Right Left Case
                   System.out.println("case4");
                node.right = rightRotate(node.right);
                  System.out.println("case4.node.right  "+node.right.key);
                return leftRotate(node);
            }
            
            return node;  /* return the (unchanged) node pointer */
        }
     
        // A utility function to print preorder traversal
        // of the tree.
        // The function also prints height of every node
        void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.key + " ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }
         void postOrder(Node node) {
            if (node != null) 
            {
                // System.out.println(node.key + " key");
                postOrder(node.left);
                //  System.out.println(node.left.key+ " nl");
                postOrder(node.right);
                // System.out.println(node.right.key + " nr");
                System.out.print(node.key + " ");
            }
        }


         void inOrder(Node node) {
            if (node != null) {
                
                inOrder(node.left);
                System.out.print(node.key + " ");
                inOrder(node.right);
                
            }
        }

        Node find(int key) {
                Node current = root;
                while (current != null) {
                    if (current.key == key) {
                        break;
                    }
                    current = current.key < key ? current.right : current.left;
                }
                return current;
            }
     
            int countNodes(Node node ){
             if( node == null)
                 return 0;
            else{
                return 1 + countNodes(node.left) + countNodes(node.right);}
            }

            public int findHeightkey(Node root,int key){  
                if(root == null) {  
                    return -1;  
                }   
                       int  leftHeight = findHeightkey(root.left,key);  
                 
                       int rightHeight = findHeightkey(root.right,key);  
                       int maximum = Math.max(leftHeight, rightHeight) + 1; 

                    if(root.key==key)
                    height=maximum;
                    
                  return maximum; //height of root plus one   
                } 
             
            int findHeight(Node root, int key)
            {
                findHeightkey(root, key);
                return height;
            }


         int findDepth(Node root, int x)
            {
              if (root == null)
                return -1;
           
             int dist = -1;
            System.out.println("key "+root.key);
    // Check if x is current node=
            if ((root.key == x)|| (dist = findDepth(root.left, x)) >= 0 ||   (dist = findDepth(root.right, x)) >= 0){
            System.out.println("key1 "+root.key);
            System.out.println("distance "+dist );
        return dist + 1;
        }
        return dist;
        }

    void findParent(Node node,  int val, int parent)
    {
        if (node == null)
            return ;
        if (node.key == val)  // If current node is the required node
        {
            System.out.println(parent);
        }
        else
        {
            // Recursive calls for the children of the current node Current node is now the new parent
            findParent(node.left, val, node.key);
            findParent(node.right, val, node.key);
        }
      
    }
    Node minValueNode(Node node)
    {
        Node current = node;
 
        /* loop down to find the leftmost leaf */
        while (current.left != null)
        current = current.left;
 
        return current;
    }

    Node deleteNode(Node root, int key)
    {
    
        if (root == null){
            System.out.println("basecase");
            return root;}
       
        if (key < root.key){
        System.out.println("key  "+key);
        System.out.println("leftof node  "+root.key);
            root.left = deleteNode(root.left, key);}
        else if (key > root.key){
        System.out.println("key  "+key);
        System.out.println("rightof node  "+root.key);
        root.right = deleteNode(root.right, key);}
 
        // if key is same as root's key, then this is the node to be deleted
        else
        {
           
    
            if ((root.left == null) || (root.right == null))    // node with only one child or no child
            {

                Node temp = null;
                if (temp == root.left){
                     System.out.println("left -right to temp ");
                    //  System.out.println("left -right to temp1 "+root.right.key);
                    temp = root.right;}
                else{
                     System.out.println("right -left to temp ");
                    temp = root.left;}
 
               
                if (temp == null) // No child case
                {
                     System.out.println("no child");
                    temp = root;
                     System.out.println("no child "+temp.key);
                    root = null;
                }
                else {// One child case
                     System.out.println("one child");
                    root = temp;
                } // Copy the contents of// the non-empty child
            }
            else
            {
 
                // node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);
 
                // Copy the inorder successor's data to this node
                root.key = temp.key;
 
                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }
 
        // If the tree had only one node then return
         System.out.println("--------");

        if (root == null){
               System.out.println("if root = nul in del");
            return root;
        }
 
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
         System.out.println("del key"+root.key);
        root.height = max(height(root.left), height(root.right)) + 1;
        System.out.println("dele height"+root.height);
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);
         System.out.println("dele balance"+balance);
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0){
          System.out.println("case1");
            return rightRotate(root);}
 
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
              System.out.println("case2");
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
 
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0){
              System.out.println("case3");
            return leftRotate(root);}
 
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
              System.out.println("case4");
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
 
        return root;
    }

       


        public static void main(String[] args) {
            insertavltree tree = new insertavltree();
     
            /* Constructing tree given in the above figure */
            tree.root = tree.insert(tree.root, 10);
            tree.root = tree.insert(tree.root, 20);
            tree.root = tree.insert(tree.root, 30);
            tree.root = tree.insert(tree.root, 40);
            tree.root = tree.insert(tree.root, 50);
            tree.root = tree.insert(tree.root, 25);

            /* The constructed AVL Tree would be
                 30
                /  \
              20   40
             /  \     \
            10  25    50
            */
            System.out.println("postorder traversal" );
            tree.postOrder(tree.root);
            System.out.println();

            System.out.println("inorder traversal" );
            tree.inOrder(tree.root);
             System.out.println();


            System.out.println("prerder traversal" );
            tree.preOrder(tree.root);
            System.out.println();
             

            System.out.println();
            if(tree.find(0)==null){
                 System.out.println("key not  found" );
            }
            else{
                 System.out.println("key found" );
            }

            System.out.println();
            System.out.println("count of node from avl tree : "+ tree.countNodes(tree.root));

            System.out.println();
            System.out.println("height of root from avl tree : "+ tree.findHeight(tree.root,0));


            System.out.println();
            System.out.println("depth of root from avl tree : "+ tree.findDepth(tree.root,25));

            System.out.println();
             System.out.print("parent of given node  " );
            tree.findParent(tree.root,10,-1);

            System.out.println();
            tree.deleteNode(tree.root,40);
            System.out.println("inorder traversal" );
            tree.inOrder(tree.root);
            System.out.println();
        }
    }

   