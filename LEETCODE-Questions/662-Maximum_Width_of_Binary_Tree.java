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
class Pair{
    TreeNode node;
    int idx;

    public Pair(TreeNode _node, int _idx){
        this.node = _node;
        this.idx = _idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(q.size() != 0){
            int size = q.size();
            int min = q.peek().idx;

            int first = 0;
            int last = 0;

            for(int i=0; i<size; i++){
                // Just to prevent overflow
                int curId = q.peek().idx - min;
                Pair rem = q.poll();

                if(i == 0){
                    first = curId;
                }

                if(i == size-1){
                    last = curId;
                }

                if(rem.node.left != null){
                    q.add(new Pair(rem.node.left, 2 * curId + 1));
                }
                if(rem.node.right != null){
                    q.add(new Pair(rem.node.right, 2 * curId + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}