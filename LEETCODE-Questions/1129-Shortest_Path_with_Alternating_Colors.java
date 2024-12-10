class Pair{
    int vtx;
    char c;

    public Pair(int _vtx, char _c){
        this.vtx = _vtx;
        this.c = _c;
    }
}

class Tuple{
    int vtx;
    char c;
    int weight;

    public Tuple(int _vtx, char _c, int _weight){
        this.vtx = _vtx;
        this.c = _c;
        this.weight = _weight;
    }
}

class Solution {
    public ArrayList<ArrayList<Pair>> construction(int[][] red, int[][] blue, int n){
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        // Adding red edges
        for(int i=0; i<red.length; i++){
            int u = red[i][0];
            int v = red[i][1];

            graph.get(u).add(new Pair(v, 'R'));
        }

        // Adding blue edges
        for(int i=0; i<blue.length; i++){
            int u = blue[i][0];
            int v = blue[i][1];

            graph.get(u).add(new Pair(v, 'B'));
        }

        return graph;
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<Pair>> graph = construction(redEdges, blueEdges, n);
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;

        boolean[][] visited = new boolean[n][2];

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 'W', 0));

        while(!q.isEmpty()){
            Tuple rem = q.poll();
            int vtx = rem.vtx;
            char color = rem.c;
            int weight = rem.weight;

            if(ans[vtx] == -1){
                ans[vtx] = weight;
            }

            ArrayList<Pair> nbrs = graph.get(vtx);
            for(Pair nbr: nbrs){
                int v = nbr.vtx;
                char c = nbr.c;

                int cIdx = (c == 'R') ? 0 : 1;

                // Alternate color, then add or else don't, so that using that path as it is invalid path
                if (!visited[v][cIdx] && (color == 'W' || color != c)) {
                    visited[v][cIdx] = true;
                    q.add(new Tuple(v, c, weight + 1));
                }
            }
        }

        return ans;
    }
}   