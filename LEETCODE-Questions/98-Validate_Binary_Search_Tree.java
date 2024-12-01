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
    public void solve(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;

        solve(root.left, arr);
        arr.add(root.val);
        solve(root.right, arr);
    }

    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        solve(root, arr);

        for(int i=0; i<arr.size()-1; i++){
            if(arr.get(i+1) <= arr.get(i)){
                return false;
            }
        }
        
        return true;
    }
}