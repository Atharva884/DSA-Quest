class Solution {
    public ArrayList<ArrayList<Integer>> construction(int[][] adj, int n){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            int[] arr = adj[i];

            for(int num: arr){
                graph.get(i).add(num);
            }
        }

        return graph;
    }

    public void dfs(int src, ArrayList<ArrayList<Integer>> graph, int n, List<List<Integer>> ans, List<Integer> path){
        ArrayList<Integer> nbrs = graph.get(src);

        for(int nbr: nbrs){
            path.add(nbr);

            // Reached the destination
            if(nbr == n-1){
                ans.add(new ArrayList<>(path));
            }

            dfs(nbr, graph, n, ans, path);

            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] adj) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = adj.length;

        ArrayList<ArrayList<Integer>> graph = construction(adj, n);

        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(0, graph, n, ans, path);

        return ans;
    }
}