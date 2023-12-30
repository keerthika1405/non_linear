public class narycountofleafnode {

// Function to calculate
// leaf nodes in n-ary tree
static int calcNodes(int N, int I)
{
    int result = 0;
 
    result = I * (N - 1) + 1;
 
    return result;
}
 
// Driver code
public static void main(String[] args)
{
    int N = 2, I = 5;//n==child for each internal (I)
 
    System.out.println("Leaf nodes = " +calcNodes(N, I));
}
}
    

