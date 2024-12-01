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
    public TreeNode solve(TreeNode root, int val){
        if(root == null){
            return null;
        }

        if(root.val == val){
            return root;
        }

        TreeNode l = solve(root.left, val);
        TreeNode r = solve(root.right, val);

        if(l != null){
            return l;
        }else if(r != null){
            return r;
        }

        return null;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        return solve(root, val);
    }
}