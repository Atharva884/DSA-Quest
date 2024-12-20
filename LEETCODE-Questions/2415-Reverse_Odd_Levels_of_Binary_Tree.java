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
    public void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    // TC: O(N), SC: O(N)
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<TreeNode> arr = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode rem = q.poll();

                arr.add(rem);

                if(rem.left != null){
                    q.add(rem.left);
                }
                if(rem.right != null){
                    q.add(rem.right);
                }
            }

            if(level % 2 != 0){
                // Odd level
                int l = 0;
                int r = arr.size() - 1;
                
                while(l < r){
                    swap(arr.get(l), arr.get(r));

                    l++;
                    r--;
                }
            }

            level++;
        }

        return root;
    }
}