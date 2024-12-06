class Solution {
    
    public void dfs(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis, ArrayList<Integer> ans){
        ans.add(src);
        
        ArrayList<Integer> nbrs = graph.get(src);

        for(int nbr: nbrs){
            if(!vis[nbr]){
                vis[nbr] = true;
                dfs(nbr, graph, vis, ans);
            }
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        vis[0] = true;
        
        dfs(0, adj, vis, ans);
        
        return ans;
    }
}