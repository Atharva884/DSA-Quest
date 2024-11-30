//User function Template for Java


class Pair{
    Node node;
    int level;
    
    public Pair(Node _node, int _level){
        this.node = _node;
        this.level = _level;
    }
}

class Solution
{
    public ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null){
            return ans;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(q.size() != 0){
            Pair pair = q.poll();
            Node rem = pair.node;
            int level = pair.level;
            
            map.put(level, rem.data);
            
            if(rem.left != null){
                q.add(new Pair(rem.left, level - 1));
            }
            
            if(rem.right != null){
                q.add(new Pair(rem.right, level + 1));
            }
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int key: map.keySet()){
            min = Math.min(min, key);
            max = Math.max(max, key);
        }
        
        for(int i=min; i<=max; i++){
            ans.add(map.get(i));
        }
        
        return ans;
    }
}