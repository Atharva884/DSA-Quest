// User function Template for Java

// Kruskal Algorithm (It uses DSU)
class Solution {
    // Find By Union
    static boolean union(int x, int y, int[] par, int[] rank){
        int px = find(x, par);
        int py = find(y, par);

        // They are already in the same grp
        if(px == py){
            return false; 
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
        
        return true;
    }

    // Find
    static int find(int x, int[] par){
        if(x == par[x]){
            return par[x];
        }

        int temp = find(par[x], par);
        par[x] = temp;

        return temp;
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<int[]> edges = new ArrayList<>();
        
        // for(int i=0; i<V; i++){
        //     List<int[]> list = graph.get(i);
            
        //     for(int[] arr: list){
        //         int u = arr[0];
        //         int v = arr[1];
        //         int w = arr[2];
                
        //         edges.add(new int[]{u, v, w});
        //     }
        // }
        
        for (int u = 0; u < V; u++) {
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                edges.add(new int[]{u, v, w});
            }
        }
        
        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
        int[] par = new int[V];
        int[] rank = new int[V];
        
        for(int i=0; i<V; i++){
            par[i] = i;
            rank[i] = 1;
        }
        
        int ans = 0;
        for(int i=0; i<edges.size(); i++){
            int u = edges.get(i)[0];
            int v = edges.get(i)[1];
            int w = edges.get(i)[2];
            
            boolean temp = union(u, v, par, rank);
            if(temp == false){
                continue;
            }
            
            ans += w;
        }
        
        return ans;
    }
}