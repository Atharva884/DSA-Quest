class Solution {
    // Find by union
    public boolean union(int x, int y, int[] par, int[] rank){
        int px = find(x, par);
        int py = find(y, par);

        if(px == py){
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

    public int makeConnected(int n, int[][] connections) {
        int[] par = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++){
            par[i] = i;
            rank[i] = 1;
        }

        int m = connections.length;
        int ans = 0;
        for(int i=0; i<m; i++){
            int u = connections[i][0];
            int v = connections[i][1];

            boolean tmp = union(u, v, par, rank);
            if(tmp == false){
                ans++;
            }
        }

        int total = 0;
        for(int i=0; i<n; i++){
            if(par[i] == i){
                total++;
            }
        }

        int req = total - 1;

        return req <= ans ? req : -1; 
    }
}