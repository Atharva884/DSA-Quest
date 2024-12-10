class Solution {
    int time = 0;

    public void dfs(int[] low, int[] dis, boolean[] vis, List<List<Integer>> graph, List<List<Integer>> ans, int src,
            int parent) {

        low[src] = time;
        dis[src] = time;

        time++;

        List<Integer> nbrs = graph.get(src);

        for (int nbr : nbrs) {

            if (nbr == parent) {
                continue;
            } else if (vis[nbr] == false) {
                vis[nbr] = true;
                dfs(low, dis, vis, graph, ans, nbr, src);
                low[src] = Math.min(low[src], low[nbr]);

                if (low[nbr] > dis[src]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(src);
                    temp.add(nbr);

                    ans.add(temp);
                }
            } else {
                low[src] = Math.min(low[src], dis[nbr]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] low = new int[n];
        int[] dis = new int[n];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        dfs(low, dis, vis, graph, ans, 0, -1);

        return ans;
    }
}