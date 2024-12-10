class Solution {
    // Find By Union
    public void union(int x, int y, int[] par, int[] rank){
        int px = find(x, par);
        int py = find(y, par);
        // They are already in the same grp
        if(px == py){
            return;
        }
        if(rank[px] > rank[py]){
            par[py] = px;
        }else if(rank[px] < rank[py]){
            par[px] = py;
        }else{
            // They are of same size
            par[px] = py;
            rank[py]++;
        }
    }
    
    // Find
    public int find(int x, int[] par){
        if(x == par[x]){
            return par[x];
        }
        int temp = find(par[x], par);
        par[x] = temp;
        return temp;
    }
    
    public ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        int m = edges.length;
        
        int[] par = new int[v];
        int[] rank = new int[v];
        
        for(int i=0; i<v; i++){
            par[i] = i;
            rank[i] = 1;
        }
        
        for(int i=0; i<m; i++){
            int u = edges[i][0];
            int v1 = edges[i][1];
            
            union(u, v1, par, rank);
        }
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < v; i++) {
            int root = find(i, par);
            ArrayList<Integer> temp = map.getOrDefault(root, new ArrayList<>());
            temp.add(i);
            map.put(root, temp);
        }
        
        return new ArrayList<>(map.values());
    }
}