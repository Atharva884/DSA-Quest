import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.

    // TC: O(N), SC: O(H)
    public static void inOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);

        list.add(root.data);

        inOrder(root.right, list);
    }

    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> list = new ArrayList<>();

        inOrder(root1, list);
        inOrder(root2, list);

        Collections.sort(list);

        return list;
    }
}