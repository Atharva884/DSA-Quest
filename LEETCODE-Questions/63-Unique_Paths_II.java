class Solution {
    public static int solve(int i, int j, int[][] mat, int n, int m, int[][] dp){
        if(i >= n || j >= m || mat[i][j] == 1) return 0;

        if(i == n-1 && j == m-1) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int left = solve(i, j+1, mat, n, m, dp);
        int right = solve(i+1, j, mat, n, m, dp);
        
        return dp[i][j] = left + right;
    }

    public int uniquePathsWithObstacles(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, mat, n, m, dp);
    }
}