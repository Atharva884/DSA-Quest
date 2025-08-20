class Solution {
    List<List<Integer>> construction(int[][] edges, int v){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<v; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u1 = edge[0];
            int v1 = edge[1];
            
            graph.get(u1).add(v1);
            graph.get(v1).add(u1);
        }
        
        return graph;
    }
    
    boolean isPossible(int[] color, int node, int idx, List<List<Integer>> graph, int v){
        for(int a: graph.get(node)){
            if(color[a] == idx) return false;
        }
        
        return true;
    }
    
    boolean solve(int i, List<List<Integer>> graph, int v, int m, int[] color){
        if(i == v) return true;
        
        for(int idx=1; idx<=m; idx++){
            if(isPossible(color, i, idx, graph, v)){
                color[i] = idx;
                if(solve(i+1, graph, v, m, color)) return true;
                color[i] = 0;
            }
        }
        
        return false;
    }
    
    boolean graphColoring(int v, int[][] edges, int m) {
        int[] color = new int[v];
        List<List<Integer>> graph = construction(edges, v);
        
        // TC: O(N * M^N), SC: O(N+V+E)
        return solve(0, graph, v, m, color);
    }
}
