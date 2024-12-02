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
    public int findMax(TreeNode root){
        while(root.right != null){
            root = root.right;
        }

        return root.val;
    }

    public TreeNode solve(TreeNode root, int key){
        if(root == null){
            return null;
        }

        if(root.val > key){
            // Go to left
            root.left = solve(root.left, key);
        }else if(root.val < key){
            // Go to right
            root.right = solve(root.right, key);
        }else{
            // You have found the Node to be deleted

            // 4 possibilities
            // 1. Leaf Node
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left != null && root.right == null){
                // 2. Left Node is not null
                return root.left;
            }else if(root.left == null && root.right != null){
                // 3. Right Node is not null
                return root.right;
            }else{
                // 4. Both the nodes are not null
                int max = findMax(root.left);
                root.val = max;

                root.left = solve(root.left, max);

                return root;
            }
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        return solve(root, key);
    }
}