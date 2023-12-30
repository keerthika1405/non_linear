
class Node{
        public int key;
        public Node right,left;
         Node(int k){
            this.key = k;
            this.right = this.left = null;
        }
    }
public class perfectBT {
   
     
    //Returns height of tree
    public static  int getheight(Node root){  
             
        if (root == null)  
           return 0;  
        else  
        {  
            int lheight = getheight(root.left);  
            int rheight = getheight(root.right);  
                
            if (lheight > rheight)  
                return(lheight+1);  
            else   
                return(rheight+1);  
        }  
    }  
    // This functions gets the size of binary tree
    // Basically, the number of nodes this binary tree has
    static int getLength(Node root){
        if(root == null)
            return 0;
        return 1 + getLength(root.left) + getLength(root.right);
    }
     
    // Returns True if length of binary tree is 2^h - 1
    static boolean isPerfect(Node root){
        int length = getLength(root);
        int height = getheight(root);
        
        return length + 1 == (int)Math.pow(2, height);//8==8
    }
     
    /* Driver program to test above function*/
    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.right.left.left = new Node(60);
        root.right.right.right= new Node(70);
        // System.out.println(getheight(root));
        //  System.out.println(getLength(root));

        if (isPerfect(root))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    }
    

