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
class Tuple implements Comparable<Tuple>{
    int level;
    int vlevel;
    TreeNode node;

    public Tuple(int _level, int _vlevel, TreeNode _node){
        this.level = _level;
        this.vlevel = _vlevel;
        this.node = _node;
    }

    public int compareTo(Tuple o){
        return this.node.val - o.node.val;
    }
}

class Solution {
    // TC: O(NlogN) + O(N), SC: O(N)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, root));

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();

            PriorityQueue<Tuple> pq = new PriorityQueue<>();
            for(int i=0; i<size; i++){
                Tuple rem = q.poll();
                int level = rem.level;
                int vlevel = rem.vlevel;
                TreeNode node = rem.node;

                pq.add(rem);

                if(node.left != null){
                    q.add(new Tuple(level + 1, vlevel - 1, node.left));
                }

                if(node.right != null){
                    q.add(new Tuple(level + 1, vlevel + 1, node.right));
                }
            }

            while(!pq.isEmpty()){
                Tuple t = pq.poll();

                ArrayList<Integer> temp = map.getOrDefault(t.vlevel, new ArrayList<Integer>());
                temp.add(t.node.val);
                map.put(t.vlevel, temp);
            }

        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int key: map.keySet()){
            min = Math.min(min, key);
            max = Math.max(max, key);
        }

        for(int i=min; i<=max; i++){
            List<Integer> temp = map.get(i);

            List<Integer> tmp = new ArrayList<>();
            for(int n: temp){
                tmp.add(n);
            }

            ans.add(tmp);
        }

        return ans;
    }
}