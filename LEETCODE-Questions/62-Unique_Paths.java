class Solution {
    public int solve(int i, int j, int n, int m, int[][] dp){
        if(i >= n || j >= m) return 0;
        
        if(i == n-1 && j == m-1){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = solve(i, j+1, n, m, dp);
        int down = solve(i+1, j, n, m, dp);

        return dp[i][j] = right + down;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return solve(0, 0, m, n, dp);
    }
}