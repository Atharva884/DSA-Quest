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
    public static TreeNode postOrder(TreeNode root, HashSet<Integer> hs, ArrayList<TreeNode> forest) {
        if (root == null) {
            return root;
        }

        root.left = postOrder(root.left, hs, forest);
        root.right = postOrder(root.right, hs, forest);

        if (hs.contains(root.val)) {
            if (root.left != null) {
                forest.add(root.left);
            }

            if (root.right != null) {
                forest.add(root.right);
            }

            return null;
        }

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            hs.add(to_delete[i]);
        }

        ArrayList<TreeNode> list = new ArrayList<>();

        TreeNode node = postOrder(root, hs, list);
        if (node != null) {
            list.add(node);
        }

        return list;
    }
}