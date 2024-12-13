class Solution {
    
    public void dfs(int i, int j, int n, int m, int[][] grid, int[] count, int[][] dirs){
        grid[i][j] = 0;
        count[0]++;

        for(int d=0; d<4; d++){
            int iDash = i + dirs[d][0];
            int yDash = j + dirs[d][1];

            if(iDash >= 0 && iDash < n && yDash >= 0 && yDash < m){
                if(grid[iDash][yDash] == 1){
                    grid[iDash][yDash] = 0;
                    dfs(iDash, yDash, n, m, grid, count, dirs);
                }
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] count = new int[1];
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; 

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    count[0] = 0;
                    dfs(i, j, n, m, grid, count, dirs);

                    // You will get the count
                    max = Math.max(max, count[0]);
                }
            }
        }

        return max;
    }
}