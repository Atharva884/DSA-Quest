class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class Solution {
    // Function to check whether a Binary Tree is BST or not.
    // static int i;
    // public static void bst(Node root, ArrayList<Integer> arr){
    // if(root == null){
    // return;
    // }

    // bst(root.left, arr);
    // arr.add(root.data);
    // // i++;
    // bst(root.right, arr);
    // }

    // Optimal: TC: O(N), SC: O(1)
    public static boolean bst(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        int val = root.data;
        if (val < min || val > max) {
            return false;
        }

        boolean left = bst(root.left, min, val - 1);
        boolean right = bst(root.right, val + 1, max);

        if (left == true && right == true) {
            return true;
        }

        return false;
    }

    boolean isBST(Node root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return bst(root, min, max);
    }
}