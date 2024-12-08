class Solution {
    // Find By Union
    public void union(int x, int y, int[] par, int[] rank){
        int px = find(x, par);
        int py = find(y, par);

        // They are already in the same grp
        if(px == py){
            return;
        }

        if(rank[px] > rank[py]){
            par[py] = px;
        }else if(rank[px] < rank[py]){
            par[px] = py;
        }else{
            // They are of same size
            par[px] = py;
            rank[py]++;
        }
    }

    // Find
    public int find(int x, int[] par){
        if(x == par[x]){
            return par[x];
        }

        int temp = find(par[x], par);
        par[x] = temp;

        return temp;
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int[] par = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=1; i<=n; i++){
            par[i] = i;
            rank[i] = 1;
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    int u = i+1;
                    int v = j+1;

                    union(u, v, par, rank);
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=n; i++){
            if(par[i] == i){
                ans++;
            }
        }

        return ans;
    }
}