// User function Template for Java

/*
// A Binary Tree node
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
    // Function to return sum of all nodes of a binary tree
    static int solve(Node root){
        if(root == null) return 0;
        
        int a = solve(root.left);
        int b = solve(root.right);
        
        return a + b + root.data;
    }
    static int sumBT(Node root) {
        return solve(root);
    }
}