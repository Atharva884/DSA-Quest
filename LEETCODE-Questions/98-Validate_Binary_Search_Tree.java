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
    // Brute Force Approach
    // TC: O(2N), SC: O(N)

    // public void solve(TreeNode root, ArrayList<Integer> arr){
    //     if(root == null) return;

    //     solve(root.left, arr);
    //     arr.add(root.val);
    //     solve(root.right, arr);
    // }

    // public boolean isValidBST(TreeNode root) {
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     solve(root, arr);

    //     for(int i=0; i<arr.size()-1; i++){
    //         if(arr.get(i+1) <= arr.get(i)){
    //             return false;
    //         }
    //     }
        
    //     return true;
    // }

    // Optimal Approach
    // TC: O(N), SC: O(H)
    public boolean solve(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }

        long val = root.val;

        if(val < min || val > max){
            return false;
        }

        boolean l = solve(root.left, min, val - 1);
        boolean r = solve(root.right, val + 1, max);

        if(l == false || r == false){
            return false;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root){
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        return solve(root, min, max);
    }
}