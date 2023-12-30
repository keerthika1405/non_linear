
class Node{  
        int data;  
        Node left, right; 
        public Node(int data){  
        this.data = data;  
        left=right = null;  
        }   
  } 
  class BinaryTree{
    Node root;
    
  public int getsumofnode(Node root)
    {  
      if(root==null){
        return 0;
      }
      else{
      return root.data +getsumofnode(root.left) +getsumofnode(root.right);
    } 
  }
  public static void main(String[] args) {  
      BinaryTree tree=new BinaryTree();
      
      tree.root =new Node(5);  
      tree.root.left =new Node(5);  
      tree.root.right =new Node(5);  
      tree.root.left.left =new Node(5);  
      tree.root.right.left =new Node(5);  
      tree.root.right.right =new Node(5);  
      System.out.println("Sum of all nodes of binary tree: " + tree.getsumofnode(tree.root));  
      } 
  }
  
   