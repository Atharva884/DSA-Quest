class Solution {
    public int solve(int i, int k, int[] arr, int[][] dp){
        if(k == 0) return 1;
        
        if(i < 0 || k < 0) return 0;

        if(dp[i][k] != -1) return dp[i][k];

        int x = solve(i-1, k, arr, dp);
        int y = 0;

        if(k >= arr[i]){
            y = solve(i, k - arr[i], arr, dp);
        }

        return dp[i][k] = x + y;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return solve(n-1, amount, coins, dp);
    }
}