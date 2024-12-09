class Solution {
    // Find by Union 
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
        if(par[x] == x){
            return x;
        }

        int temp = find(par[x], par);
        par[x] = temp;

        return temp;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        int[] par = new int[n+1];
        int[] rank = new int[n+1];

        for(int i=1; i<=n; i++){
            par[i] = i;
            rank[i] = 1;
        }

        int[] inDegree = new int[n+1];
        Arrays.fill(inDegree, -1);

        int bl1 = -1;
        int bl2 = -1;

        for(int i=0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(inDegree[v] == -1){
                inDegree[v] = i;
            }else{
                bl1 = i;
                bl2 = inDegree[v];
                break;
            }
        }

        for(int i=0; i<n; i++){
            // You will be worried about the case 2 i.e cycle case but the
            // bl1 would be -1 and u will processed all the edges
            if(i == bl1){
                continue;
            }

            int u = edges[i][0];
            int v = edges[i][1];

            boolean temp = union(u, v, par, rank);

            if(temp == false){
                if(bl1 == -1){
                    // Cycle is found, but it will be case 2 as bl1 will be -1
                    return edges[i];
                }else{
                    // U have skipped the bl1 edge then also u have found the cyle
                    return edges[bl2];
                }
            }
        }

        return edges[bl1];
    }
}