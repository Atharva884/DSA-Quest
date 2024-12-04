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
class Pair {
    int sum;
    int max;
    int min;

    public Pair(int _sum, int _max, int _min) {
        this.sum = _sum;
        this.max = _max;
        this.min = _min;
    }
}

class Solution {
   int maxSum = 0;

   public Pair maxSumBSTHelper(TreeNode root) {
       if (root == null) {
           return new Pair(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
       }

       Pair left = maxSumBSTHelper(root.left);
       Pair right = maxSumBSTHelper(root.right);

       // It's a bst
       if ((left.max < root.val) && (root.val < right.min)) {
           int currentSum = left.sum + right.sum + root.val;
           maxSum = Math.max(maxSum, currentSum);
           return new Pair(currentSum, 
                           Math.max(root.val, right.max),
                           Math.min(root.val, left.min));
       }

       // It's not a bst
       return new Pair(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
   }

   public int maxSumBST(TreeNode root) {
       maxSumBSTHelper(root);
       return maxSum;
   }
}