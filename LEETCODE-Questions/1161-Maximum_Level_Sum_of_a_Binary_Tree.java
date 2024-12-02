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
    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int max = Integer.MIN_VALUE;
        int maxSumLevel = -1;

        int level = 1;
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

            if(sum > max){
                max = sum;
                maxSumLevel = level;
            }
            level++;
        }

        return maxSumLevel;
    }
}