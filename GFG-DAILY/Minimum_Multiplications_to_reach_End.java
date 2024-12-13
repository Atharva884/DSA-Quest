// User function Template for Java

class Pair{
    int val;
    int level;
    
    public Pair(int _val, int _level){
        this.val =  _val;
        this.level = _level;
    }
}

class Solution {
    int mod = (int) (1e5);
    // TC: O(V+E), SC: O(V)
    int minimumMultiplications(int[] arr, int start, int end) {
        int n = arr.length;
        
        Queue<Pair> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        q.add(new Pair(start, 0));
        
        while(!q.isEmpty()){
            Pair rem = q.poll();
            int val = rem.val;
            int level = rem.level;
            
            if(val == end){
                return level;
            }
            
            for(int a: arr){
                int newVal = (val * a) % mod;
                
                if(!hs.contains(newVal)){
                    hs.add(newVal);
                    q.add(new Pair(newVal, level + 1));
                }
            }
        }
        
        return -1;
    }
}
