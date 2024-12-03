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
    int camera;
    public int solve(TreeNode root){
        if(root == null){
            return 2;
        }

        int l = solve(root.left);
        int r = solve(root.right);

        // There exist a leaf node at the bottom
        if(l == 0 || r == 0){
            camera++;
            return 1;
        }

        if(l == 1 || r == 1){
            return 2;
        }

        return 0;
    }

    public int minCameraCover(TreeNode root) {
        camera = 0;

        int rtn = solve(root);

        if(rtn == 0){
            camera++;
        }

        return camera;
    }
}