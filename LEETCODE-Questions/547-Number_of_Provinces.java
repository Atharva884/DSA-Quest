class Solution {
    public void dfs(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis){
        ArrayList<Integer> nbrs = graph.get(src);

        for(int nbr: nbrs){
            if(!vis[nbr]){
                vis[nbr] = true;
                dfs(nbr, graph, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // Convert to Adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int n = isConnected.length;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(isConnected[i][j] == 1){
                    int u = i;
                    int v = j;

                    graph.get(u).add(v);
                }
            }
        }

        int ans = 0;
        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++){
            if(!vis[i]){
                vis[i] = true;
                dfs(i, graph, vis);
                ans++;
            }
        }

        return ans;
    }
}