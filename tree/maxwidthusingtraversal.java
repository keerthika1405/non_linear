

//level order traversal without queue
class Node {
        int data;
        Node left, right;
     
        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
public class maxwidthusingtraversal {
        Node root;
     
        int getMaxWidth(Node node)
        {
            int maxWidth = 0;
            int width;
            int h = height(node);
            int i;
     
            /* Get width of each level and compare
               the width with maximum width so far */
            for (i = 1; i <= h; i++) {
                width = getWidth(node, i);
                System.out.println("width"+width);
                if (width > maxWidth)
                    maxWidth = width;
                    System.out.println("maxwidth"+maxWidth);
            }
     
            return maxWidth;
        }
     
       
int getWidth(Node node, int level)
        {
            if (node == null)
                return 0;
     
            if (level == 1)
                return 1;
            else if (level > 1)
                return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
            return 0;
        }
     
   
     
        /* Compute the "height" of a tree -- the number of
         nodes along the longest path from the root node
         down to the farthest leaf node.*/
        int height(Node node)
        {
            if (node == null||node.left==null && node.right==null)
                return 0;
            else {
                /* compute the height of each subtree */
                int lHeight = height(node.left);
                  System.out.println("L "+lHeight);
                int rHeight = height(node.right);
                  System.out.println("R "+rHeight);
    
                return (lHeight > rHeight) ? (lHeight + 1): (rHeight + 1);
              
            }
        }
     
    public static void main(String args[])
        {
            maxwidthusingtraversal tree = new maxwidthusingtraversal();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.right = new Node(8);
            tree.root.right.right.left = new Node(6);
            tree.root.right.right.right = new Node(7);
             System.out.println("height  " + tree.height(tree.root));
            System.out.println("Maximum width is " + tree.getMaxWidth(tree.root));
        }
    }

 /*
            Constructed binary tree is:
                  1
                /  \
               2    3
             /  \    \
            4   5     8
                     /  \
                    6   7
             */