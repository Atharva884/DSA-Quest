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

    public void dfs(int src, ArrayList<ArrayList<Integer>> graph, boolean[] vis, int[] count, List<Integer> comp){
        comp.add(src);
        count[0]++;

        ArrayList<Integer> nbrs = graph.get(src);
        for(int nbr: nbrs){
            if(!vis[nbr]){
                vis[nbr] = true;
                dfs(nbr, graph, vis, count, comp);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        int m = edges.length;

        ArrayList<ArrayList<Integer>> graph = construction(edges, n, m);
        boolean[] vis = new boolean[n];
        int[] count = new int[1];
        int ans = 0;

        for(int i=0; i<n; i++){
            if(!vis[i]){
                vis[i] = true;
                List<Integer> comp = new ArrayList<>();
                count[0] = 0;
                dfs(i, graph, vis, count, comp);

                // It will return once it complete one component
                boolean isFlag = true;
                for(int node: comp){
                    int size = graph.get(node).size();
                    if(size != count[0] - 1){
                        isFlag = false;
                        break;
                    }
                }

                if(isFlag){
                    ans++;
                }
            }
        }

        return ans;
    }
}