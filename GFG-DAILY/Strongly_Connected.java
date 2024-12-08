//User function Template for Java


class Solution
{
    public void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st){
        ArrayList<Integer> nbrs = adj.get(src);
        for(int nbr: nbrs){
            if(!vis[nbr]){
                vis[nbr] = true;
                dfs(nbr, adj, vis, st);
            }
        } 
        
        st.push(src);
    }
    
    
    public void StackDfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        ArrayList<Integer> nbrs = adj.get(src);
        
        for(int nbr: nbrs){
            if(!vis[nbr]){
                vis[nbr] = true;
                StackDfs(nbr, adj, vis);
            }
        } 
    }
    
    
    // TC: O(E+V), SC: O(V)
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        
        // Do DFS
        for(int i=0; i<V; i++){
            if(!vis[i]){
                vis[i] = true;
                dfs(i, adj, vis, st);
            }
        }
        
        
        // Reverse the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<V; i++){
            for(int nbr: adj.get(i)){
                int u = i;
                int v = nbr;
                
                graph.get(v).add(u);
            }
        }
        
        // Do DFS in the Stack Order
        vis = new boolean[V];
        
        int ans = 0;
        while(st.size() != 0){
            int src = st.pop();
            
            if(!vis[src]){
                vis[src] = true;
                StackDfs(src, graph, vis);
                ans++;  
            }
        }
        
        return ans;
    }
}
