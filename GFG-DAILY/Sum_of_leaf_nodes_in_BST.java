/*node class of the binary ssearch tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution
{
    static int sum;
    public static void solve(Node root){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            // It's a leaf Node
            sum += root.data;
        }
        
        solve(root.left);
        solve(root.right);
    }
    
    public static int sumOfLeafNodes(Node root)
    {
        sum = 0;
        solve(root);
        
        return sum;
    }
}
