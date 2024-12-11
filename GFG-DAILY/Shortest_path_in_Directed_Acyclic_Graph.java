class Pair implements Comparable<Pair>{
    int vtx;
    int weight;
    
    public Pair(int _vtx, int _weight){
        this.vtx = _vtx;
        this.weight = _weight;
    }
    
    public int compareTo(Pair o){
        return this.weight - o.weight;
    }
}

// User function Template for Java
class Solution {
   
    public ArrayList<ArrayList<Pair>> construction(int[][] edges, int n){
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        // Adding red edges
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            graph.get(u).add(new Pair(v, w));
        }

        return graph;
    }
    
    // // Brute Force Approach
    // // TC: O(V * E), SC: O(V)
    // public int[] shortestPath(int V, int E, int[][] edges) {
    //     ArrayList<ArrayList<Pair>> graph = construction(edges, V);
        
    //     int[] dist = new int[V];
    //     Arrays.fill(dist, -1);
        
    //     PriorityQueue<Pair> pq = new PriorityQueue<>();
    //     pq.add(new Pair(0, 0));
        
    //     while(!pq.isEmpty()){
    //         Pair rem = pq.poll();
    //         int vtx = rem.vtx;
    //         int w = rem.weight;
            
    //         if(dist[vtx] != -1) continue;
    //         dist[vtx] = w;
            
    //         for(Pair nbr: graph.get(vtx)){
    //             int v = nbr.vtx;
    //             int weight = nbr.weight;
                
    //             if(dist[v] != -1) continue;
    //             pq.add(new Pair(v, weight + w));
    //         }
    //     }
        
    //     return dist;
    // }
    
    
    public void dfs(int src, ArrayList<ArrayList<Pair>> graph, Stack<Integer> st, boolean[] vis){
        vis[src] = true;
        
        ArrayList<Pair> nbrs = graph.get(src);
        
        for(Pair nbr: nbrs){
            if(!vis[nbr.vtx]){
                dfs(nbr.vtx, graph, st, vis);
            }
        }
        
        st.push(src);
    }
    
    // TC: O(2(V+E) ~ V+E), SC: O(V+E) -> {Adj list}
    public int[] shortestPath(int V, int E, int[][] edges){
        ArrayList<ArrayList<Pair>> graph = construction(edges, V);
        
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];

        // Topo Sort using DFS
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, graph, st, vis);
            }
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        while(!st.isEmpty()){
            int vtx = st.pop();
            
            int w = dist[vtx];
            if(w == Integer.MAX_VALUE) continue;
            
            for(Pair nbr: graph.get(vtx)){
                int v = nbr.vtx;
                int weight = nbr.weight;
                
                if(weight + w < dist[v]){
                    dist[v] = weight + w;
                }
            }
        }
        
        for(int i=0; i<V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}