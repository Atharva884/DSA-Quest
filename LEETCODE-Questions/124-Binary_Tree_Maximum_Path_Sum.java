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
    int max;
    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }

        // Just taking max as 0 in case of negative values
        int leftSum = Math.max(0, solve(root.left));
        int rightSum = Math.max(0, solve(root.right));

        max = Math.max(max, leftSum + rightSum + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        solve(root);

        return max;
    }
}