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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int leftVal = root.val;

        while(q.size() != 0){
            int size = q.size();

            leftVal =  q.peek().val;   

            for(int i=0; i<size; i++){
                TreeNode rem = q.poll();


                if(rem.left != null){
                    q.add(rem.left);
                }

                if(rem.right != null){
                    q.add(rem.right);
                }
            }

        }

        return leftVal;
    }
}