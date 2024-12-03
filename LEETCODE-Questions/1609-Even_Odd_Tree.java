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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int levels = 0;
        while (q.size() != 0) {
            int size = q.size();

            int prev = Integer.MAX_VALUE;
            if(levels % 2 == 0){
                prev = Integer.MIN_VALUE;
            }

            for (int i = 0; i < size; i++) {
                TreeNode rem = q.poll();

                if (levels % 2 == 0) {
                    // Even -> Odd and all the values must be decreasing

                    if (rem.val % 2 == 0 || rem.val <= prev) {
                        return false;
                    }

                } else {
                    // Odd -> Even and all the values must be increasing
                    
                    if (rem.val % 2 != 0 || rem.val >= prev) {
                        return false;
                    }
                }

                prev = rem.val;

                if (rem.left != null) {
                    q.add(rem.left);
                }

                if (rem.right != null) {
                    q.add(rem.right);
                }

            }

            levels++;
        }

        return true;
    }
}