/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode solve(int[] arr, int sp, int ep){
        if(sp > ep){
            return null;
        }

        int idx = -1;
        int max = -1;
        for(int i=sp; i<=ep; i++){
            if(arr[i] > max){
                max = arr[i];
                idx = i;
            }
        }

        TreeNode root = new TreeNode(arr[idx]);

        root.left = solve(arr, sp, idx-1);
        root.right = solve(arr, idx + 1, ep);

        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        int sp = 0;
        int ep = n-1;

        return solve(nums, sp, ep);
    }
}