class Solution {
    public int findCenter(int[][] edges) {
        // int n = edges.length;
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int[] edge: edges){
        //     int u = edge[0];
        //     int v = edge[1];

        //     map.put(u, map.getOrDefault(u, 0) + 1);
        //     map.put(v, map.getOrDefault(v, 0) + 1);
        // }

        // for(int key: map.keySet()){
        //     int val = map.get(key);

        //     if(val == n){
        //         return key;
        //     }
        // }

        // return -1;

        int u1 = edges[0][0], v1 = edges[0][1];
        int u2 = edges[1][0], v2 = edges[1][1];
        
        if (u1 == u2 || u1 == v2) {
            return u1;
        } else {
            return v1;
        }
    }
}