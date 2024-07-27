class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {

    public static Node dfs(Node root) {
        if (root == null) {
            return null;
        }

        root.left = dfs(root.left);
        root.right = dfs(root.right);

        // We have only left node
        if (root.left != null && root.right == null) {
            return root.left;
        }

        // We have only right node
        if (root.right != null && root.left == null) {
            return root.right;
        }

        return root;
    }

    public Node RemoveHalfNodes(Node root) {
        // Code Here
        return dfs(root);
    }
}