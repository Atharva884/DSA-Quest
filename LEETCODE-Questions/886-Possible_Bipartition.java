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

    public boolean bfs(int src, ArrayList<ArrayList<Integer>> graph, int[] vis, int n){
        vis[src] = 5;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int vtx = q.poll();

            for(int nbr: graph.get(vtx)){
                if(vis[nbr] == -1){
                    if(vis[vtx] == 5){
                        vis[nbr] = 10;
                    }else{
                        vis[nbr] = 5;
                    }
                    q.add(nbr);
                }else if(vis[vtx] == vis[nbr]){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int m = dislikes.length;

        ArrayList<ArrayList<Integer>> graph = construction(dislikes, n, m);

        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);

        for(int i=1; i<=n; i++){
            if(vis[i] == -1){
                boolean flag = bfs(i, graph, vis, n);
                if(flag == false){
                    return false;
                }
            }
        }

        return true;
    }
}