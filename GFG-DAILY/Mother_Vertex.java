class Solution
{
    public void dfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> graph, Stack<Integer> st){
        vis[src] = true;
        
        ArrayList<Integer> nbrs = graph.get(src);
        
        for(int nbr: nbrs){
            if(!vis[nbr]){
                dfs(nbr, vis, graph, st);
            }
        }
        
        st.push(src);
    }
    
   
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
    
    
    // Optimal Approach
    // TC: O(V+E), SC: O(V)
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, vis, adj, st);
            }
        }
        
        // Verify the st topmost element
        Stack<Integer> dummy = new Stack<>();
        Arrays.fill(vis, false);
        dfs(st.peek(), vis, adj, dummy);
        
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                return -1;
            }
        }
        
        return st.peek();
    }
}