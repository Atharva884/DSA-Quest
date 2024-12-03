// User function Template for Java

/*class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class Solution {
    int max;
    int solve(Node root){
        if(root == null){
            return -1;
        }
        
        int l = solve(root.left);
        int r = solve(root.right);
        
        max = Math.max(max, l + r + 2);
        
        return Math.max(l, r) + 1;
    }
    
    int diameter(Node root) {
        max = 0;
        
        solve(root);
        
        return max;
    }
}
