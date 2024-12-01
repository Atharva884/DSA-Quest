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
    public TreeNode solve(int[] post, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map){
        if(ps > pe || is > ie){
            return null;
        }

        TreeNode root = new TreeNode(post[pe]);

        // int idx = -1;
        // for(int i=is; i<=ie; i++){
        //     if(in[i] == post[pe]){
        //         idx = i;
        //         break;
        //     }
        // }
        int idx = map.get(root.val);
        int count = idx - is;

        root.left = solve(post, ps, ps + count - 1, in, is, idx - 1, map);
        root.right = solve(post, ps + count, pe - 1, in, idx + 1, ie, map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;

        for(int i=0; i<n; i++){
            map.put(inorder[i], i);
        }

        int ps = 0;
        int pe = n-1;
        int is = 0;
        int ie = n-1;

        return solve(postorder, ps, pe, inorder, is, ie, map);
    }
}