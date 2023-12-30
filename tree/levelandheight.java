
    
    class Node{  
        int key;  
        Node left, right;  
        public Node(int item)  
        {  
          key = item;  
          left = right = null;  
        }  
         
       }  
public class levelandheight {
    
        Node node;  

        levelandheight(int key)  
        {  
            node = new Node(key);  
        }  
         
        levelandheight()  
        {  
          node = null;  
        }  
           
         
       public void printTree()  
          {  
              int h = height(node);  
              int i;  
              for (i=1; i<=h; i++){  
                  printCurrentLevel(node, i);  
                  System.out.println();  
                }  
          }  
         
public  int height(Node root){  
             
              if (root == null)  
                 return 0;  
              else  
              {  
                  int lheight = height(root.left);  
                  int rheight = height(root.right);  
                      
                  if (lheight > rheight)  
                      return(lheight+1);  
                  else   
                      return(rheight+1);  
              }  
          }  
          
         
         public static void printCurrentLevel (Node root ,int level)  
          {  
              if (root == null)  
                  return;  
              if (level == 1)  
                  System.out.print(root.key + " ");  
              else if (level > 1)  
              {  
                  printCurrentLevel(root.left, level-1);  
                  printCurrentLevel(root.right, level-1);  
              }  
          }    
         
public static void main(String[] args)
{     
          levelandheight tree = new levelandheight();  
          tree.node = new Node(150);  
          tree.node.left = new Node(250);  
          tree.node.right = new Node(270);  
          tree.node.left.left = new Node(320);  
          tree.node.left.right = new Node(350);  
         
     
         
         
         
          System.out.println("Printing the nodes of tree level wise :");  
          System.out.println("Level order traversal : ");  
          tree.printTree();  
           
          int h = tree.height(tree.node);
        
          System.out.println("The height of the Binary tree is : " + h );  
        
        }  
      }  

     /*  
                     150 
                  /          \ 
             250         270 
              /     \       /      \ 
            320 350  null  null 
        
      */  