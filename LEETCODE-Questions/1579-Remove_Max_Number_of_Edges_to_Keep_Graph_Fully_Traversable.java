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

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int m = edges.length;

        int[] parA = new int[n+1];
        int[] parB = new int[n+1];
        int[] rankA = new int[n+1];
        int[] rankB = new int[n+1];

        for(int i=1; i<=n; i++){
            parA[i] = parB[i] = i;
            rankA[i] = rankB[i] = 1;
        }

        // Sort the edges acc to type (We need to process type 3 first)
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        int ans = 0;
        for(int i=0; i<m; i++){
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];

            // Type 3 (Traverse by both Alice and Bob)
            if(type == 3){
                // Alice ke liye
                boolean a = union(u, v, parA, rankA);

                // Bob ke liye
                boolean b = union(u, v, parB, rankB);

                if(a == false && b == false){
                    ans++;
                }
            }else if(type == 1){
                // Alice ke liye
                boolean a = union(u, v, parA, rankA);

                if(a == false){
                    ans++;
                }
            }else{
                // Bob ke liye
                boolean b = union(u, v, parB, rankB);

                if(b == false){
                    ans++;
                }
            }

        }

        int countA = 0;
        int countB = 0;
        for(int i=1; i<=n; i++){
            if(parA[i] == i){
                countA++;
            }

            if(parB[i] == i){
                countB++;
            }
        }

        if(countA > 1 || countB > 1){
            return -1;
        }

        return ans;
    }
}