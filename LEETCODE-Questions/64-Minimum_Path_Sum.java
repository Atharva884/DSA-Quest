class Solution {
    public int solve(int i, int j, int[][] grid, int n, int m, int[][] dp){
        if(i >= n || j >= m) return Integer.MAX_VALUE;

        if(i == n-1 && j == m-1){
            return grid[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = solve(i, j+1, grid, n, m, dp);
        int down = solve(i+1, j, grid, n, m, dp);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, grid, n, m, dp);  
    }
}