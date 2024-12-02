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
    public TreeNode solve(int[] pre, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map){
        if(ps > pe || is > ie){
            return null;
        }

        TreeNode root = new TreeNode(pre[ps]);

        // int idx = -1;
        // for(int i=is; i<=ie; i++){
        //     if(in[i] == pre[ps]){
        //         idx = i;
        //         break;
        //     }
        // }

        int idx = map.get(root.val);
        int count = idx - is;

        root.left = solve(pre, ps + 1, ps + count, in, is, idx - 1, map);
        root.right = solve(pre, ps + count + 1, pe, in, idx + 1, ie, map);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preOrder) {
        int n = preOrder.length;
        int[] inOrder = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            inOrder[i] = preOrder[i];
        }

        Arrays.sort(inOrder);
        for(int i=0; i<n; i++){
            map.put(inOrder[i], i);
        }

        int ps = 0;
        int pe = n-1;
        int is = 0;
        int ie = n-1;

        return solve(preOrder, ps, pe, inOrder, is, ie, map);
    }
}