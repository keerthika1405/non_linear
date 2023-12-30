
import java.util.ArrayList;


public class nodetopath {

    public static boolean haspath(Node root, ArrayList<Integer> arr,int x){
        if(root==null)
        return false;

        arr.add(root.data);
        if(root.data==x)
        return true;
        if(haspath(root.left,arr,x)||
        haspath(root.right,arr,x))
        return true;

        arr.remove(arr.size()-1);
        return false;
    }

    public static void Nodetopath(Node root,int x){
        ArrayList<Integer> arr=new ArrayList<>();
        
   
        if(haspath(root,arr,x)){
            for(int i=0;i<arr.size()-1;i++)
                System.out.print(arr.get(i)+"--> ");
            System.out.print(arr.get(arr.size()-1));}
        else{
            System.out.print("no path");
        }
    }
    public static void main(String[] args){ 
        Node root;
        root = new Node(5);
        root.left = new Node(20);
        root.left.left = new Node(10);
        root.left.left.left = new Node(5);   
        root.left.right = new Node(30);
        root.right = new Node(50);
        root.right.right = new Node(60);
        root.left.right.left = new Node(67);
        root.left.right.right = new Node(8);
         
       int x=67;
       Nodetopath(root,x);
    
}
}

class Node{
    int data;
    Node left;
    Node right; 

    public Node(int data) {
    this.data = data;
    this.left=null;
    this.right = null;
    }  
} 
