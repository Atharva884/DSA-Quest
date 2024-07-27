class NodeValue {
    int minNode;
    int maxNode;
    int size;

    NodeValue(int _minNode, int _maxNode, int _size) {
        minNode = _minNode;
        maxNode = _maxNode;
        size = _size;
    }
}

class Solution {
    static NodeValue largeBST(Node root) {
        if (root == null) {
            // Means, it is not a bst and make sure ur size is 0
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = largeBST(root.left);
        NodeValue right = largeBST(root.right);

        if (root.data > left.maxNode && root.data < right.minNode) {
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
                    left.size + right.size + 1);
        }

        // If it is not a BST, then return [-inf, inf] value so that parent can't
        // compare
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }

    static int largestBst(Node root) {
        return largeBST(root).size;
    }

}