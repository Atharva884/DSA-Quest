class Solution {
    public ArrayList<ArrayList<Integer>> construction(int[][] edges, int n, int m){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<=n; i++){
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

    // public void bfs(int src, ArrayList<ArrayList<Integer>> graph, int[] vis, int n){
    //     vis[src] = 1;
    //     Queue<Integer> q = new LinkedList<>(); 
    //     q.add(src);

    //     for(int i=1; i<=graph.get(src).size(); i++){
    //         int nbr = graph.get(src).get(i-1);
    //         if(vis[nbr] == 0){
    //             vis[nbr] = vis[src] + i;
    //             q.add(nbr);
    //         }
    //     }
    // }

    public void bfs(int src, ArrayList<ArrayList<Integer>> graph, int[] vis, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int vtx = q.poll();

            boolean[] color = new boolean[5];

            // Travelling nbrs who are already visited and marking in color array as true
            // so, this can't be assigned to the cur vtx
            for (int nbr: graph.get(vtx)) {
                if (vis[nbr] != 0) {
                    color[vis[nbr]] = true;
                }
            }

            // Once, i encounted any color that has not been marked to any node
            for (int c = 1; c <= 4; c++) {
                if (!color[c]) {
                    vis[vtx] = c;
                    break;
                }
            }

            for (int nbr : graph.get(vtx)) {
                if (vis[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }
    }


    public int[] gardenNoAdj(int n, int[][] paths) {
        int m = paths.length;
        
        int[] vis = new int[n+1];

        ArrayList<ArrayList<Integer>> graph = construction(paths, n, m);

        for(int i=1; i<=n; i++){
            if(vis[i] == 0){
                bfs(i, graph, vis, n);
            }
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = vis[i+1];
        }

        return ans;
    }
}