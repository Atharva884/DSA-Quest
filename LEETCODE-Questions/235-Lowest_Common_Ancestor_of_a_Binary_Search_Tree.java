/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // TC: O(H), SC: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(root.val > p.val && root.val > q.val){
                // Go to left
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                // Go to right
                root = root.right;
            }else{
                return root;
            }
        }
    }
}