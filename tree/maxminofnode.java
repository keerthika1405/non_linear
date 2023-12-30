class Node{  
        int data;  
        Node left, right; 
        public Node(int data){  
        this.data = data;  
        left=right = null;  
        }   
} 
class maxminofnode{
    Node root;
    public int maxofdata(Node temp)
    {  
      if(root==null){
        return Integer.MIN_VALUE;
      }
      int lmax,rmax;
      int result=temp.data;
       //else{
      //   int lmax=maxofdata(temp.left);
      //   int rmax=maxofdata(temp.right);
      //   int result=temp.data;

      // if (lmax>result){
      //      result=lmax;
      //    }
      //    if(rmax>result){
      //      result=rmax;
      //    }
      //  return result;
         if(temp.left!=null){
           lmax=maxofdata(temp.left);
           result=Math.max(result,lmax);}
         if(temp.right!=null){
           rmax=maxofdata(temp.right);
           result=Math.max(result,rmax);}return result;
      }
      //min
      public int minofdata(Node temp)
    {  
      if(root==null){
        return Integer.MAX_VALUE;
      }
      int lmin,rmin;
      int result1=temp.data;
       //else{
      //   int lmax=maxofdata(temp.left);
      //   int rmax=maxofdata(temp.right);
      //   int result=temp.data;

      // if (lmax>result){
      //      result=lmax;
      //    }
      //    if(rmax>result){
      //      result=rmax;
      //    }
      //  return result;
         if(temp.left!=null){
           lmin=minofdata(temp.left);
           result1=Math.min(result1,lmin);}
         if(temp.right!=null){
           rmin=maxofdata(temp.right);
           result1=Math.min(result1,rmin);}return result1;
      }
      
   
    public static void main(String[] args) {  
      maxminofnode tree=new maxminofnode();
      
      tree.root =new Node(5);  
      tree.root.left =new Node(10);  
      tree.root.right =new Node(15);  
      tree.root.left.left =new Node(9);  
      tree.root.right.left =new Node(90);  
      tree.root.right.right =new Node(12); 
       
      System.out.println("max of all node value is : " + tree.maxofdata(tree.root)); 
      System.out.println("min  of all node value is : " + tree.minofdata(tree.root));  
      } 
  }