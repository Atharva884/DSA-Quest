class Solution {
    // public static int solve(int i, int j, int[][] mat, int n, int m, int[][] dp){
    //     if(i >= n || j >= m || mat[i][j] == 1) return 0;

    //     if(i == n-1 && j == m-1) return 1;

    //     if(dp[i][j] != -1) return dp[i][j];

    //     int left = solve(i, j+1, mat, n, m, dp);
    //     int right = solve(i+1, j, mat, n, m, dp);
        
    //     return dp[i][j] = left + right;
    // }

    // Recursion + Memoization
    // TC: O(N*M), SC: O(N*M) + O(N+M)
    // public int uniquePathsWithObstacles(int[][] mat) {
    //     int n = mat.length;
    //     int m = mat[0].length;
    //     int[][] dp = new int[n][m];
    //     for(int[] arr: dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     return solve(0, 0, mat, n, m, dp);
    // }

    // Tabulation
    // TC: O(N*M), SC: O(N*M)
    public int uniquePathsWithObstacles(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];

        // Base cases
        if(mat[n-1][m-1] == 1) return 0;

        boolean obsR = false;
        for(int i=n-1; i>=0; i--){
            if(mat[i][m-1] == 1){
                obsR = true;
            }
            dp[i][m-1] = obsR ? 0 : 1;
        }
        
        boolean obsC = false;
        for(int i=m-1; i>=0; i--){
            if(mat[n-1][i] == 1){
                obsC = true;
            }
            dp[n-1][i] = obsC ? 0 : 1;
        }

        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){
                if(mat[i][j] == 1){
                    // You can't generate the way from the obstacle, so add 0
                    // it won't affect.
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }

        return dp[0][0];
    }
}