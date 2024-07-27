import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // TC: O(N), SC: O(N) - DFS
    public static void dfs(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }

        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);

        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }

    // public List<List<Integer>> levelOrder(TreeNode root){
    // List<List<Integer>> list = new ArrayList<>();
    // dfs(root, 0, list);

    // return list;
    // }

    // TC: O(N), SC: O(N) - BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        q.add(root);

        while (q.size() > 0) {
            int n = q.size();

            List<Integer> sublist = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode remNode = q.remove();

                sublist.add(remNode.val);

                if (remNode.left != null) {
                    q.add(remNode.left);
                }

                if (remNode.right != null) {
                    q.add(remNode.right);
                }
            }

            list.add(sublist);
        }

        return list;
    }
}