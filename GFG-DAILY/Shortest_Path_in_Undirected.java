class Pair{
    int vtx;
    int weight;
    
    public Pair(int _vtx, int _weight){
        this.vtx = _vtx;
        this.weight = _weight;
    }
}

class Solution {
    
    public ArrayList<ArrayList<Integer>> construction(int[][] edges, int n, int m){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
    }
    
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> graph = construction(edges, n, m);
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        boolean[] vis = new boolean[n];
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(src, 0));
        vis[src] = true;
        
        while(q.size() != 0){
            Pair rem = q.poll();
            int vtx = rem.vtx;
            int weight = rem.weight;
            
            ans[vtx] = weight;
            
            for(int nbr: graph.get(vtx)){
                if(!vis[nbr]){
                    q.add(new Pair(nbr, weight + 1));
                    vis[nbr] = true;
                }
            }
        }
        
        return ans;
    }
}