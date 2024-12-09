class Solution {
    // Find by Union
    public boolean union(int x, int y, int[] par, int[] rank){
        int px = find(x, par);
        int py = find(y, par);

        if(px == py){
            // Already merge, redundant edge then
            return false;
        }

        if(rank[px] > rank[py]){
            par[py] = px;
        }else if(rank[px] < rank[py]){
            par[px] = py;
        }else{
            par[px] = py;
            rank[py]++;
        }

        return true;
    }

    public int find(int x, int[] par){
        if(x == par[x]){
            return x;
        }

        int temp = find(par[x], par);
        par[x] = temp;

        return temp;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] par = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=0; i<n+1; i++){
            par[i] = i;
            rank[i] = 1;
        }

        int[] ans = new int[2];
        for(int i=0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            boolean temp = union(u, v, par, rank);
            if(temp == false){
                ans[0] = u;
                ans[1] = v;
            }
        }

        return ans;
    }
}