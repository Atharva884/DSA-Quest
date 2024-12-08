class Solution {
    public void dfs(int i, int j, int n, int m, char[][] grid){
        grid[i][j] = '0';

        // Check for all the neighbours

        // Top Dir
        if(i-1 >= 0 && grid[i-1][j] == '1'){
            dfs(i-1, j, n, m, grid);
        }

        // Right Dir
        if(j+1 < m && grid[i][j+1] == '1'){
            dfs(i, j+1, n, m, grid);
        }

        // Bottom Dir
        if(i+1 < n && grid[i+1][j] == '1'){
            dfs(i+1, j, n, m, grid);
        }

        // Left Dir
        if(j-1 >= 0 && grid[i][j-1] == '1'){
            dfs(i, j-1, n, m, grid);
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, n, m, grid);
                    ans++;
                }
            }
        }

        return ans;
    }
}