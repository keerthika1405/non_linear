import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

 class TreeNode{
        int val;
        List<TreeNode> children = new LinkedList<>();

        TreeNode(int data){
            val = data;
        }

        TreeNode(int data,List<TreeNode> child){
            val = data;
            children = child;
        }
    }
public class narylevelorder {
 

    private static void printNAryTree(TreeNode root){
        if(root == null) 
        return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int len = queue.size();
            System.out.println("len"+len);

            for(int i=0;i<len;i++) {
                TreeNode node = queue.poll();
                // System.out.println("node"+node.val);

                assert node != null;
                System.out.print(node.val + " ");

                for (TreeNode item : node.children) { // for-Each loop to iterate over all childrens
                    //  System.out.println("child"+child.val);
                    queue.offer(item);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        root.children.add(new TreeNode(4));
         root.children.add(new TreeNode(11));
        root.children.get(0).children.add(new TreeNode(5));
        root.children.get(0).children.add(new TreeNode(6));
        root.children.get(0).children.add(new TreeNode(7));
        root.children.get(1).children.add(new TreeNode(8));
        root.children.get(2).children.add(new TreeNode(9));
        root.children.get(2).children.add(new TreeNode(10));
        root.children.get(2).children.add(new TreeNode(11));
        root.children.get(3).children.add(new TreeNode(11));
        printNAryTree(root);
    }
}
    

