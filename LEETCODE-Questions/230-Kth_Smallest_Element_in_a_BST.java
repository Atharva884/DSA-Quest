/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int i;
    int val;
    
    // TC: O(N), SC: O(N)
    public void solve(TreeNode root, int k){
        if(root == null){
            return;
        }

        solve(root.left, k);
        
        i++;
        if(i == k){
            val = root.val;
            return;
        }

        solve(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        i = 0;
        val = 0;
        solve(root, k);

        return val;
    }
}