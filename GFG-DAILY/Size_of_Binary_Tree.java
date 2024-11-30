/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static int solve(Node node){
        if(node == null){
            return 0;
        }
        
        int x = solve(node.left);
        int y = solve(node.right);
        
        return x + y + 1;
    }
    
    public static int getSize(Node node) {
        return solve(node);
    }
}
        
