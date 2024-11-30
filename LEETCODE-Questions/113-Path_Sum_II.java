/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public void solve(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans, int target) {
        if (root == null) {
            return;
        }

        sum += root.val;
        path.add(root.val);

        if (sum == target && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        }

        solve(root.left, sum, path, ans, target);
        solve(root.right, sum, path, ans, target);

        sum = sum - path.get(path.size() - 1);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        solve(root, 0, path, ans, targetSum);

        return ans;
    }
}