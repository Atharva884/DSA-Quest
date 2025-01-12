class Solution {
    // public int solve(int i, int j, int[][] grid, int n, int m, int[][] dp){
    //     if(i >= n || j >= m) return Integer.MAX_VALUE;

    //     if(i == n-1 && j == m-1){
    //         return grid[i][j];
    //     }

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }

    //     int right = solve(i, j+1, grid, n, m, dp);
    //     int down = solve(i+1, j, grid, n, m, dp);

    //     return dp[i][j] = grid[i][j] + Math.min(right, down);
    // }

    // Recursion + DP
    // TC: O(N*M), SC: O(N*M) with stack space (N+M)
    // public int minPathSum(int[][] grid) {
    //     int n = grid.length;
    //     int m = grid[0].length;

    //     int[][] dp = new int[n][m];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(0, 0, grid, n, m, dp);  
    // }

    // Tabulation
    // TC: O(N*M), SC: O(N*M)
    public int minPathSum(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        
        dp[n-1][m-1] = grid[n-1][m-1];

        for(int i=n-2; i>=0; i--){
            dp[i][m-1] = grid[i][m-1] + dp[i+1][m-1];
        }

        for(int i=m-2; i>=0; i--){
            dp[n-1][i] = grid[n-1][i] + dp[n-1][i+1];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){
                int min = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = grid[i][j] + min;
            }
        }

        return dp[0][0];
    }
}