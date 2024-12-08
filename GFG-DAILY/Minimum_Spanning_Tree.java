// Kruskal Algorithm (It uses DSU)

// TC: TC: O(ElogE) ~ O(ELogV), SC: O(V)

// class Solution {
//     // Find By Union
//     static boolean union(int x, int y, int[] par, int[] rank){
//         int px = find(x, par);
//         int py = find(y, par);

//         // They are already in the same grp
//         if(px == py){
//             return false; 
//         }

//         if(rank[px] > rank[py]){
//             par[py] = px;
//         }else if(rank[px] < rank[py]){
//             par[px] = py;
//         }else{
//             // They are of same size
//             par[px] = py;
//             rank[py]++;
//         }
        
//         return true;
//     }

//     // Find
//     static int find(int x, int[] par){
//         if(x == par[x]){
//             return par[x];
//         }

//         int temp = find(par[x], par);
//         par[x] = temp;

//         return temp;
//     }
    
//     static int spanningTree(int V, int E, List<List<int[]>> adj) {
//         List<int[]> edges = new ArrayList<>();
        
//         for (int u = 0; u < V; u++) {
//             for (int[] neighbor : adj.get(u)) {
//                 int v = neighbor[0];
//                 int w = neighbor[1];
//                 edges.add(new int[]{u, v, w});
//             }
//         }
        
//         Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
//         int[] par = new int[V];
//         int[] rank = new int[V];
        
//         for(int i=0; i<V; i++){
//             par[i] = i;
//             rank[i] = 1;
//         }
        
//         int ans = 0;
//         for(int i=0; i<edges.size(); i++){
//             int u = edges.get(i)[0];
//             int v = edges.get(i)[1];
//             int w = edges.get(i)[2];
            
//             boolean temp = union(u, v, par, rank);
//             if(temp == false){
//                 continue;
//             }
            
//             ans += w;
//         }
        
//         return ans;
//     }
// }


// Prim's Alogrithm (It uses PQ)
// TC: O(ElogE) ~ O(ElogV), SC: O(E)

class Pair implements Comparable<Pair>{
    int v;
    int w; 
    
    public Pair(int _v, int _w){
        this.v = _v;
        this.w = _w;
    }
    
    public int compareTo(Pair o){
        return this.w - o.w;
    }
}

class Solution{
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        
        int sum = 0;
        while(pq.size() != 0){
            Pair rem = pq.poll();
            int vtx = rem.v;
            int weight = rem.w;
            
            if(ans[vtx] != Integer.MAX_VALUE){
                continue;
            }
            ans[vtx] = weight;
            sum += weight;
            
            
            for(int[] nbr: adj.get(vtx)){
                int v = nbr[0];
                int w = nbr[1];
                
                if(ans[v] != Integer.MAX_VALUE){
                    continue;
                }
                
                pq.add(new Pair(v, w));
            }
        }
        
        
        return sum;
    }
}