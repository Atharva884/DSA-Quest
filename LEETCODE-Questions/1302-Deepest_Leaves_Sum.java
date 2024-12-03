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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int minDeepestSum = 0; 

        while(q.size() != 0){
            int size = q.size();

            int sum = 0;
            for(int i=0; i<size; i++){
                TreeNode rem = q.poll();

                sum += rem.val;

                if(rem.left != null){
                    q.add(rem.left);
                }

                if(rem.right != null){
                    q.add(rem.right);
                }
            }

            minDeepestSum = sum;
        }


        return minDeepestSum;
    }
}