
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
    public static TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left == null) {
            // If right is not null
            return right;
        } else if (right == null) {
            // If left is not null
            return left;
        } else {
            // Both of them are null, then return root;
            return root;
        }
    }

    public static boolean dfs(TreeNode root, int target, StringBuilder sb) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        sb.append("L");
        boolean left = dfs(root.left, target, sb);
        if (left) {
            return true;
        }
        sb.setLength(sb.length() - 1);

        sb.append("R");
        boolean right = dfs(root.right, target, sb);
        if (right) {
            return true;
        }
        sb.setLength(sb.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb = new StringBuilder();
        TreeNode temp = lca(root, startValue, destValue);

        dfs(temp, startValue, sb);

        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, 'U');
        }

        dfs(temp, destValue, sb);

        return sb.toString();
    }
}