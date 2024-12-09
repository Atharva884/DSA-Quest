class Solution
{
    // public void dfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> graph){
    //     ArrayList<Integer> nbrs = graph.get(src);
        
    //     for(int nbr: nbrs){
    //         if(!vis[nbr]){
    //             vis[nbr] = true;
    //             dfs(nbr, vis, graph);
    //         }
    //     }
    // }
    
   
    // Brute Force Approach - {TLE}
    // TC: O(V * (V+E)), SC: O(V)
    // public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj){
        
    //     int ans = -1;
        
    //     for(int node=0; node<V; node++){
    //         boolean[] vis = new boolean[V];
                
    //         if(!vis[node]){
    //             vis[node] = true;
    //             dfs(node, vis, adj);
    //         }  
            
    //         // Check if this node is reachable to all the other nodes
    //         boolean isTrue = true;
            
    //         for(int i=0; i<V; i++){
    //             if(vis[i] == false){
    //                 isTrue = false;
    //                 break;
    //             }
    //         }
            
    //         if(isTrue){
    //             return node;
    //         }
    //     }
        
        
    //     return ans;
    // }
}