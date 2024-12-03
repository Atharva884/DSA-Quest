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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;

        while(cur != null){
            if(cur.left == null){
                ans.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode curP1 = cur.left;

                while(curP1.right != null && curP1.right != cur){
                    curP1 = curP1.right;
                }

                if(curP1.right == null){
                    curP1.right = cur;
                    cur = cur.left;
                }else{
                    curP1.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }

        return ans;
    }
}