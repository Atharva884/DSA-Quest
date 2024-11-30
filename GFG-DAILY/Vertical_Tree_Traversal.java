//User function Template for Java


class Pair {
    Node node;
    int level;

    public Pair(Node _node, int _level) {
        this.node = _node;
        this.level = _level;
    }
}

class Solution
{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (q.size() != 0) {
            Pair pair = q.poll();
            Node rem = pair.node;
            int level = pair.level;

            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<>());
            }
            map.get(level).add(rem.data);

            if (rem.left != null) {
                q.add(new Pair(rem.left, level - 1));
            }

            if (rem.right != null) {
                q.add(new Pair(rem.right, level + 1));
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            min = Math.min(min, key);
            max = Math.max(max, key);
        }

        for (int i = min; i <= max; i++) {
            List<Integer> list = map.get(i);
            for(int k=0; k<list.size(); k++){
                ans.add(list.get(k));
            }
        }

        return ans;
    }
}