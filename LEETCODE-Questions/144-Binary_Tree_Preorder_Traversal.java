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
    public List<Integer> preorderTraversal(TreeNode root) {
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
                    ans.add(cur.val);
                    cur = cur.left;
                }else{
                    // The path is created someway back
                    // curP1.right == cur
                    curP1.right = null;
                    cur = cur.right;
                }
            }

        }

        return ans;
    }
}