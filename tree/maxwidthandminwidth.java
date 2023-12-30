import java.util.LinkedList;
import java.util.Queue;    
 class Node  
      {    
        int data;    
        Node left;    
        Node right;    
        public Node(int data)  
        {    
          //Assign data to the new node, set left and right children to null    
          this.data = data;    
          this.left = null;    
          this.right = null;    
        }    
      } 
public class maxwidthandminwidth {
          
      public Node root;   
      public maxwidthandminwidth()  
      {    
        root = null;    
      }    
//checking the eacch level asnd finding the max node on all
      public int findMaximumWidth()   
      {    
          int maxWidth = 0;        
          int nodesInLevel = 0;    
          
          Queue<Node> queue = new LinkedList<Node>();     
          if(root == null) {    
              System.out.println("Tree is empty"+"And width is zero");    
              return 0;    
          }    
          else   
          {    
             
              queue.add(root); //Add root node to queue as it represents the first level    
              
              while(queue.size() != 0)   
              {    
               
                  nodesInLevel = queue.size();       
                //   System.out.println("nodelevel"+nodesInLevel);    
                 
                  maxWidth = Math.max(maxWidth, nodesInLevel);
                //   System.out.println("max"+maxWidth);       
                 
                  while(nodesInLevel > 0)   
                  {    
                     Node current = queue.remove();    
                    //  System.out.println("cuurent"+current.data);  
                     if(current.left != null)     
                         queue.add(current.left);    
                     if(current.right != null)     
                         queue.add(current.right); 

                     nodesInLevel--;  
                    // System.out.println("nodelevel--"+nodesInLevel); 

                  }    
              }    
          }    
        //    System.out.println("maxreturn"+maxWidth); 
          return maxWidth;    
      }    
      public static void main(String[] args)   
      {    
          maxwidthandminwidth bt = new maxwidthandminwidth();        
          bt.root = new Node(1);    
          bt.root.left = new Node(2);    
          bt.root.right = new Node(3);    
          bt.root.left.left = new Node(4);    
          bt.root.left.right = new Node(5);    
          bt.root.right.left = new Node(6);    
          bt.root.right.right = new Node(7);    
          bt.root.left.left.left = new Node(8);    
          System.out.println("Maximum width of the binary tree: " + bt.findMaximumWidth());    
      }    
}  

