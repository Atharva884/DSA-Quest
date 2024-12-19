class Solution {
    // Union by rank & size
    public void union(int x, int y, int[] par, int[] rank, int[] size){
        int px = find(x, par);
        int py = find(y, par);

        if(px == py) return;

        if(rank[px] > rank[py]){
            par[py] = px;
            size[px] += size[py];
        }else if(rank[px] < rank[py]){
            par[px] = py;
            size[py] += size[px];
        }else{
            par[px] = py;
            rank[py]++;
            size[py] += size[px];
        }
    }

    public int find(int x, int[] par){
        if(par[x] == x){
            return x;
        }

        int temp = find(par[x], par);
        par[x] = temp;

        return temp;
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        int maxRow = 0;
        int maxCol = 0;

        // Getting the dimensions
        for(int i=0; i<n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        int[] par = new int[maxRow + maxCol + 2];
        int[] rank = new int[maxRow + maxCol + 2];
        int[] size = new int[maxRow + maxCol + 2];

        for(int i=0; i<maxRow + maxCol + 2; i++){
            par[i] = i;
            rank[i] = 1;
            size[i] = 1;
        }

        for(int i=0; i<n; i++){
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1;

            union(row, col, par, rank, size);
        }

        int count = 0;
        for(int i=0; i<maxRow + maxCol + 2; i++){
            if(par[i] == i && size[i] > 1){
                count++;
            }
        }

        return n - count;
    }
}