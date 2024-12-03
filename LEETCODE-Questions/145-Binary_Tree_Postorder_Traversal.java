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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode cur = root;

        while(cur != null){
            if(cur.right == null){
                ans.add(cur.val);
                cur = cur.left;
            }else{
                TreeNode curP1 = cur.right;

                while(curP1.left != null && curP1.left != cur){
                    curP1 = curP1.left;
                }

                if(curP1.left == null){
                    curP1.left = cur;
                    ans.add(cur.val);
                    cur = cur.right;
                }else{
                    curP1.left = null;
                    cur = cur.left;
                }
            }
        }

        Collections.reverse(ans);

        return ans;
    }
}