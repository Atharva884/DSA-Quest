class Solution {
    // public int solve(int i, int j, int n, int m, int[][] dp){
    //     if(i >= n || j >= m) return 0;
        
    //     if(i == n-1 && j == m-1){
    //         return 1;
    //     }

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }

    //     int right = solve(i, j+1, n, m, dp);
    //     int down = solve(i+1, j, n, m, dp);

    //     return dp[i][j] = right + down;
    // }

    // Recursion + Memoization
    // TC: O(N*M), SC: O(N*M) + stack space (N + M)
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(0, 0, m, n, dp);
    // }

    // Tabulation
    // TC: O(N*M), SC: O(N*M)
    public int uniquePaths(int n, int m){
        int[][] dp = new int[n][m];

        // Base cases
        for(int i=0; i<n; i++){
            dp[i][m-1] = 1;
        }
        
        for(int i=0; i<m; i++){
            dp[n-1][i] = 1;
        }

        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}