// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    public int solve(Node node){
        if(node == null){
            return -1;
        }
        
        int l = solve(node.left);
        int r = solve(node.right);
        
        return Math.max(l, r) + 1;
    }
    
    int height(Node node) {
        // Edge Case
        if(node.left == null && node.right == null){
            return 0;
        }
        
        return solve(node);
    }
}
