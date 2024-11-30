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
    public void solve(TreeNode root, ArrayList<Integer> ans){
        if(root == null){
            ans.add(Integer.MIN_VALUE);
            return;
        }

        ans.add(root.val);
        solve(root.left, ans);
        solve(root.right, ans);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> tmp1 = new ArrayList<>();
        ArrayList<Integer> tmp2 = new ArrayList<>();

        solve(p, tmp1);
        solve(q, tmp2);

        return tmp1.equals(tmp2);
    }
}