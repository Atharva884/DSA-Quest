class Solution {
    int[][] dirs = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
    public void dfs(int i, int j, int n, int m, int[][] grid, int[] sum){
        sum[0] += grid[i][j];
        // Convert to 0 so we can't come back to that node
        grid[i][j] = 0;

        for(int d=0; d<4; d++){
            int xDash = i + dirs[d][0];
            int yDash = j + dirs[d][1];

            if(xDash >= 0 && xDash < n && yDash >= 0 && yDash < m){
                if(grid[xDash][yDash] > 0){
                    dfs(xDash, yDash, n, m, grid, sum);
                }
            }
        }
    }

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] sum = new int[1];
        int max = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] > 0){
                    sum[0] = 0;
                    dfs(i, j, n, m, grid, sum);

                    max = Math.max(sum[0], max);
                }
            }
        }

        return max;
    }
}