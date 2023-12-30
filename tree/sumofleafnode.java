class Node{  
        int data;  
        Node left, right; 
        public Node(int data){
        this.data = data;  
        left=right = null;  
        }
    }
public class  sumofleafnode {
Node root;
static int sum;
public static int leafsum(Node root){
 
    if(root==null){
        return 0;
    }
  
    if(root.left==null && root.right==null){
        sum =sum+ root.data;
    }
        leafsum(root.left);
        leafsum(root.right);
        return sum;
}
    
    public  static void main(String[] args) {  
      sumofleafnode tree=new sumofleafnode();
      
      tree.root =new Node(5);  
      tree.root.left =new Node(10);  
      tree.root.right =new Node(15);  
      tree.root.left.left =new Node(9);  
      tree.root.right.left =new Node(90);  
      tree.root.right.right =new Node(12); 
      tree.root.left.right =new Node(9);

      System.out.println(leafsum(tree.root)); 
      } 
}
