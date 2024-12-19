class Solution {
    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    // Union By Rank & Size
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

        return par[x];
    }

    public void dfs(int i, int j, int[][] grid, int n, int[] par, int[] rank, int[] size) {

        for(int d=0; d<4; d++){
            int iDash = i + dirs[d][0];
            int jDash = j + dirs[d][1];

            if(iDash >= 0 && iDash < n && jDash >= 0 && jDash < n && grid[iDash][jDash] == 1){
                int cellNo = (i * n) + j;
                int nCellNo = (iDash * n) + jDash;

                union(cellNo, nCellNo, par, rank, size);
            }
        }

    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        // Parent, Rank & Size Array
        int[] par = new int[n * n];
        int[] rank = new int[n * n];
        int[] size = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            par[i] = i;
            size[i] = 1;
            rank[i] = 1;
        }

        // Step 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // Move 4 directionally
                    dfs(i, j, grid, n, par, rank, size);
                }
            }
        }

        int max = -1;
        for(int i=0; i<n*n; i++){
            max = Math.max(max, size[i]);
        }

        // Step 2: Convert all 0's to 1 and get the large island
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    // Check four direction what's the size
                    HashSet<Integer> hs = new HashSet<>();
                    for(int d=0; d<4; d++){
                        int iDash = i + dirs[d][0];
                        int jDash = j + dirs[d][1];

                        if(iDash >= 0 && iDash < n && jDash >= 0 && jDash < n && grid[iDash][jDash] == 1){
                            int newCellNo = (iDash * n) + jDash;
                            hs.add(find(newCellNo, par));
                        }
                    }

                    int sum = 1;
                    for(int num: hs){
                        sum += size[num];
                    }

                    max = Math.max(max, sum);
                }
            }
        }

        return max;
    }
}