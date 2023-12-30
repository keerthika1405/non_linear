class Node{
    int data;
    Node left;
    Node right; 

    public Node(int item) {
    this.data = item;
    this.left=null;
    this.right = null;
    }   
          
}
class sizeoftree { 
  Node root;
  int size(){
    return size(root);
  }
//operation
  int size(Node root) {
      if (root == null) {
        return (0);
    }else{
    return size(root.left)+1+size(root.right);
    }
  }   
  public static void main(String[] args){ 
    sizeoftree tree=new sizeoftree();
    tree.root = new Node(5);
    tree.root.left = new Node(20);
    tree.root.left.left = new Node(10);
    tree.root.left.left.left = new Node(5);   
    tree.root.left.right = new Node(30);
    tree.root.right = new Node(50);
    tree.root.right.right = new Node(60);
    tree.root.left.right.left = new Node(67);
    tree.root.left.right.right = new Node(78);
    tree.root.left.right.right = new Node(8);
     
    System.out.println("sizeof:"+tree.size()); 
} 
} 

 

