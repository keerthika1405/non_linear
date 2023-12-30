 class Node  
{    
        int data;    
        Node left;    
        Node right;    
        public Node(int data)  
        {      
          this.data = data;    
          this.left = null;    
          this.right = null;    
        }    
    }    

public class searchnode {
  

      public Node root;    
      public static boolean flag = false;    
      public searchnode()  
      {    
        root = null;    
      }    
    
      public void searchNode(Node temp, int value)  
      {    
        if(root == null)  
        {    
          System.out.println("Tree is empty");    
        }    
        else  
        {      
          if(temp.data == value)  
          {    
            flag = true;    
               return;    
          }    
          //Search in left subtree    
          if(flag == false && temp.left != null)  
          {    
          searchNode(temp.left, value);    //update
          }    
         
          if(flag == false && temp.right != null)  
          {    
          searchNode(temp.right, value);    //update
          }    
        }    
      }    
      public static void main(String[] args)   
      {    
        searchnode bt = new searchnode();    
        //Add nodes to the binary tree    
        bt.root = new Node(11);    
        bt.root.left = new Node(8);    
        bt.root.right = new Node(12);    
        bt.root.left.left = new Node(78);    
        bt.root.right.left = new Node(23);    
        bt.root.right.right = new Node(36);    
    
        bt.searchNode(bt.root, 23);    
        if(flag)    
          System.out.println("Element is present in the binary tree.");    
        else    
          System.out.println("Element is not present in the binary tree.");    
      }    
    }    
    

