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
    // TC: O(N), SC: O(H)
    public Node sort(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        if (lo == hi) {
            Node node = new Node(arr[lo]);
            return node;
        }

        int mid = lo + (hi - lo) / 2;

        Node left = sort(arr, lo, mid - 1);
        Node right = sort(arr, mid + 1, hi);

        Node m = new Node(arr[mid]);
        m.left = left;
        m.right = right;

        return m;
    }

    public Node sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        return sort(nums, lo, hi);
    }
}