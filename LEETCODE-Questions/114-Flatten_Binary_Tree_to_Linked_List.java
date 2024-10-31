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
    // TC: O(N), SC: O(H) -> Stack space
    public static TreeNode solve(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode lt = solve(root.left);
        TreeNode rt = solve(root.right);

        if(lt == null && rt == null){
            return root;
        }else if(lt == null && rt != null){
            // Make sure, u are not returning root instead returning the
            // tail
            return rt;      
        }else if(lt != null && rt == null){
            TreeNode lc = root.left;
            root.right = lc;
            root.left = null;

            return lt;
        }else{
            // If both are not null
            TreeNode lc = root.left;
            TreeNode rc = root.right;
            root.right = lc;
            root.left = null;
            lt.right = rc;

            return rt;
        }
    }  

    public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        solve(root);
    }
}